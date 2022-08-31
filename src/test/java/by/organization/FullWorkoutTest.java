package by.organization;

import by.organisation.pages.CalendarPage;
import by.organisation.pages.CreateWorkoutPage;
import by.organisation.pages.LoginPage;
import by.organisation.pages.UpdateWorkoutPage;
import by.organisation.testdata.WorkoutProvider;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Log4j2
public class FullWorkoutTest {
    WorkoutProvider workoutProvider = new WorkoutProvider();
    CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage();
    CalendarPage calendarPage = new CalendarPage();
    UpdateWorkoutPage updateWorkoutPage = new UpdateWorkoutPage();

    @BeforeClass
    public void login() {
        new LoginPage().open()
                .loginWithValidData();
        workoutProvider.generateWorkout();

    }

        @Test()
    public void createWorkoutTest() {
        createWorkoutPage.open()
                .openRunMenu();
        createWorkoutPage.fillInNewWorkoutModal(workoutProvider.generateWorkout())
                .saveWorkout(workoutProvider.workoutName);
    }

     @Test(priority = 1)
    public void updateWorkoutTest() {
        calendarPage.openUpdateWorkoutMenu(workoutProvider.workoutName);
        updateWorkoutPage.updateWorkoutPageIsOpened();
        createWorkoutPage.fillInNewWorkoutModal(workoutProvider.generateWorkout())
                .saveWorkout(workoutProvider.workoutName);

    }

    @Test(priority = 2)
    public void deleteWorkoutTest() {
        calendarPage.open();
        calendarPage.deleteWorkout(workoutProvider.workoutName);
    }
}