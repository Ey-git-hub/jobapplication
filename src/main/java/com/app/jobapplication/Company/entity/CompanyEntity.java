package com.app.jobapplication.Company.entity;

import java.util.List;

import com.app.jobapplication.Job.dto.JobRequest;
import com.app.jobapplication.Job.entity.JobEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @OneToMany
    private List<JobEntity> jobs;
    private String description;
}
