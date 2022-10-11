package com.javabackendspringboot.controller;

import com.javabackendspringboot.model.Employee;
import com.javabackendspringboot.service.impl.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("/getAllemployee")
    public ResponseEntity<String> getAllEmployee(){
        return restTemplateService.allEmployee();


    }
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return restTemplateService.createEmployee(employee);


    }
    @GetMapping("/getAllemployee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return restTemplateService.getEmployeeById(id);


    }
        @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        restTemplateService.updateEmployee(employee);


    }
    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable int id){
        restTemplateService.deleteEmployee(id);


    }
}
