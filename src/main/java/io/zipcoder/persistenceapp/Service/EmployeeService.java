package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee createEmployee(String firstName, String lastName, String title, String phoneNumber, String email, String hireDate, Employee manager, Long department) {
        Employee employee = new Employee(firstName, lastName, title, phoneNumber, email, hireDate, manager, department);
        return employeeRepo.save(employee);

    }

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Iterable<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Iterable<Employee> findAllByManager(Long managerId) {
        return employeeRepo.findAllByDepartment(managerId)
    }
}
