package com.app.jobapplication.Company.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.jobapplication.Company.service.Impl.CompanyServiceImpl;
import com.app.jobapplication.Company.dto.CompanyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
 private final CompanyServiceImpl companyServiceImpl;
  @GetMapping
  public ResponseEntity<List<CompanyResponse>> getAllComapnies() {
    return ResponseEntity.ok(companyServiceImpl.getAllCompanies());
  }
}