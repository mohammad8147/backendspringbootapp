package com.javabackendspringboot.service.impl;

import com.javabackendspringboot.exception.ResourceNotFoundException;
import com.javabackendspringboot.model.Employee;
import com.javabackendspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
      /* Optional<Employee> employee= employeeRepository.findById(id);
       if(employee.isPresent()){
           return employee.get();
       }else{
           throw new ResourceNotFoundException("Employee","id",id);
       }*/
        //using lamda exp
        return employeeRepository.findById(id).orElseThrow(()->
                    new ResourceNotFoundException("Employee","id",id));

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //we need to check weather employee with given is is exit in DB or not
        Employee exitingEmployee=employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee","id",id));
             exitingEmployee.setFirstName(employee.getFirstName());
             exitingEmployee.setLastName(employee.getLastName());
             exitingEmployee.setEmailId(employee.getEmailId());
             //save exiting employee to DB
        employeeRepository.save(exitingEmployee);
        return exitingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check weather a employee exit in a DB or not
        employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","id",id));
        employeeRepository.deleteById(id);
    }


}
