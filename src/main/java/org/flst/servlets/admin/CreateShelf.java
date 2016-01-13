package org.flst.servlets.admin;

import org.flst.entity.Shelf;
import org.flst.exceptions.ShelfException;
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
 * Created by franckmahieu on 13/01/16.
 */
public class CreateShelf extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("shelf/create/success.jsp");

        Shelf shelf = new Shelf();
        List<Shelf> shelfs = new ArrayList<>();
        Context context = null;
        ShelfServiceItf shelfService = null;

        try {
            context = new InitialContext();
            shelfService = (ShelfServiceItf) context.lookup("java:global/ShelfService");
            shelf.setName(request.getParameter("shelfName"));
        } catch (Exception e) {
            dispatcher = request.getRequestDispatcher("shelf/create/error.jsp");
            request.setAttribute("error", e);
            dispatcher.forward(request, response);
        }

        //On utilise un Validator afin de vérifier que notre objet rayon est en phase avec les contraintes
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Shelf>> constraintViolationSet = validator.validate(shelf);

        if(constraintViolationSet.isEmpty()) {
        //Pas d'erreurs après vérification, on peut persister l'objet
            try {
                shelfService.addShelf(shelf);
                dispatcher.forward(request, response);
            } catch (ShelfException e) {
                dispatcher = request.getRequestDispatcher("shelf/create/error.jsp");
                request.setAttribute("error", e);
                dispatcher.forward(request, response);
            }
        }
        else {
        //Une ou plusieurs erreurs pendant la vérification. On informe l'utilisateur
            dispatcher = request.getRequestDispatcher("admin/create-shelf.jsp");
            request.setAttribute("errors", constraintViolationSet);
            request.setAttribute("shelfs", shelfs);
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/create-shelf.jsp");
        dispatcher.forward(request, response);
    }
}
