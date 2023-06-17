package cn.edu.guet.bean;

//学生类
public class Student {
    //学生学号
    private String Number;
    //学生姓名
    private String Name;
    //学生性别
    private String Sex;
    //学生出生年月日
    private String Birth;
    //学生所属专业
    private String Profession;
    //学生人学年份
    private String Year;
    //学生联系电话
    private String Telephone;
    //学生联系地址
    private String Address;
    //学生电子邮件
    private String Email;
    //学生个人主页
    private String Website;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Number='" + Number + '\'' +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Birth='" + Birth + '\'' +
                ", Profession='" + Profession + '\'' +
                ", Year='" + Year + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                ", Website='" + Website + '\'' +
                '}';
    }
}
