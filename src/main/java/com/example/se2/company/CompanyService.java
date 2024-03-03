package com.example.se2.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findOne(Long id) {
        return companyRepository.findById(id).get();
    }

    public void save(Company company) {
        companyRepository.save(company);
    }

    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
