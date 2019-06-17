/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author fabriciogmc
 */
@Entity(name="papel")
public class Papel extends Identificador{
    
    @Id
    private long id;
    
    @Column(name="descricao")
    private String descricao;
    
    @ManyToMany(mappedBy="papeis")
    private List<Usuario> usuarios;
    
    public Papel(){} //Construtor default
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
