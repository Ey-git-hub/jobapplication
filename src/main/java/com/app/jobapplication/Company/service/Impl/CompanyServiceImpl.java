package com.app.jobapplication.Company.service.Impl;

import org.springframework.stereotype.Service;
import com.app.jobapplication.Company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import com.app.jobapplication.Company.service.CompanyService;
import java.util.List;
// import com.app.jobapplication.Company.entity.Company;
import com.app.jobapplication.Company.entity.CompanyEntity;
import com.app.jobapplication.Company.dto.CompanyRequest;
import com.app.jobapplication.Company.dto.CompanyResponse;
import com.app.jobapplication.Job.dto.JobRequest;
import com.app.jobapplication.Job.entity.JobEntity;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
     
    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyRepository.findAll().stream().map(CompanyResponse::fromEntity).collect(Collectors.toList());
    }
    @Override
    public CompanyResponse updateCompany(Long id,CompanyRequest companyRequest) {
        CompanyEntity existingCompany = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
        existingCompany.setName(companyRequest.getName());
        existingCompany.setLocation(companyRequest.getLocation());
        existingCompany.setDescription(companyRequest.getDescription());

        if (companyRequest.getJobs() != null) {
            List<JobEntity> updatedJobs = companyRequest.getJobs().stream()
                .map(this::mapJobRequestToEntity)
                .collect(Collectors.toList());
            existingCompany.setJobs(updatedJobs);
        }

        CompanyEntity updatedCompany = companyRepository.save(existingCompany);
        return CompanyResponse.fromEntity(updatedCompany);
    }

    private JobEntity mapJobRequestToEntity(JobRequest jobRequest) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setTitle(jobRequest.getTitle());
        jobEntity.setDescription(jobRequest.getDescription());
        jobEntity.setMinSalary(jobRequest.getMinSalary());
        jobEntity.setMaxSalary(jobRequest.getMaxSalary());
        jobEntity.setLocation(jobRequest.getLocation());
        return jobEntity;
    }
    
}
