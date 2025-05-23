package org.serratec.trabalho1.dto;

import java.math.BigDecimal;

public class VendedorEmpresaDTO {
    private Long codigoVendedor;
    private String nome;
    private String email;
    private BigDecimal salario;
    private String cnpj;

    // Getters e setters
    public Long getCodigoVendedor() { return codigoVendedor; }
    public void setCodigoVendedor(Long codigoVendedor) { this.codigoVendedor = codigoVendedor; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}