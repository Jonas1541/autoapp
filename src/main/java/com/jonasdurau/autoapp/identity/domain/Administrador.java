package com.jonasdurau.autoapp.identity.domain;

import com.jonasdurau.autoapp.shared.enums.PerfilAcesso;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_administradores")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Administrador extends Usuario {

    public Administrador() {
        super();
        this.adicionarPerfil(PerfilAcesso.ROLE_ADMIN);
    }

    public Administrador(String nome, String email, String senhaHash) {
        super(nome, email, senhaHash);
        this.adicionarPerfil(PerfilAcesso.ROLE_ADMIN);
    }
}