package org.flst.servlets;

import com.mysql.jdbc.exceptions.MySQLDataException;
import org.flst.entity.Article;
import org.flst.entity.Shelf;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by guillaumevdh on 12/01/16.
 */
public class Result extends HttpServlet {

    /**
     * Retrieve the product name passed in parameter to find the exact occurence and redirect to the result JSP.
     * If no product match exactly, similars are seeked into our database and a list of results is sent to results JSP.
     * In the last case (i.e still no result) we redirect to result JSP and inform the user.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");

        Article article = new Article();
        List<Shelf> shelfs = new ArrayList<>();
        Context context = null;
        ArticleServiceItf articleServices = null;
        ShelfServiceItf shelfService = null;

        String requestedProduct = request.getParameter("product");
        request.setAttribute("requestedProduct", requestedProduct);

        try {
            //We try to find the exact product into our database
            context = new InitialContext();
            articleServices = (ArticleServiceItf) context.lookup("java:global/ArticleService");
            article = articleServices.findArticleByName(requestedProduct);
            request.setAttribute("article", article);
            dispatcher.forward(request, response);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (ArticleException e) {
            try {
                //We didn't catch any product! Let's try to find similiars
                List<Article> articles = articleServices.findArticlesByNameContaining(requestedProduct);
                request.setAttribute("articles", articles);
                dispatcher = request.getRequestDispatcher("results.jsp");
                dispatcher.forward(request, response);
            } catch(ArticleException eFindArticlesByNameContaining) {
                //Nothing found in the database (exact article or containing the name requested), telling it to the user
                request.setAttribute("articleException", eFindArticlesByNameContaining);
                dispatcher.forward(request, response);
            }
        }
    }

    /**
     * Return a list of all products & all the shelfs to the results JSP
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
        String shelfParameter = request.getParameter("shelfs");

        List<Article> articles = new ArrayList<>();
        List<Shelf> shelfs = new ArrayList<>();

        try {
            //Retrieve articles & shelfs from services
            Context context = new InitialContext();
            ArticleServiceItf articleServices = (ArticleServiceItf) context.lookup("java:global/ArticleService");
            ShelfServiceItf shelfService = (ShelfServiceItf) context.lookup("java:global/ShelfService");

            articles = articleServices.findAll();
            shelfs = shelfService.findAll();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        //Bind the objects and redirect to the results JSP
        request.setAttribute("articles", articles);
        request.setAttribute("shelfs", shelfs);
        request.setAttribute("shelfParameter", shelfParameter);
        dispatcher.forward(request, response);
    }
}
