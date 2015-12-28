package org.flst.dao;

import org.flst.entity.Shelf;

import java.util.List;

/**
 * Created by anthonycallaert on 21/12/2015.
 */
public interface ShelfDAO {

    public String createShelf(String name);

    public void deleteShelf(Shelf shelf);

    public Shelf findById(int id);

    public Shelf findByName(String name);
}
