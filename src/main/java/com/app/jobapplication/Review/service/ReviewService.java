package com.app.jobapplication.Review.service;

import com.app.jobapplication.Review.dto.*;
import java.util.List;

public interface ReviewService {
     List<ReviewResponse> getAllReviews(Long companyId);
     // boolean updateReview(Long id, ReviewRequest reviewRequest);
     boolean createReview(ReviewRequest reviewRequest,Long id);
     // boolean deleteReview(Long id);
     // ReviewResponse getReviewById(Long id);
}
