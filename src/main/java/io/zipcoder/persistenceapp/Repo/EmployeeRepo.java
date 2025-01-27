package io.zipcoder.persistenceapp.Repo;

import io.zipcoder.persistenceapp.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Iterable<Employee> findAllByManager(Long managerId);

    Iterable<Employee> findAllByDepartment(Long departmentId);

    Iterable<Employee> findByManagerIsNull();
}
