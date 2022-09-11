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
    }

    @Test
    public void loginWithInvalidData() {

        new LoginPage().open()
                       .loginWithInvalidData();
        assertThat(loginPage.getError().getText()).isNotNull()
                            .isEqualTo("Invalid login credentials. Please try again.");
    }
}