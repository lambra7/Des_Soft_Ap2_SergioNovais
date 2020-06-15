/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.sergionovais.repositorios;

import frb.edu.br.sergionovais.contratos.ICidade;
import frb.edu.br.sergionovais.data.DaoUtil;
import frb.edu.br.sergionovais.entidades.CidadeDto;
import frb.edu.br.sergionovais.entidades.PaisDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Novais
 */
public class CidadeRepositorio extends DaoUtil implements ICidade{

    @Override
    public boolean incluir(CidadeDto cidade) {
        String sql = "INSERT INTO cidade (cidade, pais_id) VALUES (?, ?) ";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, cidade.getCidade());
            ps.setInt(2, cidade.getPais().getPais_id());

            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        }catch (SQLException ex){
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
 
    }

    @Override
    public boolean alterar(CidadeDto cidade) {
        String sql = "UPDATE cidade SET cidade=?, pais_id=? WHERE cidade_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, cidade.getCidade());
            ps.setInt(2, cidade.getPais().getPais_id());

            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        }catch (SQLException ex){
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret >0;
    }

    @Override
    public boolean deletar(int id) {
       String sql = "DELETE FROM cidade WHERE cidade_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public CidadeDto getRegistroPorId(int id) {
        String sql = "SELECT cidade_id, cidade, pais_id, ultima_atualizacao FROM cidade WHERE cidade_id=?";
        CidadeDto cidade = new CidadeDto();
        PaisRepositorio pais = new PaisRepositorio();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                cidade = new CidadeDto(rs.getInt("cidade_id"), 
                        rs.getString("cidade"), 
                        pais.getRegistroPorId(rs.getInt("pais_id")),
                        rs.getTimestamp("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidade;
    }

    @Override
    public List<CidadeDto> getListaTodos() {
        List<CidadeDto> cidade = new LinkedList<CidadeDto>();
        String sql = "SELECT cidade_id, cidade, pais_id, ultima_atualizacao FROM cidade";
        PaisRepositorio paises = new PaisRepositorio();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                PaisDto pais = paises.getRegistroPorId(rs.getInt("pais_id"));
                cidade.add( new CidadeDto( rs.getInt("cidade_id"), 
                        rs.getString("cidade"), 
                        pais,
                        rs.getTimestamp("ultima_atualizacao")
                        )
                );
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidade;
    }
    
}
