package com.app.jobapplication.Review.service.Impl;

import org.springframework.stereotype.Service;
import com.app.jobapplication.Review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl {
   private final ReviewRepository reviewRepository;
}
