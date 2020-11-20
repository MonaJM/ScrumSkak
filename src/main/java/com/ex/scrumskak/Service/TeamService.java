package com.ex.scrumskak.Service;

import com.ex.scrumskak.Model.Team;
import com.ex.scrumskak.Repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService
{
    @Autowired
    TeamRepo teamRepo;
    public List<Team> fetchTeams()
    {
        return teamRepo.fetchAllTeams();
    }

    public void addTeam(Team team) {

        // Generating the team code.
        int total_teams = this.fetchTeams().size();
        String code = (total_teams >= 10) ? "T"+total_teams : "T0"+total_teams;

        // Saving the team code
        team.setCode(code);
        teamRepo.addTeam(team);
    }
}
