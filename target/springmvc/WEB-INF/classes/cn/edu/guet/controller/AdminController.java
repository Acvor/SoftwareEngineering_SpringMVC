package cn.edu.guet.controller;

import cn.edu.guet.bean.Student;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.AdminService;
import cn.edu.guet.service.StudentService;

//管理员控制器
@Controller
public class AdminController {

    //创建对象
    private AdminService adminService;
    private StudentService studentService;
    //注入对象
    public void setAdminService(AdminService adminService) {this.adminService = adminService;}
    public void setStudentService(StudentService studentService) {this.studentService = studentService;}

    //查看当前所有学生
    @RequestMapping("/selectStudents")
    public ResponseData selectStudents(){
        return adminService.selectStudents();
    }

    //管理员新增学生信息
    @RequestMapping("/createStudent")
    public ResponseData createStudent(Student student){
        //新增学生应属于学生类的业务，调用学生的Service对象，传入student对象进行创建
        return studentService.createStudent(student);
    }

    //管理员修改学生信息（默认学号不能修改）
    @RequestMapping("/updateStudent")
    public ResponseData updateStudent(Student student){
        //属于学生类的业务，调用学生的Service对象
        return studentService.updateStudent(student);
    }

    //管理员删除学生信息
    @RequestMapping("/deleteStudent")
    public ResponseData deleteStudent(Student student){
        //属于学生类的业务，调用学生的Service对象，根据学号删除即可
        return studentService.deleteStudent(student.getNumber());
    }

}
