/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Usuario;

/**
 *
 * @author fabriciogmc
 */
public interface ServicoUsuario {
    public Usuario insert(Usuario usuario);
    public Usuario findByNomeUsuario(String nomeUsuario);
    
}
