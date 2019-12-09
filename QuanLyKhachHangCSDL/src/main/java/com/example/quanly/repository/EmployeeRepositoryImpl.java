package com.example.quanly.repository;

import com.example.quanly.entity.Employee;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("select c from Employee c", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Long id) {
        TypedQuery<Employee> query = em.createQuery("select c from Employee c where  c.id=:id", Employee.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Employee model) {
        if(model.getId() != null){
            em.merge(model);
        } else {
            em.persist(model);
        }
    }
    @Override
    public void remove(Long id) {
        Employee Employee = findById(id);
        if(Employee != null){
            em.remove(Employee);
        }
    }

    @Override
    public List<Employee> findAllEmployeeByDiaChi(String diachi) {
        TypedQuery<Employee> query = em.createQuery("select c from Employee c where  c.diachi=:diachi", Employee.class);
        query.setParameter("diachi", diachi);
        try {
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        TypedQuery<Employee> query = em.createQuery("select c from Employee c where  c.name=:name", Employee.class);
        query.setParameter("name", name);
        try {
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
     public List<Employee> findEmployeeByNameLike(String name) {
        return null;
    }
}

