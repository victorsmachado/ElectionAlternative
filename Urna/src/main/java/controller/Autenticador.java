/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;




import model.Usuario;
import model.ServicoUsuario;
import model.ServicoUsuarioImpl;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;


/**
 *
 * @author fabriciogmc
 */
@WebServlet("/Autenticador.action")
public class Autenticador extends HttpServlet {   
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
        
        String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");
        ServicoUsuario sUsuario = new ServicoUsuarioImpl();
        Usuario uBD = sUsuario.findByNomeUsuario(nomeUsuario);      
        ServletContext sc = req.getServletContext();
        if (uBD!= null && uBD.getSenha().equals(senha)){
            try{
                session.setAttribute("usuarioUsuario", nomeUsuario);
                req.setAttribute("usuarioLogado",uBD);
                sc.getRequestDispatcher("/perfil.jsp").forward(req, resp); 
            }catch( Exception e){
               //Tratamento de exceção... 
            }            
        }
        else{
            try {
               
                req.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/index.jsp").forward(req, resp);
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }  
        }//if-else 
    }//doPost
}//Autenticador.java