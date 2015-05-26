/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.vo;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class Cpr_Cot_ConcorrenteVO implements Serializable{

    private Integer id_cot_concorrente;
    private String nmconcorrente;
    private String ativo;
    private String nmoperador;

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
     * @return the nmconcorrente
     */
    public String getNmconcorrente() {
        return nmconcorrente;
    }

    /**
     * @param nmconcorrente the nmconcorrente to set
     */
    public void setNmconcorrente(String nmconcorrente) {
        this.nmconcorrente = nmconcorrente;
    }

    /**
     * @return the ativo
     */
    public String getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(String ativo) {
        this.ativo = ativo;
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
    
}
