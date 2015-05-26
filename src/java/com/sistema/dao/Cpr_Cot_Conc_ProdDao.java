/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.dao;

import com.sistema.util.Database;
import com.sistema.vo.Cpr_Cot_Conc_ProdVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class Cpr_Cot_Conc_ProdDao {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public Cpr_Cot_Conc_ProdDao() throws Exception {
        // TODO Auto-generated constructor stub
        conn = Database.getConnection();
        if (conn == null){
                throw new Exception(getClass().getName() + ": null connection.");
        }
        this.conn = conn;        
    }
    public List getConcProd() throws SQLException{
        List l = new ArrayList<Cpr_Cot_Conc_ProdVO>();
        
        String query = "select * from Cpr_Cot_Conc_Prod"
                + " where valor is null"
                + " order by id_cot_conc_prod";
        
        stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            Cpr_Cot_Conc_ProdVO vo = new Cpr_Cot_Conc_ProdVO();
            vo.setId_cot_conc_prod(rs.getInt("id_cot_conc_prod"));
            vo.setId_cot_concorrente(rs.getInt("id_cot_concorrente"));
            vo.setCdproduto(rs.getLong("cdproduto"));
            vo.setValor(rs.getDouble("valor"));
            vo.setDt_cotacao(rs.getTimestamp("dt_cotacao"));
            vo.setNmoperador(rs.getString("nmoperador"));
            vo.setPromocao_conc(rs.getString("promocao_conc"));
            l.add(vo);
        }
        return l;
    }
    public int updateConcProd(Cpr_Cot_Conc_ProdVO vo) throws SQLException{
        int iReturn = 0;
        
        String query = "update Cpr_Cot_Conc_Prod set valor = ? ,"
                + " promocao_conc = ? where id_cot_conc_prod = ?";
        
        stmt = conn.prepareStatement(query);
        stmt.setDouble(1, vo.getValor());
        stmt.setString(2, vo.getPromocao_conc());
        stmt.setInt(3, vo.getId_cot_conc_prod());
        
        iReturn = stmt.executeUpdate();
        
        return iReturn;
    }
    
}
