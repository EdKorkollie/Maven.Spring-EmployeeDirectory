package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Models.Department;
import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Repo.DepartmentRepo;
import io.zipcoder.persistenceapp.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepo departmentRepo;
    private EmployeeRepo employeeRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo, EmployeeRepo employeeRepo) {
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
    }

    public Department createDepartment(String departmentName, Employee manager) {
        Department department = new Department(departmentName, manager);
        return departmentRepo.save(department);
    }

    public Department createDepartment(Department departmentName) {
        return departmentRepo.save(departmentName);
    }

    public Iterable<Department> findAll() {
        return  departmentRepo.findAll();
    }

    public Department findById(Long id) {
        return departmentRepo.getOne(id);
    }

    public boolean deletDepartment(Long id) {
        departmentRepo.delete(id);
        return true;
    }

    public Department updateName(Long id, String name) {
        Department previous = findById(id);
        previous.setDepartName(name);
        return departmentRepo.save(previous);
    }
}
