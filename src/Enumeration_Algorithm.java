import Bayes_Net.Bayes_Net;
import Bayes_Net.Distribution;
import Bayes_Net.Evidence;
import Bayes_Net.Variable;

import java.util.ArrayList;
import java.util.List;

public class Enumeration_Algorithm {
    Bayes_Net bn;

    public Double Enumeration_ask(String query, Evidence evidence,String valueReq, Bayes_Net bn) {
        this.bn=bn;
        Variable x = bn.getVariable(query);
        Distribution dist = new Distribution(x);
        evidence.match(bn.getVariableList());
        Evidence otherE;
        for(Object value : x.getDomain()) {
             otherE = evidence.add(x, value);
            dist.put(value, Enumerate_all(bn.getVariableList(), otherE));
        }
        dist.normalize();
        return dist.get(valueReq);
    }

    public double Enumerate_all(List<Variable> variables, Evidence e) {
        double sum = 0.0;
        if(variables.isEmpty()) {
            sum=1.0;
            return sum;
        }
        List<Variable> vars = new ArrayList<>(variables);
        Variable y = vars.remove(0);

        if(e.containsKey(y)) {
            return bn.getProb(y, e) * Enumerate_all(vars, e);
        } else {
            Evidence e2;
            for(Object v : y.getDomain()) {
                e2 = e.add(y, v);
                sum += bn.getProb(y, e2) * Enumerate_all(vars, e2);
            }
            return sum;
        }
    }

}
