package org.flst.services;

import org.flst.entity.Article;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by guillaumevdh on 06/01/16.
 */
@Remote
public interface ArticleServicesItf {
    public List<Article> findAll();
}
