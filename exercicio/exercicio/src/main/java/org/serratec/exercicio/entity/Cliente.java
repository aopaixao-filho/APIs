package org.serratec.exercicio.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nome_cliente", nullable = false)
    @Size(min = 10, max = 100, message = "O nome deve ter entre 10 e 100 caracteres")
    private String nomeCliente;

    @CPF
    @Column(name = "cpf_cliente")
    private String cpfCliente;

    @Email
    @Column(name = "email_cliente")
    private String emailCliente;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido> pedido;
    

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente
                + ", emailCliente=" + emailCliente + ", pedido=" + pedido + ", endereco=" + endereco + "]";
    }


    @OneToOne
    private Endereco endereco;


    public Long getIdCliente() {
        return idCliente;
    }


    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }


    public String getNomeCliente() {
        return nomeCliente;
    }


    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }


    public String getCpfCliente() {
        return cpfCliente;
    }


    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }


    public String getEmailCliente() {
        return emailCliente;
    }


    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }


    public List<Pedido> getPedido() {
        return pedido;
    }


    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }


    public Endereco getEndereco() {
        return endereco;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}
