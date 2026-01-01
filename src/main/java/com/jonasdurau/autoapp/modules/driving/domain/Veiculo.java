package com.jonasdurau.autoapp.modules.driving.domain;

import com.jonasdurau.autoapp.core.domain.Recurso;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculos")
@PrimaryKeyJoinColumn(name = "recurso_id") // Une com a tabela pai tb_recursos
public class Veiculo extends Recurso {

    @Column(nullable = false)
    private String modelo; // Ex: "Gol G5", "Honda CG 160"

    @Column(nullable = false, unique = true)
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVeiculo tipo;

    @Column(nullable = false)
    private Integer anoFabricacao;

    // Controle simples de disponibilidade (pode evoluir pra agenda depois)
    private boolean emManutencao = false;

    public Veiculo() {
    }

    @Override
    public String getDescricao() {
        return String.format("%s (%s) - Placa: %s", modelo, tipo, placa);
    }

    @Override
    public boolean isDisponivel() {
        return !emManutencao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public boolean isEmManutencao() {
        return emManutencao;
    }

    public void setEmManutencao(boolean emManutencao) {
        this.emManutencao = emManutencao;
    }
}
