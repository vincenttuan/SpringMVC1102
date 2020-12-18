package com.lab.jpa.entities;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    @NotNull
    //@Size(min = 1, max = 20, message = "請輸入社團名稱")
    //預設會抓取 classpath:ValidationMessages.properties
    //classpath -> 在 Eclipse 中就是 src/
    //             在 Netbeans 中就是 src/main/resources
    //             在 war 檔中會配置在 /WEB-INF/classes/
    @Size(min = 1, max = 20, message = "{club.name.empty}")
    private String name;
    
    // 注意, cascade = CascadeType.REMOVE 會把員工也一並刪除
    //@ManyToMany(mappedBy = "clubs", cascade = CascadeType.REMOVE)
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
    
    
    
}
