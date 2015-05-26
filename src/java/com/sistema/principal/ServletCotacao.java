/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.principal;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sistema.dao.Cpr_Cot_Conc_ProdDao;
import com.sistema.dao.Cpr_Cot_ConcorrenteDao;
import com.sistema.dao.Prd_ProdutoDao;
import com.sistema.vo.Cpr_Cot_Conc_ProdVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class ServletCotacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Gson gson = new Gson();
//            Gson gson = new GsonBuilder().disab.create();
            
            Map<String, List<Object>> mapJson = new LinkedHashMap<String, List<Object>>();

            if (request.getParameter("request").equals("servertoclient")){
            
                if (request.getParameter("tabela").equals("prd_produto")){
                    Prd_ProdutoDao dao_produto = new Prd_ProdutoDao();
    //                
                    mapJson.put("prd_produto", dao_produto.getProdutos());
    //                
                } else if (request.getParameter("tabela").equals("cpr_cot_concorrente")){
                    Cpr_Cot_ConcorrenteDao dao_concorrente = new Cpr_Cot_ConcorrenteDao();

                    mapJson.put("cpr_cot_concorrente", dao_concorrente.getConcorrente());

                } else if (request.getParameter("tabela").toLowerCase().equals("cpr_cot_conc_prod")){
                    Cpr_Cot_Conc_ProdDao dao_conc_prod = new Cpr_Cot_Conc_ProdDao();

                    mapJson.put("cpr_cot_conc_prod", dao_conc_prod.getConcProd());
                }
            } else if (request.getParameter("request").equals("clienttoserver")){
                if (request.getParameter("tabela").toLowerCase().equals("cpr_cot_conc_prod")){
                    String sRowItens =  request.getParameter("dados");
                    List rowItens = new ArrayList<>(Arrays.asList(sRowItens));
                    Cpr_Cot_Conc_ProdVO[] conc_prodArray = gson.fromJson(sRowItens, Cpr_Cot_Conc_ProdVO[].class);
                    Cpr_Cot_Conc_ProdDao dao = new Cpr_Cot_Conc_ProdDao();
                    for (int i = 0; i < conc_prodArray.length; i++) {
                        Cpr_Cot_Conc_ProdVO vo = conc_prodArray[i];
                        dao.updateConcProd(vo);
                    }
                    mapJson.put("cpr_cot_conc_prod",rowItens);

                }
            }
            out.println(gson.toJson(mapJson));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
           Logger.getLogger(ServletCotacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletCotacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
