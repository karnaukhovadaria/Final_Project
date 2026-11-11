package qa_desk;

import api.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CardCreateSteps {

    private final TestContext context;
    private final DataGenerator dataGenerator;

    public CardCreateSteps(TestContext context) {
        this.context = context;
        this.dataGenerator = new DataGenerator();
    }
    @Given("User is authorized in the system to create card")
    public void userIsAuthorizedForCardCreation() {
        // User is already registered in the system from previous step
        context.loginPage.openPage();
        context.loginPage.loginUser(context.userRegisterData);
        Assertions.assertTrue(context.mainPageAfterLogin.isAuthorized());
    }

    @When("User creates new card")
    public void createNewCard() {
        context.mainPageAfterLogin.clickCreateCardButton();
        context.createCardPage.createCard(dataGenerator.createCard());
    }

    @Then("Card is displayed in user profile")
    public void cardDisplayedInProfile() {
        context.mainPageAfterLogin.clickProfileButton();
        context.profilePage.hasCards();
    }
}
