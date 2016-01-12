package org.flst.servlets;

import org.flst.entity.Article;
import org.flst.entity.Shelf;
import org.flst.services.ArticleServiceItf;
import org.flst.services.ShelfServiceItf;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaumevdh on 04/01/16.
 */
public class Home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");

        String shelfParameter = request.getParameter("shelfs");

        List<Article> articles = new ArrayList<>();
        List<Shelf> shelfs = new ArrayList<>();

        try {
            Context context = new InitialContext();

            ArticleServiceItf articleServices = (ArticleServiceItf) context.lookup("java:global/ArticleService");
            ShelfServiceItf shelfService = (ShelfServiceItf) context.lookup("java:global/ShelfService");

            articles = articleServices.findAll();
            shelfs = shelfService.findAll();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        request.setAttribute("articles", articles);
        request.setAttribute("shelfs", shelfs);
        request.setAttribute("shelfParameter", shelfParameter);
        dispatcher.forward(request, response);
    }
}
