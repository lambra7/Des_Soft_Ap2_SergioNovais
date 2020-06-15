/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.sergionovais.controladores;

import frb.edu.br.sergionovais.contratos.IEndereco;
import frb.edu.br.sergionovais.entidades.EnderecoDto;
import frb.edu.br.sergionovais.repositorios.EnderecoRepositorio;
import java.util.List;

public class EnderecoController {
    private EnderecoDto endereco;
    private List<EnderecoDto> enderecos = null;
    
    private IEndereco enderecoRepositorio = new EnderecoRepositorio();
    
    public EnderecoController() {
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<EnderecoDto> getEnderecos() {
        if(enderecos == null){
            enderecos = enderecoRepositorio.getListaTodos();
        }
        return enderecos;
    }
    public String prepararInclusao(){
        endereco = new EnderecoDto();
        return "vaiParaEnderecoIncluir";
    }
    
    public String finalizaInclusao(){
        
        enderecoRepositorio.incluir(endereco);
        enderecos = null;
        return "voltaParaEnderecoListagem";
    }
    
    public String finalizaEdicao(){
        enderecoRepositorio.alterar(endereco);
        enderecos = null;
        return "voltaParaEnderecoListagem";
    }
    
    public String finalizaDelecao(){
        enderecoRepositorio.deletar( endereco.getEndereco_id());
        enderecos = null;
        return "refresh";
    }
    
    
}

