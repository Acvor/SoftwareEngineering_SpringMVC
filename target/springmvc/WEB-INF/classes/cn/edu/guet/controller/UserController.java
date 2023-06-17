package cn.edu.guet.controller;

import cn.edu.guet.bean.Users;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.UserService;

/**
 * @Author liwei
 * @Date 2023/5/18 20:52
 * @Version 1.0
 */
@Controller
public class UserController {

    private UserService userService;

    /**
     * 曾经new的方式，耦合度太强（一个变化会影响另一个也跟着变了）
     * 依赖的方式发生了《反转：曾经自己new，现在别人送货上门》，这种现象在官方Spring框架中叫做：IoC（Inverse of Control），也叫DI（依赖注入）
     *
     * @param userService
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/saveUser")
    public ResponseData saveUser(Users user) {
        return userService.saveUser(user);
    }

    @RequestMapping("/getUserById")
    public ResponseData getUserById(long id){
        return userService.getUserById(id);
    }

    @RequestMapping("/getUsers")
    public ResponseData getUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/updateUserById")
    public ResponseData updateUserById(long id,Users user){
        return userService.updateUserById(id,user);
    }

    @RequestMapping("/deleteUserById")
    public ResponseData deleteUserById(long id){
        return userService.delteUserById(id);
    }

}
