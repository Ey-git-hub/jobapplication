package com.app.jobapplication.Review.dto;
import com.app.jobapplication.Review.entity.ReviewEntity;
import lombok.*;

@Data
@NoArgsConstructor
public class ReviewResponse {
    private Long id;
    private String reviewerName;
    private String reviewText;
    private int rating;
    private String jobName;
    private String companyName;
    private String reviewerEmail;
    private String reviewerPhone;

    public static ReviewResponse fromEntity(ReviewEntity reviewEntity) {
        ReviewResponse response = new ReviewResponse();
        response.setId(reviewEntity.getId());
        response.setReviewerName(reviewEntity.getReviewerName());
        response.setReviewText(reviewEntity.getReviewText());
        response.setRating(reviewEntity.getRating());
        response.setJobName(reviewEntity.getJobName());
        response.setCompanyName(reviewEntity.getCompanyName());
        response.setReviewerEmail(reviewEntity.getReviewerEmail());
        response.setReviewerPhone(reviewEntity.getReviewerPhone());
        return response;
    }
}
