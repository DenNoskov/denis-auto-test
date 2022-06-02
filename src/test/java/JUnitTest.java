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
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class JUnitTest {

    @BeforeEach
    public void setup(){
        open("https://github.com/junit-team");
        TestPages.repositoriesPage.repositoriesButton()
                .click();
        TestPages.repositoriesPage.jUnitTeamImage()
                .shouldBe(visible);
    }

    @Test
    @DisplayName("Переключение на фича ветку")
    public void switchToFeatureBranchTest() {
        TestPages.repositoriesPage.jUnitButton()
                .click();
        TestPages.repositoriesPage.jUnitText()
                .shouldBe(visible);
        TestPages.repositoriesPage.dropdownJUnitButton()
                .click();
        TestPages.repositoriesPage.fixturesBranchButton()
                .click();
        TestPages.repositoriesPage.fixturesTitle()
                .shouldBe(visible);
    }

        @MethodSource("correctData")
        @ParameterizedTest(name = "{displayName} :{0}")
        @DisplayName("Позитивня проверка поиска по релизам в репозитории")
        public void positiveVerificationOfTheSearch(String type, String searchData, String searchResults){
            TestPages.repositoriesPage.jUnitButton()
                    .click();
            TestPages.repositoriesPage.jUnitText()
                    .shouldBe(visible);
            TestPages.repositoriesPage.releaseButton()
                    .click();
            TestPages.repositoriesPage.examinationReleasesButton()
                    .shouldBe(visible);
            TestPages.repositoriesPage.inputField()
                    .sendKeys(searchData + Keys.ENTER);
           TestPages.repositoriesPage.ResultsText()
                    .shouldHave(text(searchResults));
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
