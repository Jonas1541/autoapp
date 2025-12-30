package com.jonasdurau.autoapp.core.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_especialidades")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome; // Ex: "Aula de Direção B", "Piano Clássico"

    @Column(nullable = false)
    private BigDecimal precoBaseHora;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    // Uma especialidade pode exigir vários recursos (Ex: Carro + Baliza)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_especialidade_recursos", joinColumns = @JoinColumn(name = "especialidade_id"), inverseJoinColumns = @JoinColumn(name = "recurso_id"))
    private List<Recurso> recursosNecessarios = new ArrayList<>();

    public Especialidade() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoBaseHora() {
        return precoBaseHora;
    }

    public void setPrecoBaseHora(BigDecimal precoBaseHora) {
        this.precoBaseHora = precoBaseHora;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Recurso> getRecursosNecessarios() {
        return recursosNecessarios;
    }

    public void setRecursosNecessarios(List<Recurso> recursosNecessarios) {
        this.recursosNecessarios = recursosNecessarios;
    }
}
