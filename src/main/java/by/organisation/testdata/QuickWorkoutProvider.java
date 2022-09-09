package by.organisation.testdata;

import by.organisation.dto.Workout;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class QuickWorkoutProvider {
    public String workoutName = "";
    public String activityType = "Run";

    public Workout generateWorkout() {
        Faker faker = new Faker();
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(faker.number().numberBetween(1, 5));
        this.workoutName = faker.company().profession();

        return Workout.builder()
                .date(localDateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
                .timeOfDay(localDateTime.format(DateTimeFormatter.ofPattern("hh:mm a")))
                .workoutName(workoutName)
                .workoutDescription(faker.company().suffix())
                .distance((long) faker.number().numberBetween(1, 250))
                .duration("01:05:00")
                .activityType(activityType)
                .build();
    }
}