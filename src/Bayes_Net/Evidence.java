package Bayes_Net;

import java.util.LinkedHashMap;
import java.util.List;

public class Evidence extends LinkedHashMap<Variable,Object> {
    public Evidence() {
        super();
    }

    public Variable getKeyByName(String name) {
        for(Variable key : this.keySet()) {
            if(key.getName().equals(name)) {
                return key;
            }
        }
        return null;
    }
    public void match(List<Variable> var) {
        for(Variable v : var) {
            Variable mine = this.getKeyByName(v.getName());
            if(mine != null) {
                Object value = this.get(mine);
                this.remove(mine);
                this.put(v, value);
            }
        }
    }
    public Evidence add(Variable v, Object value) {
        Evidence add = this.copy();
        add.put(v, value);
        return add;
    }
    public Evidence copy() {
        return (Evidence)this.clone();
    }
}
