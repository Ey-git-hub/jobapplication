package com.app.jobapplication.Review.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.jobapplication.Review.service.Impl.ReviewServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewServiceImpl reviewService;
    
}
