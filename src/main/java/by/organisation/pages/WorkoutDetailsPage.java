package by.organisation.pages;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;

public class WorkoutDetailsPage {

    public WebElement getUpdateWorkoutButton() {
        return $x("//span[@class='dropdown-toggle']");
    }
}