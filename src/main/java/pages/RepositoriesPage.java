package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RepositoriesPage {

    public SelenideElement repositoriesButton() {
        return $(byText("Repositories")).as("кнопка репозитория");
    }
    public SelenideElement jUnitButton() {
        return $(byText("junit4")).as("кнопка джеюнита4");
    }
    public SelenideElement pullRequestsButton() {
        return $(byText("Pull requests")).as("кнопка пул-реквест");
    }
    public SelenideElement dropdownJUnitButton() {
        return $("[class='btn css-truncate']").as("кнопка выпадающего меню");
    }
    public SelenideElement fixturesBranchButton() {
        return $(byText("fixtures")).as("кнопка фичя ветки");
    }
    public SelenideElement issuesButton() {
        return $("[id='issues-tab']").as("кнопка релиза");
    }
    public SelenideElement inputField() {
        return $("[id='js-issues-search']").as("поле ввода данных");
    }
}
