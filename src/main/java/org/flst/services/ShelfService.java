package org.flst.services;

import org.flst.entity.Shelf;
import org.flst.exceptions.ShelfException;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by franck on 12/01/16.
 */
@Remote(ShelfServiceItf.class)
@Stateless (name = "ShelfService")
@EJB(name="java:global/ShelfService",beanInterface=ShelfServiceItf.class)
public class ShelfService implements ShelfServiceItf{

    @PersistenceContext(unitName = "jeeproject")
    EntityManager em;

    @Override
    public List<Shelf> findAll() {
        return em.createQuery("SELECT a FROM Shelf a").getResultList();
    }

    @Override
    public Shelf findShelfById(Integer id) {
        return em.find(Shelf.class, id);
    }

    public void addShelf(Shelf shelf) throws ShelfException {
        try {
            em.persist(shelf);
        } catch (Exception e) {
            throw  new ShelfException("Impossible d'enregistrer le rayon en base de données. " + e.getMessage());
        }
    }
}
