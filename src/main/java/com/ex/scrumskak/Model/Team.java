package com.ex.scrumskak.Model;

import javax.persistence.*;

@Entity
public class Team {

    @Id
    private int id;
    private int employeeId;
    private String code;
    private String name;

    //CONSTRUCTORS
    public Team() {
    }

    public Team(int id, int employeeId, String code, String name) {
        this.id = id;
        this.employeeId = employeeId;
        this.code = code;
        this.name = name;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
}