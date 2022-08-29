package by.organization;

import by.organisation.dto.Workout;
import by.organisation.pages.AddWorkoutPage;
import by.organisation.pages.LoginPage;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FullWorkoutTest {

    @BeforeMethod
    public void login() {
        new LoginPage().open()
                .loginWithValidData();
    }

    @Test
    public void createAccountTest() {
        Faker faker = new Faker();
        GregorianCalendar gc = new GregorianCalendar();
        Date dateNow = new Date();


        gc.add(Calendar.DATE, faker.number().numberBetween(1,30));
        Date nextDate = gc.getTime();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("MM/dd/yyyy");
        String date = formatForDateNow.format(nextDate);

        SimpleDateFormat formatForTimeNow = new SimpleDateFormat("hh:mm a");
        String timeOfDay = formatForTimeNow.format(dateNow);

        String workoutName = faker.company().name();
        String workoutDescription = faker.company().suffix();
        Long distance = faker.number().randomNumber();
        String duration = "01:05:00";

        Long pace = faker.number().randomNumber();
        Long perceivedEffort = (long) faker.number().numberBetween(1, 10);
        long minHR = faker.number().numberBetween(1, 300);
        long avgHR = faker.number().numberBetween(1, 300);
        long maxHR = faker.number().numberBetween(1, 300);
        long caloriesBurned = faker.number().numberBetween(1, 3000);

        Workout expWorkout = Workout.builder()
                .date(date)
                .timeOfDay(timeOfDay)
                .workoutName(workoutName)
                .workoutDescription(workoutDescription)
                .distance(distance)
                .duration(duration)
                .pace(pace)
                .perceivedEffort(perceivedEffort)
                .minHR(minHR)
                .avgHR(avgHR)
                .maxHR(maxHR)
                .caloriesBurned(caloriesBurned)
                .build();


        AddWorkoutPage addWorkoutPage = new AddWorkoutPage();
        addWorkoutPage.open()
                .openRunMenu();
        addWorkoutPage.fillInNewWorkoutModal(expWorkout)
                .saveWorkout(workoutName);

    }
}