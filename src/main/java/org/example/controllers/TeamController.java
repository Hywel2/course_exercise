package org.example.controllers;

import java.util.List;

import org.example.entities.Team;
import org.example.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamController {
    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    
    @GetMapping (value = "/main")
    public String getMainScreen(){
        return "main";
    }

    @GetMapping (value = "/submitteam")
    public String getSubmitScreen(@ModelAttribute Team team) {
        return "submitteam";
    }

    @GetMapping (path = "/viewteams", produces = "application/json")
    public String selectTeams(Model model) {
        List<Team> teamList = teamService.viewTeams();
        model.addAttribute("teamList", teamList);
        return "viewteams";
    }

    @GetMapping (path = "/deleteteam")
    public String deleteTeam(@RequestParam ("id") int id) {
        teamService.deleteTeam(id);
        return "deleteteam";
    }

    @PostMapping (path = "/addteam")
    public String addTeam(@ModelAttribute Team team) {
        teamService.addTeam(team);
        return "submitteam";
    }
}
