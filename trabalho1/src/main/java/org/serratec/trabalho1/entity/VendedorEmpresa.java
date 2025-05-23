package org.serratec.trabalho1.entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;


@Entity
public class VendedorEmpresa extends Vendedor {

    private String numeroCarteiraTrabalho;
    private LocalDate dataAdmissao;
    
    public String getNumeroCarteiraTrabalho() {
        return numeroCarteiraTrabalho;
    }
    public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
    }
    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }
    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    
}
