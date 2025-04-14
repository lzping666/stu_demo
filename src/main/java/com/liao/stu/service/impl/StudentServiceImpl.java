package com.liao.stu.service.impl;

import com.liao.stu.dao.StudentMapper;
import com.liao.stu.pojo.Student;
import com.liao.stu.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lzp
 * @version 1.0
 * lzpnb!
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public int insertStudent(String name, Integer age, Date birthday) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setBirthday(birthday);
        return studentMapper.insertStudent(student);

    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentMapper.findAllStudents();
    }



}
