package com.student.dao;

import com.student.data.Student;
import com.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    //insert query on student table
    // select query on student table
    public int insertIntoStudent(Student student) throws SQLException, ClassNotFoundException {
        int rows = 0;
        String sql = "INSERT INTO STUDENT (SNAME, SEMAIL, SMOBILE) VALUES(?,?,?)";
        Connection connection = DBUtil.getDbConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //set the values of parameters
        // by using setXXX methods of PreparedStatement
        // XXX -> type of parameter
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setString(3,student.getMobile());
        rows = preparedStatement.executeUpdate();
        return rows;
    }

    public List<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT";
        Connection connection = DBUtil.getDbConnection();
        Statement statement = connection.createStatement();
        // when query is executed , it will return 0 or 1 or more than 1 records
        // those records we call as result set
        // to store that we use ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            // rows
            // each row contains columns
            // we will get the data by using result set getXXX method
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String mobile = rs.getString(4);
            Student student = new Student(id,name,email, mobile);
            studentList.add(student);
        }
        return studentList;
    }
}
