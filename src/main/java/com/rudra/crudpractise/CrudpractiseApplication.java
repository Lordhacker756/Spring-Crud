package com.rudra.crudpractise;

import com.rudra.crudpractise.dao.StudentDao;
import com.rudra.crudpractise.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudpractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudpractiseApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao){
        return runner -> {
//            createStudent(studentDao);
//            findById(studentDao);
//            findAllStudents(studentDao);
//            findByLastName(studentDao);
//              updateStudent(studentDao);
//            updateAllStudents(studentDao);
              deleteAllStudents(studentDao);
        };
    }

    private void deleteAllStudents(StudentDao studentDao) {
        studentDao.deleteAllStudent();
    }

    private void updateAllStudents(StudentDao studentDao) {
        List<Student> modStuds = studentDao.updateAllStudents();
        for(Student stud: modStuds)
        System.out.println("Modifed studetns: "+ stud.toString());
    }

    private void updateStudent(StudentDao studentDao) {
        System.out.println("Finding student with id: 2");

        Student stud = studentDao.findById(1);
        System.out.println("Student found"+stud.toString());

        System.out.println("Updating lastName of it to Reddy");
        stud.setLastName("Reddy");

        System.out.println("Reddy Antunna Babu"+stud.toString());
        studentDao.updateStudent(stud);
    }

    private void findByLastName(StudentDao studentDao) {
        List<Student> tempStuds = studentDao.findByLastName("Chaurasiya");
        for(Student s: tempStuds)
            System.out.println(s);
    }

    private void findAllStudents(StudentDao studentDao) {
        List<Student> allStuds = studentDao.findAll();
        for(Student s: allStuds)
            System.out.println(s);
    }

    private void findById(StudentDao studentDao) {
//        Create a student object
        System.out.println("Creating new student ...");
        Student student = new Student("Prince", "Chaurasiya", "smc@gmail.com");

//        Save the student object
        studentDao.save(student);

//      find the student by id
        Student temp = studentDao.findById(student.getId());
        if(temp != null)
        System.out.println("The student we found is: "+ temp.toString());
        else
            System.out.println("No student found with that ID");
    }

    ;

    private void createStudent(StudentDao studentDao){
//        Create a student object
            System.out.println("Creating new student ...");
            Student student = new Student("Utkarsh", "Mishra", "utkarshmishra2001@gmail.com");

//        Save the student object
            studentDao.save(student);

//        Print the id of the saved student
            System.out.println("The student generated is "+ student.toString());
    }
}
