package org.serratec.trabalho1.entity;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
@Entity
public class VendedorAutonomo extends Vendedor {
    private BigDecimal comissao;

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }
}