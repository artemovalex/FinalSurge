package by.organisation.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Workout {

    private String date;
    private String timeOfDay;
    private String workoutName;
    private String workoutDescription;
    private Long distance;
    private String duration;
    private Long pace;
    private Long perceivedEffort;
    private Long minHR;
    private Long avgHR;
    private Long maxHR;
    private Long caloriesBurned;
}