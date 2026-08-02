package com.app.jobapplication.Job;

import lombok.Data;

@Data
public class jobResponse {
    private Long id;
    private String title;
    private String description; 
    private String minSalary;
    private String maxSalary;
    private String location;


    private static jobResponse fromEntity(jobEntity entity) {
        jobResponse response = new jobResponse();
        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setMinSalary(entity.getMinSalary());
        response.setMaxSalary(entity.getMaxSalary());
        response.setLocation(entity.getLocation());
        return response;
    }
}