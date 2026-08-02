package com.app.jobapplication.Job;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class jobController {
    private final JobService jobService; 
    @GetMapping
    public ResponseEntity<List<JobResponse>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobs());
    }
}
