package org.flst.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by anthonycallaert on 19/12/2015.
 */
@Entity
@Table(name = "articles")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "select a from Article a")
})
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelf")
    private Shelf shelf;

    //default constructor
    public Article() {

    }

    public Article(String name) {
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

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
        if(!shelf.getArticles().contains(this)){ //FIXME throw exception when it goes wrong
            shelf.getArticles().add(this);
        }
    }
}
