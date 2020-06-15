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
public class PaisDto {
    private int pais_id;
    private String pais;
    private Timestamp ultima_atualizacao;

   public PaisDto(){
       
   }
    
    public PaisDto(int pais_id, String pais, Timestamp ultima_atualizacao) {
        this.pais_id = pais_id;
        this.pais = pais;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Timestamp getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Timestamp ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }
    
    
}
