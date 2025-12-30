package com.jonasdurau.autoapp.identity.domain;

import com.jonasdurau.autoapp.shared.enums.PerfilAcesso;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_clientes")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Cliente extends Usuario {

    public Cliente() {
        super();
        this.adicionarPerfil(PerfilAcesso.ROLE_CLIENTE);
    }

    public Cliente(String nome, String email, String senhaHash) {
        super(nome, email, senhaHash);
        this.adicionarPerfil(PerfilAcesso.ROLE_CLIENTE);
    }
}