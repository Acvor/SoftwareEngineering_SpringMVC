package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Score;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.SubjectDao;
import cn.edu.guet.dao.TeacherDao;
import cn.edu.guet.service.TeacherService;

//教师操作Service层实现类
public class TeacherServiceImpl implements TeacherService {
    //创建对象
    private TeacherDao teacherDao;
    //注入对象
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    //Service层查询教授课程实现，调用Dao层
    @Override
    public ResponseData selectTeachSubjects(String teacherName) {
        return teacherDao.selectTeachSubjects(teacherName);
    }

    @Override
    public ResponseData selectScoreFromSubject(String subjectNum) {
        return teacherDao.selectScoreFromSubject(subjectNum);
    }

    @Override
    public ResponseData updateThisScore(Score score) {
        return teacherDao.updateThisScore(score);
    }
}
