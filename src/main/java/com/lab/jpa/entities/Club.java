package com.lab.jpa.entities;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    private String name;
    
    @ManyToMany(mappedBy = "clubs")
    private Set<Employee> employees = new LinkedHashSet<>();
    
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
