/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Papel;
import model.ServicoUsuario;
import model.ServicoUsuarioImpl;
/**
 *
 * @author fabricio
 */
@WebServlet("/Autorizar.action")
public class Autorizar extends HttpServlet { 
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
        EntityManager em = emf.createEntityManager();
        HttpSession session = req.getSession();
        String idUser = session.getAttribute("usuarioUsuario").toString();
        String autorizavoto2 = req.getParameter("autorizavoto");
        Long autorizaVoto = Long.parseLong(autorizavoto2);
        ServletContext sc = req.getServletContext();
        ServicoUsuario sUsuario = new ServicoUsuarioImpl();
        Usuario uBD = sUsuario.findByNomeUsuario(idUser); 
        Usuario u2 = em.find(Usuario.class, autorizaVoto); 
        if(u2.getAutorizacao().equals("nao autorizado")){
        em.getTransaction().begin();       
        u2.setAutorizacao("autorizado"); 
        em.getTransaction().commit();
        em.close();
        emf.close();}
        else if(u2.getAutorizacao().equals("autorizado")){
        em.getTransaction().begin();       
        u2.setAutorizacao("nao autorizado"); 
        em.getTransaction().commit();
        em.close();
        emf.close();}
        else {
        req.setAttribute("falhaAutorizacao", true);}
        try{
                req.setAttribute("usuarioLogado",uBD);
                sc.getRequestDispatcher("/index.jsp").forward(req, resp); 
            }catch( Exception e){
               //Tratamento de exceção... 
            }
        
        
    }//doPost
}
