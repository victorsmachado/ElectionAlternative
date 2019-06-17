/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Victor.Machado
 */
public class CandidatoDAOMariaDB10 implements CandidatoDAO {
    private Connection conexao;
    
    public CandidatoDAOMariaDB10(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.mariadb.jdbc.Driver");
            /* Abertura de conexão: */
            /* Notar que poderia ser substituida por
            uma chamada de get instance de uma conexão já aberta. 
            */
            conexao = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3310/back_end_dao","victor", "123"); 
            
            System.out.println("Conectado.. Candidato DAO...");
        } catch (Exception e){
            System.out.print("Erro de conexão...UsuarioDAOMYSQL");
        }
        
    }
    
    @Override
    public Candidato insert(Candidato candidato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Candidato findById(Long id) {
        Candidato c = null;
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from back_end_dao.candidato where id = ?");  
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();
            rs.next();
            c = new Candidato();
            c.setId(rs.getLong(1));
            c.setNome(rs.getString(2));
            c.setNumero(rs.getString(3)); 
            System.out.println(rs.getString(2));
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return c;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão... CandidatoDAOMysql - Find by Id");
        }
        return c;
    }
    
    @Override
    public Candidato findByNumero(String numero){
        Candidato c = null;
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from back_end_dao.candidato where numero = ?");  
            comandoSQLp.setString(1, numero);
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado...");
            rs.next();
            c = new Candidato();
            c.setId(rs.getLong(1));
            c.setNome(rs.getString(2));
            c.setNumero(rs.getString(3));
            System.out.println(rs.getString(2));           
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return c;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão... find by numero");
        }
        return c;
    }
    
    @Override
    public List<Candidato> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Candidato update(Candidato candidatoA, Candidato N) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Candidato candidato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
