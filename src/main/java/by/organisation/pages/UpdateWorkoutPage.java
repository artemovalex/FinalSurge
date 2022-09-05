package by.organisation.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class UpdateWorkoutPage {

    public void updateWorkoutPageIsOpened() {
        $x("//ul[@id='breadcrumbs']//a[text()='Update Workout']").shouldBe(visible);
    }
}