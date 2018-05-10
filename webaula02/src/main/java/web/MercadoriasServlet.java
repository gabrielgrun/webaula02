package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author gg005249
 */
public class MercadoriasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Produto a = new Produto("Feijão", 7.00);
        Produto b = new Produto("Fanta Uva", 6.00);
        Produto c = new Produto("Bife", 14.50);

        List<Produto> lista = new ArrayList<>();
        lista.add(a);
        lista.add(b);
        lista.add(c);

        PrintWriter saida = resp.getWriter();
        saida.println("<b>Lista de Produtos:</b> <br><br>");

        //Ler parâmetro
        String pesquisa = req.getParameter("pesquisa");
        if (pesquisa == null) {
            pesquisa = "";
        }

        String precos = req.getParameter("precos");
        if (precos == null) {
            precos = "";
        }

        for (Produto item : lista) {
            if (item.getNome().contains(pesquisa)) {
                saida.println(item.getNome());
                if (precos.equals("sim")) {
                    saida.println(" - " + item.getPreco());
                }
                saida.println("<br>");
            }
        }
    }

}
