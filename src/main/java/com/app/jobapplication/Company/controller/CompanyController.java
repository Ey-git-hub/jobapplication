package com.app.jobapplication.Company.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.app.jobapplication.Company.dto.CompanyRequest;
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
  @PostMapping("/update/{id}")
  public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
    boolean isUpdated = companyServiceImpl.updateCompany(id, companyRequest);
    if (isUpdated) {
        return ResponseEntity.ok("Company updated successfully.");
    } else {
        return ResponseEntity.notFound().build();
    }
  }
}