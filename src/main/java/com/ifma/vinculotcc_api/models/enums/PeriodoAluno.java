package com.ifma.vinculotcc_api.models.enums;

public enum PeriodoAluno {
    /*
    PRIMEIRO("1° periodo"),
    SEGUNDO("2° periodo"),
    TERCEIRO("3° periodo"),
    QUARTO("4° periodo"),
    QUINTO("5° periodo"),
    SEXTO("6° periodo"),
    SETIMO("7° periodo"),
    OITAVO("8° periodo"),
    NONO("9° periodo"),
    DECIMO("10° periodo");
    */
    // TODO enum Periodo refatorado
    PRIMEIRO(1),
    SEGUNDO(2),
    TERCEIRO(3),
    QUARTO(4),
    QUINTO(5),
    SEXTO(6),
    SETIMO(7),
    OITAVO(8),
    NONO(9),
    DECIMO(10);


    private Integer descricao;

    private PeriodoAluno(Integer descricao) {
        this.descricao = descricao;
    }

    public Integer getDescricao() {
        return descricao;
    }

}
