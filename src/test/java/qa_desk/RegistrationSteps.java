package qa_desk;

import api.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class RegistrationSteps {

    private final TestContext context;
    private final DataGenerator dataGenerator;

    public RegistrationSteps(TestContext context) {
        this.context = context;
        this.dataGenerator = new DataGenerator();
    }

    @Given("User data is generated")
    public void generateUserData() {
        context.userRegisterData = dataGenerator.createUser();
    }

    @When("User opens home page")
    public void openMainPage() {
        context.mainPageBeforeLogin.openPage();
    }

    @When("Goes to the registration form")
    public void goToRegistrationForm() {
        context.registrationPage = context.mainPageBeforeLogin
                .clickLoginRegisterButton()
                .clickRegisterButton();
    }

    @When("Registers with correct data")
    public void registerCorrectData() {
        context.registrationPage.registerUser(context.userRegisterData);
    }

    @Then("Authorized user username is displayed in header")
    public void usernameIsDisplayed() {
        Assertions.assertTrue(context.mainPageAfterLogin.isAuthorized());
        Assertions.assertEquals("User.", context.mainPageAfterLogin.getUsername(),
                "Default username is wrong");
    }

    @Given("User is already registered in the system")
    public void userAlreadyRegistered() {
        context.userRegisterData = dataGenerator.createUser();
        context.userApi.registerUser(context.userRegisterData);
    }

    @When("Registers with already existing data")
    public void registerWithExistingData() {
        context.registrationPage.registerExistingUser(context.userRegisterData);
    }

    @Then("Registration error is displayed")
    public void registrationErrorDisplayed() {
        Assertions.assertTrue(context.registrationPage.isRegistrationFailed());
        Assertions.assertTrue(context.mainPageBeforeLogin.isNotAuthorized());
    }
}
