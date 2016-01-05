package org.flst.servlets;

import org.flst.entity.Article;
import org.flst.entity.Shelf;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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



        Shelf shelf = new Shelf();
        shelf.setId(999);
        shelf.setName("Test-shelf");

        Article article = new Article();
        article.setId(99);
        article.setName("Test-article");

        //FIXME DOESN'T WORK
        //article.setShelf(shelf);

        System.out.println("ARTICLE: " + article.getName());

        List<Article> articles = new ArrayList<>();
        articles.add(article);

        request.setAttribute("articles", articles);
        dispatcher.forward(request, response);

    }
}
