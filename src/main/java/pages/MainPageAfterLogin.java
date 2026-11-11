package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static constants.Elements.*;
import static constants.Url.HOST;

public class MainPageAfterLogin extends BasePage{

    private final SelenideElement profileButton = $(PROFILE_BUTTON);
    private final SelenideElement username = $(USERNAME_SELECTOR);
    private final SelenideElement logoutButton = $x(LOGOUT_BUTTON);
    private final SelenideElement createAdButton = $x(CREATE_AD_BUTTON);

    CreateCardPage createCardPage = page(CreateCardPage.class);
    ProfilePage profilePage = page(ProfilePage.class);

    @Override
    public void openPage() {
        open(HOST);
    }

    public String getUsername() {
        return username.getText();
    }

    public ProfilePage clickProfileButton() {
        profileButton.click();
        return profilePage;
    }

    public CreateCardPage clickCreateCardButton() {
        createAdButton.click();
        return createCardPage;
    }

    public boolean isAuthorized() {
        profileButton.shouldBe(visible);
        username.shouldBe(visible);
        logoutButton.shouldBe(visible);
        return true;
    }
}
