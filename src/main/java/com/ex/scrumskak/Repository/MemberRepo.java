// reposiroty is for database communication to send data and receive data. (Working with SQL queries)
package com.ex.scrumskak.Repository;

import com.ex.scrumskak.Model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepo
{
    @Autowired
    JdbcTemplate template;

    public List<Member> fetchAllMembers()
    {
        // This is where the actual SQL communication would have been done!

        String sql ="SELECT * FROM Member";
        RowMapper<Member> rowMapper = new BeanPropertyRowMapper<>(Member.class);
        return template.query(sql, rowMapper);
    }

    public void addMember(Member member) {
        String sql = "INSERT INTO Member (membership_type, fName, lName, member_no, created_date, expire_date) VALUES (?, ?, ?, ?, ?, ?)";
        template.update(sql,  member.getMembership_type(), member.getfName(), member.getlName(), member.getMemberNo(), member.getCreateDate(), member.getExpireDate());
    }
}