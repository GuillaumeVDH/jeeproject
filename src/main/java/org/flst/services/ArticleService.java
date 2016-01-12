package org.flst.services;

import org.flst.entity.Article;
import org.flst.exceptions.ArticleException;

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

    @Override
    public Article findArticleByName(String name) throws ArticleException {
        List<Article> results = em.createQuery("SELECT DISTINCT a FROM Article a WHERE a.name = :name ")
                                .setParameter("name", name).getResultList();
        if(results.size() > 0)
            return results.get(0);
        else
            throw new ArticleException( "[ArticleService] findArticleByName() - Aucun produit récupéré en base de données" +
                                        " portant le nom de : " + name + ".");
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
