package com.ra.dto;

import java.sql.Date;

public class StudentDto {
    private Integer id;
    private String name;
    private Date birthday;
    private  Integer classId;
    private  String className;

    public StudentDto() {
    }

    public StudentDto(Integer id, String name, Date birthday, Integer classId, String className) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.classId = classId;
        this.className = className;
    }

    public StudentDto(String name, java.sql.Date birthday, int classId) {
        this.name = name;
        this.birthday = birthday;
        this.classId = classId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}
