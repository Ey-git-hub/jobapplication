package com.app.jobapplication.Company.service;
import com.app.jobapplication.Company.dto.CompanyResponse;
import java.util.List;

public interface CompanyService {
    List<CompanyResponse> getAllCompanies();
}
