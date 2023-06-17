package cn.edu.guet.service;

import cn.edu.guet.bean.UserAccount;
import cn.edu.guet.common.ResponseData;

//用户管理的Service层
public interface UserAccountService {
    //Service层登录方法
    ResponseData login(UserAccount userAccount);
}
