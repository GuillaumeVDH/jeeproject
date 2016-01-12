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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shelf")
    private Shelf shelf;

    @Column(name="prix")
    private int prix;

    @Column(name="picturelink")
    private String picturelink;

    @Column(name="brand")
    private String brand;

    //default constructor
    public Article() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    @Basic
    @Column(name = "prix")
    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "picturelink")
    public String getPicturelink() {
        return picturelink;
    }

    public void setPicturelink(String picturelink) {
        this.picturelink = picturelink;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article that = (Article) o;

        if (id != that.id) return false;
        if (shelf != that.shelf) return false;
        if (prix != that.prix) return false;
        if (picturelink != null ? !picturelink.equals(that.picturelink) : that.picturelink != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

}
