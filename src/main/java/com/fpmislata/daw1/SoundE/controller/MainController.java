package com.fpmislata.daw1.SoundE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    public MainController() {
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/")
    public String index(Model model) {
        return "playlistPage";
    }
}
