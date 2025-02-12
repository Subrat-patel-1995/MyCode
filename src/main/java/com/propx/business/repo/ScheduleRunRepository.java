package com.example.scheduling.repository;

import com.example.scheduling.model.ScheduleRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRunRepository extends JpaRepository<ScheduleRun, Long> {
}

