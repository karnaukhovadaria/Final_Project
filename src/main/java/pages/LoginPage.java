package pages;

import api.UserRegisterData;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static constants.Elements.*;
import static constants.Endpoints.LOGIN_PAGE;
import static constants.Url.HOST;

public class LoginPage extends BasePage{

    private final SelenideElement emailInput = $(EMAIL_INPUT);
    private final SelenideElement passwordInput = $(PASSWORD_INPUT);
    private final SelenideElement loginButton = $x(LOGIN_BUTTON);
    private final SelenideElement registerButton = $x(REGISTER_BUTTON);

    @Override
    public void openPage() {
        open(HOST + LOGIN_PAGE);
    }

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public MainPageAfterLogin loginUser(UserRegisterData user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickLoginButton();
        MainPageAfterLogin mainPage = page(MainPageAfterLogin.class);
        return mainPage;
    }

    public RegistrationPage clickRegisterButton() {
        registerButton.click();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        return registrationPage;
    }
}
