package cn.edu.guet.bean;

public class Score {

    //学生成绩自然主键
    private int Id;
    //学生成绩学生学号
    private String StudentNum;
    //学生成绩课程编号
    private String SubjectNum;
    //学生成绩课程名称
    private String Subject;
    //学生成绩授课教师名称
    private String TeacherName;
    //学生成绩所属学期
    private String Year;
    //学生成绩
    private int Score;
    //学生
    private Student Student;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStudentNum() {
        return StudentNum;
    }

    public void setStudentNum(String studentNum) {
        StudentNum = studentNum;
    }

    public String getSubjectNum() {
        return SubjectNum;
    }

    public void setSubjectNum(String subjectNum) {
        SubjectNum = subjectNum;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public cn.edu.guet.bean.Student getStudent() {
        return Student;
    }

    public void setStudent(cn.edu.guet.bean.Student student) {
        Student = student;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

}
