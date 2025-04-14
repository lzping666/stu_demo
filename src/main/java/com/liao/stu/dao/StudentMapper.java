package com.liao.stu.dao;

import com.liao.stu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lzp
 * @version 1.0
 * lzpnb!
 */
@Mapper
public interface StudentMapper {
    public Student getStudentById(Integer id);

    public List<Student> findAllStudents();

    public int insertStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(Integer id);
}
