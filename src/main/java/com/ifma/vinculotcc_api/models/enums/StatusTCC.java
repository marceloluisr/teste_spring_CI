package com.ifma.vinculotcc_api.models.enums;

public enum StatusTCC {
    PENDENTE("Pendente"),
    ACEITO("Aceito"),
    REJEITADO("Rejeitado");

    private String descricao;

    private StatusTCC(String descricao) {
        this.descricao = descricao;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
