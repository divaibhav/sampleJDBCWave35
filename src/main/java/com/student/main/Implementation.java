package com.student.main;

import com.student.dao.StudentDAO;
import com.student.data.Student;

import java.sql.SQLException;
import java.util.List;

public class Implementation {
    public static void main(String[] args) {
        Student student = new Student("Suresh", "Suresh@gmail.com", "9876543210");
        StudentDAO studentDAO = new StudentDAO();
        try {
            int noOfRows = studentDAO.insertIntoStudent(student);
            if(noOfRows == 1){
                System.out.println("data inserted");
            }
            else{
                System.out.println("data not inserted");
            }
            List<Student> allStudent = studentDAO.getAllStudent();
            for (Student student1 : allStudent) {
                System.out.println(student1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
