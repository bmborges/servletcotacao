/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.dao;

import com.sistema.util.Database;
import com.sistema.vo.Prd_ProdutoVO;
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
public class Prd_ProdutoDao {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public Prd_ProdutoDao() throws Exception {
        // TODO Auto-generated constructor stub
        conn = Database.getConnection();
        if (conn == null){
                throw new Exception(getClass().getName() + ": null connection.");
        }
        this.conn = conn;        
    }
    public List getProdutos() throws SQLException{
        List l = new ArrayList<Prd_ProdutoVO>();
        
        String query = "select distinct cdproduto, nmproduto, nm_p_pesquisa, ativo "
                + " from cpr_cot_conc_prod" 
                + " inner join prd_produto using (cdproduto)"
                + " order by cdproduto";
        
        stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            Prd_ProdutoVO vo = new Prd_ProdutoVO();
            vo.setCdproduto(rs.getLong("cdproduto"));
            vo.setNmproduto(rs.getString("nmproduto"));
            vo.setNm_p_pesquisa(rs.getString("nm_p_pesquisa"));
            vo.setAtivo(rs.getString("ativo"));
            l.add(vo);
        }
        return l;
        
    }
    
}
