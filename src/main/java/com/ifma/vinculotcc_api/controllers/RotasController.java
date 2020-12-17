package com.ifma.vinculotcc_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RotasController {
    //Adcionando comentario
    @GetMapping("/")
    public String login() {
        return "Login";
    }

    @GetMapping("home")
    public String home() {
        return "Home";
    }


    @GetMapping("login-professor")
    public String loginProfessor() {
        return "LoginProfessor";
    }

    @GetMapping("login-aluno")
    public String loginAluno() {
        return "LoginAluno";
    }
    
}
