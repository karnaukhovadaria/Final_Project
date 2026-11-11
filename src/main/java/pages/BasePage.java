package pages;

import static com.codeborne.selenide.Selenide.open;
import static constants.Url.HOST;

public abstract class BasePage {
    public void openPage() {
        open(HOST);
    }
}
