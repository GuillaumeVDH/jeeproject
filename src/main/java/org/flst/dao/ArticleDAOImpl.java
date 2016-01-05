package org.flst.dao;

import org.flst.entity.Article;
import org.flst.entity.Shelf;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by anthonycallaert on 19/12/2015.
 */
public class ArticleDAOImpl implements ArticleDAO {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeeproject");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    @Override
    public Article findById(int id) {
        Article article = new Article();

        String sql = "select a from article a where a.id = :id";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", id);

        try{
            article = (Article) query.getSingleResult();
        } catch(NoResultException e){
            article = null;
        }

        return article;
    }

    @Override
    public String createArticle(String name) {
        String result = "";

        Article article = new Article();
        try {
            article = this.findByName(name);
        }catch(Exception e){
            article = null;
        }

        if(article != null){
            result = "Article already exists";
        } else {
            article = new Article(name);

            entityTransaction.begin();
            entityManager.persist(article);
            entityManager.flush();
            entityTransaction.commit();

            result = "Article created successsfull";
        }

        return result;
    }

    @Override
    public void deleteArticle(Article article) {
        entityTransaction.begin();
        entityManager.remove(article);
        entityManager.flush();
        entityTransaction.commit();
    }

    @Override
    public Article findByName(String name) {
        Article article = new Article();

        String sql = "select a from article a where a.name = :name";
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", name);

        try{
            article = (Article) query.getSingleResult();
        }catch (NoResultException e){
            article = null;
        }

        return article;
    }

    @Override
    public List<Article> findByShelf(Shelf shelf) {
        String sql = "select a from articles a where a.shelf = :shelf";
        Query query = entityManager.createQuery(sql);
        query.setParameter("shelf", shelf);

        List<Article> articles = (List<Article>) query.getResultList();

        return articles;
    }
}
