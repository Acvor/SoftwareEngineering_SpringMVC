package cn.edu.guet.controller;

import cn.edu.guet.bean.UserAccount;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.UserAccountService;

//用户控制器
@Controller
public class UserAccountController {

    //创建对象
    private UserAccountService userAccountService;
    //注入对象
    public void setUserAccountService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    //登陆操作
    @RequestMapping("/login")
    public ResponseData login(UserAccount userAccount){
        return userAccountService.login(userAccount);
    }


}