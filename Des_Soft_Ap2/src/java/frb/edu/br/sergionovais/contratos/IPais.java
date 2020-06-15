/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.sergionovais.contratos;

import frb.edu.br.sergionovais.entidades.PaisDto;
import java.util.List;

/**
 *
 * @author Sergio Novais
 */
public interface IPais {
    
    boolean incluir(PaisDto pais_id);
    boolean alterar(PaisDto pais_id);
    boolean deletar(int id);
    PaisDto getRegistroPorId(int id);
    List<PaisDto> getListaTodos();
}
