package com.example.EmployesAPICRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return "Employee saved successfully in db";
    }

    @GetMapping("/employees")
     public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> emplList=new ArrayList<>();
        employeeRepository.findAll().forEach(emplList::add);
        return new ResponseEntity<List<Employee>>(emplList, HttpStatus.OK);
    }

    @GetMapping("/employees/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empid){
        Optional<Employee> emp=employeeRepository.findById(empid);
        if(emp.isPresent()) {
            return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/employees/{empid}")
    public String updateEmployeeById(@PathVariable long empid, @RequestBody Employee employee) {
        Optional<Employee> emp = employeeRepository.findById(empid);
        if (emp.isPresent()) {
            Employee existEmp = emp.get();
            existEmp.setEmpage(employee.getEmpage());
            existEmp.setEmpcity(employee.getEmpcity());
            existEmp.setEmpname(employee.getEmpname());
            existEmp.setEmpsalary(employee.getEmpsalary());
            employeeRepository.save(existEmp);
            return "Employee Details against Id " + empid + " updated";
        } else {
            return "Employee Details does not exist for empid " + empid;
        }
    }

    @DeleteMapping("/employees/{empid}")
    public String deleteEmployee(@PathVariable Long empid){
        Optional<Employee> emp=employeeRepository.findById(empid);
        if(emp.isPresent()){
            employeeRepository.deleteById(empid);
            return "Employee deleted successfully";
        }
        else {
            return "Employee not found";
        }
    }

    @DeleteMapping("/employees")
    public String deleteEmployeeAll(){
            employeeRepository.deleteAll();
            return "Employee deleted successfully";
    }

    //===================Get by city=============================================


    @GetMapping("/employees/empcity")
    public ResponseEntity<List<Employee>> getEmployeesByCity(@RequestParam("emp_city") String emp_city) {
        List<Employee> employees = employeeRepository.findByEmpcity(emp_city);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //===================Get by age greater than=============================================
    @GetMapping("/employee/employeeGreaterThan")
    public ResponseEntity<List<Employee>> getEmployeeGreaterThan(@RequestParam("emp_age") int emp_age){
        Optional<List<Employee>> empList = employeeRepository.findByEmpageGreaterThan(emp_age);
        return new ResponseEntity<List<Employee>>(empList.get(), HttpStatus.FOUND);
    }

}
