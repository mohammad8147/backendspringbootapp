package com.javabackendspringboot.controller;

import com.javabackendspringboot.exception.ResourceNotFoundException;
import com.javabackendspringboot.model.Employee;
import com.javabackendspringboot.repository.EmployeeRepository;
import com.javabackendspringboot.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    // build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }

    // buidl  get all employee REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
// build get employee by id REST API
    //http://localhost:8080/api/v1/employee/1
     @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return  new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);

    }

    //build update employee REST Api
    // http://localhost:8080/api/v1/employee/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }
     //buid delete employee REST Api
    // http://localhost:8080/api/v1/employee/1
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        //delete employee form DB
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted Successfully.",HttpStatus.OK);
    }


}
