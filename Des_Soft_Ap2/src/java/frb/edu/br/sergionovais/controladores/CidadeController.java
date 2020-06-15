/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.sergionovais.controladores;

import frb.edu.br.sergionovais.contratos.ICidade;
import frb.edu.br.sergionovais.entidades.CidadeDto;
import frb.edu.br.sergionovais.repositorios.CidadeRepositorio;
import java.util.List;

/**
 *
 * @author Sergio Novais
 */

public class CidadeController {
    private CidadeDto cidade;
    private List<CidadeDto> cidades = null;
    
    private ICidade cidadeRepositorio = new CidadeRepositorio();
    
    public CidadeController() {
    }

    public CidadeDto getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDto cidade) {
        this.cidade = cidade;
    }

    public List<CidadeDto> getCidades() {
        if(cidades == null){
            cidades = cidadeRepositorio.getListaTodos();
        }
        return cidades;
    }
    public String prepararInclusao(){
        cidade = new CidadeDto();
        return "vaiParaCidadeIncluir";
    }
    
    public String finalizaInclusao(){
        
        cidadeRepositorio.incluir(cidade);
        cidades = null;
        return "voltaParaCidadeListagem";
    }
    
    public String finalizaEdicao(){
        cidadeRepositorio.alterar(cidade);
        cidades = null;
        return "voltaParaCidadeListagem";
    }
    
    public String finalizaDelecao(){
        cidadeRepositorio.deletar( cidade.getCidade_id());
        cidades = null;
        return "refresh";
    }
    
    
}

