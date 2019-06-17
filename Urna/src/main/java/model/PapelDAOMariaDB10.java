/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.PapelDAO;
import model.EnumPapeis;
import model.Papel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Victor.Machado
 */
public class PapelDAOMariaDB10 implements PapelDAO{

    private Connection conexao;
    
    public PapelDAOMariaDB10(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.mariadb.jdbc.Driver");
            /* Abertura de conexão: */
            /* Notar que poderia ser substituida por
            uma chamada de get instance de uma conexão já aberta. 
            */
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3310/back_end_dao","victor", "123"); //usuario/usuario123

            //conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/back_end_dao?" +
            //                       "user=root&password=root");
        } catch (Exception e){
            System.out.print("Erro de conexão...PapelDAOMysql - Construtor");
        }
    }
    
    @Override
    public Papel insert(Papel papel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Papel findById(Long id) {
        Papel p = null;
        try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from back_end_dao.papel where id = ?");  
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();
            rs.next();
            p = new Papel();
            p.setId(rs.getLong(1));
            p.setDescricao(rs.getString(2));       
            System.out.println(rs.getString(2));
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return p;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão... PapelDAOMysql - Find by Id");
        }
        return p;
    }

    @Override
    public Papel findByDescricao(EnumPapeis desc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Papel> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Papel update(Papel papelA, Papel N) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Papel papel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
