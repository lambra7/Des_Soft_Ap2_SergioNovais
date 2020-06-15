/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.sergionovais.controladores;

import frb.edu.br.sergionovais.contratos.IPais;
import frb.edu.br.sergionovais.entidades.PaisDto;
import frb.edu.br.sergionovais.repositorios.PaisRepositorio;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Sergio Novais
 */
@Named(value = "paisController1")
@Dependent
public class PaisController {

    /**
     * Creates a new instance of PaisController
     */
    public PaisController() {
    }
    
    private PaisDto pais;
    private List<PaisDto> paises = null;
    
    private IPais paisRepositorio = new PaisRepositorio();
    
    public PaisDto getPais() {
        return pais;
    }

    public void setPais(PaisDto pais) {
        this.pais = pais;
    }

    public List<PaisDto> getPaises() {
        if(paises == null){
            paises = paisRepositorio.getListaTodos();
        }
        return paises;
    }
    public String prepararInclusao(){
        pais = new PaisDto();
        return "vaiParaPaisIncluir";
    }
    
    public String finalizaInclusao(){
        
        paisRepositorio.incluir(pais);
        paises = null;
        return "voltaParaPaisListagem";
    }
    
    public String finalizaEdicao(){
        paisRepositorio.alterar(pais);
        paises = null;
        return "voltaParaPaisListagem";
    }
    
    public String finalizaDelecao(){
        paisRepositorio.deletar( pais.getPais_id());
        paises = null;
        return "refresh";
    }
    
    
}