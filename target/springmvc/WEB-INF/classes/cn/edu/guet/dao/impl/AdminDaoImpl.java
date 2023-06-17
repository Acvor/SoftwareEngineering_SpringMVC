package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Student;
import cn.edu.guet.dao.AdminDao;
import cn.edu.guet.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//管理员Dao层实现类
public class AdminDaoImpl implements AdminDao {
    //预定义JDBC对象
    PreparedStatement pstmt;
    Connection conn;

    //Dao层查看所有学生实现
    @Override
    public List<Student> selectStudents() {
        conn = DBConnection.getConn();
        //sql语句，查询student表中所有学生信息
        String sql = "SELECT * FROM `student`";
        try {

            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<Student> studentList = new ArrayList<>();
            while(rs.next()) {
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
                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
