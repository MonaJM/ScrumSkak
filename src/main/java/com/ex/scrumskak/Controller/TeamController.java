// Controls the routing in home.html

package com.ex.scrumskak.Controller;

import com.ex.scrumskak.Model.Team;
import com.ex.scrumskak.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamController
{
    @Autowired
    TeamService teamService;

    @RequestMapping("/create_team")
    public String create_team(@ModelAttribute Team team)
    {
        teamService.addTeam(team);
        return "redirect:/";
    }
}
