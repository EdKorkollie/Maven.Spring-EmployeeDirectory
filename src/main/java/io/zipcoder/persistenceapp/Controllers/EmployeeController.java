package io.zipcoder.persistenceapp.Controllers;

import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByManager/{managerId}")
    public ResponseEntity<Iterable<Employee>> findAllByManager(@PathVariable Long managerId) {
        return new ResponseEntity<>(employeeService.findAllByManager(managerId), HttpStatus.OK);
    }
    @GetMapping("/findByDepartment/{departmentId")
    public ResponseEntity<Iterable<Employee>> findAllByDepartment(@PathVariable Long departmentId) {
        return new ResponseEntity<>(employeeService.findAllByDepartment(departmentId), HttpStatus.OK);
    }

    @GetMapping("/noManager")
    public ResponseEntity<Iterable<Employee>> findAllWithNoManager() {
        return new ResponseEntity<>(employeeService.findAllWithNoManager(), HttpStatus.OK);
    }

    @GetMapping("/{id}/findAllManagers")
    public ResponseEntity<List<Employee>>  findAllManagers(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findHierarchy(id), HttpStatus.OK);
    }

    @GetMapping("/findByManager/includirect/{managerId}")
    public ResponseEntity<List<Employee>> findByManagerIndirect(@PathVariable Long managerId) {
        return new ResponseEntity<>(employeeService.findAllByManagerinCdirect(managerId), HttpStatus.OK);
    }

    @PutMapping("/{id}/updateManager/{managerId}")
    public ResponseEntity<Employee> updateManagerId(@PathVariable Long id, @PathVariable Long managerId) {
        return new ResponseEntity<>(employeeService.updateManager(id, managerId), HttpStatus.OK);
    }

    @PutMapping("/{id}/updateManager")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteEmployeeList(@RequestBody List<Employee> employees) {
        return new ResponseEntity<>(employeeService.deleteEmployeeList(employees), HttpStatus.OK);
    }


}
