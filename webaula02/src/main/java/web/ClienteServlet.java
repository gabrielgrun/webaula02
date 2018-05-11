package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClienteServlet extends HttpServlet {

    private int numAcessos = 0;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        numAcessos++;
        
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        
        PrintWriter saida = resp.getWriter();
        saida.println("Nome: " + nome + "<br>");
        saida.println("CPF: " + cpf + "<br>");
        
        saida.println("Acessos: " + this.numAcessos);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        PrintWriter saida = resp.getWriter();
        saida.write("<html>");
        //saida.write("Hoje é: " + new Date() );
        
        String nome = req.getParameter("nome");
        saida.write("O nome digitado é: " + nome);
                
        saida.write("</html>");
        
        
    }
    
    
}
