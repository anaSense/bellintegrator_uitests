package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage {

    private final ElementsCollection searchResultElements = $(".search-results").$$("li");
    private final SelenideElement searchAlert = $(".alert-warning");

    public void checkValueInSearchResult(String searchString) {
        for (int i = 0; i < searchResultElements.size(); i++) {
            String searchResult = searchResultElements.get(i).$(".search-result__snippet").$("strong").innerText();
            assertThat(searchResult.compareToIgnoreCase(searchString)).isEqualTo(0);
        }
    }

    public void checkValueInSearchResultWithCombination(String[] expectedResults) {
        boolean result = true;
        boolean needFinishСycle = false;
        for (int i = 0; i < searchResultElements.size(); i++) {
            if (needFinishСycle) break;
            ElementsCollection results = searchResultElements.get(i).$(".search-result__snippet").$$("strong");
            boolean[] stringsExist = new boolean[expectedResults.length];
            for (int j = 0; j < results.size(); j++) {
                String currentValue = results.get(j).innerText();
                for (int l = 0; l < expectedResults.length; l++) {
                    if (currentValue.compareToIgnoreCase(expectedResults[l]) == 0) {
                        stringsExist[l] = true;
                        break;
                    }
                }
            }
            for (int k = 0; k < stringsExist.length; k++) {
                if (!stringsExist[k]) {
                    needFinishСycle = true;
                    break;
                }
            }
        }
        assertThat(result).isTrue();
    }

    public int getSizeOfSearchResult(String searchString) {
        return searchResultElements.size();
    }

    public void checkErrorMessageIsVisible(String error) {
        searchAlert.shouldHave(text(error));
    }
}
