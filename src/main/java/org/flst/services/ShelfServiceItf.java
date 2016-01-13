package org.flst.services;

import org.flst.entity.Shelf;
import org.flst.exceptions.ShelfException;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by franck on 12/01/16.
 */

@Remote
public interface ShelfServiceItf {
    List<Shelf> findAll();
    Shelf findShelfById(Integer id);

    void addShelf(Shelf shelf) throws ShelfException;
}
