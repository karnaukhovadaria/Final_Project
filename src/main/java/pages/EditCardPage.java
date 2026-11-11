package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constants.Elements.EDIT_TITLE;
import static constants.Endpoints.EDIT_AD_PAGE;
import static constants.Url.HOST;

public class EditCardPage extends BasePage {

    private final SelenideElement title = $(EDIT_TITLE);

    @Override
    public void openPage() {
        open(HOST + EDIT_AD_PAGE);
    }

    public void checkTitle(String someTitle) {
        title.shouldBe(visible).shouldHave(text(someTitle));
    }

    public void shouldBeOpened(String expectedTitle) {
        title.shouldBe(visible).shouldHave(text(expectedTitle));
    }
}