package qa_desk;

import api.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CardDeleteSteps {

    private final TestContext context;
    private final DataGenerator dataGenerator;

    public CardDeleteSteps(TestContext context) {
        this.context = context;
        this.dataGenerator = new DataGenerator();
    }

    @Given("User is registered in the system for card deletion")
    public void userIsRegistered() {
        context.userRegisterData = dataGenerator.createUser();
        context.userApi.registerUser(context.userRegisterData);
    }

    @Given("User is authorized in the system for card deletion")
    public void userIsLoggedIn() {
        context.loginPage.openPage();
        context.loginPage.loginUser(context.userRegisterData);
        Assertions.assertTrue(context.mainPageAfterLogin.isAuthorized());
    }

    @Given("User has a created card for deletion")
    public void userHasCardToDelete() {
        context.createCardData = dataGenerator.createCard();
        context.mainPageAfterLogin.clickCreateCardButton();
        context.createCardPage.createCard(context.createCardData);
        context.mainPageAfterLogin.clickProfileButton();
        Assertions.assertTrue(context.profilePage.hasCards());
    }

    @When("User goes to profile with cards")
    public void goToProfile() {
        context.mainPageAfterLogin.clickProfileButton();
        context.profilePage.hasCards();
    }

    @Then("Delete button is available")
    public void deleteButtonAvailable() {
        Assertions.assertTrue(context.profilePage.hasDeleteButton());
    }
}
