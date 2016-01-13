package org.flst.servlets.admin;

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
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by guillaumevdh on 13/01/16.
 */
public class CreateArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");

        Article article = new Article();
        Shelf shelf = new Shelf();
        Context context = null;
        ArticleServiceItf articleServices = null;
        ShelfServiceItf shelfService = null;

        article.setName(request.getParameter("productName"));
        article.setPicturelink(request.getParameter("productImage"));
        article.setBrand(request.getParameter("productBrand"));
        article.setPrix(Float.valueOf(request.getParameter("productPrice")));
        try {
            context = new InitialContext();
            shelfService = (ShelfServiceItf) context.lookup("java:global/ShelfService");
//            shelf = shelfService.findShelfById(Integer.valueOf(request.getParameter("productShelf")));
            shelf = shelfService.findShelfById(1);
            article.setShelf(shelf);

            articleServices = (ArticleServiceItf) context.lookup("java:global/ArticleService");
        } catch (NamingException e1) {
            e1.printStackTrace();
        }

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Article>> constraintViolationSet = validator.validate(article);
        if(constraintViolationSet.isEmpty()) {
            System.out.println("VALIDATION SUCCEED!");
            try {
                articleServices.addArticle(article);
            } catch (ArticleException e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println("VALIDATION FAILED!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/createarticle.jsp");
        List<Shelf> shelfs = new ArrayList<>();
        ShelfServiceItf shelfService = null;
        Context context = null;

        try {
            context = new InitialContext();
            shelfService = (ShelfServiceItf) context.lookup("java:global/ShelfService");
            shelfs = shelfService.findAll();
            request.setAttribute("shelfs", shelfs);
        } catch (NamingException e1) {
            e1.printStackTrace();
        }
        dispatcher.forward(request, response);
    }
}
