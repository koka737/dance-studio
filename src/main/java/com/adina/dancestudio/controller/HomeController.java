package com.adina.dancestudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.adina.dancestudio.service.DanceStudioService;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final DanceStudioService danceStudioService;

    public HomeController(DanceStudioService danceStudioService) {
        this.danceStudioService = danceStudioService;
    }

    @GetMapping
    public String home() {
        danceStudioService.saySomething();
        return "home";
    }

}
