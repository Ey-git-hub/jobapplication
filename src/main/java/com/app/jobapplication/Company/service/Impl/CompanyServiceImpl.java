package com.app.jobapplication.Company.service.Impl;

import org.springframework.stereotype.Service;
import com.app.jobapplication.Company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import com.app.jobapplication.Company.service.CompanyService;
import java.util.List;
import com.app.jobapplication.Company.dto.CompanyResponse;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
     
    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyRepository.findAll().stream().map(CompanyResponse::fromEntity).collect(Collectors.toList());
    }
    
}
