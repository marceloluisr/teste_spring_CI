package com.ifma.vinculotcc_api.models.enums;

public enum Titulacao {
    BACHARELADO("Bacharelado"),
    LICENCIATURA("Licenciatura"),
    TECNOLOGO("Tecnólogo"),
    ESPECIALIZACAO("Especialização"),
    MBA("MBA"),
    MESTRADO("Mestrado"),
    POSDOUTORADO("Pós-doutorado");
  

    private String descricao;

    private Titulacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
