package com.jonasdurau.autoapp.core.domain.assessment;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_opcoes")
public class Opcao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String texto;

    private boolean ehCorreta;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    public Opcao() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isEhCorreta() {
        return ehCorreta;
    }

    public void setEhCorreta(boolean ehCorreta) {
        this.ehCorreta = ehCorreta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
