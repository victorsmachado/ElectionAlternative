/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Candidato;
import model.ServicoUsuario;
import model.ServicoUsuarioImpl;
import model.UsuarioCandidato;
/**
 *
 * @author Victor.Machado
 */
@WebServlet("/Votar.action")
public class Votar extends HttpServlet { 
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
        EntityManager em = emf.createEntityManager();
        
        HttpSession session = req.getSession();
        String idUser = session.getAttribute("usuarioUsuario").toString();
        Long voto2;
        String voto = req.getParameter("voto");
        if(voto.equals("")){
            String votinho = "0";
            voto2 = Long.parseLong(votinho);
        }else{
            voto2 = Long.parseLong(voto);}
        
        //CandidatoDAOMariaDB10 cDao = new CandidatoDAOMariaDB10();
        ServletContext sc = req.getServletContext();
        ServicoUsuario sUsuario = new ServicoUsuarioImpl();
        Usuario uBD = sUsuario.findByNomeUsuario(idUser);
        
        Long idUsuario = uBD.getId();
        Usuario u2 = em.find(Usuario.class, idUsuario);
        //Candidato cBD = cDao.findByNumero("voto");
        Candidato cBD = em.find(Candidato.class, voto2);
        if(cBD!= null){       
        u2.setVoto(voto);
        u2.setAutorizacao("ja votou");
        UsuarioCandidato uc = new UsuarioCandidato();
        uc.setIdusuario(idUsuario);
        uc.setIdcandidato(cBD.getId());
        em.getTransaction().begin();
        
        em.persist(uc);           
        em.getTransaction().commit();
        em.close();
        emf.close();
        }
        else{
        req.setAttribute("falhaAutorizacao", true);}
        try{
                req.setAttribute("usuarioLogado",uBD);
                sc.getRequestDispatcher("/index.jsp").forward(req, resp); 
            }catch( Exception e){
               //Tratamento de exceção... 
            }
        
        
    }//doPost
}
