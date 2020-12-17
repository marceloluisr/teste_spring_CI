package com.ifma.vinculotcc_api.models;

//import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ifma.vinculotcc_api.models.enums.StatusTCC;



@Entity
public class Tcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tcc;

    private String tema;
    private String area;

    @Enumerated(EnumType.STRING)
    private StatusTCC status;
    
    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @OneToMany(mappedBy = "tcc")
    private Set<Aluno> alunos;

    

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Long getId_tcc() {
        return id_tcc;
    }

    public void setId_tcc(Long id_tcc) {
        this.id_tcc = id_tcc;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            aluno.setTcc(this);
        }
        this.alunos = alunos;
    }

    public StatusTCC getStatus() {
        return status;
    }

    public void setStatus(StatusTCC status) {
        this.status = status;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_tcc == null) ? 0 : id_tcc.hashCode());
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
        Tcc other = (Tcc) obj;
        if (id_tcc == null) {
            if (other.id_tcc != null)
                return false;
        } else if (!id_tcc.equals(other.id_tcc))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tcc [alunos=" + alunos + ", area=" + area + ", id_tcc=" + id_tcc + ", professor=" + professor
                + ", status=" + status + ", tema=" + tema + "]";
    }

    public String mostrarNomeProfessor() {
        return this.professor.getNome();
    }
    
     
}
