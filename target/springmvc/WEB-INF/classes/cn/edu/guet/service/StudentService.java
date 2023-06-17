package cn.edu.guet.service;

import cn.edu.guet.bean.Score;
import cn.edu.guet.bean.Student;
import cn.edu.guet.common.ResponseData;

//学生类业务层接口
public interface StudentService {
    //Service层查看基本信息
    ResponseData selectInformation(String number);
    //Service层查看已选课程
    ResponseData selectSubjects(String number);
    //Service层查询已有成绩
    ResponseData selectScores(String number);
    //Service层学生更新个人信息（仅联系方式、邮箱、个人主页）
    ResponseData studentUpdate(Student student);
    //Service层新增学生
    ResponseData createStudent(Student student);
    //Service层修改学生信息
    ResponseData updateStudent(Student student);
    //Service层删除学生
    ResponseData deleteStudent(String number);
    //Service层学生退课
    ResponseData dropSubject(Score score);
    //Service层学生选课
    ResponseData studentAddSubject(Score score);
}
