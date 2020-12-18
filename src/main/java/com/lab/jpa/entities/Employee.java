package com.lab.jpa.entities;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    private String name;
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "salary_id")
    private Salary salary;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_club",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "club_id", referencedColumnName = "id")}
    )
    private List<Club> clubs = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", salary=" + salary.getMoney() + ", department=" + department + ", clubs=" + clubs + '}';
    }
    
    
}
