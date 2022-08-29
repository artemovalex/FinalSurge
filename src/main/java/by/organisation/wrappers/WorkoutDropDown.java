package by.organisation.wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WorkoutDropDown {

    String label;

    public WorkoutDropDown(String label) {
        this.label = label;
    }

    public void select(String option) {
        $(By.id(label)).click();
        $x(String.format("//select[@name='%s']//option[@value='%s']", label, option)).click();
    }
}