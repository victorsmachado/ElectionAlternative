/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ServicoUsuario;
import model.ServicoUsuarioImpl;
import model.Usuario;

/**
 *
 * @author Victor.Machado
 */
@WebServlet("/Sair.action")
public class Sair extends HttpServlet {   
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
        session.invalidate();
        ServletContext sc = req.getServletContext();
            try{
                sc.getRequestDispatcher("/index.jsp").forward(req, resp); 
            }catch( Exception e){
               //Tratamento de exceção... 
            }            
        }
}
