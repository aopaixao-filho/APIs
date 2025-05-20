package org.serratec.aula5.enums;

public enum Combustivel {
    DIESEL(1, "Diesel"), FLEX(2, "Flex"), ALCOOL(4, "Alcool"), GASOLINA(5, "Gasolina");

    private final int codigo;
    private final String descricao;

    Combustivel(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}