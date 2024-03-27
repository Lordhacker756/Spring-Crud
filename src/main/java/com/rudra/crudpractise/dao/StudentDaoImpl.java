package com.rudra.crudpractise.dao;

import com.rudra.crudpractise.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    private final EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }


    @Override
    @Transactional
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> allStuds = entityManager.createQuery("FROM Student", Student.class);
        return  allStuds.getResultList();
    }


    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> allStuds = entityManager.createQuery("from Student where lastName=:ln", Student.class);
        allStuds.setParameter("ln", lastName);
        return allStuds.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public List<Student> updateAllStudents() {
        entityManager.createQuery("UPDATE Student SET lastName = 'Mishra'").executeUpdate();
        // Assuming you want to return all updated students after the update
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName = 'Mishra'", Student.class)
                .getResultList();
    }


    @Override
    public void removeStudent() {

    }

    @Override
    @Transactional
    public void deleteAllStudent() {
        int numRowsAffected = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println(numRowsAffected + " Number of rows affected");
    }


}
