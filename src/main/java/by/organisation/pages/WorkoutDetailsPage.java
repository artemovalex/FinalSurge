package by.organisation.pages;

import org.apache.commons.lang3.StringUtils;
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

    public String getWorkoutMinHR() {
        String text = $x("//small[text()='Min HR:']/ancestor::p").getText();
        return StringUtils.substringBetween(text, "Min HR: ", " ");
    }

    public String getWorkoutAvgHR() {
        String text = $x("//small[text()='Min HR:']/ancestor::p").getText();
        return StringUtils.substringBetween(text, "Avg HR: ", " ");
    }

    public String getWorkoutMaxHR() {
        String text = $x("//small[text()='Min HR:']/ancestor::p").getText();
        return StringUtils.substringBetween(text, "Max HR: ", " ");
    }
}