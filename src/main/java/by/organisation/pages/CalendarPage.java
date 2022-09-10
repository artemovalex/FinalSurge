package by.organisation.pages;

import by.organisation.dto.Workout;
import by.organisation.utils.PropertiesLoader;
import by.organisation.wrappers.Input;
import by.organisation.wrappers.WorkoutDropDown;
import by.organisation.wrappers.WorkoutTextArea;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.By.id;

public class CalendarPage {
    Faker faker = new Faker();
    int day = faker.number().numberBetween(1, 28);

    public CalendarPage open() {
        String baseUrl = PropertiesLoader.loadProperties("configuration.properties").getProperty("base.url");
        Selenide.open(baseUrl + "/Calendar.cshtml");
        $(id("CalendarContent")).shouldBe(visible);
        getWebDriver().manage().window().maximize();
        return new CalendarPage();
    }

    public void openUpdateWorkoutMenu(String workoutName) {
        open();
        $x(String.format("//div[contains(text(), '%s')]//ancestor::div[contains(@class, 'dropdown')]", workoutName)).click();
        $x(String.format("//div[contains(text(), '%s')]//ancestor::div[contains(@class, 'dropdown')]//a[contains(text(), 'Update Workout')]", workoutName)).click();
    }

    public void deleteWorkout(String workoutName) {
        $x(String.format("//div[contains(text(), '%s')]//ancestor::div[contains(@class, 'dropdown')]", workoutName)).hover().click();
        $x(String.format("//div[contains(text(), '%s')]//ancestor::div[contains(@class, 'dropdown')]//a[contains(text(), 'Delete')]", workoutName)).click();
        $x("//div[@class='modal-body']//following::a[contains(text(),'OK')]").click();
        $x(String.format("//div[contains(text(), '%s')]//ancestor::div[contains(@class, 'dropdown')]", workoutName)).shouldNotBe(visible);
    }

    public boolean workoutIsDeleted(String workoutName) {
        try {
            $x(String.format("//div[contains(text(), '%s')]//ancestor::div[contains(@class, 'dropdown')]", workoutName));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getCalendar() {
        return $(id("CalendarContent"));
    }

    public WebElement getBreadcrumbsCalendar() {
        return $x("//ul[@id='breadcrumbs']//a[contains(@href, 'Calendar')]");
    }

    public void openQuickMenu() {
        $x(String.format("//div[contains(text(),'%s')]//ancestor::td//div[contains(@class,'calendar-add')]", day)).hover().click();
        $x(String.format("//div[contains(text(),'%s')]//ancestor::tbody//following::a[@data-day = '%s']", day, day)).shouldBe(visible).click();
    }

    public WebElement getQuickAddTitle() {
        return $(id("QuickAdd"));
    }

    public CalendarPage fillInQuickNewWorkoutModal(Workout workout) {

        new Input("WorkoutDate").fillIn(workout.getDate());
        new Input("WorkoutTime").fillIn(workout.getTimeOfDay());
        new Input("Name").fillIn(workout.getWorkoutName());
        new WorkoutTextArea("Desc").fillIn(workout.getWorkoutDescription());
        new Input("Distance").fillIn(workout.getDistance().toString());
        new Input("Duration").fillIn(workout.getDuration());
        new WorkoutDropDown("ActivityType").selectActivityType(workout.getActivityType());
        return this;
    }

    public void saveQuickWorkout() {
        $(By.id("saveButton")).shouldBe(visible).click();
    }

    public WebElement getQuickWorkoutName(String workoutName) {
        return $x(String.format("//div[contains(text(), '%s')]", workoutName));
    }

    public void logout() {
        $x("//a[text()='Logout']").click();
        $x("//a[text()='Account Login']").click();
    }
}