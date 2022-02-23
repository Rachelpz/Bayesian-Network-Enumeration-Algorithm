package Bayes_Net;

import java.util.LinkedHashMap;

public class Distribution extends LinkedHashMap<Object,Double> {
    public Distribution(int initialSize) {
        super(initialSize);
    }
    public void put(Object x, double d) {
        put(x, new Double(d));
    }
    public Distribution(Variable X) {
        this(X.getDomain().size());
    }

    public void normalize() {
        double sum = 0.0;
        for (Double value : values()) {
            sum += value;
        }
        for (Object key : keySet()) {
            put(key, get(key) /sum);
        }
    }

}
