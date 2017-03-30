package com.bang;

import javax.persistence.*;

/**
 * Created by tom on 2017/3/30.
 */
@Entity
@Table(name = "user", schema = "bangbang", catalog = "")
public class UserEntity {
    private int id;
    private String iphonenum;
    private String name;
    private String email;
    private String age;
    private String address;
    private String headurl;
    private String password;
    private String bangbangnum;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "iphonenum")
    public String getIphonenum() {
        return iphonenum;
    }

    public void setIphonenum(String iphonenum) {
        this.iphonenum = iphonenum;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "headurl")
    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "bangbangnum")
    public String getBangbangnum() {
        return bangbangnum;
    }

    public void setBangbangnum(String bangbangnum) {
        this.bangbangnum = bangbangnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (iphonenum != null ? !iphonenum.equals(that.iphonenum) : that.iphonenum != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (headurl != null ? !headurl.equals(that.headurl) : that.headurl != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (bangbangnum != null ? !bangbangnum.equals(that.bangbangnum) : that.bangbangnum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (iphonenum != null ? iphonenum.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (headurl != null ? headurl.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (bangbangnum != null ? bangbangnum.hashCode() : 0);
        return result;
    }
}
