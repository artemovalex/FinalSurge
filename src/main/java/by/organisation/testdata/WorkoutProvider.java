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
        LocalDateTime localDateTime = LocalDateTime.now();//.plusDays(faker.number().numberBetween(1,30));
        String date = localDateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String timeOfDay = localDateTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
        this.workoutName = faker.company().name();
        String workoutDescription = faker.company().suffix();
        long distance = faker.number().numberBetween(1, 300);
        String duration = "01:05:00";
        //Long pace = faker.number().randomNumber();
        this.perceivedEffort = (long) faker.number().numberBetween(1, 10);
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
                //.pace(pace)
                .perceivedEffort(perceivedEffort)
                .minHR(minHR)
                .avgHR(avgHR)
                .maxHR(maxHR)
                .caloriesBurned(caloriesBurned)
                .build();
    }
}