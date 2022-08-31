package by.organisation.testdata;

import by.organisation.dto.Workout;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorkoutProvider {

    public WorkoutProvider() {
    }

    public Workout generateWorkout(){
        Faker faker = new Faker();
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(faker.number().numberBetween(1,30));
        String date = localDateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String timeOfDay = localDateTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
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

        return Workout.builder()
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
    }
}
