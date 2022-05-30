import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MyPageTest {

    @Test
    public void shouldGoToMyPageTest() {
        open("https://github.com/");
        $("[href='/login']").click();
        $("[id='login_field']").sendKeys("DenNoskov");
        $("[id='password']").sendKeys("123456789");
        $("[name='commit']").click();
        $(".Header").shouldBe(Condition.visible);
        $("[aria-label='View profile and more']").click();
        $(byText("Your profile")).click();
        $("[class='btn btn-block js-profile-editable-edit-button']").shouldBe(Condition.visible);
    }
}
