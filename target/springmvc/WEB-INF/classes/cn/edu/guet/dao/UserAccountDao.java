package cn.edu.guet.dao;

import cn.edu.guet.bean.UserAccount;
import cn.edu.guet.common.ResponseData;

import java.sql.SQLException;

public interface UserAccountDao {
    //Dao层登陆方法
    ResponseData login(UserAccount userAccount) throws SQLException;
}
