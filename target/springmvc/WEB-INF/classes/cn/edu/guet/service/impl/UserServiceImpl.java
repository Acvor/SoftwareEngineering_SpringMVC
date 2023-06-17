package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Users;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.UserDao;
import cn.edu.guet.service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @Author liwei
 * @Date 2023/5/16 20:25
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ResponseData saveUser(Users user) {
        int save = 0;
        try {
            save = userDao.save(user);
        } catch (SQLException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (save == 1) {
            return new ResponseData("保存成功", 200);
        }
        return ResponseData.fail("保存失败");

    }

    @Override
    public ResponseData getUserById(Long id) {
        return ResponseData.ok(userDao.getObjectById(id));
    }

    @Override
    public ResponseData getUsers() {
        return ResponseData.ok(userDao.getObjects());
    }

    @Override
    public ResponseData updateUserById(Long id,Users user) {
        int update = 0;
        update = userDao.updateObjectById(id,user);

        if (update == 1) {
            return new ResponseData("修改成功", 200);
        }
        return ResponseData.fail("修改失败");
    }

    @Override
    public ResponseData delteUserById(Long id) {
        int delete = 0;
        delete=userDao.deleteObjectById(id);
        if (delete==1){
            return new ResponseData("删除成功", 200);
        }
        return ResponseData.fail("删除失败");
    }


}
