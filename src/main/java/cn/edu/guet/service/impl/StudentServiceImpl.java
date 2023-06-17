package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Score;
import cn.edu.guet.bean.Student;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.StudentDao;
import cn.edu.guet.service.StudentService;

//学生类业务层实现类
public class StudentServiceImpl implements StudentService {
    //创建对象
    private StudentDao studentDao;
    //注入对象
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //Service层查看基本信息实现，调用Dao层
    @Override
    public ResponseData selectInformation(String number) {
        //接收返回的Student对象
        Student student = studentDao.selectInformation(number);
        return new ResponseData(student);
    }

    //Service层查看已选课程实现，调用Dao层
    @Override
    public ResponseData selectSubjects(String number) {
        //接收返回的Subject对象集合
        return ResponseData.ok(studentDao.selectSubjects(number));
    }

    //Service层查看已有成绩实现，调用Dao层
    @Override
    public ResponseData selectScores(String number) {
        //接收返回的Score对象集合
        return ResponseData.ok(studentDao.selectScores(number));
    }

    //Service层学生更新个人信息实现，调用Dao层
    @Override
    public ResponseData studentUpdate(Student student) {
        return ResponseData.ok(studentDao.studentUpdate(student));
    }

    //Service层新增学生实现，调用Dao层
    @Override
    public ResponseData createStudent(Student student) {
        return studentDao.createStudent(student);
    }

    //Service层修改学生信息实现，调用Dao层
    @Override
    public ResponseData updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    //Service层删除学生实现，调用Dao层
    @Override
    public ResponseData deleteStudent(String number) {
        return studentDao.deleteStudent(number);
    }

    //Service层学生退课实现，调用Dao层
    @Override
    public ResponseData dropSubject(Score score) {
        return studentDao.dropSubject(score);
    }

    //Service层学生选课实现，调用Dao层
    @Override
    public ResponseData studentAddSubject(Score score) {
        return studentDao.studentAddSubject(score);
    }
}
