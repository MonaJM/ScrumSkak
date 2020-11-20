package com.ex.scrumskak.Repository;

import com.ex.scrumskak.Model.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TournamentRepo
{
    @Autowired
    JdbcTemplate template;

    public List<Tournament> fetchAllTournaments()
    {
        String sql ="SELECT * FROM Tournament";
        RowMapper<Tournament> rowMapper = new BeanPropertyRowMapper<>(Tournament.class);
        return template.query(sql, rowMapper);
    }

    public void addTournament(Tournament tournament) {
        String sql = "INSERT INTO Tournament (code, name, type, date) VALUES (?, ?, ?, ?)";
        template.update(sql, tournament.getCode(), tournament.getName(), tournament.getType(), tournament.getDate());
    }
}
