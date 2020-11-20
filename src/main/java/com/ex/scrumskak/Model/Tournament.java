package com.ex.scrumskak.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tournament
{
    @Id
    private int id;
    private String code;
    private String name;
    private String type;
    private String date;

    //CONSTRUCTORS
    public Tournament() {
    }

    public Tournament(int id, String code, String name, String type, String date) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.date = date;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTypeStr() {
        String typeStr = "";

        if(this.type.equals("local")) {
            typeStr = "Egne";
        }
        else if(this.type.equals("weekend")) {
            typeStr = "Weekend";
        }
        else if(this.type.equals("other")) {
            typeStr = "Andre";
        }

        return typeStr;
    }

    public String getDate() {
        return date;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
