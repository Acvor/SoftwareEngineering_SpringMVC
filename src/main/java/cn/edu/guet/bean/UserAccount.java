package cn.edu.guet.bean;

//用户账户类
public class UserAccount {
    //用户账户自然主键
    private int Id;
    //用户名
    private String Username;
    //用户密码
    private String Password;
    //用户类别
    private String UserType;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "Id=" + Id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", UserType='" + UserType + '\'' +
                '}';
    }
}
