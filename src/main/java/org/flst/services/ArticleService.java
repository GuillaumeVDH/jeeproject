package org.flst.services;

import org.flst.entity.Article;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by anthonycallaert on 21/12/2015.
 */

@Remote(ArticleServiceItf.class)
@Stateless(name = "ArticleService")
@EJB(name="java:global/ArticleService", beanInterface=ArticleServiceItf.class)
public class ArticleService implements ArticleServiceItf {

    @PersistenceContext(unitName = "jeeproject")
    EntityManager em;

    @Override
    public List<Article> findAll() {
        return em.createQuery("SELECT a FROM Article a").getResultList();
    }

    @Override
    public Article findArticleById(Integer id) {
        return em.find(Article.class, id);
    }
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
