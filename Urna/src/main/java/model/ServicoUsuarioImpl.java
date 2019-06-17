/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.PapelDAO;
import model.UsuarioDAO;
import model.UsuarioPapelDAO;
import model.Papel;
import model.Usuario;
import model.ServicoUsuario;
import model.PapelDAOMariaDB10;
import model.UsuarioDAOMariaDB10;
import model.UsuarioPapelDAOMariaDB10;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabriciogmc
 */
public class ServicoUsuarioImpl implements ServicoUsuario {

    @Override
    public Usuario insert(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findByNomeUsuario(String nomeUsuario) {
        UsuarioDAO uDao = new UsuarioDAOMariaDB10();
        UsuarioPapelDAO upDao = new UsuarioPapelDAOMariaDB10();
        PapelDAO pdao = new PapelDAOMariaDB10();
        Usuario u = uDao.findByNomeUsuario(nomeUsuario);
        List<Long> idPapeis = upDao.findByUsuario(u);
        List<Papel> papeis = new ArrayList();
        for ( Long id: idPapeis){
            papeis.add(pdao.findById(id));
        }
        u.setPapeis(papeis);
        return u;
    }    
}
