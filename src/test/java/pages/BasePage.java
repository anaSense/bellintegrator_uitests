package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    private final SelenideElement searchOpenBtn = $("#search-open"),
            searchInput = $("#search").$("input");


    public void openPage() {
        open("");
    }

    public void clickToSearchBtn() {
        searchOpenBtn.click();
    }

    public void enterTextToSearchFieldAndAccept(String value) {
        searchInput.setValue(value).pressEnter();
    }

    public void enterTextToSearchField(String value) {
        searchInput.setValue(value);
    }

    public void pressBackspace(int count) {
        for(int i = 0; i < count; i++) {
            searchInput.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void checkIsSearchFieldEmpty() {
        searchInput.shouldBe(empty);
    }
}
