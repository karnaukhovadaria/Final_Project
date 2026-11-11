package qa_desk;

import api.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CardEditSteps {

    private final TestContext context;
    private final DataGenerator dataGenerator;

    public CardEditSteps(TestContext context) {
        this.context = context;
        this.dataGenerator = new DataGenerator();
    }

    @Given("User is registered in the system for card edit")
    public void userIsRegistered() {
        context.userRegisterData = dataGenerator.createUser();
        context.userApi.registerUser(context.userRegisterData);
    }

    @Given("User is authorized in the system for card edit")
    public void userIsAuthorizedForCardEdit() {
        context.loginPage.openPage();
        context.loginPage.loginUser(context.userRegisterData);
        Assertions.assertTrue(context.mainPageAfterLogin.isAuthorized());
    }

    @Given("User has a created card")
    public void userHasCard() {
        context.createCardData = dataGenerator.createCard();
        context.mainPageAfterLogin.clickCreateCardButton();
        context.createCardPage.createCard(context.createCardData);
        context.mainPageAfterLogin.clickProfileButton();
        Assertions.assertTrue(context.profilePage.hasCards());
    }

    @When("User clicks edit button")
    public void userClicksEditButton() {
        Assertions.assertTrue(context.profilePage.hasEditButton());
        context.profilePage.clickEditButton();
    }

    @Then("Edit card is opened")
    public void editCardIsOpened() {
        context.editCardPage.shouldBeOpened(context.createCardData.getName());
    }
}