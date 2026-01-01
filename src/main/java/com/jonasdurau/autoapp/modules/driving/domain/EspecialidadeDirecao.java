package com.jonasdurau.autoapp.modules.driving.domain;

import com.jonasdurau.autoapp.core.domain.Especialidade;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_especialidades_direcao")
@PrimaryKeyJoinColumn(name = "especialidade_id")
public class EspecialidadeDirecao extends Especialidade {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVeiculo categoriaVeiculo; // Ex: Só serve pra quem quer carteira B

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransmissao transmissao; // Manual ou Automático

    private boolean aceitaIniciantes = true;

    public EspecialidadeDirecao() {
        super();
    }

    public TipoVeiculo getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    public void setCategoriaVeiculo(TipoVeiculo categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public TipoTransmissao getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(TipoTransmissao transmissao) {
        this.transmissao = transmissao;
    }

    public boolean isAceitaIniciantes() {
        return aceitaIniciantes;
    }

    public void setAceitaIniciantes(boolean aceitaIniciantes) {
        this.aceitaIniciantes = aceitaIniciantes;
    }
}