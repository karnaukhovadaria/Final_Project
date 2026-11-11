package pages;

import api.UserRegisterData;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static constants.Elements.*;
import static constants.Endpoints.REGISTER_PAGE;
import static constants.Url.HOST;

public class RegistrationPage extends BasePage{

    private final SelenideElement emailInput = $x(EMAIL_INPUT_XPATH);
    private final SelenideElement passwordInput = $x(PASSWORD_INPUT_XPATH);
    private final SelenideElement submitPasswordInput = $x(SUBMIT_PASSWORD_XPATH);
    private final SelenideElement createAccountButton = $x(CREATE_ACCOUNT_BUTTON_XPATH);
    private final SelenideElement registrationError = $x(REGISTRATION_ERROR_XPATH);

    MainPageAfterLogin homePage = page(MainPageAfterLogin.class);

    @Override
    public void openPage() {
        open(HOST + REGISTER_PAGE);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public MainPageAfterLogin registerUser(UserRegisterData user) {
        fillDataIn(user);
        clickCreateAccountButton();
        return homePage;
    }

    public MainPageAfterLogin registerExistingUser(UserRegisterData user) {
        registerUser(user);
        registerUser(user);
        return homePage;
    }

    public boolean isRegistrationFailed() {
        registrationError.shouldBe(visible);
        return true;
    }

    private void fillDataIn(UserRegisterData user) {
        $(emailInput).setValue(user.getEmail());
        $(passwordInput).setValue(user.getPassword());
        $(submitPasswordInput).setValue(user.getSubmitPassword());
    }
}
