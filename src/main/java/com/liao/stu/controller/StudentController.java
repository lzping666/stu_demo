package com.liao.stu.controller;

import com.liao.stu.pojo.Student;
import com.liao.stu.service.StudentService;
import com.liao.stu.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author lzp
 * @version 1.0
 * lzpnb!
 */
@Controller
public class StudentController {
    @Resource
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/student/{id}")
    public Result getStudentById(@PathVariable("id") Integer id){
        Student student = studentService.getStudentById(id);
        return Result.success(student);
    }

    @ResponseBody
    @RequestMapping("/students")
    public Result getAllStudent(){
        List<Student> students = studentService.findAllStudents();
        return Result.success(students);
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public Result save(@Validated @RequestBody Student student, Errors errors){
        List<FieldError> fieldErrors = errors.getFieldErrors();
        HashMap<String, Object> map = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        if(map.isEmpty()){
            studentService.insertStudent(student.getName(), student.getAge(), student.getBirthday());
            Result success = new Result();
            success.setCode("200");
            success.setMsg("插入成功");
            success.setData(student);
            return success;
        }else {
            return Result.error("500", "插入失败");
        }
    }

    @PutMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Student student) {
        studentService.updateStudent(student);
        return Result.success();
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") Integer id){
        int i = studentService.deleteStudent(id);
        if(i > 0 ) {
            return Result.success();
        }else {
            return Result.error("500", "删除失败");
        }
    }

}
