package com.jonasdurau.autoapp.core.domain.assessment;

import com.jonasdurau.autoapp.identity.domain.Usuario;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    private Double notaAprovacao;

    @Enumerated(EnumType.STRING)
    private AlcanceAvaliacao alcance;

    // Quem criou a prova? Pode ser Admin ou Instrutor
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questao> questoes = new ArrayList<>();

    public Avaliacao() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getNotaAprovacao() {
        return notaAprovacao;
    }

    public void setNotaAprovacao(Double notaAprovacao) {
        this.notaAprovacao = notaAprovacao;
    }

    public AlcanceAvaliacao getAlcance() {
        return alcance;
    }

    public void setAlcance(AlcanceAvaliacao alcance) {
        this.alcance = alcance;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
}
