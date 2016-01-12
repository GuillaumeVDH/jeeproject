package org.flst.services;

import org.flst.entity.Article;
import org.flst.exceptions.ArticleException;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by guillaumevdh on 06/01/16.
 */
@Remote
public interface ArticleServiceItf {
    List<Article> findAll();

    Article findArticleById(Integer id);

    Article findArticleByName(String name) throws ArticleException;
}
