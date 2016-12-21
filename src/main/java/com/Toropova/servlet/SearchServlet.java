package com.Toropova.servlet;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String query = (String) req.getParameter("query");

        String doc1 = FileWorker.read("src/Alice In Wonderland/1.txt");
        String doc2 = FileWorker.read("src/Alice In Wonderland/2.txt");
        String doc3 = FileWorker.read("src/Alice In Wonderland/3.txt");
        String doc4 = FileWorker.read("src/Alice In Wonderland/4.txt");
        String doc5 = FileWorker.read("src/Alice In Wonderland/5.txt");
        String doc6 = FileWorker.read("src/Alice In Wonderland/6.txt");
        String doc7 = FileWorker.read("src/Alice In Wonderland/7.txt");
        String doc8 = FileWorker.read("src/Alice In Wonderland/8.txt");
        String doc9 = FileWorker.read("src/Alice In Wonderland/9.txt");
        String doc10 = FileWorker.read("src/Alice In Wonderland/10.txt");

        Index index = new Index();

        index.loadDocument(1, doc1);
        index.loadDocument(2, doc2);
        index.loadDocument(3, doc3);
        index.loadDocument(4, doc4);
        index.loadDocument(5, doc5);
        index.loadDocument(6, doc6);
        index.loadDocument(7, doc7);
        index.loadDocument(8, doc8);
        index.loadDocument(9, doc9);
        index.loadDocument(10, doc10);



        Set<Integer> docIds = index.search(query);

        resp.getWriter().println("<!DOCTYPE HTML>");
        resp.getWriter().println("<html><body><p> Results for: " + query + "</p>");
        resp.getWriter().println("<p>Documents " + docIds + "</p>");

        for (Integer id : docIds) {
            switch (id) {
                case 1:  resp.getWriter().println("<p>" + doc1 + "</p>");
                    break;
                case 2:  resp.getWriter().println("<p>" + doc2 + "</p>");
                    break;
                case 3:  resp.getWriter().println("<p>" + doc3 + "</p>");
                    break;
                case 4:  resp.getWriter().println("<p>" + doc4 + "</p>");
                    break;
                case 5:  resp.getWriter().println("<p>" + doc5 + "</p>");
                    break;
                case 6:  resp.getWriter().println("<p>" + doc6 + "</p>");
                    break;
                case 7:  resp.getWriter().println("<p>" + doc7 + "</p>");
                    break;
                case 8:  resp.getWriter().println("<p>" + doc8 + "</p>");
                    break;
                case 9:  resp.getWriter().println("<p>" + doc9 + "</p>");
                    break;
                case 10: resp.getWriter().println("<p>" + doc10 + "</p>");
                    break;
                default: resp.getWriter().println("<p> Invalid doc </p>");
                    break;
            }
        }
        resp.getWriter().println("</body></html>");

        // req.setAttribute("name", "Alena");
        // req.getRequestDispatcher("page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}