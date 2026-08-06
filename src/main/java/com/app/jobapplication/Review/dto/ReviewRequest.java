package com.app.jobapplication.Review.dto;

import lombok.Data;

@Data
public class ReviewRequest {
     private String reviewerName;
    private String reviewText;
    private int rating;
    private String jobName;
    private String companyName;
    private String reviewerEmail;
    private String reviewerPhone;
}
