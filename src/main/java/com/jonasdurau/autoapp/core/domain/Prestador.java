package com.jonasdurau.autoapp.core.domain;

import com.jonasdurau.autoapp.shared.enums.PerfilAcesso;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_prestadores")
@PrimaryKeyJoinColumn(name = "fornecedor_id")
public class Prestador extends Fornecedor {

    @Column(unique = true)
    private String cpf;

    // Se null, é autônomo. Se preenchido, é funcionário.
    @ManyToOne
    @JoinColumn(name = "instituicao_empregadora_id")
    private Instituicao empregador;

    public Prestador() {
        super();
        this.adicionarPerfil(PerfilAcesso.ROLE_PRESTADOR);
    }

    public boolean isAutonomo() {
        return empregador == null;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Instituicao getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Instituicao empregador) {
        this.empregador = empregador;
    }
}