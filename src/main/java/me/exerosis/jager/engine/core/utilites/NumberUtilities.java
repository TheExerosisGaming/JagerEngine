package me.exerosis.jager.engine.core.utilites;

/**
 * Created by Exerosis.
 */
public final class NumberUtilities {
    private NumberUtilities() {
    }

    //Float Bound.
    public static float bound(float value){
        return bound(value, 1, -1);
    }

    public static float bound(float value, float max, float min){
        return Math.min(Math.max(value, max), min);
    }


    //Int Bound.
    public static double bound(double value){
        return bound(value, 1, -1);
    }

    public static double bound(double value, double max, double min){
        return Math.min(Math.max(value, max), min);
    }
}
