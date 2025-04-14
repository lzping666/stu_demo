package com.liao.stu.service;

import com.liao.stu.pojo.Student;

import java.util.Date;
import java.util.List;

/**
 * @author lzp
 * @version 1.0
 * lzpnb!
 */

public interface StudentService {
    public Student getStudentById(Integer id);

    public int insertStudent(String name, Integer age, Date birthday);

    public int updateStudent(Student student);

    public int deleteStudent(Integer id);

    public List<Student> findAllStudents();
}
