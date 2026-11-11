package pages;

import api.CreateCardData;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static constants.Elements.*;
import static constants.Endpoints.CREATE_AD_PAGE;
import static constants.Url.HOST;

public class CreateCardPage extends BasePage{

    private final SelenideElement nameInput = $(NAME_INPUT);
    private final SelenideElement descriptionInput = $(DESCRIPTION_SELECTOR);
    private final SelenideElement priceInput = $(PRICE_INPUT_SELECTOR);
    private final SelenideElement publishButton = $x(POST_BUTTON_XPATH);

    @Override
    public void openPage() {
        open(HOST + CREATE_AD_PAGE);
    }

    public void clickPublishButton() {
        publishButton.click();
    }

    public MainPageAfterLogin createCard(CreateCardData card) {
        $(nameInput).setValue(card.getName());
        $(descriptionInput).setValue(card.getDescription());
        $(priceInput).setValue(String.valueOf(card.getPrice()));
        clickPublishButton();
        MainPageAfterLogin mainPage = page(MainPageAfterLogin.class);
        return mainPage;
    }
}
