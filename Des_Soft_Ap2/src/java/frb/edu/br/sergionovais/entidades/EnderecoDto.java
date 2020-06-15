/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.sergionovais.entidades;

import java.sql.Timestamp;

/**
 *
 * @author Sergio Novais
 */
public class EnderecoDto {
    
    private int endereco_id;
    private String endereco;
    private String endereco2;
    private String bairro;
    private CidadeDto cidade_id;
    private String cep;
    private String telefone;
    private Timestamp ultima_atualizacao;

    public EnderecoDto() {
    }

    public EnderecoDto(int endereco_id, String endereco, String endereco2, String bairro, CidadeDto cidade_id, String cep, String telefone, Timestamp ultima_atualizacao) {
        this.endereco_id = endereco_id;
        this.endereco = endereco;
        this.endereco2 = endereco2;
        this.bairro = bairro;
        this.cidade_id = cidade_id;
        this.cep = cep;
        this.telefone = telefone;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public int getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(int endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco2() {
        return endereco2;
    }

    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public CidadeDto getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(CidadeDto cidade_id) {
        this.cidade_id = cidade_id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Timestamp getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Timestamp ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }
    
    
}
