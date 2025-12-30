package com.jonasdurau.autoapp.core.domain;

import com.jonasdurau.autoapp.shared.enums.PerfilAcesso;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_instituicoes")
@PrimaryKeyJoinColumn(name = "fornecedor_id")
public class Instituicao extends Fornecedor {

    @Column(unique = true)
    private String cnpj;

    private String razaoSocial;

    @OneToMany(mappedBy = "empregador")
    private List<Prestador> equipe = new ArrayList<>();

    public Instituicao() {
        super();
        this.adicionarPerfil(PerfilAcesso.ROLE_INSTITUICAO);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Prestador> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Prestador> equipe) {
        this.equipe = equipe;
    }
}