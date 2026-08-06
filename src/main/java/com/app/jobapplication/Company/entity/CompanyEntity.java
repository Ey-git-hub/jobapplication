package com.app.jobapplication.Company.entity;

import java.util.List;

import com.app.jobapplication.Job.entity.JobEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import lombok.AllArgsConstructor;
import lombok.*;
// import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @OneToMany(mappedBy = "company")
    private List<JobEntity> jobs;
    private String description;
}
