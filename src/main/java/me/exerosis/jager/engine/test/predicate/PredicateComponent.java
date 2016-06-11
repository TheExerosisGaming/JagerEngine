package me.exerosis.jager.engine.test.predicate;

import me.exerosis.jager.engine.core.component.ComponentImplementation;

import java.util.function.Predicate;

/**
 * Created by Exerosis.
 */
public class PredicateComponent <T> extends ComponentImplementation {
    private Predicate<T> predicate;

    public PredicateComponent(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    public void setPredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    public Predicate<T> getPredicate() {
        return predicate;
    }
}
