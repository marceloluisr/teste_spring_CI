package com.ifma.vinculotcc_api.models;

//import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ifma.vinculotcc_api.models.enums.Titulacao;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;

    private String nome;
    private String sobrenome;
    private String matricula;
    private Long anoIngresso;
    private String curso;

    @Enumerated(EnumType.STRING)
    private Titulacao titulacao;
    private String area;

    private String link_curriculo;

    @OneToMany(mappedBy = "professor")
    private Set<Tcc> tccs;

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(Long anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Titulacao getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }

    public String getLink_curriculo() {
        return link_curriculo;
    }

    public void setLink_curriculo(String link_curriculo) {
        this.link_curriculo = link_curriculo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getId_professor() {
        return id_professor;
    }

    public void setId_professor(Long id_professor) {
        this.id_professor = id_professor;
    }


    public Set<Tcc> getTccs() {
        return tccs;
    }

    public void setTccs(Set<Tcc> tccs) {
        this.tccs = tccs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_professor == null) ? 0 : id_professor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Professor other = (Professor) obj;
        if (id_professor == null) {
            if (other.id_professor != null)
                return false;
        } else if (!id_professor.equals(other.id_professor))
            return false;
        return true;
    }

}