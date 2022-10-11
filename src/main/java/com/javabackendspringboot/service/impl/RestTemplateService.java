package com.javabackendspringboot.service.impl;

import com.javabackendspringboot.model.Employee;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestTemplateService {


    RestTemplate restTemplate=new RestTemplate();
    private static final String get_All_Employee_URL="http://localhost:8080/api/v1/employees";
    private static final String create_Employee_URL="http://localhost:8080/api/v1/employees";
    private static final String get_Employee_By_Id_URL="http://localhost:8080/api/v1/employees/{id}";
    private static final String update_Employee_By_Id_URL="http://localhost:8080/api/v1/employees/{id}";
    private static final String delete_Employee_By_Id_URL="http://localhost:8080/api/v1/employees/{id}";

    //Method to get all employee
    public ResponseEntity<String> allEmployee(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //if we using Security
        //headers.add("Authorization","headerValue");
        HttpEntity<String> entity=new HttpEntity<String>("parameters",headers);

       ResponseEntity<String>response= restTemplate.exchange(get_All_Employee_URL, HttpMethod.GET,entity,String.class);
        return  response;
    }

    public  ResponseEntity<Employee> createEmployee(Employee employee){
        return restTemplate.postForEntity(create_Employee_URL,employee,Employee.class);

    }
    public Employee getEmployeeById(int id){
        Map<String,Integer>param=new HashMap<String,Integer>();
        param.put("id",id);
        return restTemplate.getForObject(get_Employee_By_Id_URL,Employee.class,param);
    }

    public void updateEmployee(Employee employee) {
        restTemplate.put(update_Employee_By_Id_URL,employee);
    }

    public void deleteEmployee(int id) {
        Map<String,Integer>params=new HashMap<>();
        params.put("id",id);
        restTemplate.delete(delete_Employee_By_Id_URL,params);
    }
}
