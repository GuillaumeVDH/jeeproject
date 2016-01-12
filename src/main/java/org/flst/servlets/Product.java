package org.flst.servlets;

import org.flst.entity.Article;
import org.flst.services.ArticleServiceItf;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by guillaumevdh on 06/01/16.
 */
public class Product extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");

        Article article = new Article();

        try {
            Context context = new InitialContext();

            ArticleServiceItf articleServices = (ArticleServiceItf) context.lookup("java:global/ArticleService");

            article = articleServices.findArticleById(Integer.valueOf(request.getParameter("id")));
        } catch (NamingException e) {
            e.printStackTrace();
        }

        request.setAttribute("article", article);
        dispatcher.forward(request, response);
    }
}