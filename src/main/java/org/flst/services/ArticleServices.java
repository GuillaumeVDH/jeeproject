package org.flst.services;

import org.flst.dao.ArticleDAO;
import org.flst.entity.Article;
import org.flst.entity.Shelf;
import org.flst.utils.Factory;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by anthonycallaert on 21/12/2015.
 */

@Remote
@Stateless
public class ArticleServices implements ArticleServicesItf{

    @PersistenceContext(unitName = "jeeproject")
    EntityManager em;

//    @EJB
//    ArticleDAO articleDAO;

//    private ArticleDAO articleDAO = Factory.getArticleDAO();

    public List<Article> findAll() {
        return em.createQuery("SELECT a FROM Article a").getResultList();
    }

//    public List<Article> findAll() {
//        return articleDAO.findAll();
//    }

//    public Article findById(int id){
//        return articleDAO.findById(id);
//    }
//
//    public List<Article> findByhelf(Shelf shelf) {
//        return articleDAO.findByShelf(shelf);
//    }
//
//    public String createArticle(String name){
//        return articleDAO.createArticle(name);
//    }
//
//    public void deleteArticle(Article article){
//        articleDAO.deleteArticle(article);
//    }
}
