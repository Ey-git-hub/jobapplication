package com.app.jobapplication.Review.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewerName;
    private String reviewText;
    private int rating;
    private String jobName;
    private String companyName;
    private String reviewerEmail;
    private String reviewerPhone;
}
