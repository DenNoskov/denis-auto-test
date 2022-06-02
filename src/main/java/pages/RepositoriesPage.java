package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RepositoriesPage {

    public SelenideElement repositoriesButton() {
        return $(byText("Repositories")).as("кнопка репозитория");
    }
    public SelenideElement jUnitButton() {
        return $(byText("junit4")).as("кнопка 'ДжеЮнита4'");
    }
    public SelenideElement dropdownJUnitButton() {
        return $(".btn.css-truncate").as("кнопка выпадающего меню");
    }
    public SelenideElement fixturesBranchButton() {
        return $(byText("fixtures")).as("кнопка переключения на ветку 'Фикстура'");
    }
    public SelenideElement releaseButton() {
        return  $(byText("Releases")).as("кнопка релизов");
    }
    public SelenideElement inputField() {
        return $(".form-control.subnav-search-input.width-full").as("поле ввода данных");
    }
    public SelenideElement jUnitTeamImage() {
        return $("[alt='@junit-team']").as("изображение иконки 'ДжейЮнит'");
    }
    public SelenideElement jUnitText() {
        return $("#user-content-junit-4").as("текст 'ДжеЮнит4'");
    }
    public SelenideElement fixturesTitle() {
        return $(".btn.css-truncate").as("название ветки 'Фикстуры'");
    }
    public SelenideElement examinationReleasesButton() {
        return  $(".js-selected-navigation-item.selected.subnav-item").as("проверка кнопки 'Релиза'");
    }
    public SelenideElement ResultsText() {
        return $(".clearfix.container-xl.px-3.px-md-4.px-lg-5.mt-4").as("текст проверки результата");
    }
}
