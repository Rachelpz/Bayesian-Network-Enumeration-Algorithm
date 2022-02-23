package Bayes_Net;

import java.util.ArrayList;
import java.util.Arrays;


public class Domain extends ArrayList<Object> {

    public Domain() {
        super();
    }

    public Domain(Object... elements) {
        this();
        this.addAll(Arrays.asList(elements));
    }
}
