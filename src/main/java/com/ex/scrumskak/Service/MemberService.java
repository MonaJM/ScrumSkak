// Service is used to the logic.

package com.ex.scrumskak.Service;

import com.ex.scrumskak.Model.Member;
import com.ex.scrumskak.Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MemberService
{
    @Autowired
    MemberRepo memberRepo;
    public List<Member> fetchAllMembers()
    {
        return memberRepo.fetchAllMembers();
    }

    public void addMember(Member member) {

        // Generate the create and expire date.
        Calendar calender = Calendar.getInstance();
        Date created_date = new Timestamp(calender.getTime().getTime());

        calender.add(Calendar.YEAR, 1);
        Date expire_date = new Timestamp(calender.getTime().getTime());

        // Generating the member no.
        int total_members = this.fetchAllMembers().size();
        String member_no = (total_members >= 10) ? "M"+total_members : "M0"+total_members;

        // Saving the dates and member no
        member.setMemberNo(member_no);
        member.setCreateDate(created_date.toString());
        member.setExpireDate(expire_date.toString());

        memberRepo.addMember(member);
    }
}