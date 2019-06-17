/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Victor.Machado
 */
@Entity(name="candidato")
public class Candidato {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="numero")
    private String numero;

    @Column(name="qtdvotos")
    private int qtdvotos;
    
    public Candidato(){}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
     public int getQtdvotos() {
        return qtdvotos;
    }

    public void setQtdvotos(int qtdvotos) {
        this.qtdvotos = qtdvotos;
    }
    
    
}
