package org.example.controllers;

import java.util.List;

import org.example.entities.Match;
import org.example.services.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MatchController {

    MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping (value = "/submitmatch")
    public String getSubmitScreen(@ModelAttribute Match match) {
        return "submitmatch";
    }

    @GetMapping (path = "/viewmatches", produces = "application/json")
    public String selectMatches(Model model) {
        List<Match> matchList = matchService.viewMatches();
        model.addAttribute("matchList", matchList);
        return "viewmatches";
    }

    @GetMapping (path = "/deletematch")
    public String deleteMatch(@RequestParam ("id") int id) {
        matchService.deleteMatch(id);
        return "deletematch";
    }

    @PostMapping (path = "/addmatch")
    public String addMatch(@ModelAttribute Match match) {
        matchService.addMatch(match);
        return "submitmatch";
    }
}
