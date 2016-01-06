package org.flst.services;

import org.flst.dao.ArticleDAO;
import org.flst.entity.Article;
import org.flst.entity.Shelf;
import org.flst.utils.Factory;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by anthonycallaert on 21/12/2015.
 */

@Remote
@Stateless
public class ArticleServices {
    @EJB
    ArticleDAO articleDAO;

//    private ArticleDAO articleDAO = Factory.getArticleDAO();

    public List<Article> findAll() {
        return articleDAO.findAll();
    }

    public Article findById(int id){
        return articleDAO.findById(id);
    }

    public List<Article> findByhelf(Shelf shelf) {
        return articleDAO.findByShelf(shelf);
    }

    public String createArticle(String name){
        return articleDAO.createArticle(name);
    }

    public void deleteArticle(Article article){
        articleDAO.deleteArticle(article);
    }
}
