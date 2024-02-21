package com.example.se2.employee;

import com.example.se2.employee.entities.Employee;
import com.example.se2.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public Optional<Employee> findOne(Long id) {
    return employeeRepository.findById(id);
  }

  public void create(Employee employee) {
    employeeRepository.save(employee);
  }

  public void update(Employee employee) {
    employeeRepository.save(employee);
  }

  public void delete(Long id) {
    employeeRepository.deleteById(id);
  }

}
