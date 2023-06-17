package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Subject;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.SubjectDao;
import cn.edu.guet.service.SubjectService;

//课程类业务层实现类
public class SubjectServiceImpl implements SubjectService {
    //创建对象
    private SubjectDao subjectDao;
    //注入对象
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    //Service层查询现有课程实现
    @Override
    public ResponseData selectSubjects() {
        return ResponseData.ok(subjectDao.selectSubjects());
    }

    //Service层新增课程实现，调用Dao层
    @Override
    public ResponseData addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    //Service层修改课程实现，调用Dao层
    @Override
    public ResponseData updateSubject(Subject subject) {
        return subjectDao.updateSubject(subject);
    }

    //Service层删除课程实现，调用Dao层
    @Override
    public ResponseData deleteSubject(String number) {
        return subjectDao.deleteSubject(number);
    }

    //Service层根据课程号查询单个现有课程实现，调用Dao层
    @Override
    public ResponseData selectSubject(String number) {
        return subjectDao.selectSubject(number);
    }
}
