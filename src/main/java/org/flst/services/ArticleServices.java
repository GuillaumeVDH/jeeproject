package org.flst.services;

import org.flst.dao.ArticleDAO;
import org.flst.entity.Article;
import org.flst.entity.Shelf;
import org.flst.utils.Factory;

import java.util.List;

/**
 * Created by anthonycallaert on 21/12/2015.
 */
public class ArticleServices {
    private ArticleDAO articleDAO = Factory.getArticleDAO();

    public Article findById(int id){
        return articleDAO.findById(id);
    }

    public List<Article> findByShelf(Shelf shelf) {
        return articleDAO.findByShelf(shelf);
    }

    public String createArticle(String name){
        return articleDAO.createArticle(name);
    }

    public void deleteArticle(Article article){
        articleDAO.deleteArticle(article);
    }
}
