package com.fpmislata.daw1.SoundE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExplorerController {
    @SuppressWarnings("SameReturnValue")
    @GetMapping("/explore")
    public String explorer(Model model) {
        return "explorerpage/explorerpage";
    }
}
