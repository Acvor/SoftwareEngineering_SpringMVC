package cn.edu.guet.controller;

import cn.edu.guet.bean.Score;
import cn.edu.guet.bean.Student;
import cn.edu.guet.bean.Subject;
import cn.edu.guet.bean.UserAccount;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.StudentService;


//学生类控制器
@Controller
public class StudentController {

    //创建对象
    private StudentService studentService;
    //注入对象
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    //学生查看个人信息,通过学号查询
    @RequestMapping("/selectStudentInformation")
    public ResponseData selectStudentInformation(UserAccount userAccount){
        return studentService.selectInformation(userAccount.getUsername());
    }

    //学生成绩查询,通过学号查询
    @RequestMapping("/selectStudentScores")
    public ResponseData selectStudentScores(UserAccount userAccount){
        return studentService.selectScores(userAccount.getUsername());
    }

    //学生查看已选课程，通过学号查询
    @RequestMapping("/selectStudentSubjects")
    public ResponseData selectStudentSubjects(UserAccount userAccount){
        return studentService.selectSubjects(userAccount.getUsername());
    }

    //学生更新个人信息（联系方式、地址、网站）
    @RequestMapping("/studentUpdate")
    public ResponseData studentUpdate(Student student){
        return studentService.studentUpdate(student);
    }

    //学生退课，根据学号、课程号退课
    @RequestMapping("/dropSubject")
    public ResponseData dropSubject(Score score){
        return studentService.dropSubject(score);
    }

    //学生选课，根据学号、课程号退课
    @RequestMapping("/studentAddSubject")
    public ResponseData studentAddSubject(Score score){
        return studentService.studentAddSubject(score);
    }


}