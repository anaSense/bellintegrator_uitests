package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.VacanciesTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
public class VacanciesPage {
    private final SelenideElement specializationTextfield = $("#edit-field-specializaciya-target-id--2"),
            locationTextfield = $("#edit-field-lokaciya-target-id--2"),
            hotVacantionCheckbox = $("#edit-field-goryachee-value--2"),
            remoteVacantionCheckbox = $("#edit-field-udalennka-value--2"),
            searchButton = $("#views-exposed-form-vakansii-block-1").$("button");
    private final ElementsCollection specializationElements = $("#edit-field-specializaciya-target-id--2")
            .$$("option"),
            locationElements = $("#edit-field-lokaciya-target-id--2")
            .$$("option");

    private final VacanciesTableComponent vacanciesTableComponent = new VacanciesTableComponent();

    public void openPage() {
        open("/information/vacancies/");
    }

    public void clickToSpecializationBtn() {
        specializationTextfield.click();
    }

    public void chooseSpecializationOption(String name) {
        specializationElements.findBy(text(name)).click();
    }

    public void clickToLocationBtn() {
        locationTextfield.click();
    }

    public void chooseLocationOption(String name) {
        locationElements.findBy(text(name)).click();
    }

    public void chooseHotVacationsCheckbox() {
        hotVacantionCheckbox.click();
    }

    public void chooseRemoteVacationsCheckbox() {
        remoteVacantionCheckbox.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void checkSearchedVacanciesIsMatchToSpecializationFilter(String specialization) {
        vacanciesTableComponent.checkSearchedVacanciesIsMatchToFilters(specialization, null,
                false, false);
    }

    public void checkSearchedVacanciesIsMatchToLocationFilter(String location) {
        vacanciesTableComponent.checkSearchedVacanciesIsMatchToFilters(null, location,
                false, false);
    }

    public void checkSearchedVacanciesIsMatchToHotFilter() {
        vacanciesTableComponent.checkSearchedVacanciesIsMatchToFilters(null, null,
                true, false);
    }

    public void checkSearchedVacanciesIsMatchToComplexFilter(String specialization, String location) {
        vacanciesTableComponent.checkSearchedVacanciesIsMatchToFilters(specialization, location,
                true, true);
    }

}
