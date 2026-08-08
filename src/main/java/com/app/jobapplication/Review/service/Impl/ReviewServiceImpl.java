package com.app.jobapplication.Review.service.Impl;

import java.util.List;
// import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.jobapplication.Company.dto.CompanyResponse;
import com.app.jobapplication.Company.entity.CompanyEntity;
import com.app.jobapplication.Company.service.CompanyService;
import com.app.jobapplication.Review.dto.ReviewRequest;
import com.app.jobapplication.Review.dto.ReviewResponse;
import com.app.jobapplication.Review.entity.ReviewEntity;
import com.app.jobapplication.Review.repository.ReviewRepository;
import com.app.jobapplication.Review.service.ReviewService;
// import java.util.Collection
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
   private final ReviewRepository reviewRepository;
   private final CompanyService companyService;
 @Override
 public List<ReviewResponse> getAllReviews(Long companyId){
  return reviewRepository.findByCompanyEntityId(companyId);
 }
@Override
public boolean createReview(ReviewRequest reviewRequest, Long id) {
   CompanyResponse company=companyService.getCompanyById(id);
   if(company != null){
   ReviewEntity review= new ReviewEntity();
   review.setTitle(reviewRequest.getTitle());
   review.setDescription(reviewRequest.getDescription());
   review.setRating(reviewRequest.getRating());
   reviewRepository.save(review);
   return true;
   }
   return false;
   
}

public ReviewResponse getReviewById(Long companyId,Long reviewId){
   List<ReviewResponse> reviews =getAllReviews(companyId);
           return reviews.stream().filter(review-> review.getId().equals(reviewId))
           .findFirst()
           .orElse(null);

}
}
