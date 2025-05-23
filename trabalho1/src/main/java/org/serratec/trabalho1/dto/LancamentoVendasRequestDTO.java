package org.serratec.trabalho1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class LancamentoVendasRequestDTO {

    @NotNull(message = "Data da venda é obrigatória")
    private LocalDate dataVenda;

    @NotNull(message = "Valor da venda é obrigatório")
    private BigDecimal valorVenda;

    @Valid
    private VendedorRefDTO vendedor;

    public static class VendedorRefDTO {
        @NotNull(message = "Código do vendedor é obrigatório")
        private Long codigoVendedor;

        public Long getCodigoVendedor() {
            return codigoVendedor;
        }

        public void setCodigoVendedor(Long codigoVendedor) {
            this.codigoVendedor = codigoVendedor;
        }
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public VendedorRefDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorRefDTO vendedor) {
        this.vendedor = vendedor;
    }
}