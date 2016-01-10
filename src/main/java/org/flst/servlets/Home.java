package org.flst.servlets;

import org.elasticsearch.common.inject.Inject;
import org.flst.dao.ArticleDAO;
import org.flst.dao.ArticleDAOImpl;
import org.flst.entity.Article;
import org.flst.entity.Shelf;
import org.flst.services.ArticleServices;
import org.flst.services.ArticleServicesItf;
import org.flst.services.ShelfRestService;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.jws.WebResult;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by guillaumevdh on 04/01/16.
 */
public class Home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");

//        List<Article> articles = new ArrayList<>();

        try {
            Context context = new InitialContext();

//            ArticleServicesItf articleServices = (ArticleServicesItf) context.lookup("ArticleServices");
            ArticleServicesItf articleServices = (ArticleServicesItf) context.lookup("java:global/which-shelf-0.0.1-SNAPSHOT/ArticlesServices");

            List<Article> articles = articleServices.findAll();
            System.out.println("SIZE OF THE LIST: " + articles.size());

        } catch (NamingException e) {
            e.printStackTrace();
        }
//        Object ejb = null;
//        Context ctx = null;
//        try {
//            ctx = new InitialContext();
//            ejb = ctx.lookup("java:global/which-shelf-0.0.1-SNAPSHOT/ArticleService");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//
//        ArticleServicesItf articleServices = (ArticleServicesItf) PortableRemoteObject.
//                narrow(ejb, ArticleServicesItf.class);

//        articles = articleServices.findAll();
//        System.out.println("SIZE OF THE LIST: " + articles.size());

//        request.setAttribute("articles", articles);
        dispatcher.forward(request, response);
    }
}
