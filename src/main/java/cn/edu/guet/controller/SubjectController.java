package cn.edu.guet.controller;

import cn.edu.guet.bean.Subject;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.SubjectService;

//课程类控制器
@Controller
public class SubjectController {
    //创建对象
    private SubjectService subjectService;
    //注入对象
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //查看所有课程操作
    @RequestMapping("/selectSubjects")
    public ResponseData selectSubjects(){
        return subjectService.selectSubjects();
    }

    //新增课程信息操作，传入Subject对象
    @RequestMapping("/addSubject")
    public ResponseData addSubject(Subject subject){
        return subjectService.addSubject(subject);
    }

    //修改课程信息操作，传入Subject对象(默认课程号不能修改)
    @RequestMapping("/updateSubject")
    public ResponseData updateSubject(Subject subject){
        return subjectService.updateSubject(subject);
    }

    //删除课程信息操作，根据课程号删除
    @RequestMapping("/deleteSubject")
    public ResponseData deleteSubject(Subject subject){
        return subjectService.deleteSubject(subject.getNumber());
    }

    //单独查询一个课程操作，根据课程号查询
    @RequestMapping("/selectSubject")
    public ResponseData selectSubject(Subject subject){
        return subjectService.selectSubject(subject.getNumber());
    }


}
