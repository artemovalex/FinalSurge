package by.organisation.pages;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;

public class WorkoutDetailsPage {

    public WebElement getUpdateWorkoutButton() {
        return $x("//span[@class='dropdown-toggle']");
    }
    public String getWorkoutName() {
        return $x("//span[@class='activityTypeName']//following::div").getText();
    }
    public String getWorkoutDesc() {
        return $x("//small[text()='Workout Description:']//ancestor::p").getText();
    }
    public WebElement getWorkoutMinHR() {
        return $x("//small[text()='Min HR:']/following-sibling::text()[1]");
    }
    public WebElement getWorkoutAvgHR() {
        return $x("//small[text()='Avg HR:']/following-sibling::text()[1]");
    }

    public WebElement getWorkoutKCal() {
        return $x("//small[text()='Calories Burned:']/following-sibling::text()[1]");
    }
}