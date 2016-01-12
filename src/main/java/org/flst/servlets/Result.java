package org.flst.servlets;

import com.mysql.jdbc.exceptions.MySQLDataException;
import org.flst.entity.Article;
import org.flst.exceptions.ArticleException;
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

/**
 * Created by guillaumevdh on 12/01/16.
 */
public class Result extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");

        Article article = new Article();
        String requestedProduct = request.getParameter("product");
        request.setAttribute("requestedProduct", requestedProduct);
        try {
            Context context = new InitialContext();

            ArticleServiceItf articleServices = (ArticleServiceItf) context.lookup("java:global/ArticleService");

            article = articleServices.findArticleByName(requestedProduct);
        } catch (ArticleException e) {
            request.setAttribute("articleException", e);
            dispatcher.forward(request, response);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        request.setAttribute("article", article);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
