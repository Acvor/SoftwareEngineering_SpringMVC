package cn.edu.guet.controller;

import cn.edu.guet.bean.Score;
import cn.edu.guet.bean.Teacher;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.TeacherService;

//教师类控制器
@Controller
public class TeacherController {
    //创建对象
    private TeacherService teacherService;
    //注入对象
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //查询教师教授课程
    @RequestMapping("/selectTeachSubjects")
    public ResponseData selectTeachSubjects(Teacher teacher){
        return teacherService.selectTeachSubjects(teacher.getName());
    }

    //根据课程号查询选了该课的学生
    @RequestMapping("/selectScoreFromSubject")
    public ResponseData selectScoreFromSubject(Score score){
        return teacherService.selectScoreFromSubject(score.getSubjectNum());
    }

    //根据课程号和学号修改当前学生的成绩
    @RequestMapping("/updateThisScore")
    public ResponseData updateThisScore(Score score){
        return teacherService.updateThisScore(score);
    }

}
