package me.exerosis.jager.engine.core.utilites;

import java.util.*;

/**
 * Durpped in to existence by Exerosis on 3/24/2016.
 */
public class ListUtilities {
    public static final Random RANDOM = new Random();
    private ListUtilities() {
    }

    public boolean isIterable(Object obj) {
        return obj instanceof Iterable || obj.getClass().isArray();
    }

    @SafeVarargs
    public static <T> List<T> joinLists(Collection<T> collection, Collection<T>... collections) {
        List<T> list = new ArrayList<>(collection);

        for (Collection<T> collection1 : collections) {
            list.addAll(collection1);
        }

        return list;
    }

    public static <T> T getRandom(List<T> collection){
        return collection.get(RANDOM.nextInt(collection.size()));
    }
}
