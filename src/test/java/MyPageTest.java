import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("dennoskov")
@Feature("Авторизация")
public class MyPageTest {

    @BeforeEach
    public void setup(){
        step("Открыть сайт https://github.com", () -> {
        open("https://github.com/");
        TestPages.mainPage.mainSignInButton()
                .click();
        });
    }

    @Test
    @DisplayName("Успешная атворизация")
    public void shouldGoToMyPageTest() {
        step("Заполнить поля инпута и пароля и нажать кнопку авторизации", () -> {
            TestPages.mainPage.loginField()
                .sendKeys("DenNoskov");
            TestPages.mainPage.passwordField()
                .sendKeys("123456789");
            TestPages.mainPage.loginButton()
                .click();
        });

        step("Проверить, что появился верхний баннер", () -> {
            TestPages.mainPage.headerBanner()
                .shouldBe(visible);
        });

        step("Открыть выпадающее меню", () -> {
            TestPages.mainPage.dropdownButton()
                .click();
        });

        step("Открыть раздел 'Your profile'", () -> {
            TestPages.mainPage.yourProfileButton()
                .click();
        });

        step("Проверить, что появилась кнопка 'Edit Profile'", () -> {
            TestPages.mainPage.editProfileButton()
                .shouldBe(visible);
        });
    }

    @MethodSource("incorrectCredentials")
    @ParameterizedTest(name = "{displayName} :{0}")
    @DisplayName("Авторизация с некорректными данными")
    public void shouldNotAuthorizeTest(String type, String phone, String password){
        step("Заполнить поля инпута и пароля и нажать кнопку авторизации", () -> {
            TestPages.mainPage.loginField()
                .sendKeys(phone);
            TestPages.mainPage.passwordField()
                .sendKeys(password);
            TestPages.mainPage.loginButton()
                .click();
        });

        step("Проверить, что появилась ошибка", () -> {
            TestPages.mainPage.warningPopup()
                .shouldBe(visible);
        });

    }
    static Stream<Arguments> incorrectCredentials() {
        return Stream.of(
                arguments(
                        "зарегистрированный номер телефона и пароль от чужого аккаунта",
                        "9999999999",
                        "123456789Qq"
                ),
                arguments(
                        "незарегистрированный номер телефона и пароль от чужого аккаунта",
                        "9100000000",
                        "123456789Qq"
                )
        );
    }
}