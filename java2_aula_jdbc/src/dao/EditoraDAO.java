/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Editora;
import util.ConnectionJDBC;

/**
 *
 * @author gg005249
 */
public class EditoraDAO {

    Connection connection;

    public EditoraDAO() throws Exception {
        connection = ConnectionJDBC.getConnection();
    }

    public void save(Editora editora) throws Exception {
        String SQL = "INSERT INTO EDITORA(NOME, MUNICIPIO) VALUES(?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            //p.setInt(1, autor.getAutor_id());
            p.setString(1, editora.getNome_editora());
            p.setString(2, editora.getMun_editora());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }

    }

    public void update(Editora editora) throws Exception {
        String SQL = "UPDATE EDITORA SET NOME=?, MUNICIPIO=? WHERE EDITORA_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, editora.getNome_editora());
            p.setString(2, editora.getMun_editora());
            p.setInt(3, editora.getEditora_id());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Editora editora) {
        String SQL = "DELETE FROM EDITORA WHERE EDITORA_ID=?";

        PreparedStatement p;
        try {
            p = connection.prepareStatement(SQL);
            p.setInt(1, editora.getEditora_id());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Editora> findAll() throws Exception {
        //Lista para manter os valores do resultset
        List<Editora> list = new ArrayList<>();
        Editora objeto;
        String SQL = "SELECT * FROM EDITORA ORDER BY EDITORA_ID";
        
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            // Executa a SQL e mantém os valores no ResultSet rs
            ResultSet rs = p.executeQuery();
            // Navega pelos registros no rs
            while (rs.next()) {
                // Instancia a classe Autor e informa os valores do banco
                objeto = new Editora();
                objeto.setEditora_id(rs.getInt("editora_id"));
                objeto.setNome_editora(rs.getString("nome"));
                objeto.setMun_editora(rs.getString("municipio"));
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
