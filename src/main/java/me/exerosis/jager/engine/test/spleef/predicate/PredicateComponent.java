package me.exerosis.jager.engine.test.spleef.predicate;

import me.exerosis.jager.engine.core.component.Component;

import java.util.function.Predicate;

/**
 * Created by Exerosis.
 */
public class PredicateComponent <T> extends Component {
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
