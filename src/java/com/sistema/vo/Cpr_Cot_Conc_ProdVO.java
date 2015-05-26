/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author root
 */
public class Cpr_Cot_Conc_ProdVO implements Serializable{

    private Integer id_cot_conc_prod;
    private Integer id_cot_concorrente;
    private Long cdproduto;
    private Double valor;
    private Timestamp dt_cotacao;
    private String nmoperador;
    private String promocao_conc;

    /**
     * @return the id_cot_conc_prod
     */
    public Integer getId_cot_conc_prod() {
        return id_cot_conc_prod;
    }

    /**
     * @param id_cot_conc_prod the id_cot_conc_prod to set
     */
    public void setId_cot_conc_prod(Integer id_cot_conc_prod) {
        this.id_cot_conc_prod = id_cot_conc_prod;
    }

    /**
     * @return the id_cot_concorrente
     */
    public Integer getId_cot_concorrente() {
        return id_cot_concorrente;
    }

    /**
     * @param id_cot_concorrente the id_cot_concorrente to set
     */
    public void setId_cot_concorrente(Integer id_cot_concorrente) {
        this.id_cot_concorrente = id_cot_concorrente;
    }

    /**
     * @return the cdproduto
     */
    public Long getCdproduto() {
        return cdproduto;
    }

    /**
     * @param cdproduto the cdproduto to set
     */
    public void setCdproduto(Long cdproduto) {
        this.cdproduto = cdproduto;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the dt_cotacao
     */
    public Timestamp getDt_cotacao() {
        return dt_cotacao;
    }

    /**
     * @param dt_cotacao the dt_cotacao to set
     */
    public void setDt_cotacao(Timestamp dt_cotacao) {
        this.dt_cotacao = dt_cotacao;
    }

    /**
     * @return the nmoperador
     */
    public String getNmoperador() {
        return nmoperador;
    }

    /**
     * @param nmoperador the nmoperador to set
     */
    public void setNmoperador(String nmoperador) {
        this.nmoperador = nmoperador;
    }

    /**
     * @return the promocao_conc
     */
    public String getPromocao_conc() {
        return promocao_conc;
    }

    /**
     * @param promocao_conc the promocao_conc to set
     */
    public void setPromocao_conc(String promocao_conc) {
        this.promocao_conc = promocao_conc;
    }
}
