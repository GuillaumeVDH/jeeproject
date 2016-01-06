package org.flst.servlets;

import org.flst.dao.ArticleDAO;
import org.flst.dao.ArticleDAOImpl;
import org.flst.entity.Article;
import org.flst.entity.Shelf;
import org.flst.services.ArticleServices;
import org.flst.services.ShelfRestService;

import javax.ejb.EJB;
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

        ArticleServices articleServices = new ArticleServices();


        articles = articleServices.findAll();
        System.out.println("SIZE OF THE LIST: " + articles.size());

        request.setAttribute("articles", articles);
        dispatcher.forward(request, response);
    }
}
