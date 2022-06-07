import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("dennoskov")
@Feature("Проверка репозиториев 'ДжейЮнитТим'")
public class JUnitTest {

    @BeforeEach
    public void setup(){
        step("Открыть сайт https://github.com/junit-team", () -> {
        open("https://github.com/junit-team");
            TestPages.repositoriesPage.repositoriesButton()
                .click();
            TestPages.repositoriesPage.jUnitTeamImage()
                .shouldBe(visible);
        });
    }

    @Test
    @Story("Проверка репозитория 'ДжейЮнит4'")
    @DisplayName("Переключение на фича ветку")
    public void switchToFeatureBranchTest() {
        step("Открыть репозиторий 'ДжейЮнит4'", () -> {
            TestPages.repositoriesPage.jUnitButton()
                .click();
            TestPages.repositoriesPage.jUnitText()
                .shouldBe(visible);
        });

        step("Открыть выпадающее меню", () -> {
            TestPages.repositoriesPage.dropdownJUnitButton()
                .click();
        });

        step("Переключиться на ветку 'fixtures'", () -> {
            TestPages.repositoriesPage.fixturesBranchButton()
                .click();
        });

        step("Проверить, что есть название ветки 'fixtures'", () -> {
            TestPages.repositoriesPage.fixturesTitle()
                .shouldBe(visible);
        });
    }

        @MethodSource("correctData")
        @ParameterizedTest(name = "{displayName} :{0}")
        @Story("Проверка релизов в репозитории 'ДжейЮнит4'")
        @DisplayName("Позитивня проверка поиска по релизам в репозитории")
        public void positiveVerificationOfTheSearch(String type, String searchData, String searchResults){
            step("Открыть репозиторий 'ДжейЮнит4'", () -> {
                TestPages.repositoriesPage.jUnitButton()
                    .click();
                TestPages.repositoriesPage.jUnitText()
                    .shouldBe(visible);
            });

            step("Открыть раздел 'Releases'", () -> {
                TestPages.repositoriesPage.releaseButton()
                    .click();
                TestPages.repositoriesPage.examinationReleasesButton()
                    .shouldBe(visible);
            });

            step("Ввести валидные данные в поле поиск и нажать кнопку 'Enter'", () -> {
                TestPages.repositoriesPage.inputField()
                    .sendKeys(searchData + Keys.ENTER);
            });

            step("Проверить, что поиск прощёл успешно", () -> {
                TestPages.repositoriesPage.ResultsText()
                    .shouldHave(text(searchResults));
            });
    }

    static Stream<Arguments> correctData() {
        return Stream.of(
                arguments(
                        "по цифрам и полному слову",
                        "JUnit 4.12 Beta 2",
                        "JUnit 4.12 Beta 2"
                ),

                arguments(
                        "по цифрам",
                        "4.12",
                        "JUnit 4.12"
                ),

                arguments(
                        "по слову",
                        "Beta",
                        "Beta"
                )
        );
    }
}
