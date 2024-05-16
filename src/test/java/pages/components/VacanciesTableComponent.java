package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.VacanciesConstants;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class VacanciesTableComponent {

    private final SelenideElement vacanciesTable = $(".table-vakansii"),
            pagerBlock = $(".pager"),
            nextPage = $(byText("Следующая страница"));
    private final ElementsCollection vacancyElements = $(".table-vakansii").$("tbody").$$("tr");

    private List<ElementsCollection> getVacanciesResultsFromAllPages() {
        List<ElementsCollection> elements = new ArrayList<ElementsCollection>();
        assertThat(vacanciesTable.exists()).overridingErrorMessage(VacanciesConstants.EMPTY_VACANCIES_TABLE_ERROR).isTrue();
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
        assertThat(elementValue.contains(VacanciesConstants.REMOTE_WORK_TEXT)).isTrue();
    }

    public void checkSearchedVacanciesIsMatchToFilters(String specializationValue, String locationValue,
                                                       boolean isHot, boolean isRemote) {
        List<ElementsCollection> elementsCollections = getVacanciesResultsFromAllPages();
        assertThat(elementsCollections.isEmpty()).overridingErrorMessage(VacanciesConstants.EMPTY_VACANCIES_TABLE_ERROR).isFalse();
        for (int i = 0; i < elementsCollections.size(); i++) {
            ElementsCollection tmpCollection = elementsCollections.get(i);
            assertThat(tmpCollection.isEmpty()).overridingErrorMessage(VacanciesConstants.EMPTY_VACANCIES_TABLE_ERROR).isFalse();
            for (int j = 0; j < tmpCollection.size(); j++) {
                if (specializationValue != null) checkSpecialization(tmpCollection.get(j), specializationValue);
                if (locationValue != null) checkLocation(tmpCollection.get(j), locationValue);
                if (isHot) checkHot(tmpCollection.get(j));
                if (isRemote) checkRemote(tmpCollection.get(j));
            }
        }
    }
}
