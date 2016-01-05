package org.flst.servlets;

import org.flst.entity.Article;
import org.flst.entity.Shelf;
import org.flst.services.ArticleServices;
import org.flst.services.ShelfRestService;

import javax.jws.WebResult;
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

        List<Article> articles = new ArrayList<>();
        Shelf shelf = new Shelf();

        shelf.setId(1);
        shelf.setName("surgelés");


        /*ArticleServices articleServices = new ArticleServices();
        articles = articleServices.findByShelf(shelf);*/

        Article article = new Article();
        article.setId(99);
        article.setName("Apéricube");
//        shelf.addArticle(article);
//        article.setShelf(shelf);

        Article article2 = new Article();
        article2.setId(100);
        article2.setName("Jus de pommes");
//        shelf.addArticle(article2);
//        article2.setShelf(shelf);

        articles.add(article);
        articles.add(article2);

        request.setAttribute("articles", articles);
        dispatcher.forward(request, response);
    }
}
