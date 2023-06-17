package cn.edu.guet.service.impl;

import cn.edu.guet.bean.UserAccount;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.UserAccountDao;
import cn.edu.guet.service.UserAccountService;

import java.sql.SQLException;

//用户管理Service层的实现类
public class UserAccountServiceImpl implements UserAccountService {
    //创建对象
    private UserAccountDao userAccountDao;
    //注入对象
    public void setUserAccountDao(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    public UserAccountServiceImpl(){

    }

    //Service登录方法实现，调用Dao层登陆方法
    @Override
    public ResponseData login(UserAccount userAccount) {
        try {
            return userAccountDao.login(userAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseData.fail();
    }
}
