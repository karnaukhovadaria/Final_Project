package qa_desk;

import api.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    private final TestContext context;
    private final DataGenerator dataGenerator;

    public LoginSteps(TestContext context) {
        this.context = context;
        this.dataGenerator = new DataGenerator();
    }

    @Given("User is registered in the system")
    public void userIsRegistered() {
        context.userRegisterData = dataGenerator.createUser();
        context.userApi.registerUser(context.userRegisterData);
    }

    @When("User opens login page")
    public void openLoginPage() {
        context.loginPage.openPage();
    }

    @When("Enters correct data and logs in")
    public void enterValidCredentialsAndLogin() {
        context.loginPage.loginUser(context.userRegisterData);
    }

    @Then("User is authorized")
    public void userLoggedIn() {
        Assertions.assertTrue(context.mainPageAfterLogin.isAuthorized());
    }
}
