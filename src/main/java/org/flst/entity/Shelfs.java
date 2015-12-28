package org.flst.entity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by anthonycallaert on 22/12/2015.
 */
@XmlRootElement
@XmlSeeAlso(Shelf.class)
public class Shelfs extends ArrayList<Shelf>{

    public Shelfs(){
        super();
    }

    public Shelfs(Collection<? extends Shelf> collection){
        super(collection);
    }

    @XmlElement(name = "shelf")
    public List<Shelf> getShelfs(){
        return this;
    }

    public void setShelfs(List<Shelf> shelfs){
        this.addAll(shelfs);
    }
}
