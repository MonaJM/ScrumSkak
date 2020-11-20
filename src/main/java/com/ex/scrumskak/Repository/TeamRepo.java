// reposiroty is for database communication to send data and receive data. (Working with SQL queries)
package com.ex.scrumskak.Repository;

import com.ex.scrumskak.Model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamRepo
{
    @Autowired
    JdbcTemplate template;

    public List<Team> fetchAllTeams()
    {
        // This is where the actual SQL communication would have been done!

        String sql ="SELECT * FROM Team";
        RowMapper<Team> rowMapper = new BeanPropertyRowMapper<>(Team.class);
        return template.query(sql, rowMapper);
    }

    public void addTeam(Team team) {
        String sql = "INSERT INTO Team (code, name, Employee_idEmployee) VALUES (?, ?, ?)";
        template.update(sql,  team.getCode(), team.getName(), team.getEmployeeId());
    }
}