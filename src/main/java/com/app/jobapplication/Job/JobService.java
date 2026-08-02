package com.app.jobapplication.Job;

// import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class JobService {
    private final JobRepository jobRepository;


    public JobResponse getAllJobs() {
       JobRepository.findAll().stream()
       .map(JobResponse::fromEntity)
       .collect(Collectors.toList);
        
    }
    
}
