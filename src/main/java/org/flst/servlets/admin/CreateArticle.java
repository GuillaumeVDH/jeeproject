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
        RequestDispatcher dispatcher = request.getRequestDispatcher("article/create/success.jsp");

        Article article = new Article();
        Shelf shelf = new Shelf();
        List<Shelf> shelfs = new ArrayList<>();
        Context context = null;
        ArticleServiceItf articleServices = null;
        ShelfServiceItf shelfService = null;

        try {
            context = new InitialContext();
            shelfService = (ShelfServiceItf) context.lookup("java:global/ShelfService");
            shelf = shelfService.findShelfById(Integer.valueOf(request.getParameter("productShelf")));
            shelfs = shelfService.findAll();

            article.setName(request.getParameter("productName"));
            article.setPicturelink(request.getParameter("productImage"));
            article.setBrand(request.getParameter("productBrand"));
            article.setPrix(Float.valueOf(request.getParameter("productPrice")));
            article.setShelf(shelf);
            System.out.println("DEBUG productBrand set to: " + request.getParameter("productBrand"));
            articleServices = (ArticleServiceItf) context.lookup("java:global/ArticleService");
        } catch (Exception e) {
            dispatcher = request.getRequestDispatcher("article/create/error.jsp");
            request.setAttribute("error", e);
            dispatcher.forward(request, response);
        }

        //On utilise un Validator afin de vérifier que notre objet Article est en phase avec les contraintes
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Article>> constraintViolationSet = validator.validate(article);

        if(constraintViolationSet.isEmpty()) {
        //Pas d'erreurs après vérification, on peut persister l'objet
            try {
                articleServices.addArticle(article);
                dispatcher.forward(request, response);
            } catch (ArticleException e) {
                dispatcher = request.getRequestDispatcher("article/create/error.jsp");
                request.setAttribute("error", e);
                dispatcher.forward(request, response);
            }
        }
        else {
        //Une ou plusieurs erreurs pendant la vérification. On informe l'utilisateur
            dispatcher = request.getRequestDispatcher("admin/create-article.jsp");
            request.setAttribute("errors", constraintViolationSet);
            request.setAttribute("shelfs", shelfs);
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/create-article.jsp");
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
