package me.exerosis.jager.gameengine.core.utilites;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class ListUtilities {
    private ListUtilities()
    {
    }

    public boolean isIterable(Object obj)
    {
        return obj instanceof Iterable || obj.getClass().isArray();
    }

    @SafeVarargs
    public static <T> List<T> joinLists(Collection<T> collection, Collection<T>... collections)
    {
        List<T> list = new ArrayList<>(collection);

        for (Collection<T> collection1 : collections)
        {
            list.addAll(collection1);
        }

        return list;
    }



}
