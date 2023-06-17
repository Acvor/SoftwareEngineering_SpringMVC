package cn.edu.guet.dao;

import cn.edu.guet.bean.Score;
import cn.edu.guet.common.ResponseData;

//教师操作Dao层接口
public interface TeacherDao {
    //教师查询教授课程Dao层方法接口
    ResponseData selectTeachSubjects(String teacherName);

    ResponseData selectScoreFromSubject(String subjectNum);

    ResponseData updateThisScore(Score score);
}
