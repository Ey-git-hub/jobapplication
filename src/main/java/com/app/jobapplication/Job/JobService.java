package com.app.jobapplication.Job;

import java.util.List;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public List<JobResponse> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(JobResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public JobResponse addNewJob(JobRequest request) {
        JobEntity entity = new JobEntity();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setMinSalary(request.getMinSalary());
        entity.setMaxSalary(request.getMaxSalary());
        entity.setLocation(request.getLocation());
        return JobResponse.fromEntity(jobRepository.save(entity));
    }

    public JobResponse getJobById(Long id) {
        return jobRepository.findById(id)
                .map(JobResponse::fromEntity)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    public JobResponse updateJob(Long id, JobRequest request) throws IllegalAccessException {
        JobEntity existingJob=jobRepository.findById(id).orElseThrow(() -> new IllegalAccessException("job doest not exist by id: "+id));
        existingJob.setTitle(request.getTitle());
        existingJob.setDescription(request.getDescription());
        existingJob.setMinSalary(request.getMinSalary());
        existingJob.setMinSalary(request.getMinSalary());
        existingJob.setLocation(request.getLocation());
        return JobResponse.fromEntity(jobRepository.save(existingJob));
    }
}
