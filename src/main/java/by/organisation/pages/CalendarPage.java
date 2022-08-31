package by.organisation.pages;

import by.organisation.utils.PropertiesLoader;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.By.id;

public class CalendarPage {

    public CalendarPage open() {
        String baseUrl = PropertiesLoader.loadProperties("configuration.properties").getProperty("base.url");
        Selenide.open(baseUrl + "/Calendar.cshtml");
        $(id("CalendarContent")).shouldBe(visible);
        getWebDriver().manage().window().maximize();
        return new CalendarPage();
    }

    public void openUpdateWorkoutMenu(String workoutName) {
        $x(String.format("//div[contains(text(), '%s')]//ancestor::div[contains(@class, 'dropdown')]//a[contains(text(), 'Update Workout')]", workoutName)).click();
    }

}