package com.fpmislata.daw1.SoundE.controller;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.domain.service.LoginService;
import com.fpmislata.daw1.SoundE.domain.service.AccountService;
import com.fpmislata.daw1.SoundE.common.container.LoginIoc;
import com.fpmislata.daw1.SoundE.common.container.AccountIoc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utils.Password;

@Controller
public class UserController {

    private final LoginService loginService;
    private final AccountService accountService;

    public UserController() {
        this.loginService = LoginIoc.createService();
        this.accountService = AccountIoc.createService();
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("error", false);
        return "loginpage/loginpage.html";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        User user = loginService.authenticate(username, password);
        if (user != null) {
            return "redirect:/";
        } else {
            model.addAttribute("error", true);
            return "loginpage/loginpage.html";
        }
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "accountpage/accountpage.html";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute User user, Model model) {
        if (accountService.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "El nombre de usuario ya existe.");
            return "accountpage/accountpage.html";
        }

        if (accountService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "El correo electrónico ya está en uso.");
            return "accountpage/accountpage.html";
        }

        accountService.create(user);
        return "redirect:/login";
    }


    @GetMapping("/principalpage")
    public String showPrincipal() {
        return "principalpage/principalpage.html";
    }
}
