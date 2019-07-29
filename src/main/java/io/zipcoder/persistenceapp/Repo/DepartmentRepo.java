package io.zipcoder.persistenceapp.Repo;

import io.zipcoder.persistenceapp.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
