package cn.edu.guet.dao;

import cn.edu.guet.bean.Subject;
import cn.edu.guet.common.ResponseData;

import java.util.List;

//课程类持久层接口
public interface SubjectDao {
    //Dao层查询现有课程接口
    List<Subject> selectSubjects();
    //Dao层新增课程接口
    ResponseData addSubject(Subject subject);
    //Dao层修改课程接口
    ResponseData updateSubject(Subject subject);
    //Dao层删除课程接口
    ResponseData deleteSubject(String number);
    //Dao层查询现有课程接口（单个）
    ResponseData selectSubject(String number);
}
