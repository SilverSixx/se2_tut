package com.example.se2.company;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/company")
public class CompanyApiController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/add")
    public String add(Company company) {
        companyService.save(company);
        return "redirect:/company/" + company.getId();
    }

    @PostMapping("/update")
    public String update(@Valid Company company, BindingResult res) {
        if (res.hasErrors()) {
            return "companyUpdate";
        }
        companyService.save(company);
        return "redirect:/company/" + company.getId();
    }

}
