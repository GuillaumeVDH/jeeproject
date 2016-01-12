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
import java.util.List;
import java.util.Set;

/**
 * Created by guillaumevdh on 12/01/16.
 */
public class Result extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");

        Article article = new Article();
        String requestedProduct = request.getParameter("product");
        request.setAttribute("requestedProduct", requestedProduct);
        Context context = null;
        ArticleServiceItf articleServices = null;
        try {
            context = new InitialContext();
            articleServices = (ArticleServiceItf) context.lookup("java:global/ArticleService");

            article = articleServices.findArticleByName(requestedProduct);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (ArticleException e) {
            //We didn't catch any product! Let's try to find similiars
            try {
                List<Article> articles = articleServices.findArticlesByNameContaining(requestedProduct);
                request.setAttribute("articles", articles);
                dispatcher = request.getRequestDispatcher("results.jsp");
                dispatcher.forward(request, response);
            } catch(ArticleException eFindArticlesByNameContaining) {
                request.setAttribute("articleException", eFindArticlesByNameContaining);
                dispatcher.forward(request, response);
            }
        }

        request.setAttribute("article", article);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
