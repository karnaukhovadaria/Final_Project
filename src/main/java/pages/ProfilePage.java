package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static constants.Elements.*;
import static constants.Endpoints.PROFILE_PAGE;
import static constants.Url.HOST;

public class ProfilePage extends BasePage{

    private final SelenideElement adSelector = $(AD_SELECTOR);
    private final SelenideElement editButtonElement = $(EDIT_BUTTON_SELECTOR);
    private final SelenideElement deleteButtonElement = $(DELETE_BUTTON_SELECTOR);

    @Override
    public void openPage() {
        open(HOST + PROFILE_PAGE);
    }

    public boolean hasCards() {
        $(adSelector).shouldBe(visible);
        return true;
    }

    public boolean hasEditButton() {
        editButtonElement.shouldBe(visible);
        return true;
    }

    public boolean hasDeleteButton() {
        if (!deleteButtonElement.exists()) {
            throw new AssertionError("Delete button not found");
        }
        deleteButtonElement.shouldBe(visible);
        return true;
    }

    public void clickEditButton() {
        $$(EDIT_BUTTON_SELECTOR).get(0).click();
    }

    public void clickDeleteButton() {
        $$(DELETE_BUTTON_SELECTOR).get(0).click();
    }
}
