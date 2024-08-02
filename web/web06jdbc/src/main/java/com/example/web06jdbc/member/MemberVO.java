package com.example.web06jdbc.member;

public class MemberVO {
    private int num;
    private String id;
    private String pw;
    private String name;
    private String tel;

    // Getter and Setter methods
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "MemberVO [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + "]";
    }
}
