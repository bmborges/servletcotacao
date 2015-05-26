/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.dao;

import com.sistema.util.Database;
import com.sistema.vo.Cpr_Cot_ConcorrenteVO;
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
public class Cpr_Cot_ConcorrenteDao {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public Cpr_Cot_ConcorrenteDao() throws Exception {
        // TODO Auto-generated constructor stub
        conn = Database.getConnection();
        if (conn == null){
                throw new Exception(getClass().getName() + ": null connection.");
        }
        this.conn = conn;        
    }
    public List getConcorrente() throws SQLException{
        List l = new ArrayList<Cpr_Cot_ConcorrenteVO>();
        
        String query = "select * from Cpr_Cot_Concorrente" +
                       " order by id_cot_concorrente";
        
        stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            Cpr_Cot_ConcorrenteVO vo = new Cpr_Cot_ConcorrenteVO();
            vo.setId_cot_concorrente(rs.getInt("id_cot_concorrente"));
            vo.setNmconcorrente(rs.getString("nmconcorrente"));
            vo.setAtivo(rs.getString("ativo"));
            vo.setNmoperador(rs.getString("nmoperador"));
            l.add(vo);
        }
        return l;
        
    }
    
}
