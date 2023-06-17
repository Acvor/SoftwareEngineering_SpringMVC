package cn.edu.guet.service.impl;

import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.AdminDao;
import cn.edu.guet.service.AdminService;

//管理员Service层实现类
public class AdminServiceImpl implements AdminService {
    //创建对象
    private AdminDao adminDao;
    //注入对象
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    //Sevice层查看所有学生方法实现类,调用Dao层
    @Override
    public ResponseData selectStudents() {
        return ResponseData.ok(adminDao.selectStudents());
    }
}
