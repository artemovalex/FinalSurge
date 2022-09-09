package by.organization;

import by.organisation.pages.*;
import by.organisation.testdata.QuickWorkoutProvider;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Data
@Log4j2
public class QuickAddWorkoutTest {
    CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage();
    CalendarPage calendarPage = new CalendarPage();
    UpdateWorkoutPage updateWorkoutPage = new UpdateWorkoutPage();
    WorkoutDetailsPage workoutDetailsPage = new WorkoutDetailsPage();
    QuickWorkoutProvider quickWorkoutProvider = new QuickWorkoutProvider();

  @BeforeClass
  public void login() {
      new LoginPage().open()
              .loginWithValidData();
      quickWorkoutProvider.generateWorkout();
  }

    @Test(priority = 3)
    public void quickCreateWorkoutTest() {
        calendarPage.open()
                .openQuickMenu();
        assertTrue(calendarPage.getQuickAddTitle().isEnabled(), "Quick add new workout forms is not opened");
        log.info("Open quick workout form");
        calendarPage.fillInQuickNewWorkoutModal(quickWorkoutProvider.generateWorkout())
                .saveQuickWorkout();
        assertTrue(calendarPage.getQuickWorkoutName(quickWorkoutProvider.workoutName).isEnabled(), "Quick add new workout forms is not created");
        log.info("Quick workout create");
        }

    @Test(priority = 4)
    public void deleteQuickWorkoutTest() {
        calendarPage.open()
                    .deleteWorkout(quickWorkoutProvider.workoutName);
        assertTrue(calendarPage.workoutIsDeleted(quickWorkoutProvider.workoutName), "Workout is not deleted");
        log.info("Delete workout");
        calendarPage.logout();
    }
}