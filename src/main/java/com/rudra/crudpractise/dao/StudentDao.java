package com.rudra.crudpractise.dao;

import com.rudra.crudpractise.entity.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student theStudent);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    public void updateStudent(Student student);

    public List<Student> updateAllStudents();

    public void removeStudent();

    public void deleteAllStudent();
}
