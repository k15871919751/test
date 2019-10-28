package com.example.test.Entity;

import lombok.Data;

import java.io.Serializable;


public class Student implements Serializable {

    private Integer id;
    private String name;
    private String reg_No;
    private String grade;
    private Integer card_No;
    private String description;

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

    public String getReg_No() {
        return reg_No;
    }

    public void setReg_No(String reg_No) {
        this.reg_No = reg_No;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getCard_No() {
        return card_No;
    }

    public void setCard_No(Integer card_No) {
        this.card_No = card_No;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reg_No='" + reg_No + '\'' +
                ", grade='" + grade + '\'' +
                ", card_No=" + card_No +
                ", description='" + description + '\'' +
                '}';
    }
}
