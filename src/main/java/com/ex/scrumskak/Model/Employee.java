package com.ex.scrumskak.Model;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Employee
{
    @Id
    private int idEmployee;
    private String type;
    private String fName;
    private String lName;
    private String uName;
    private String pwd;

    //CONSTRUCTORS
    public Employee() {
    }

    public Employee(int idEmployee, String type, String fName, String lName, String uName, String pwd) {
        this.idEmployee = idEmployee;
        this.type = type;
        this.fName = fName;
        this.lName = lName;
        this.uName = uName;
        this.pwd = pwd;
    }

    //GETTERS
    public int getIdEmployee() {
        return idEmployee;
    }

    public String getType() {
        return type;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }


    public String getuName() {
        return uName;
    }

    public String getPwd() {
        return pwd;
    }

    //SETTERS
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}


