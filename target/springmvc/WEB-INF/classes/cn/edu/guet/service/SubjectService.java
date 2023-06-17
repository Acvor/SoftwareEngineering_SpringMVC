package cn.edu.guet.service;

import cn.edu.guet.bean.Subject;
import cn.edu.guet.common.ResponseData;

//课程类业务层接口
public interface SubjectService {
    //Service层查询现有课程接口
    ResponseData selectSubjects();
    //Service层新增课程接口
    ResponseData addSubject(Subject subject);
    //Service层修改课程接口
    ResponseData updateSubject(Subject subject);
    //Service层删除课程接口
    ResponseData deleteSubject(String number);
    //Service层根基课程号查询现有课程接口
    ResponseData selectSubject(String number);
}
