import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.stream.Stream;

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
        TestPages.repositoriesPage.readmeLink()
                .shouldBe(visible);
        TestPages.repositoriesPage.dropdownJUnitButton()
                .click();
        TestPages.repositoriesPage.fixturesBranchButton()
                .click();
        TestPages.repositoriesPage.fixturesTitle()
                .shouldBe(visible);
    }

        @MethodSource("correctData")
        @ParameterizedTest(name = "{displayName} {0}")
        @DisplayName("Позитивня проверка поиска по релизам в репозитории:")
        public void positiveVerificationOfTheSearch(String type, String searchData){
            TestPages.repositoriesPage.jUnitButton()
                    .click();
            TestPages.repositoriesPage.readmeLink()
                    .shouldBe(visible);
            TestPages.repositoriesPage.issuesButton()
                    .click();
            TestPages.repositoriesPage.newIssueButtonText()
                    .shouldBe(visible);
            TestPages.repositoriesPage.inputField()
                    .click();
            TestPages.repositoriesPage.inputField()
                    .sendKeys(searchData);
            TestPages.repositoriesPage.inputField()
                    .sendKeys(Keys.ENTER);
           TestPages.repositoriesPage.noResultsText()
                    .shouldNotBe(visible);
    }

    static Stream<Arguments> correctData() {
        return Stream.of(
                arguments(
                        "по цифрам и полному слову",
                        "1626 message"
                ),

                arguments(
                        "по цифрам и части слова",
                        "1619 Fea"
                ),

                arguments(
                        "по цифрам",
                        "1701"
                ),

                arguments(
                        "по слову",
                        "Problem"
                )
        );
    }
}
