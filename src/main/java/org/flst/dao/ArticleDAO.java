package org.flst.dao;

import org.flst.entity.Article;
import org.flst.entity.Shelf;

import java.util.List;

/**
 * Created by anthonycallaert on 19/12/2015.
 */
public interface ArticleDAO {

    /**
     * Return all voitres in the database
     *
     * @return a set of voiture
     */
    List<Article> findAll();

    public Article findById(int id);

    public String createArticle(String name);

    public void deleteArticle(Article article);

    public Article findByName(String name);

    public List<Article> findByShelf(Shelf shelf);
}
