package cn.edu.guet.dao;

import cn.edu.guet.bean.Score;
import cn.edu.guet.bean.Student;
import cn.edu.guet.bean.Subject;
import cn.edu.guet.common.ResponseData;

import java.util.List;

//学生类持久层接口
public interface StudentDao {
    //Dao层查看基本信息
    Student selectInformation(String number);
    //Dao层查看已选课程
    List<Subject> selectSubjects(String number);
    //Dao层查看已有成绩
    List<Score> selectScores(String number);
    //Dao层学生更新个人信息
    ResponseData studentUpdate(Student student);
    //Dao层新增学生
    ResponseData createStudent(Student student);
    //Dao层修改学生信息
    ResponseData updateStudent(Student student);
    //Dao层删除学生
    ResponseData deleteStudent(String number);
    //Dao层学生退课
    ResponseData dropSubject(Score score);
    //Dao层学生选课
    ResponseData studentAddSubject(Score score);
}
