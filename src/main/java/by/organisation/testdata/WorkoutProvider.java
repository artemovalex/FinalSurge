package by.organisation.testdata;

import by.organisation.dto.Workout;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.sql.Types.NULL;

public class WorkoutProvider {
    public String workoutName = "";
    public long perceivedEffort = NULL;

    public Workout generateWorkout() {
        Faker faker = new Faker();
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(faker.number().numberBetween(1, 10));
        this.workoutName = faker.company().profession();
        this.perceivedEffort = faker.number().numberBetween(1, 10);

        return Workout.builder()
                .date(localDateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
                .timeOfDay(localDateTime.format(DateTimeFormatter.ofPattern("hh:mm a")))
                .workoutName(workoutName)
                .workoutDescription(faker.company().suffix())
                .distance((long) faker.number().numberBetween(1, 250))
                .duration("01:05:00")
                .perceivedEffort(perceivedEffort)
                .minHR((long) faker.number().numberBetween(1, 200))
                .avgHR((long) faker.number().numberBetween(1, 250))
                .maxHR((long) faker.number().numberBetween(1, 300))
                .caloriesBurned((long) faker.number().numberBetween(1, 3000))
                .build();
    }
}