package com.jonasdurau.autoapp.core.domain;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_recursos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Todo recurso precisa de uma descrição para o frontend
    public abstract String getDescricao();

    // Todo recurso precisa dizer se está operante (Carro quebrado? Piano desafinado?)
    public abstract boolean isDisponivel();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
