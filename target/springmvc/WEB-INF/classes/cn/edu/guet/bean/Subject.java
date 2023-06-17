package cn.edu.guet.bean;

import java.awt.print.Book;

//课程类
public class Subject {
    //课程自然主键
    private int Id;
    //课程编号
    private String Number;
    //课程名称
    private String Name;
    //课程所属专业
    private String Profession;
    //课程任课教师
    private String Teacher;
    //课程上课校区
    private String Area;
    //课程上课教学楼
    private String Building;
    //课程上课教室
    private String Classroom;
    //课程用书
    private Book Book;
    //课程用书ISBN号
    private String Bookisbn;
    //课程所属学期
    private String Term;
    //课程上课周次
    private String Week;
    //课程上课天次
    private int DayForClass;
    //课程上课节次
    private int SectionForClass;
    //课程上课节数
    private int CountForClass;
    // 课程学生数
    private int Students;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

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

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String building) {
        Building = building;
    }

    public String getClassroom() {
        return Classroom;
    }

    public void setClassroom(String classroom) {
        Classroom = classroom;
    }

    public java.awt.print.Book getBook() {
        return Book;
    }

    public void setBook(java.awt.print.Book book) {
        Book = book;
    }

    public String getBookisbn() {
        return Bookisbn;
    }

    public void setBookisbn(String bookisbn) {
        Bookisbn = bookisbn;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public String getWeek() {
        return Week;
    }

    public void setWeek(String week) {
        Week = week;
    }

    public int getDayForClass() {
        return DayForClass;
    }

    public void setDayForClass(int dayForClass) {
        DayForClass = dayForClass;
    }

    public int getSectionForClass() {
        return SectionForClass;
    }

    public void setSectionForClass(int sectionForClass) {
        SectionForClass = sectionForClass;
    }

    public int getCountForClass() {
        return CountForClass;
    }

    public void setCountForClass(int countForClass) {
        CountForClass = countForClass;
    }

    public int getStudents() {
        return Students;
    }

    public void setStudents(int students) {
        Students = students;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "Id=" + Id +
                ", Number='" + Number + '\'' +
                ", Name='" + Name + '\'' +
                ", Profession='" + Profession + '\'' +
                ", Teacher='" + Teacher + '\'' +
                ", Area='" + Area + '\'' +
                ", Building='" + Building + '\'' +
                ", Classroom='" + Classroom + '\'' +
                ", Book=" + Book +
                ", Bookisbn='" + Bookisbn + '\'' +
                ", Term='" + Term + '\'' +
                ", Week='" + Week + '\'' +
                ", DayForClass=" + DayForClass +
                ", SectionForClass=" + SectionForClass +
                ", CountForClass=" + CountForClass +
                ", Students=" + Students +
                '}';
    }
}
