package org.flst.services;

import org.flst.entity.Article;
import org.flst.exceptions.ArticleException;

import javax.ejb.Remote;
import java.util.List;
import java.util.Set;

/**
 * Created by guillaumevdh on 06/01/16.
 */
@Remote
public interface ArticleServiceItf {
    List<Article> findAll();

    Article findArticleById(Integer id);

    Article findArticleByName(String name) throws ArticleException;

    List<Article> findArticlesByNameContaining(String name) throws ArticleException;
}
