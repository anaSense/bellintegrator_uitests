package tests;

import data.SearchConstants;
import helpers.StringsHelper;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.SearchResultPage;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonSearchTests extends TestBase {

    private final BasePage basePage = new BasePage();
    private final SearchResultPage searchResultPage = new SearchResultPage();

    private int searchResultCountWithCase = 0;
    private int searchResultCountWithoutCase = 0;

    @Test
    @Feature("Common search options")
    @Story("Check common search in header")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("The upper register ignoring in search")
    void ignoringTheUpperRegisterTest() {
        step("Open start webpage", () -> {
            basePage.openPage();
        });
        step("Click to the search button", () -> {
            basePage.clickToSearchBtn();
        });
        step(format("Enter text \"%s\" in search field and press ENTER",
                SearchConstants.SEARCH_STRING_WITH_CASE), () -> {
            basePage.enterTextToSearchFieldAndAccept(SearchConstants.SEARCH_STRING_WITH_CASE);
        });
        step("Check that all results contain "
                + SearchConstants.SEARCH_STRING_WITH_CASE, () -> {
            searchResultPage.checkValueInSearchResult(SearchConstants.SEARCH_STRING_WITH_CASE);
        });

        searchResultCountWithCase = searchResultPage.
                getSizeOfSearchResult(SearchConstants.SEARCH_STRING_WITH_CASE);

        step("Open start webpage again", () -> {
            basePage.openPage();
        });
        step("Click to the search button", () -> {
            basePage.clickToSearchBtn();
        });
        step(format("Enter text \"%s\" in search field and press ENTER",
                SearchConstants.SEARCH_STRING_WITHOUT_CASE), () -> {
            basePage.enterTextToSearchFieldAndAccept(SearchConstants.SEARCH_STRING_WITHOUT_CASE);
        });
        step("Check that all results contain "
                + SearchConstants.SEARCH_STRING_WITHOUT_CASE, () -> {
            searchResultPage.checkValueInSearchResult(SearchConstants.SEARCH_STRING_WITHOUT_CASE);
        });

        searchResultCountWithoutCase = searchResultPage.
                getSizeOfSearchResult(SearchConstants.SEARCH_STRING_WITHOUT_CASE);
        step(format("Check the search by \"%s\" contains the same " +
                "result counts as the search by {1}", SearchConstants.SEARCH_STRING_WITHOUT_CASE,
                SearchConstants.SEARCH_STRING_WITH_CASE), () -> {
            assertThat((searchResultCountWithCase == searchResultCountWithoutCase)
                    && (searchResultCountWithCase != 0) &&
                    (searchResultCountWithoutCase != 0)).isTrue();
        });


    }

    @Test
    @Feature("Common search options")
    @Story("Check common search in header")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("The error is shown when entering value < min (3 letters)")
    void errorIfEnterValueLessMinTest() {
        step("Open start webpage", () -> {
            basePage.openPage();
        });
        step("Click to the search button", () -> {
            basePage.clickToSearchBtn();
        });
        step(format("Enter text \"%s\" in search field and press ENTER",
                SearchConstants.SEARCH_STRING_LESS_MIN), () -> {
            basePage.enterTextToSearchFieldAndAccept(SearchConstants.SEARCH_STRING_LESS_MIN);
        });
        step("Check error message is visible", () -> {
            searchResultPage.checkErrorMessageIsVisible(SearchConstants.SEARCH_ERROR_TEXT);
        });
    }

    @Test
    @Feature("Common search options")
    @Story("Check common search in header")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successfully search combination of words by AND")
    void searchResultsForAndCombinationTest() {
        step("Open start webpage", () -> {
            basePage.openPage();
        });
        step("Click to the search button", () -> {
            basePage.clickToSearchBtn();
        });
        step(format("Enter text \"%s\" in search field and press ENTER",
                SearchConstants.SEARCH_AND_COMBINATION), () -> {
            basePage.enterTextToSearchFieldAndAccept(SearchConstants.SEARCH_AND_COMBINATION);
        });
        step("Check that all results contain combination of " +
                SearchConstants.SEARCH_AND_COMBINATION, () -> {
            String[] searchWorlds = StringsHelper.divideStringBySeparator(
                    SearchConstants.SEARCH_AND_COMBINATION, "AND");
            searchResultPage.checkValueInSearchResultWithCombination(searchWorlds);
        });

    }

    @Test
    @Feature("Common search options")
    @Story("Check common search in header")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successfully clean the search line by BACKSPACE")
    void abilityToCleanSearchLineTest() {
        step("Open start webpage", () -> {
            basePage.openPage();
        });
        step("Click to the search button", () -> {
            basePage.clickToSearchBtn();
        });
        step(format("Enter text \"%s\" in search field",
                SearchConstants.SEARCH_STRING_WITHOUT_CASE), () -> {
            basePage.enterTextToSearchField(SearchConstants.SEARCH_STRING_WITHOUT_CASE);
        });
        step("Clear text from search field by BACK SPACE", () -> {
            basePage.pressBackspace(SearchConstants.SEARCH_STRING_WITHOUT_CASE.length());
        });
        step("Сheck that the search field is empty ", () -> {
            basePage.checkIsSearchFieldEmpty();
        });
    }

    @Test
    @Feature("Common search options")
    @Story("Check common search in header")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Successfully search by exacting string")
    void searchExactingStringTest() {
        step("Open start webpage", () -> {
            basePage.openPage();
        });
        step("Click to the search button", () -> {
            basePage.clickToSearchBtn();
        });
        step(format("Enter text \"%s\" in search field and press ENTER",
                SearchConstants.SEARCH_EXACTING_TEXT), () -> {
            basePage.enterTextToSearchFieldAndAccept(SearchConstants.SEARCH_EXACTING_TEXT);
        });
        step("Check that all results contain " +
                SearchConstants.SEARCH_EXACTING_TEXT, () -> {
            String rareString = SearchConstants.SEARCH_EXACTING_TEXT.replace("\"", "");
            searchResultPage.checkValueInSearchResult(rareString);
        });
    }
}
