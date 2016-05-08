package me.exerosis.jager.engine.test.spleef.predicate;

import me.exerosis.jager.engine.core.component.Component;

import java.util.function.Predicate;

/**
 * Created by Exerosis.
 */
public class DualPredicateComponent<A, B> extends Component {
    private Predicate<A> predicateA;
    private Predicate<B> predicateB;

    public DualPredicateComponent(Predicate<A> predicateA, Predicate<B> predicateB) {
        this.predicateA = predicateA;
        this.predicateB = predicateB;
    }

    public Predicate<B> getPredicateB() {
        return predicateB;
    }

    public void setPredicateA(Predicate<A> predicateA) {
        this.predicateA = predicateA;
    }

    public void setPredicateB(Predicate<B> predicateB) {
        this.predicateB = predicateB;
    }

    public Predicate<A> getPredicateA() {
        return predicateA;
    }
}
