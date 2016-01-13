package org.flst.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by anthonycallaert on 21/12/2015.
 */
@Entity
@Table(name = "shelfs")
@XmlRootElement
@NamedQuery(name = Shelf.FIND_ALL, query = "SELECT s FROM Shelf s")
public class Shelf implements Serializable {

    public static final String FIND_ALL = "Shelf.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotNull
    @Size(min=1,max=100)
    private String name;

    @OneToMany(mappedBy = "shelf")
    private List<Article> articles;

    public Shelf(){

    }

    public Shelf(String name){
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void addArticle(Article article){
        this.articles.add(article);
        if(article.getShelf() != this){
            article.setShelf(this);
        }
    }
}
