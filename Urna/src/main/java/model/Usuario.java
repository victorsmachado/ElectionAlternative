/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
/**
 *
 * @author fabriciogmc
 */
@Entity(name="usuario")
public class Usuario{
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="senha")
    private String senha;
    
    @Column(name="nomeusuario")
    private String nomeUsuario;
    
    @Column(name="autorizacao")
    private String autorizacao;
    
    @Column(name="voto")
    private String voto;
    
    @ManyToMany(cascade={CascadeType.PERSIST}, fetch=FetchType.LAZY)
    @JoinTable(name="usuario_papel",
       joinColumns=@JoinColumn(name="id_usuario", 
                            referencedColumnName="id"),
       inverseJoinColumns= @JoinColumn(name="id_papel", 
                            referencedColumnName="id"))
    private List<Papel> papeis;

    public Usuario(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(String autorizacao) {
        this.autorizacao = autorizacao;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
    
    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }
    

}
