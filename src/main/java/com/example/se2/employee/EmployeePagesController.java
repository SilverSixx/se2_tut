package com.example.se2.employee;

import com.example.se2.employee.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping()
public class EmployeePagesController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public String findAll(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employeeList";
    }
    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.findOne(id).get();
        model.addAttribute("employee", employee);
        return "employeeDetail";
    }
    @GetMapping("/add")
    public String create(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeAdd";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.findOne(id).get();
        model.addAttribute("employee", employee);
        return "employeeUpdate";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if(employeeService.findOne(id).isPresent()){
            employeeService.delete(id);
        }
        return "redirect:/";
    }
}
