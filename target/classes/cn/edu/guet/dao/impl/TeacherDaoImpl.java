package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Score;
import cn.edu.guet.bean.Subject;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.TeacherDao;
import cn.edu.guet.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//教师操作Dao层实现类
public class TeacherDaoImpl implements TeacherDao {
    //预定义JDBC对象
    PreparedStatement pstmt;
    Connection conn;

    //教师查询教授课程Dao层方法实现，返回一个包含Subject集合的ResponseData
    @Override
    public ResponseData selectTeachSubjects(String teacherName) {
        conn = DBConnection.getConn();
        //sql语句，根据教师名称查询所教授的课程
        String sql = "SELECT * FROM `subject` WHERE `teacher`=?";
        try {
            List<Subject> subjectList = new ArrayList<>();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,teacherName);
            ResultSet rs = pstmt.executeQuery();
            //查询到数据，将数据生成为Subject对象，并放入集合中
            while(rs.next()) {
                Subject subject = new Subject();
                subject.setNumber(rs.getString("number"));
                subject.setName(rs.getString("name"));
                subject.setProfession(rs.getString("profession"));
                subject.setTeacher(rs.getString("teacher"));
                subject.setTerm(rs.getString("term"));
                subject.setWeek(rs.getString("week"));
                subject.setStudents(rs.getInt("students"));
                subject.setArea(rs.getString("area"));
                subject.setBuilding(rs.getString("building"));
                subject.setClassroom(rs.getString("classroom"));
                subject.setBookisbn(rs.getString("bookisbn"));
                subjectList.add(subject);
            }
            return ResponseData.ok(subjectList);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，查询失败.");
        }
    }

    //包含Score集合的
    @Override
    public ResponseData selectScoreFromSubject(String subjectNum) {
        conn = DBConnection.getConn();
        //sql语句，根据教师名称查询所教授的课程
        String sql = "SELECT * FROM `score` WHERE `subjectnum`=?";
        try {
            List<Score> scoreList = new ArrayList<>();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,subjectNum);
            ResultSet rs = pstmt.executeQuery();
            //查询到数据，将数据生成为Subject对象，并放入集合中
            while(rs.next()) {
                Score score = new Score();
                score.setStudentNum(rs.getString("studentnum"));
                score.setSubjectNum(rs.getString("subjectnum"));
                score.setScore(rs.getInt("score"));
                scoreList.add(score);
            }
            return ResponseData.ok(scoreList);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，更新失败.");
        }
    }

    //根据StudentNum，SubjectNum修改成绩
    @Override
    public ResponseData updateThisScore(Score score) {
        conn = DBConnection.getConn();
        //sql语句，根据教师名称查询所教授的课程
        String sql = "UPDATE `score` SET `score`=? WHERE `subjectnum`=? AND `studentnum`=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,score.getScore());
            pstmt.setObject(2,score.getSubjectNum());
            pstmt.setObject(3,score.getStudentNum());
            pstmt.executeUpdate();
            return ResponseData.ok("修改成功.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，更新失败.");
        }
    }
}
