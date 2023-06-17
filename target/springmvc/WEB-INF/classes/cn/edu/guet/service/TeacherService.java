package cn.edu.guet.service;

import cn.edu.guet.bean.Score;
import cn.edu.guet.common.ResponseData;

//教师操作的Service层
public interface TeacherService {
    //Service层查询教授课程接口
    ResponseData selectTeachSubjects(String teacherName);

    ResponseData selectScoreFromSubject(String subjectNum);

    ResponseData updateThisScore(Score score);
}
