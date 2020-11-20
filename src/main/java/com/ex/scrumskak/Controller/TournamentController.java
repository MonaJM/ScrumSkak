package com.ex.scrumskak.Controller;

import com.ex.scrumskak.Model.Tournament;
import com.ex.scrumskak.Service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TournamentController
{
    @Autowired
    TournamentService tournamentService;

    @RequestMapping("/create_tournament")
    public String create_tournament(@ModelAttribute Tournament tournament)
    {
        tournamentService.addTournament(tournament);
        return "redirect:/";
    }

    @GetMapping("/tournament_list")
    public String show_member_list(Model member)
    {
        member.addAttribute("tournaments", tournamentService.fetchAllTournament());
        return "tournament_list";
    }

    @GetMapping("/create_tournament")
    public String show_create_tournament()
    {
        return "create_tournament";
    }
}
