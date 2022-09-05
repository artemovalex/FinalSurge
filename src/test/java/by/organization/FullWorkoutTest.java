package by.organization;

import by.organisation.pages.*;
import by.organisation.testdata.WorkoutProvider;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Data
@Log4j2
public class FullWorkoutTest {
    WorkoutProvider workoutProvider = new WorkoutProvider();
    CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage();
    CalendarPage calendarPage = new CalendarPage();
    UpdateWorkoutPage updateWorkoutPage = new UpdateWorkoutPage();
    WorkoutDetailsPage workoutDetailsPage = new WorkoutDetailsPage();

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
        assertEquals(createWorkoutPage.getTitle(), "ADD NEW WORKOUT", "Add new workout forms is not opened");
        log.info("Open  create workout page");
        createWorkoutPage.fillInNewWorkoutModal(workoutProvider.generateWorkout())
                .saveWorkout(workoutProvider.workoutName);
        assertEquals(workoutDetailsPage.getUpdateWorkoutButton().getText(), "Update Workout", "Workout is not created");
        log.info("Create workout");
    }

    @Test(priority = 1)
    public void updateWorkoutTest() {
        calendarPage.openUpdateWorkoutMenu(workoutProvider.workoutName);
        updateWorkoutPage.updateWorkoutPageIsOpened();
        createWorkoutPage.fillInNewWorkoutModal(workoutProvider.generateWorkout())
                .saveWorkout(workoutProvider.workoutName);
        assertEquals(workoutDetailsPage.getUpdateWorkoutButton().getText(), "Update Workout", "Workout is not updated");
        log.info("Update workout");
    }

    @Test(priority = 2)
    public void deleteWorkoutTest() {
        calendarPage.open()
                .deleteWorkout(workoutProvider.workoutName);
        calendarPage.logout();
    }
}