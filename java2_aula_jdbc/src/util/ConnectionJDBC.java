package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionJDBC {

    private static Connection connection;

    public static Connection getConnection() throws Exception {

        if (connection == null) {

            try {
                //Testar o carregamento da classe (Driver)
                Class.forName("org.firebirdsql.jdbc.FBDriver");
            } catch (ClassNotFoundException ex) {
                throw new Exception(ex);
            }

            //Dados de conexão
            String servidor = "192.168.56.101";
            String database = "/databases/AULA07.fdb";
            String user = "SYSDBA";
            String password = "masterkey";

            //Prepara a URL de conexão
            //jdbc:firebirdsql:IP/3050:/diretorio/do/banco.fdb?parametros adicionais
            String url = "jdbc:firebirdsql:" + servidor + "/3050:" + database + "?encoding=WIN1252";

            //Obtém a conexão com o banco de dados
            connection = DriverManager.getConnection(url, user, password);

        }

        return connection;
    }

    public static void main(String[] args) {
        System.out.println("Teste!");
        try {
            ConnectionJDBC.getConnection();
        } catch (Exception ex) {
            System.out.println(""+ex.getMessage());
        }
    }
}
