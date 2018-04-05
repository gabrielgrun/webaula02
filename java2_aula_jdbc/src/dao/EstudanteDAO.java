package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estudante;
import util.ConnectionJDBC;

public class EstudanteDAO {
    Connection connection;
    
    public EstudanteDAO() throws Exception {
        connection = ConnectionJDBC.getConnection();
    }
    
    public void save(Estudante estudante) throws Exception {
        String SQL = "INSERT INTO ESTUDANTE(NOME, CURSO, DATA_MATRICULA, STATUS)"
                + "VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, estudante.getEstudanteNome());
            p.setString(2, estudante.getCursoNome());
            p.setDate(3, new Date(estudante.getDataMatricula().getTime()));
            p.setString(4, estudante.getStatus());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }
    
    public void update(Estudante estudante) throws Exception {
        String SQL = "UPDATE ESTUDANTE SET NOME=?, CURSO=?, DATA_MATRICULA=?, STATUS=? WHERE ESTUDANTE_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, estudante.getEstudanteNome());
            p.setString(2, estudante.getCursoNome());
            p.setDate(3, new Date(estudante.getDataMatricula().getTime()));
            p.setString(4, estudante.getStatus());
            p.setInt(5, estudante.getEstudanteID());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }
    public void delete (Estudante estudante) throws Exception {
        String SQL = "DELETE FROM ESTUDANTE WHERE ESTUDANTE_ID=?";
        
        PreparedStatement p;
        try {
            p = connection.prepareStatement(SQL);
            p.setInt(1, estudante.getEstudanteID());
            p.execute();
            p.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Estudante> findAll() throws Exception {
        List<Estudante> list = new ArrayList<>();
        Estudante objeto;
        String SQL = "SELECT * FROM ESTUDANTE ORDER BY ESTUDANTE_ID";
        
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            
            ResultSet rs = p.executeQuery();
            
            while(rs.next()) {
                objeto = new Estudante();
                objeto.setEstudanteID(rs.getInt("estudante_id"));
                objeto.setEstudanteNome(rs.getString("nome"));
                objeto.setCursoNome(rs.getString("curso"));
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                objeto.setDataMatricula((rs.getDate("data_matricula")));
                objeto.setStatus(rs.getString("status").charAt(0));
                
                list.add(objeto);
            }
            rs.close();
            p.close();
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new Exception(ex);
        }
        return list;
    }
}
