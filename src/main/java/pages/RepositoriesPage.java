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
    public SelenideElement issuesButton() {
        return $("[id='issues-tab']").as("кнопка 'Релизов'");
    }
    public SelenideElement inputField() {
        return $("#js-issues-search").as("поле ввода данных");
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
    public SelenideElement newIssueButtonText() {
        return  $(byText("New issue")).as("текст кнопки 'Новый выпуск'");
    }
    public SelenideElement noResultsText() {
        return $(byText("No results matched your search.")).as("текст 'Нет результатов по вашему поиску'");
    }
}
