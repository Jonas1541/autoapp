package com.jonasdurau.autoapp.shared.domain;

import com.jonasdurau.autoapp.shared.enums.PerfilAcesso;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senhaHash;

    @Embedded
    private Endereco endereco;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCadastro;

    // Lista de Roles (Admin, Prestador, etc)
    // Cria uma tabela auxiliar tb_usuario_perfis
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_usuario_perfis", joinColumns = @JoinColumn(name = "usuario_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil")
    private Set<PerfilAcesso> perfis = new HashSet<>();

    public Usuario() {}

    public Usuario(String nome, String email, String senhaHash) {
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
    }

    public void adicionarPerfil(PerfilAcesso perfil) {
        this.perfis.add(perfil);
    }

    public void removerPerfil(PerfilAcesso perfil) {
        this.perfis.remove(perfil);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Set<PerfilAcesso> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<PerfilAcesso> perfis) {
        this.perfis = perfis;
    }
}
