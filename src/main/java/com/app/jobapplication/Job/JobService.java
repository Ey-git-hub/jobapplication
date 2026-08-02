package com.app.jobapplication.Job;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public JobResponse addNewJob(JobRequest request){
        JobEntity entity= new JobEntity();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setMinSalary(request.getMinSalary());
        entity.setMaxSalary(request.getMaxSalary());
        entity.setLocation(request.getLocation());
        return JobResponse.fromEntity(jobRepository.save(entity));

    }
   
}
