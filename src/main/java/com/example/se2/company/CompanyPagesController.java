package com.example.se2.company;

import com.example.se2.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyPagesController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "companyList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable(value = "id") Long id, Model model) {
        Company company = companyService.findOne(id);
        List<Employee> employees = company.getEmployees();
        model.addAttribute("company", company);
        model.addAttribute("employees", employees);
        return "companyDetail";
    }

    @GetMapping("/add")
    public String create(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "companyAdd";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Company company = companyService.findOne(id);
        model.addAttribute("company", company);
        return "companyUpdate";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (companyService.findOne(id) != null) {
            companyService.delete(id);
        }
        return "redirect:/company/list";
    }
}
