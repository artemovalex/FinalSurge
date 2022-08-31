package by.organisation.pages;

import by.organisation.dto.Workout;
import by.organisation.wrappers.WorkoutDetailsTextField;

public class WorkoutDetailsPage {
    public Workout getWorkoutDetails() {
        return Workout.builder()
                .date(getWorkoutDate())
                .timeOfDay(getWorkoutTime())
                .workoutName(getWorkoutName())
                .workoutDescription(getWorkoutDesc())
                .distance(getWorkoutDistance())
                .duration(getWorkoutDuration())
                //.pace(pace)
                .perceivedEffort(getWorkoutPerEffort())
                .minHR(getWorkoutMinHR())
                .avgHR(getWorkoutAvgHR())
                .maxHR(getWorkoutMaxHR())
                .caloriesBurned(getWorkoutKCal())
                .build();
    }

    public String getWorkoutDate() {
        return new WorkoutDetailsTextField("WorkoutDate").getInputValue();
    }

    public String getWorkoutTime() {
        return new WorkoutDetailsTextField("WorkoutTime").getInputValue();
    }

    public String getWorkoutName() {
        return new WorkoutDetailsTextField("Name").getInputValue();
    }

    public String getWorkoutDesc() {
        return new WorkoutDetailsTextField("Desc").getTextAreaValue();
    }

    public Long getWorkoutDistance() {
        return Long.parseLong(new WorkoutDetailsTextField("Distance").getInputValue());
    }

    public String getWorkoutDuration() {
        return new WorkoutDetailsTextField("Duration").getInputValue();
    }

    public Long getWorkoutPerEffort() {
        return Long.parseLong(new WorkoutDetailsTextField("PerEffort").getInputValue());
    }

    public Long getWorkoutMinHR() {
        return Long.parseLong(new WorkoutDetailsTextField("MinHR").getInputValue());
    }

    public Long getWorkoutAvgHR() {
        return Long.parseLong(new WorkoutDetailsTextField("AvgHR").getInputValue());
    }

    public Long getWorkoutMaxHR() {
        return Long.parseLong(new WorkoutDetailsTextField("MaxHR").getInputValue());
    }

    public Long getWorkoutKCal() {
        return Long.parseLong(new WorkoutDetailsTextField("kCal").getInputValue());
    }
}
