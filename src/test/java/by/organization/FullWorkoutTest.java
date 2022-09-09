package by.organization;

import by.organisation.dto.Workout;
import by.organisation.pages.*;
import by.organisation.testdata.WorkoutProvider;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class FullWorkoutTest {
    WorkoutProvider workoutProvider = new WorkoutProvider();
    CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage();
    CalendarPage calendarPage = new CalendarPage();
    UpdateWorkoutPage updateWorkoutPage = new UpdateWorkoutPage();
    WorkoutDetailsPage workoutDetailsPage = new WorkoutDetailsPage();
    Workout actualWorkout;

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
        actualWorkout = workoutProvider.generateWorkout();
        createWorkoutPage.fillInNewWorkoutModal(actualWorkout)
                .saveWorkout(workoutProvider.workoutName);
        assertEquals(workoutDetailsPage.getUpdateWorkoutButton().getText(), "Update Workout", "Workout is not created");
        assertEquals(workoutDetailsPage.getWorkoutName(), actualWorkout.getWorkoutName(), "Workout Name is invalid");
        assertEquals(workoutDetailsPage.getWorkoutDesc(), "Workout Description:\n" + actualWorkout.getWorkoutDescription(), "Workout Description is invalid");
        // assertEquals(workoutDetailsPage.getWorkoutMinHR().getText(), actualWorkout.getMinHR().toString(), "Workout Min HR is invalid");
        // assertEquals(workoutDetailsPage.getWorkoutAvgHR(), actualWorkout.getAvgHR().toString(), "Workout Avg HR is invalid");
        // assertEquals(workoutDetailsPage.getWorkoutKCal(), actualWorkout.getCaloriesBurned().toString(), "Workout Calories Burned is invalid");
        log.info("Create workout");
    }

    @Test(priority = 1)
    public void updateWorkoutTest() {
        calendarPage.openUpdateWorkoutMenu(workoutProvider.workoutName);
        updateWorkoutPage.updateWorkoutPageIsOpened();
        actualWorkout = workoutProvider.generateWorkout();
        createWorkoutPage.fillInNewWorkoutModal(actualWorkout)
                .saveWorkout(workoutProvider.workoutName);
        assertEquals(workoutDetailsPage.getUpdateWorkoutButton().getText(), "Update Workout", "Workout is not updated");
        assertEquals(workoutDetailsPage.getWorkoutName(), actualWorkout.getWorkoutName(), "Workout Name is invalid");
        // assertEquals(workoutDetailsPage.getWorkoutDesc(), "Workout Description:\n" + actualWorkout.getWorkoutDescription(), "Workout Description is invalid");
        log.info("Update workout");
    }

    @Test(priority = 2)
    public void deleteWorkoutTest() {
        calendarPage.open()
                .deleteWorkout(workoutProvider.workoutName);
        assertTrue(calendarPage.workoutIsDeleted(workoutProvider.workoutName), "Workout is not deleted");
        log.info("Delete workout");
        calendarPage.logout();
    }
}