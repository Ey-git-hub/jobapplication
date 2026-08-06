package com.app.jobapplication.Review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.jobapplication.Review.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Long>{
    
}