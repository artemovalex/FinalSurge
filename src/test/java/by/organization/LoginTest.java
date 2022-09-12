package by.organization;

import by.organisation.pages.CalendarPage;
import by.organisation.pages.LoginPage;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

@Data
@Log4j2

public class LoginTest {

    LoginPage loginPage = new LoginPage();
    CalendarPage calendarPage = new CalendarPage();

    @Test
    public void loginWithValidData() {

        new LoginPage().open()
                       .loginWithValidData();
        assertTrue(calendarPage.getCalendar().isDisplayed(), "User was not logged in");
        assertThat(calendarPage.getBreadcrumbsCalendar().getText())
                               .isEqualTo("Training Calendar");
        log.info("Login with valid data");
    }

    @Test
    public void loginWithInvalidData() {

        new LoginPage().open()
                       .loginWithInvalidData();
        assertThat(loginPage.getError().getText()).isNotNull()
                            .isEqualTo("Invalid login credentials. Please try again.");
        log.info("Login with invalid data");
    }
    @Test
    public void loginWithoutEmail() {

        new LoginPage().open()
                       .loginWithoutEmail();
        assertThat(loginPage.getEmailError().getText()).isNotNull()
                            .isEqualTo("Please enter your e-mail address.");
        log.info("Login without email");
    }
    @Test
    public void loginWithoutPassword() {

        new LoginPage().open()
                       .loginWithoutPassword();
        assertThat(loginPage.getPasswordError().getText()).isNotNull()
                            .isEqualTo("Please enter a password.");
        log.info("Login without password");
    }
}