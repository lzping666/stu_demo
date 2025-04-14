package test;

import com.liao.stu.pojo.Student;
import com.liao.stu.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lzp
 * @version 1.0
 * lzpnb!
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.liao.stu.SpringbootApplication.class)
public class testService {
    @Resource
    private StudentService studentService;


    @Test
    public void getStuById(){
        Student student = studentService.getStudentById(1);
        if(student != null) {
            System.out.println(student.toString());
        }else {
            System.out.println("没有这个学生");
        }
    }

    @Test
    public void insertStu(){
        int i = studentService.insertStudent("lzp", 18, new Date());
        if(i > 0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void updateStu(){
        Student student = new Student();
        student.setId(3);
        student.setName("lzp");
        student.setAge(19);
        student.setBirthday(new Date());
        int i = studentService.updateStudent(student);
        if(i > 0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void delStu() {
        int i = studentService.deleteStudent(4);
        if(i > 0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void findAll() {
        List<Student> students = studentService.findAllStudents();
        if(students.size() > 0){
            for(Student student : students){
                System.out.println(student.toString());
            }
        }else {
            System.out.println("没有任何学生");
        }
    }
}
