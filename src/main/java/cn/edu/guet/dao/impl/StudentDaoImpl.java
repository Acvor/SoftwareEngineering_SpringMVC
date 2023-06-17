package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Score;
import cn.edu.guet.bean.Student;
import cn.edu.guet.bean.Subject;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.StudentDao;
import cn.edu.guet.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//学生类持久层实现类
public class StudentDaoImpl implements StudentDao {
    //预定义JDBC对象
    PreparedStatement pstmt;
    Connection conn;

    //Dao层查看基本信息实现,返回一个Student对象
    @Override
    public Student selectInformation(String number) {
        conn = DBConnection.getConn();
        //sql语句，通过学号查询所有信息
        String sql = "SELECT * FROM `student` WHERE `number`=?";
        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,number);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setNumber(rs.getString("number"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setBirth(rs.getString("birth"));
                student.setProfession(rs.getString("profession"));
                student.setYear(rs.getString("year"));
                student.setTelephone(rs.getString("telephone"));
                student.setAddress(rs.getString("address"));
                student.setEmail(rs.getString("email"));
                student.setWebsite(rs.getString("website"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Dao层查看已选课程实现,返回一个包含Subject对象的集合
    @Override
    public List<Subject> selectSubjects(String number) {
        conn = DBConnection.getConn();
        //sql语句，通过学号查询已选课程
        /* 首先查询score表，查看学号对应的课程号，然后再通过课程号查询subject表*/
        String sql = "SELECT * FROM `subject` WHERE `number` in (SELECT subjectnum FROM `score` WHERE studentnum = ?)";
        try {
            List<Subject> subjectList = new ArrayList<>();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,number);
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

    //Dao层查看已有成绩实现,返回一个包含Score对象的集合
    @Override
    public List<Score> selectScores(String number) {
        conn = DBConnection.getConn();
        //sql语句，通过学号查询已有成绩
        String sql = "SELECT * FROM `score` WHERE `studentnum` = ? ";
        try {
            List<Score> scoreList = new ArrayList<>();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,number);
            ResultSet rs = pstmt.executeQuery();
            //查询到数据，将数据生成为Score对象，并放入集合中
            while(rs.next()) {
                Score score = new Score();
                //再查询subject表，拿到授课教师名称和课程名称
                String sqlNext = "SELECT * FROM `subject` WHERE `number`=?";
                PreparedStatement pstmtNext = conn.prepareStatement(sqlNext);
                pstmtNext.setObject(1,rs.getString("subjectnum"));
                ResultSet rsNext = pstmtNext.executeQuery();
                if (rsNext.next()) {
                    score.setSubject(rsNext.getString("name"));
                    score.setTeacherName(rsNext.getString("teacher"));
                }
                score.setStudentNum(rs.getString("studentnum"));
                score.setSubjectNum(rs.getString("subjectnum"));
                score.setYear(rs.getString("year"));
                score.setScore(rs.getInt("score"));
                scoreList.add(score);
            }
            return scoreList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Dao层学生更新个人信息实现,返回结果成功与否
    @Override
    public ResponseData studentUpdate(Student student) {
        conn = DBConnection.getConn();
        //sql语句，更新学生的联系方式、邮箱、个人主页
        String sql = "UPDATE `student` SET `telephone`=?,`email`=?,`website`=? WHERE `number`=? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,student.getTelephone());
            pstmt.setObject(2,student.getEmail());
            pstmt.setObject(3,student.getWebsite());
            pstmt.setObject(4,student.getNumber());
            pstmt.executeUpdate();
            return ResponseData.ok("更新成功.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，更新失败.");
        }
    }

    //Dao层新增学生实现,返回结果成功与否
    @Override
    public ResponseData createStudent(Student student) {
        conn = DBConnection.getConn();
        //sql语句，动态编写，达到完整sql语句的效果
        String sql = "INSERT INTO `student` value(";
        //sql语句的拼接片段
        StringBuffer sqlPart = new StringBuffer();
        //分别加入number,name,sex,birth,profession,year,telephone,address,email,website
        sqlPart.append("'"+student.getNumber()+"',");
        sqlPart.append("'"+student.getName()+"',");
        sqlPart.append("'"+student.getSex()+"',");
        sqlPart.append("'"+student.getBirth()+"',");
        sqlPart.append("'"+student.getProfession()+"',");
        sqlPart.append("'"+student.getYear()+"',");
        sqlPart.append("'"+student.getTelephone()+"',");
        sqlPart.append("'"+student.getAddress()+"',");
        sqlPart.append("'"+student.getEmail()+"',");
        sqlPart.append("'"+student.getWebsite()+"')");
        //拼接完整sql语句
        sql+=sqlPart.toString();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            return ResponseData.ok("添加学生信息成功.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，添加失败.");
        }
    }

    //Dao层修改学生信息实现,返回结果成功与否
    @Override
    public ResponseData updateStudent(Student student) {
        conn = DBConnection.getConn();
        //sql语句，更新学生信息
        String sql = "UPDATE `student` SET " +
                "`number`=?,`name`=?,`sex`=?,`birth`=?,`profession`=?,`year`=?,`telephone`=?,`address`=?,`email`=?,`website`=?" +
                "WHERE `number`=?" ;
        try {
            pstmt = conn.prepareStatement(sql);
            //给sql语句赋值
            pstmt.setObject(1,student.getNumber());
            pstmt.setObject(2,student.getName());
            pstmt.setObject(3,student.getSex());
            pstmt.setObject(4,student.getBirth());
            pstmt.setObject(5,student.getProfession());
            pstmt.setObject(6,student.getYear());
            pstmt.setObject(7,student.getTelephone());
            pstmt.setObject(8,student.getAddress());
            pstmt.setObject(9,student.getEmail());
            pstmt.setObject(10,student.getWebsite());
            pstmt.setObject(11,student.getNumber());
            pstmt.executeUpdate();
            return ResponseData.ok("修改学生信息成功.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，修改失败.");
        }
    }


    //Dao层删除学生实现,返回结果成功与否
    @Override
    public ResponseData deleteStudent(String number) {
        conn = DBConnection.getConn();
        //sql语句，根据学号删除学生
        String sql = "DELETE FROM `student` WHERE `number`=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,number);
            pstmt.executeUpdate();
            return ResponseData.ok("成功删除该学生.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，删除失败.");
        }
    }

    //Dao层学生退课实现,返回结果成功与否
    @Override
    public ResponseData dropSubject(Score score) {
        conn = DBConnection.getConn();
        //sql语句，根据学号和课程号退课
        String sql = "DELETE FROM `score` WHERE `studentnum`=? AND `subjectnum`=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,score.getStudentNum());
            pstmt.setObject(2,score.getSubjectNum());
            pstmt.executeUpdate();
            return ResponseData.ok("成功退课.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，退课失败.");
        }
    }

    //Dao层学生选课实现,返回结果成功与否
    @Override
    public ResponseData studentAddSubject(Score score) {
        conn = DBConnection.getConn();
        //先判断是否已选该课程
        //sql语句，根据学号和课程号判断是否已选课程
        String sql = "SELECT * FROM `score` WHERE `studentnum`=? AND `subjectnum`=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,score.getStudentNum());
            pstmt.setObject(2,score.getSubjectNum());
            ResultSet rs =pstmt.executeQuery();
            //如果查到数据说明已选该课程
            if (rs.next())
                return ResponseData.fail("失败，已选该课程.");
            //否则，学生选课
            else {
                //sql语句，动态编写，达到完整sql语句的效果
                sql = "INSERT INTO `score`(`studentnum`,`subjectnum`,`year`) value(";
                //sql语句的拼接片段
                StringBuffer sqlPart = new StringBuffer();
                //分别加入学号、课程号、选课年份
                sqlPart.append("'"+score.getStudentNum()+"',");
                sqlPart.append("'"+score.getSubjectNum()+"',");
                sqlPart.append("'2022');");
                //拼接完整sql语句
                sql+=sqlPart.toString();
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
                return ResponseData.ok("选课成功.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.fail("数据库操作出错了，退课失败.");
        }
    }
}
