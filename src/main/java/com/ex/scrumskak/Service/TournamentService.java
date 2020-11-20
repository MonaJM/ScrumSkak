package com.ex.scrumskak.Service;

import com.ex.scrumskak.Model.Tournament;
import com.ex.scrumskak.Repository.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService
{
    @Autowired
    TournamentRepo tournamentRepo;
    public List<Tournament> fetchAllTournament()
    {
        return tournamentRepo.fetchAllTournaments();
    }

    public void addTournament(Tournament tournament)
    {
        // Generating the Tournament code.
        int total_tournament = this.fetchAllTournament().size();
        String tournament_code = (total_tournament >= 10) ? "M"+total_tournament : "M0"+total_tournament;
        tournament.setCode(tournament_code);

        tournamentRepo.addTournament(tournament);
    }
}
