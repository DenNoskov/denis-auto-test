package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement mainSignInButton() {
        return $("[href='/login']").as("кнопка логина");
    }
    public SelenideElement loginField() {
        return $("#login_field").as("поле логина");
    }
    public SelenideElement passwordField() {
        return $("#password").as("поле пароля");
    }
    public SelenideElement loginButton() {
        return $("[name='commit']").as("кнопка входа");
    }
    public SelenideElement headerBanner() {
        return $(".Header").as("верхний баннер");
    }
    public SelenideElement dropdownButton() {
        return $("[aria-label='View profile and more']").as("кнопка выпадающего меню");
    }
    public SelenideElement yourProfileButton() {
        return $(byText("Your profile")).as("кнопка 'Мой профиль'");
    }
    public SelenideElement editProfileButton() {
        return $("[class='btn btn-block js-profile-editable-edit-button']").as("кнопка 'Редактировать профиль'");
    }
    public SelenideElement warningPopup() {
        return $(".flash.flash-full.flash-error").as("всплывающее предупреждение");
    }
}
