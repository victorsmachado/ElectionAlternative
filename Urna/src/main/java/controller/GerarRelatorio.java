/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Candidato;
import model.ListaCandidato;
import model.UsuarioCandidato;

/**
 *
 * @author Victor.Machado
 */
@WebServlet("/Relatorio.action")
public class GerarRelatorio extends HttpServlet { 
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
        EntityManager em = emf.createEntityManager();
        ServletContext sc = req.getServletContext();
  
        Query query = em.createQuery("SELECT c FROM candidato c "); // WHERE u.nome='João' ");
        List<Candidato> candidatos = query.getResultList();
        
        Query query2 = em.createQuery("SELECT uc FROM usuario_candidato uc "); // WHERE u.nome='João' ");
        List<UsuarioCandidato> votos = query2.getResultList();
        System.out.println("deu certo");
        int votao[] = new int[100];
        for(Candidato c2: candidatos){
            int id_candidato = Integer.valueOf(c2.getId().toString());
            votao[id_candidato] = 0;
        }
        System.out.println("deu certo2");
        for(UsuarioCandidato uc2: votos){
            for(Candidato c3: candidatos){
                if(uc2.getIdcandidato().equals(c3.getId())){
                    int id_candidato = Integer.valueOf(c3.getId().toString());   
                    votao[id_candidato] += 1;
                    
                    
                }
                
            }
        }    
        System.out.println("deu certo3");
        /*Query query2 = em.createQuery("SELECT COUNT(*)\n" +
                                     "FROM usuario_candidato\n" +
                                     "where id_candidato = :x"); // 
        query2.setParameter("x", x);
        Long qtddevotos = (Long) query2.getSingleResult();*/
        Candidato c5;
        for(Candidato c4: candidatos){
            EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("persistencia_simples");        
            EntityManager em2 = emf2.createEntityManager();
            c5 = em2.find(Candidato.class, c4.getId());
            int id_usuario = Integer.valueOf(c4.getId().toString());
            em2.getTransaction().begin();
            c5.setQtdvotos(votao[id_usuario]);
            em2.getTransaction().commit();
            em2.close();
            emf2.close();
        }
        System.out.println("deu certo4");
        Query query4 = em.createQuery("SELECT c FROM candidato c "); // WHERE u.nome='João' ");
        List<Candidato> candidatosfinal = query4.getResultList();
        System.out.println("deu certo5");
        ListaCandidato lc = new ListaCandidato();
        lc.setCandidatos(candidatosfinal);
        try{
                req.setAttribute("candidatos",lc);
                System.out.println("deu certo6");
                for(Candidato c6: candidatosfinal){
                    System.out.println(c6.getNome());
                    System.out.println(c6.getQtdvotos());
                    
                }
                sc.getRequestDispatcher("/relatorio.jsp").forward(req, resp); 
            }catch( Exception e){
               //Tratamento de exceção... 
            }
        
        
    }
    
}
