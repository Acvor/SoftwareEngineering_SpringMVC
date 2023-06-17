package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Subject;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.SubjectDao;
import cn.edu.guet.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//课程类持久层实现类
public class SubjectDaoImpl implements SubjectDao {
    //预定义JDBC对象
    PreparedStatement pstmt;
    Connection conn;

    //Dao层查询现有课程方法实现,返回Subject对象的集合
    @Override
    public List<Subject> selectSubjects() {
        conn = DBConnection.getConn();
        //sql语句，查询现有课程
        String sql = "SELECT * FROM `subject`";
        try {
            List<Subject> subjectList = new ArrayList<>();
            pstmt = conn.prepareStatement(sql);
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
            return subjectList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Dao层新增课程方法实现,返回成功与否
    @Override
    public ResponseData addSubject(Subject subject) {
        conn = DBConnection.getConn();
        //sql语句，动态编写，达到完整sql语句的效果
        String sql = "INSERT INTO `subject` value(";
        //sql语句的拼接片段
        StringBuffer sqlPart = new StringBuffer();
        //分别加入number,name,profession,teacher,term,week,students,area,building,classroom,bookisbn
        sqlPart.append("'"+subject.getNumber()+"',");
        sqlPart.append("'"+subject.getName()+"',");
        sqlPart.append("'"+subject.getProfession()+"',");
        sqlPart.append("'"+subject.getTeacher()+"',");
        sqlPart.append("'"+subject.getTerm()+"',");
        sqlPart.append("'"+subject.getWeek()+"',");
        sqlPart.append(subject.getStudents()+",");
        sqlPart.append("'"+subject.getArea()+"',");
        sqlPart.append("'"+subject.getBuilding()+"',");
        sqlPart.append("'"+subject.getClassroom()+"',");
        sqlPart.append("'"+subject.getBookisbn()+"')");
        //拼接完整sql语句
        sql+=sqlPart.toString();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            return ResponseData.ok("添加课程成功.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，更新失败.");
        }
    }

    //Dao层修改课程方法实现,返回成功与否
    @Override
    public ResponseData updateSubject(Subject subject) {
        conn = DBConnection.getConn();
        //sql语句，更新课程信息
        String sql = "UPDATE `subject` SET " +
                "`number`=?,`name`=?,`profession`=?,`teacher`=?,`term`=?,`week`=?,`students`=?,`area`=?,`building`=?,`classroom`=?,`bookisbn`=?" +
                "WHERE `number`=?" ;
        try {
            pstmt = conn.prepareStatement(sql);
            //给sql语句赋值
            pstmt.setObject(1,subject.getNumber());
            pstmt.setObject(2,subject.getName());
            pstmt.setObject(3,subject.getProfession());
            pstmt.setObject(4,subject.getTeacher());
            pstmt.setObject(5,subject.getTerm());
            pstmt.setObject(6,subject.getWeek());
            pstmt.setObject(7,subject.getStudents());
            pstmt.setObject(8,subject.getArea());
            pstmt.setObject(9,subject.getBuilding());
            pstmt.setObject(10,subject.getClassroom());
            pstmt.setObject(11,subject.getBookisbn());
            pstmt.setObject(12,subject.getNumber());
            pstmt.executeUpdate();
            return ResponseData.ok("修改课程信息成功.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，更新失败.");
        }
    }

    //Dao层删除课程方法实现,返回成功与否
    @Override
    public ResponseData deleteSubject(String number) {
        conn = DBConnection.getConn();
        //sql语句，根据学号删除学生
        String sql = "DELETE FROM `subject` WHERE `number`=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,number);
            pstmt.executeUpdate();
            return ResponseData.ok("成功删除该课程.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，更新失败.");
        }
    }

    //Dao层查询单个现有课程方法实现,返回一个Subject对象
    @Override
    public ResponseData selectSubject(String number) {
        conn = DBConnection.getConn();
        //sql语句，查询现有课程
        String sql = "SELECT * FROM `subject` WHERE `number`=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,number);
            ResultSet rs = pstmt.executeQuery();
            //定义标识，判断是否有查询课程
            int result=0;
            //查询到数据，将数据生成为Subject对象
            Subject subject = new Subject();
            if(rs.next()) {
                result=1;
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

            }
            if (result==1)
                return ResponseData.ok(subject);
            else return ResponseData.fail("失败，未找到该课程.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，查询失败.");
        }
    }
}
