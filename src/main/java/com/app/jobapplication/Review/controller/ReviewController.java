package com.app.jobapplication.Review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.app.jobapplication.Review.dto.ReviewRequest;
import com.app.jobapplication.Review.dto.ReviewResponse;
import com.app.jobapplication.Review.service.Impl.ReviewServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/companies/{companyId}")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewServiceImpl reviewService;
    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewResponse>> getReviews(@PathVariable Long companyId) {
        return ResponseEntity.ok(reviewService.getAllReviews(companyId));
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@RequestBody ReviewRequest reviewRequest, 
        @PathVariable Long companyId) {
     boolean isCreated=reviewService.createReview(reviewRequest,companyId);
   if(isCreated){
    return ResponseEntity.ok("review created successfully");
   }
   return ResponseEntity.notFound().build();
    
    
}
}