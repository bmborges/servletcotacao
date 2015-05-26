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
public class Prd_ProdutoVO implements Serializable{
    private Long cdproduto;
    private String nmproduto;
    private String nm_p_pesquisa;
    private String ativo;

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
     * @return the nmproduto
     */
    public String getNmproduto() {
        return nmproduto;
    }

    /**
     * @param nmproduto the nmproduto to set
     */
    public void setNmproduto(String nmproduto) {
        this.nmproduto = nmproduto;
    }

    /**
     * @return the nm_p_pesquisa
     */
    public String getNm_p_pesquisa() {
        return nm_p_pesquisa;
    }

    /**
     * @param nm_p_pesquisa the nm_p_pesquisa to set
     */
    public void setNm_p_pesquisa(String nm_p_pesquisa) {
        this.nm_p_pesquisa = nm_p_pesquisa;
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
}
