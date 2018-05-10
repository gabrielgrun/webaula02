package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoServlet extends HttpServlet {

    List<String> arraylist = new ArrayList<>();
    List<String> preco = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        arraylist = new ArrayList<>();
        arraylist.add("suco");
        arraylist.add("feijão");
        arraylist.add("peixe frito");
        
        preco = new ArrayList<>();
        preco.add("10");
        preco.add("15");
        preco.add("20");

        resp.setContentType("text/html");

        String pesquisa = req.getParameter("pesquisa");

        if (pesquisa == null) {
            pesquisa = "";
        }

        String precos = req.getParameter("precos");

        if (precos == null) {
            precos = "";
        }

        PrintWriter saida = resp.getWriter();

        //For para percorrer array lists.
        saida.write("<ul>");
        for (int i = 0; i < arraylist.size(); i++) {
            if (arraylist.get(i).contains(pesquisa)) {
                saida.write("<li>");
                saida.write(arraylist.get(i) + " ");
                if (precos.equals("sim")) {
                    saida.write(preco.get(i));
                }
                saida.write("</li>");
            }
        }
        saida.write("</ul>");
    }
}
//For para percorrer listas de arrays, similar ao forEach do JS
/* for (String arr : arraylist){
            saida.write("funcionou");
            saida.write("<li>");
            saida.write(arr);
            saida.write("</li>");
        } */
