package org.flst;

import org.flst.services.ArticleRestService;
import org.flst.services.ShelfRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by anthonycallaert on 22/12/2015.
 */
@ApplicationPath("rs")
public class ApplicationConfig extends Application {

    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(ShelfRestService.class);
        c.add(ArticleRestService.class);

        c.add(MessageBodyReader.class);
        c.add(MessageBodyWriter.class);

        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
