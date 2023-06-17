package cn.edu.guet.dao;

import cn.edu.guet.bean.Student;

import java.util.List;

//管理员Dao层接口
public interface AdminDao {
    //Dao层查看所有学生接口
    List<Student> selectStudents();
}
