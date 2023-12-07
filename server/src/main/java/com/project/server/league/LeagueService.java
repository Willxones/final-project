package com.project.server.league;

import com.project.server.article.Article;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;
    @Autowired
    public LeagueService(LeagueRepository leagueRepository) {this.leagueRepository = leagueRepository;}

    public List<League> findAllLeagues() {
        return leagueRepository.findAll();
    }

    public void newLeague(League league) {
        leagueRepository.save(league);
    }

    public League findLeagueById(Long leagueId) {
        Optional<League> league = leagueRepository.findById(leagueId);
        if (league.isEmpty()) {
            throw new IllegalStateException("League does not exist");
        }
        return league.get();
    }

    public void deleteLeague(Long leagueId) {
        if (!leagueRepository.existsById(leagueId)) {
            throw new IllegalStateException("League does not exist");
        }
        leagueRepository.deleteById(leagueId);
    }
    @Transactional
    public void updateLeague(League updatedLeague) {
        League originalLeague = leagueRepository.findById(updatedLeague.getId()).orElseThrow(() -> new IllegalStateException(
                "League with id " + updatedLeague.getId() + " does not exist."
        ));
        originalLeague.setName(updatedLeague.getName());
        originalLeague.setImageRef(updatedLeague.getImageRef());
    }
}
