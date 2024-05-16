package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VacanciesPage;

import static helpers.PropertyReader.constantsProperties;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@Feature("Common job vacancies options")
@Story("Check the common filters for vacancies")
@Owner("egorovaa")
public class JobVacanciesFilterTests extends TestBase {

    private final VacanciesPage vacanciesPage = new VacanciesPage();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check filtering vacancies by specialization")
    void filterVacanciesBySpecializationTest() {
        String specializationFilterValue = constantsProperties.getProperty("specializationFilterValue");

        step("Open vacancies webpage", () ->
            vacanciesPage.openPage());
        step(format("Choose the specific specialization \"%s\"", specializationFilterValue), () -> {
            vacanciesPage.clickToSpecializationBtn();
            vacanciesPage.chooseSpecializationOption(specializationFilterValue);
        });
        step("Click on the search button", () ->
            vacanciesPage.clickSearchButton());
        step(format("Сheck the found vacancies using filter \"%s\"", specializationFilterValue), () ->
            vacanciesPage.checkSearchedVacanciesIsMatchToSpecializationFilter(specializationFilterValue));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check filtering vacancies by location")
    void filterVacanciesByLocationTest() {
        String locationFilterValue = constantsProperties.getProperty("locationFilterValue");

        step("Open vacancies webpage", () ->
            vacanciesPage.openPage());
        step(format("Choose the specific location \"%s\"", locationFilterValue), () -> {
            vacanciesPage.clickToLocationBtn();
            vacanciesPage.chooseLocationOption(locationFilterValue);
        });
        step("Click on the search button", () ->
            vacanciesPage.clickSearchButton());
        step(format("Сheck the found vacancies using filter \"%s\"", locationFilterValue), () -> {
            vacanciesPage.checkSearchedVacanciesIsMatchToLocationFilter(locationFilterValue);
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check filtering vacancies by \"hot\" option enabled")
    void filterVacanciesByHotOptionTest() {
        step("Open vacancies webpage", () ->
            vacanciesPage.openPage());
        step("Turn on \"hot\" vacation radio button", () ->
            vacanciesPage.chooseHotVacationsCheckbox());
        step("Click on the search button", () ->
            vacanciesPage.clickSearchButton());
        step("Сheck the found vacancies by the enabled \"hot\" vacancy filter", () ->
            vacanciesPage.checkSearchedVacanciesIsMatchToHotFilter());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check filtering vacancies by specialization + location + \"hot\" option enable + only remote")
    void filterVacanciesByCombinationFiltersTest() {
        String locationFilterValue = constantsProperties.getProperty("locationFilterValue");
        String specializationFilterValue = constantsProperties.getProperty("specializationFilterValue");

        step("Open vacancies webpage", () ->
            vacanciesPage.openPage());
        step(format("Choose the specific specialization \"%s\"",
                specializationFilterValue), () -> {
            vacanciesPage.clickToSpecializationBtn();
            vacanciesPage.chooseSpecializationOption(specializationFilterValue);
        });
        step(format("Choose the specific location \"%s\"", locationFilterValue), () -> {
            vacanciesPage.clickToLocationBtn();
            vacanciesPage.chooseLocationOption(locationFilterValue);
        });
        step("Turn on \"hot\" vacation radio button", () ->
            vacanciesPage.chooseHotVacationsCheckbox());
        step("Turn on remote option", () ->
            vacanciesPage.chooseRemoteVacationsCheckbox());
        step("Click on the search button", () ->
            vacanciesPage.clickSearchButton());
        step(format("Сheck the found vacancies by filters: \"%s\", \"%s\", enabled \"hot\" filter, enabled remote filter",
                specializationFilterValue, locationFilterValue), () ->
            vacanciesPage.checkSearchedVacanciesIsMatchToComplexFilter(specializationFilterValue,
                    locationFilterValue));
    }
}
