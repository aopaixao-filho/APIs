package org.serratec.aula5.model;
import org.serratec.aula5.enums.Categoria;
import org.serratec.aula5.enums.Combustivel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Caracteristica {
    private String renavam;
    private String chassi;
    private String cor;
    private String ano;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    
    @Enumerated(EnumType.ORDINAL)
    private Combustivel combustivel;

    public String getRenavam() {
        return renavam;
    }
    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }
    public String getChassi() {
        return chassi;
    }
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

}
