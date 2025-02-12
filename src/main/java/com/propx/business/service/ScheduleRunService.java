package com.example.scheduling.service;

import com.example.scheduling.model.ScheduleRun;
import com.example.scheduling.repository.ScheduleRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleRunService {
    @Autowired
    private ScheduleRunRepository repository;

    public ScheduleRun saveSchedule(ScheduleRun schedule) {
        return repository.save(schedule);
    }

    public List<ScheduleRun> getAllSchedules() {
        return repository.findAll();
    }

    public Optional<ScheduleRun> getScheduleById(Long id) {
        return repository.findById(id);
    }
}
