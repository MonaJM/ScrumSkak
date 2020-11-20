package com.ex.scrumskak.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member
{
    @Id
    private int idMember;
    private String membership_type;
    private String fName;
    private String lName;
    private String memberNo;
    private String status;
    private String createDate;
    private String expireDate;

    //CONSTRUCTORS
    public Member() {
    }

    public Member(int idMember, String membership_type, String fName, String lName, String memberNo, String status, String createDate, String expireDate) {
        this.idMember = idMember;
        this.membership_type = membership_type;
        this.fName = fName;
        this.lName = lName;
        this.memberNo = memberNo;
        this.status = status;
        this.createDate = createDate;
        this.expireDate = expireDate;
    }

    //GETTERS
    public int getIdMember() {
        return idMember;
    }

    public String getMembership_type() {
        return membership_type;
    }

    public String getMembership_str()
    {
        String typeStr= "";

        if(membership_type.equals("junior")) {
            typeStr = "Junior";
        }
        else if(membership_type.equals("senior")) {
            typeStr = "Senior";
        }
        else if(membership_type.equals("adult")) {
            typeStr = "Voksen";
        }

        return typeStr;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public String getStatus() {
        return status;
    }

    public String getStatus_str()
    {
        String typeStr= "Deaktiv";

        if(this.status.equals("1")) {
            typeStr = "Aktiv";
        }

        return typeStr;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    //SETTERS
    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public void setMembership_type(String membership_type) {
        this.membership_type = membership_type;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
}