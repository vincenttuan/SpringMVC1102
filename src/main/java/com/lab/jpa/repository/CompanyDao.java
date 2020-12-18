package com.lab.jpa.repository;

import com.lab.jpa.entities.Club;
import com.lab.jpa.entities.Department;
import com.lab.jpa.entities.Employee;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session = null;
    
    private Session getSession() {
        return getSession(true);
    }
    // flag: true (提供給查詢), false: 提供給新增修改刪除
    private Session getSession(boolean flag) {
        if(flag && session != null) {
            return session;
        }
        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
        return session;
    }
    
    // 查詢所有部門資料
    public List queryAllDepts() {
        List list = getSession().createQuery("from Department d").list();
        return list;
    }
    
    // 新增部門
    @Transactional
    public void saveDept(Department dept) {
        getSession(false).persist(dept);
    }
    
    // 查詢所有社團資料
    public List queryAllClubs() {
        List list = getSession().createQuery("from Club c").list();
        return list;
    }
    
    // 新增社團
    @Transactional
    public void saveClub(Club club) {
        getSession(false).persist(club);
    }
    
    // 查詢所有員工
    public List queryAllEmps() {
        List list = getSession().createQuery("from Employee e").list();
        return list;
    }
    
    // 查詢單筆員工
    public Employee getEmp(Integer id) {
        Employee emp = (Employee)getSession().get(Employee.class, id);
        return emp;
    }
    
}
