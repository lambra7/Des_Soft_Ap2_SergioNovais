/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.sergionovais.contratos;

import frb.edu.br.sergionovais.entidades.EnderecoDto;
import java.util.List;

/**
 *
 * @author Sergio Novais
 */
public interface IEndereco {

    boolean incluir(EnderecoDto cidade);
    boolean alterar(EnderecoDto cidade);
    boolean deletar(int id);
    EnderecoDto getRegistroPorId(int id);
    List<EnderecoDto> getListaTodos();
}

