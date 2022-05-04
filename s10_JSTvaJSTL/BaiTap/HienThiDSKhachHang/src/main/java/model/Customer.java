package model;

import java.util.Date;

public class Customer {
    private String name;
    private Date birthDay;
    private String addr;
    private String img;

    public Customer(){

    }

    public Customer(String name, Date birthDay, String addr, String img) {
        this.name = name;
        this.birthDay = birthDay;
        this.addr = addr;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
