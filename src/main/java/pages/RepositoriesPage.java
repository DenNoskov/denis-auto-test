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
        return $("[class='btn css-truncate']").as("кнопка выпадающего меню");
    }
    public SelenideElement fixturesBranchButton() {
        return $(byText("fixtures")).as("кнопка переключения на ветку 'Фикстура'");
    }
    public SelenideElement releaseButton() {
        return  $(byText("Releases")).as("кнопка 'Релизов'");
    }
    public SelenideElement inputField() {
        return $("[class='form-control subnav-search-input width-full']").as("поле ввода данных");
    }
    public SelenideElement jUnitTeamImage() {
        return $("[alt='@junit-team']").as("изображение иконки 'ДжейЮнит'");
    }
    public SelenideElement readmeLink() {
        return $("[class='Link--primary']").as("линк файла 'ридми'");
    }
    public SelenideElement fixturesTitle() {
        return $("[class='css-truncate-target']").as("название ветки 'Фикстуры'");
    }
    public SelenideElement examinationReleasesButton() {
        return  $("[class='js-selected-navigation-item selected subnav-item']").as("проверка кнопки 'Релиза'");
    }
    public SelenideElement ResultsText() {
        return $("[class='logged-out env-production page-responsive intent-mouse']").as("текст проверки результата");
    }
}
