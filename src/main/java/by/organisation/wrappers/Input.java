package by.organisation.wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Input {

    String label;

    public Input(String label) {
        this.label = label;
    }

    public void fillIn(String text) {
        $(By.id(label)).clear();
        $(By.id(label)).sendKeys(text);
    }
}