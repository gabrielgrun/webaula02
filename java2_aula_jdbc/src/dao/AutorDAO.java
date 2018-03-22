package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Autor;
import util.ConnectionJDBC;

public class AutorDAO {

    Connection connection;

    public AutorDAO() throws Exception {
        //Obtém uma conexão 
        connection = ConnectionJDBC.getConnection();
    }

    public void save(Autor autor) throws Exception {
        String SQL = "INSERT INTO AUTOR(NOME) VALUES(?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            //p.setInt(1, autor.getAutor_id());
            p.setString(1, autor.getNome());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(Autor autor) throws Exception {
        String SQL = "UPDATE AUTOR SET NOME=? WHERE AUTOR_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, autor.getNome());
            p.setInt(2, autor.getAutor_id());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Autor autor) {
        String SQL = "DELETE FROM AUTOR WHERE AUTOR_ID=?";

        PreparedStatement p;
        try {
            p = connection.prepareStatement(SQL);
            p.setInt(1, autor.getAutor_id());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public Autor findById(int id) {
        return new Autor();
    }

    public List<Autor> findAll() throws Exception {
        //Lista para manter os valores do resultset
        List<Autor> list = new ArrayList<>();
        Autor objeto;
        String SQL = "SELECT * FROM AUTOR ORDER BY AUTOR_ID";
        
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            // Executa a SQL e mantém os valores no ResultSet rs
            ResultSet rs = p.executeQuery();
            // Navega pelos registros no rs
            while (rs.next()) {
                // Instancia a classe Autor e informa os valores do banco
                objeto = new Autor();
                objeto.setAutor_id(rs.getInt("autor_id"));
                objeto.setNome(rs.getString("nome"));
                //Inclui na lista
                list.add(objeto);
            }
            rs.close();
            p.close();

        } catch (SQLException ex) {
            throw new Exception(ex);
        }
        // Retorna a lista
        return list;
    }
}
