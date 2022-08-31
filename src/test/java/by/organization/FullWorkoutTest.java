package by.organization;

import by.organisation.pages.AddWorkoutPage;
import by.organisation.pages.LoginPage;
import by.organisation.testdata.WorkoutProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FullWorkoutTest {
WorkoutProvider workoutProvider = new WorkoutProvider();
   @BeforeClass
    public void login() {
        new LoginPage().open()
                .loginWithValidData();
       workoutProvider.generateWorkout();

    }

    @Test
    public void createAccountTest() {
        AddWorkoutPage addWorkoutPage = new AddWorkoutPage();

        addWorkoutPage.open()
                .openRunMenu();
        addWorkoutPage.fillInNewWorkoutModal(workoutProvider.generateWorkout())
                .saveWorkout(workoutProvider.workoutName);
    }
    @Test
    public void updateAccountTest() {

    }
}