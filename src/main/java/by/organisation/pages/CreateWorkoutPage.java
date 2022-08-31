package by.organisation.pages;

import by.organisation.dto.Workout;
import by.organisation.utils.PropertiesLoader;
import by.organisation.wrappers.Input;
import by.organisation.wrappers.WorkoutDropDown;
import by.organisation.wrappers.WorkoutTextArea;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateWorkoutPage {

    public CreateWorkoutPage open() {
        String baseUrl = PropertiesLoader.loadProperties("configuration.properties").getProperty("base.url");
        Selenide.open(baseUrl + "/WorkoutAdd.cshtml");
        $x("//ul[@id='breadcrumbs']//a[text()='Add Workout']").shouldBe(visible);
        getWebDriver().manage().window().maximize();
        return new CreateWorkoutPage();
    }

    public void openRunMenu() {
        $x("//a[@data-code='run']").shouldBe(visible).click();
        $(By.id("saveButton")).shouldBe(visible);
    }

    public CreateWorkoutPage fillInNewWorkoutModal(Workout workout) {
        new Input("WorkoutDate").fillIn(workout.getDate());
        new Input("WorkoutTime").fillIn(workout.getTimeOfDay());
        new Input("Name").fillIn(workout.getWorkoutName());
        new WorkoutTextArea("Desc").fillIn(workout.getWorkoutDescription());
        new Input("Distance").fillIn(workout.getDistance().toString());
        new Input("Duration").fillIn(workout.getDuration());
        new WorkoutDropDown("PerEffort").select(workout.getPerceivedEffort().toString());
        new Input("MinHR").fillIn(workout.getMinHR().toString());
        new Input("AvgHR").fillIn(workout.getAvgHR().toString());
        new Input("MaxHR").fillIn(workout.getMaxHR().toString());
        new Input("kCal").fillIn(workout.getCaloriesBurned().toString());
        return this;
    }

    public void saveWorkout(String workoutName) {
        $(By.id("saveButton")).click();
        $x(String.format("//div[text()='%s']", workoutName)).shouldBe(visible);
    }
}