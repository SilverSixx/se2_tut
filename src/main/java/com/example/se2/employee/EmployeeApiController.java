package com.example.se2.employee;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employee")
public class EmployeeApiController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping("/add")
  public String create(Employee employee) {
    employeeService.create(employee);
    return "redirect:/" + employee.getId();
  }

  @PostMapping("/update")
  public String update(@Valid Employee employee, BindingResult res) {
    if(res.hasErrors()){
      return "employeeUpdate";
    }
    employeeService.update(employee);
    return "redirect:/" + employee.getId();
  }

}
