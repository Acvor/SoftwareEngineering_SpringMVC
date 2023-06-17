package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.UserAccount;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.UserAccountDao;
import cn.edu.guet.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountDaoImpl implements UserAccountDao {

    //预定义JDBC对象
    PreparedStatement pstmt;
    Connection conn;

    //Dao层登陆方法具体实现
    @Override
    public ResponseData login(UserAccount userAccount) throws SQLException {
        //与数据库链接
        conn = DBConnection.getConn();
        String sql = "SELECT * FROM useraccount WHERE username=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,userAccount.getUsername());
        ResultSet rs = pstmt.executeQuery();
        //若用户名存在
        if (rs.next()){
            //检查密码是否正确
            if (! rs.getString("password").equals(userAccount.getPassword()))
                return new ResponseData("密码错误.",400);
            //检查类别是否正确
            if (! rs.getString("usertype").equals(userAccount.getUserType())){
                String result = "身份错误.你不属于 ";
                if (userAccount.getUserType().equals("student"))
                    return new ResponseData(result+"学生，请检查",400);
                else if (userAccount.getUserType().equals("teacher"))
                    return new ResponseData(result+"教师，请检查",400);
                else return new ResponseData(result+"管理员，请检查",400);
            }
        }
        //若用户名不存在
        else return new ResponseData("用户不存在.",400);

        return new ResponseData("登陆成功.",200);
    }
}
