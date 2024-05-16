package tests;

import helpers.StringsHelper;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.SearchResultPage;

import static helpers.PropertyReader.constantsProperties;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Common search options")
@Story("Check of common search in the header")
@Owner("egorovaa")
public class CommonSearchTests extends TestBase {

    private final BasePage basePage = new BasePage();
    private final SearchResultPage searchResultPage = new SearchResultPage();

    private int searchResultCountWithCase = 0;
    private int searchResultCountWithoutCase = 0;

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("The uppercase letters are ignored in the search")
    void ignoringTheUpperRegisterTest() {
        String searchStringWithCase = constantsProperties.getProperty("searchStringWithCase");
        String searchStringWithoutCase = constantsProperties.getProperty("searchStringWithoutCase");

        step("Open start webpage", () ->
            basePage.openPage());
        step("Click on the search button", () ->
            basePage.clickToSearchBtn());
        step(format("Enter text \"%s\" in search field and press ENTER",
                searchStringWithCase), () ->
            basePage.enterTextToSearchFieldAndAccept(searchStringWithCase));
        step("Check that all results contain " + searchStringWithCase, () ->
            searchResultPage.checkValueInSearchResult(searchStringWithCase));

        searchResultCountWithCase = searchResultPage
                .getSizeOfSearchResult();

        step("Open start webpage again", () ->
            basePage.openPage());
        step("Click on the search button", () ->
            basePage.clickToSearchBtn());
        step(format("Enter text \"%s\" in search field and press ENTER",
                searchStringWithoutCase), () ->
            basePage.enterTextToSearchFieldAndAccept(searchStringWithoutCase));
        step("Check that all results contain a " + searchStringWithoutCase, () ->
            searchResultPage.checkValueInSearchResult(searchStringWithoutCase));

        searchResultCountWithoutCase = searchResultPage.getSizeOfSearchResult();
        step(format("Check the search by \"%s\" contains the same "
                + "result counts as the search by \"%s\"", searchStringWithoutCase,
                searchStringWithCase), () -> {
            assertThat((searchResultCountWithCase == searchResultCountWithoutCase)
                    && (searchResultCountWithCase != 0)
                    && (searchResultCountWithoutCase != 0)).isTrue();
        });


    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("The error is shown when entering value < min (3 letters)")
    void errorIfEnterValueLessMinTest() {
        String searchStringLessMin = constantsProperties.getProperty("searchStringLessMin");

        step("Open start webpage", () ->
                basePage.openPage());
        step("Click on the search button", () ->
                basePage.clickToSearchBtn());
        step(format("Enter text \"%s\" in search field and press ENTER", searchStringLessMin), () ->
            basePage.enterTextToSearchFieldAndAccept(searchStringLessMin));
        step("Check that the error message is visible", () ->
            searchResultPage.checkErrorMessageIsVisible(constantsProperties.getProperty("searchErrorText")));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successful search of word combination using AND")
    void searchResultsForAndCombinationTest() {
        String searchAndCombination = constantsProperties.getProperty("searchAndCombination");

        step("Open start webpage", () ->
            basePage.openPage());
        step("Click on the search button", () ->
            basePage.clickToSearchBtn());
        step(format("Enter text \"%s\" in search field and press ENTER", searchAndCombination), () ->
            basePage.enterTextToSearchFieldAndAccept(searchAndCombination));
        step("Check that all results contain a combination of " + searchAndCombination, () -> {
            String[] searchWorlds = StringsHelper.divideStringBySeparator(searchAndCombination,
                    "AND");
            searchResultPage.checkValueInSearchResultWithCombination(searchWorlds);
        });

    }

    @Test
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successfully clean the search line by BACKSPACE")
    void abilityToCleanSearchLineTest() {
        String searchStringWithoutCase = constantsProperties.getProperty("searchStringWithoutCase");

        step("Open start webpage", () ->
            basePage.openPage());
        step("Click on the search button", () ->
            basePage.clickToSearchBtn());
        step(format("Enter text \"%s\" in search field", searchStringWithoutCase), () ->
            basePage.enterTextToSearchField(searchStringWithoutCase));
        step("Clear text from search field by BACKSPACE", () ->
            basePage.pressBackspace(searchStringWithoutCase.length()));
        step("Сheck that the search field is empty", () ->
            basePage.checkIsSearchFieldEmpty());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successful search by exacting string")
    void searchExactingStringTest() {
        String searchExactingText = constantsProperties.getProperty("searchExactingText");
        step("Open start webpage", () ->
            basePage.openPage());
        step("Click on the search button", () ->
            basePage.clickToSearchBtn());
        step(format("Enter text \"%s\" in search field and press ENTER", searchExactingText), () ->
            basePage.enterTextToSearchFieldAndAccept(searchExactingText));
        step("Check that all results contain a " + searchExactingText, () -> {
            String rareString = searchExactingText.replace("\"", "");
            searchResultPage.checkValueInSearchResult(rareString);
        });
    }
}
