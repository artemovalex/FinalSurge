package by.organisation.wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WorkoutTextArea {

    String label;

    public WorkoutTextArea(String label) {
        this.label = label;
    }

    public void fillIn(String text) {
        $(By.id(label)).sendKeys(text);
    }
}