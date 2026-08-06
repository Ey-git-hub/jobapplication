package com.app.jobapplication.Review.service;

import com.app.jobapplication.Review.dto.*;
import java.util.List;

public interface ReviewService {
     List<ReviewResponse> getAllReviews();
     boolean updateReview(Long id, ReviewRequest reviewRequest);
     Void createReview(ReviewRequest reviewRequest);
     boolean deleteReview(Long id);
     ReviewResponse getReviewById(Long id);
}
