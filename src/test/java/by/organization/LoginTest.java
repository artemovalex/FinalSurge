package by.organization;

import by.organisation.pages.LoginPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

@Data
@AllArgsConstructor
@Log4j2

public class LoginTest {

    @Test
    public void loginWithValidData() {

        new LoginPage().open()
                .loginWithValidData();
        $(id("CalendarContent")).shouldBe(visible);
        assertThat($x("//ul[@id='breadcrumbs']//a[contains(@href, 'Calendar')]").getText()).isNotNull()
                .isEqualTo("Training Calendar");
    }

    @Test
    public void loginWithInvalidData() {

        new LoginPage().open()
                .loginWithInvalidData();
        $x("//button[@type='submit']").shouldBe(visible);
        assertThat($x("//div[contains(@class, 'alert-error')]//strong").getText()).isNotNull()
                .isEqualTo("Invalid login credentials. Please try again.");
    }
}