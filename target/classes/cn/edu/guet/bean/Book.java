package cn.edu.guet.bean;

public class Book {

    //课程用书自然主键
    private int Id;
    //课程用书书名
    private String Name;
    //课程用书编著
    private String Author;
    //课程用书出版社
    private String Publisher;
    //课程用书ISBN
    private String Isbn;
    //课程用书所属课程
    private String Subject;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Isbn='" + Isbn + '\'' +
                ", Subject='" + Subject + '\'' +
                '}';
    }
}
