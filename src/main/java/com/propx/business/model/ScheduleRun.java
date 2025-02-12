package com.propx.business.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ScheduleRun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active;

    private String repeatDays; // Stores days as a comma-separated string (e.g., "T,W,T,F,S")

    private LocalDateTime startDate;

    private LocalDateTime endDate; // Nullable for 'No end date'

    private boolean noEndDate; // Flag for 'No end date'

    private int numberOfRuns; // If applicable

    private LocalTime reconciliationTime;

    // Getters and Setters
}
