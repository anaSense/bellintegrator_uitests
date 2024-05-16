package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage {

    private final ElementsCollection searchResultElements = $(".search-results").$$("li");
    private final SelenideElement searchAlert = $(".alert-warning");

    public void checkValueInSearchResult(String searchString) {
        searchResultElements.forEach(tmpElemnt -> {
            String searchResult = tmpElemnt.$(".search-result__snippet")
                    .$("strong").innerText();
            assertThat(searchResult.compareToIgnoreCase(searchString)).isEqualTo(0);
        });
    }

    public void checkValueInSearchResultWithCombination(String[] expectedResults) {
        boolean result = true;
        boolean needFinishСycle = false;
        for (int i = 0; i < searchResultElements.size(); i++) {
            if (needFinishСycle) break;
            ElementsCollection results = searchResultElements.get(i).$(".search-result__snippet")
                    .$$("strong");
            Boolean[] stringsExist = new Boolean[expectedResults.length];
            results.forEach(tmpResult -> {
                String currentValue = tmpResult.innerText();
                for (int l = 0; l < expectedResults.length; l++) {
                    if (currentValue.compareToIgnoreCase(expectedResults[l]) == 0) {
                        stringsExist[l] = true;
                        break;
                    }
                }
            });

            needFinishСycle = Arrays.stream(stringsExist).anyMatch(tmp -> !tmp);
        }
        assertThat(result).isTrue();
    }

    public int getSizeOfSearchResult() {
        return searchResultElements.size();
    }

    public void checkErrorMessageIsVisible(String error) {
        searchAlert.shouldHave(text(error));
    }
}
