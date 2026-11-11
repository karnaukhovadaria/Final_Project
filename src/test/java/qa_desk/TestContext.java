package qa_desk;

import api.CreateCardData;
import api.UserApi;
import api.UserRegisterData;
import pages.*;

public class TestContext {

    public UserRegisterData userRegisterData;
    public CreateCardData createCardData;
    public MainPageAfterLogin mainPageAfterLogin = new MainPageAfterLogin();
    public MainPageBeforeLogin mainPageBeforeLogin = new MainPageBeforeLogin();
    public LoginPage loginPage = new LoginPage();
    public ProfilePage profilePage = new ProfilePage();
    public RegistrationPage registrationPage = new RegistrationPage();
    public EditCardPage editCardPage = new EditCardPage();
    public CreateCardPage createCardPage = new CreateCardPage();
    public UserApi userApi = new UserApi();
}
