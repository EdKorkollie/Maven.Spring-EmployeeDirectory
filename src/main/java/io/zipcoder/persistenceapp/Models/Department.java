package io.zipcoder.persistenceapp.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;


//@JsonIgnoreProperties ignores the specified logical properties in Json serialization and deseralization.
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Employee manager;

    public Department() {

    }

    public Department(String departmentName, Employee manager) {
        this.name = departmentName;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getdepartmentName() {
        return name;
    }

    public void setdepartmentName(String departmentName) {
        this.name = departmentName;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
    public Employee getDepartmentManager() {
        return manager;
    }
    public void setDepartmentManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;

        }
        if(!(o instanceof  Department)) {
            return false;
        }
        Department that = (Department) o;
        return name.equals(that.name) &&
                manager.equals(that.manager);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manager);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                '}';
    }
}
