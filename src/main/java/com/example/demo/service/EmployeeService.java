package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee save(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> getAll(){
        return repository.findAll();
    }

    public Employee getById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Employee update(Long id, Employee emp){
        Employee existing = repository.findById(id).orElse(null);
        if(existing != null){
            existing.setName(emp.getName());
            existing.setDepartment(emp.getDepartment());
            existing.setSalary(emp.getSalary());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}