package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static helpers.PropertyReader.constantsProperties;
import static org.assertj.core.api.Assertions.assertThat;

public class VacanciesTableComponent {

    private final SelenideElement vacanciesTable = $(".table-vakansii"),
            pagerBlock = $(".pager"),
            nextPage = $(byText("Следующая страница"));
    private final ElementsCollection vacancyElements = $(".table-vakansii").$("tbody").$$("tr");

    private List<ElementsCollection> getVacanciesResultsFromAllPages() {
        List<ElementsCollection> elements = new ArrayList<ElementsCollection>();
        assertThat(vacanciesTable.exists()).overridingErrorMessage(constantsProperties.getProperty("emptyVacanciesTableError")).isTrue();
        elements.add(vacancyElements);
        if (pagerBlock.exists()) {
            pagerBlock.scrollTo();
            while (nextPage.parent().isDisplayed()) {
                nextPage.parent().click();
                elements.add(vacancyElements);
                pagerBlock.scrollTo();
            }
        }
        return elements;
    }

    private void checkSpecialization(SelenideElement el, String filterValue) {
        String elementValue = el.$(".views-field-field-specializaciya").text();
        assertThat(elementValue.contains(filterValue)).isTrue();
    }

    private void checkLocation(SelenideElement el, String filterValue) {
        String elementValue = el.$(".views-field-field-lokaciya").text();
        assertThat(elementValue.contains(filterValue)).isTrue();
    }

    private void checkHot(SelenideElement el) {
        el.$(".bi-lightning-charge").shouldBe(visible);
    }

    private void checkRemote(SelenideElement el) {
        String elementValue = el.$(".views-field-field-lokaciya").text();
        assertThat(elementValue.contains(constantsProperties.getProperty("remoteWorkText"))).isTrue();
    }

    public void checkSearchedVacanciesIsMatchToFilters(String specializationValue, String locationValue,
                                                       boolean isHot, boolean isRemote) {
        String emptyVacanciesTableError = constantsProperties.getProperty("emptyVacanciesTableError");

        List<ElementsCollection> elementsCollections = getVacanciesResultsFromAllPages();
        assertThat(elementsCollections.isEmpty()).overridingErrorMessage(emptyVacanciesTableError).isFalse();
        elementsCollections.forEach(tmpCollection -> {
            assertThat(tmpCollection.isEmpty()).overridingErrorMessage(emptyVacanciesTableError).isFalse();
            tmpCollection.forEach(element -> {
                if (specializationValue != null)
                    checkSpecialization(element, specializationValue);
                if (locationValue != null)
                    checkLocation(element, locationValue);
                if (isHot)
                    checkHot(element);
                if (isRemote)
                    checkRemote(element);
            });
        });
    }
}
