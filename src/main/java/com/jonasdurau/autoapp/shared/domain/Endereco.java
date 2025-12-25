package com.jonasdurau.autoapp.shared.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.locationtech.jts.geom.Point;

@Embeddable
public class Endereco {

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    private String logradouro;

    private String cep;

    // SRID 4326 é o padrão GPS (WGS 84) usado pelo Google Maps
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point localizacao;

    public Endereco() {}

    public Endereco(String cidade, String estado, String logradouro, String cep, Point localizacao) {
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.cep = cep;
        this.localizacao = localizacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Point getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Point localizacao) {
        this.localizacao = localizacao;
    }
}