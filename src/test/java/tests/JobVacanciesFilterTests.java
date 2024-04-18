package tests;

import data.VacanciesConstants;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VacanciesPage;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class JobVacanciesFilterTests extends TestBase {

    private final VacanciesPage vacanciesPage = new VacanciesPage();

    @Test
    @Feature("Common job vacancies options")
    @Story("Check common filers for vacancies")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check filter vacancies by specialization")
    void filterVacanciesBySpecializationTest() {
        step("Open vacancies webpage", () -> {
            vacanciesPage.openPage();
        });
        step(format("Choose the specific specialization \"%s\"",
                VacanciesConstants.SPECIALIZATION_FILER_VALUE), () -> {
            vacanciesPage.clickToSpecializationBtn();
            vacanciesPage.chooseSpecializationOption(VacanciesConstants.SPECIALIZATION_FILER_VALUE);
        });
        step("Click search button", () -> {
            vacanciesPage.clickSearchButton();
        });
        step(format("Сhecking of found vacancies by filter \"%s\"",
                VacanciesConstants.SPECIALIZATION_FILER_VALUE), () -> {
            vacanciesPage.checkSearchedVacanciesIsMatchToSpecializationFilter
                    (VacanciesConstants.SPECIALIZATION_FILER_VALUE);
        });
    }

    @Test
    @Feature("Common job vacancies options")
    @Story("Check common filers for vacancies")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check filter vacancies by location")
    void filterVacanciesByLocationTest() {
        step("Open vacancies webpage", () -> {
            vacanciesPage.openPage();
        });
        step(format("Choose the specific location \"%s\"",
                VacanciesConstants.LOCATION_FILER_VALUE), () -> {
            vacanciesPage.clickToLocationBtn();
            vacanciesPage.chooseLocationOption(VacanciesConstants.LOCATION_FILER_VALUE);
        });
        step("Click search button", () -> {
            vacanciesPage.clickSearchButton();
        });
        step(format("Сhecking of found vacancies by filter \"%s\"",
                VacanciesConstants.LOCATION_FILER_VALUE), () -> {
            vacanciesPage.checkSearchedVacanciesIsMatchToLocationFilter
                    (VacanciesConstants.LOCATION_FILER_VALUE);
        });
    }

    @Test
    @Feature("Common job vacancies options")
    @Story("Check common filers for vacancies")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check filter vacancies by hot option enable")
    void filterVacanciesByHotOptionTest() {
        step("Open vacancies webpage", () -> {
            vacanciesPage.openPage();
        });
        step("Turn on hot vacation radio button", () -> {
            vacanciesPage.chooseHotVacationsCheckbox();
        });
        step("Click search button", () -> {
            vacanciesPage.clickSearchButton();
        });
        step("Сhecking of found vacancies by the enabled hot vacancy filter", () -> {
            vacanciesPage.checkSearchedVacanciesIsMatchToHotFilter();
        });
    }

    @Test
    @Feature("Common job vacancies options")
    @Story("Check common filers for vacancies")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check filter vacancies by specialization + location + hot option enable + only remote")
    void filterVacanciesByCombinationFiltersTest() {
        step("Open vacancies webpage", () -> {
            vacanciesPage.openPage();
        });
        step(format("Choose the specific specialization \"%s\"",
                VacanciesConstants.SPECIALIZATION_FILER_VALUE), () -> {
            vacanciesPage.clickToSpecializationBtn();
            vacanciesPage.chooseSpecializationOption(VacanciesConstants.SPECIALIZATION_FILER_VALUE);
        });
        step(format("Choose the specific location \"%s\"",
                VacanciesConstants.LOCATION_FILER_VALUE), () -> {
            vacanciesPage.clickToLocationBtn();
            vacanciesPage.chooseLocationOption(VacanciesConstants.LOCATION_FILER_VALUE);
        });
        step("Turn on hot vacation radio button", () -> {
            vacanciesPage.chooseHotVacationsCheckbox();
        });
        step("Turn on remote option", () -> {
            vacanciesPage.chooseRemoteVacationsCheckbox();
        });
        step("Click search button", () -> {
            vacanciesPage.clickSearchButton();
        });
        step(format("Сhecking of found vacancies by filters: \"%s\", \"%s\"," +
                        " enabled hot filter, enabled remote filter",
                VacanciesConstants.SPECIALIZATION_FILER_VALUE,
                VacanciesConstants.LOCATION_FILER_VALUE), () -> {
            vacanciesPage.checkSearchedVacanciesIsMatchToComplexFilter
                    (VacanciesConstants.SPECIALIZATION_FILER_VALUE,VacanciesConstants.LOCATION_FILER_VALUE);
        });
    }
}
