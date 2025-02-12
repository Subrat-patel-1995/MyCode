package com.example.scheduling.controller;

import com.example.scheduling.model.ScheduleRun;
import com.example.scheduling.service.ScheduleRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleRunController {
    @Autowired
    private ScheduleRunService service;

    @PostMapping("/save")
    public ScheduleRun saveSchedule(@RequestBody ScheduleRun schedule) {
        return service.saveSchedule(schedule);
    }

    @GetMapping("/all")
    public List<ScheduleRun> getAllSchedules() {
        return service.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Optional<ScheduleRun> getScheduleById(@PathVariable Long id) {
        return service.getScheduleById(id);
    }
}
