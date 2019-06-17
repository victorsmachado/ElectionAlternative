/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Victor.Machado
 */
@Entity(name="usuario_candidato")
public class UsuarioCandidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="id_usuario")
    private Long idusuario;
    
    @Column(name="id_candidato")
    private Long idcandidato;
    
    public UsuarioCandidato(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Long getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(Long idcandidato) {
        this.idcandidato = idcandidato;
    }
}
