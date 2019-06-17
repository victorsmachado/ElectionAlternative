/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fabriciogmc
 */
public enum EnumPapeis {
    CHEFE_DE_SECAO ("Chefe de Seção"), 
    USUARIO_COMUM ("Usuário Comum"), 
    MESARIO ("Mesario");    
    private final String descricao;        
    EnumPapeis(String valor){
        this.descricao = valor;
    }    
    @Override
    public String toString(){
        return this.descricao;
    }
}
