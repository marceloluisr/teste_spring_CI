package com.ifma.vinculotcc_api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ifma.vinculotcc_api.models.Aluno;
import com.ifma.vinculotcc_api.models.Professor;
import com.ifma.vinculotcc_api.models.Tcc;
import com.ifma.vinculotcc_api.models.enums.StatusTCC;
import com.ifma.vinculotcc_api.service.AlunoService;
import com.ifma.vinculotcc_api.service.ProfessorService;
import com.ifma.vinculotcc_api.service.TccService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/tccs")
public class TccController {
    @Autowired
    private TccService tccService;
    @Autowired
    private ProfessorService profService;
    @Autowired
    private AlunoService alunoService;

    private Long idAlunoTcc;

    // Versão 2
    //@RequestMapping("/novo")
    @RequestMapping("/{id_aluno}/{id_professor}/novo") 
    public ModelAndView novo(@PathVariable("id_aluno") Long id_aluno,
    @PathVariable("id_professor") Long id_professor) {
        this.setIdAlunoTcc(id_aluno);

        Optional<Aluno> optional_al = alunoService.buscarPor(id_aluno);

        Optional<Professor> optional_prof = profService.buscarPor(id_professor);


        ModelAndView mv = new ModelAndView("CadastroTcc");
        mv.addObject("aluno", optional_al.get());
        mv.addObject("prof", optional_prof.get());
        return mv;
    }

    /* TODO refatoração aqui
    @RequestMapping("/{id_aluno}/entrada")
    public ModelAndView alunoTcc(@PathVariable("id_aluno") Long id) {
        Optional<Aluno> optional = alunoService.buscarPor(id);
        
        ModelAndView mv = new ModelAndView("EntradaAluno");
        mv.addObject("situacao_tccs_aluno", optional.get().getTcc());
        return mv;
    }
    */

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView cadastrar(Tcc tcc) {
        tcc.setStatus(StatusTCC.PENDENTE);
        this.tccService.salva(tcc);

        
        ModelAndView mv = new ModelAndView("solicitado");
        mv.addObject("id", idAlunoTcc);
        return mv;
        
        
        //return "redirect:professores/pesquisar/"+idAlunoTcc;//http://localhost:8080/professores/pesquisar/1
        //return "redirect:alunos/autentica-aluno";
    }

    /* Versão 1 cadastro
    @ModelAttribute("todosProfessores")
    public List<Professor> todosProfessores() {
        List<Professor> profs = (List<Professor>) profService.todos();
        return profs;
    }
    */
    // Fim Versão 2
    

    @GetMapping("/todos")
    public ModelAndView listarTodos() {
        List<Tcc> todos = (List<Tcc>) this.tccService.todos();

        ModelAndView mv = new ModelAndView("ListaTccs");
        mv.addObject("tccs", todos);
        return mv;
    }

    
    @RequestMapping("{codigo}/{aceito}/{id_professor}")
    public ModelAndView atualizarStatusTcc(@PathVariable("codigo") Long id_Tcc, @PathVariable("aceito") int aceito, @PathVariable("id_professor") int id_professor) {
        Tcc tcc = tccService.buscarUm(id_Tcc);
        if(aceito == 1) {
            tcc.setStatus(StatusTCC.ACEITO);
            tccService.salva(tcc);
        } else {
            tcc.setStatus(StatusTCC.REJEITADO);
            tccService.salva(tcc);
        }
        Set<Tcc> tccs = tcc.getProfessor().getTccs();
        ModelAndView mv = new ModelAndView("Solicitacoes");
        mv.addObject("solicitacoes", tccs);
        return mv;
    }

    public Long getIdAlunoTcc() {
        return idAlunoTcc;
    }

    public void setIdAlunoTcc(Long idAlunoTcc) {
        this.idAlunoTcc = idAlunoTcc;
    }


    
}
