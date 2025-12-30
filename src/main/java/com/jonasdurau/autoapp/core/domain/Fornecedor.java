package com.jonasdurau.autoapp.core.domain;

import com.jonasdurau.autoapp.identity.domain.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_fornecedores")
@PrimaryKeyJoinColumn(name = "usuario_id")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Fornecedor extends Usuario {

    @Column(columnDefinition = "TEXT")
    private String biografia;

    private Double notaMedia = 0.0;

    public Fornecedor() {
        super();
    }

    public Fornecedor(String nome, String email, String senhaHash, String biografia) {
        super(nome, email, senhaHash);
        this.biografia = biografia;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Double notaMedia) {
        this.notaMedia = notaMedia;
    }
}