package by.organisation.wrappers;

import by.organisation.testdata.WorkoutProvider;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class WorkoutDetailsTextField {

    WorkoutProvider workoutProvider = new WorkoutProvider();
    String label;

    public WorkoutDetailsTextField(String label) {
        this.label = label;
    }

    public String getInputValue() {
        return $(By.id(label)).getText();
    }
    public String getTextAreaValue() {
        return $(By.id(label)).getText();
    }
    public String getDropDownValue() {
        return $x(String.format("//select[@name='%s']//option[@value='%s']", label, workoutProvider.workoutName)).getText();
    }
}