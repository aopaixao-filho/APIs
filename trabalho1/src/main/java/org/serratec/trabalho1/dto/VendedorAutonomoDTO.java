package org.serratec.trabalho1.dto;

import java.math.BigDecimal;

public class VendedorAutonomoDTO {
    private Long codigoVendedor;
    private String nome;
    private String email;
    private BigDecimal salario;
    private String cpf;

    // Getters e setters
    public Long getCodigoVendedor() { return codigoVendedor; }
    public void setCodigoVendedor(Long codigoVendedor) { this.codigoVendedor = codigoVendedor; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}