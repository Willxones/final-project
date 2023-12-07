package com.project.server.league;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/league")
public class LeagueController {
    private final LeagueService leagueService;
    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }
    @GetMapping
    public List<League> getLeagues() {
        return leagueService.findAllLeagues();
    }
    @GetMapping(path = "{leagueId}")
    public League getLeague(@PathVariable("leagueId") Long leagueId) {
        return leagueService.findLeagueById(leagueId);
    }
    @PostMapping
    public void newLeague(@RequestBody League league) {
        leagueService.newLeague(league);
    }
    @DeleteMapping(path = "{leagueId}")
    public void deleteLeague(@PathVariable("leagueId") Long leagueId) {
        leagueService.deleteLeague(leagueId);
    }
    @PutMapping
    public void updateLeague(@RequestBody League updatedLeague) {
        leagueService.updateLeague(updatedLeague);
    }

}
