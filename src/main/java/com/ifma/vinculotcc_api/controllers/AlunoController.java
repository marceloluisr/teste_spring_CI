package com.ifma.vinculotcc_api.controllers;

import java.util.Optional;

import com.ifma.vinculotcc_api.models.Aluno;
import com.ifma.vinculotcc_api.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("CadastroAluno");
        mv.addObject(new Aluno());

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView cadastrar(@Validated Aluno aluno, Errors errors) {
        ModelAndView mv = new ModelAndView("CadastroAluno");
        if (errors.hasErrors()) {
            return mv;
        }

        this.alunoService.salva(aluno);
    
        mv.addObject("mensagem", "Aluno cadastrado com sucesso!");
        return mv;
    }

    @PostMapping("/autentica-aluno") // TODO Receber matricula por URI
    public ModelAndView buscarUmPorMatricula(@RequestParam("matricula") String matricula) {
        Optional<Aluno> optional = this.alunoService.buscarUmAlunoPorMatricula(matricula);
        
        if (optional.isPresent()) {
            ModelAndView mv = new ModelAndView("DashboardAluno");
            mv.addObject("aluno", optional.get());
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("LoginAluno");
            mv.addObject("mensagem", "Usuário não encontrado");
            return mv;
        }
        
    }

    @RequestMapping("/{id_aluno}/entrada")
    public ModelAndView alunoTcc(@PathVariable("id_aluno") Long id) {
        Optional<Aluno> optional = alunoService.buscarPor(id);
        
        ModelAndView mv = new ModelAndView("EntradaAluno");
        mv.addObject("tcc", optional.get().getTcc());
        return mv;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscaPor(@PathVariable Long id) {
        Optional<Aluno> optional = alunoService.buscarPor(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get()); // retorna codigo 200
        } else {
            return ResponseEntity.notFound().build(); // retorna codigo 400
        }
    }

    



}
