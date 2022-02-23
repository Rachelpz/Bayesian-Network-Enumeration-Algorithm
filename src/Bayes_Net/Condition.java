package Bayes_Net;


import java.io.PrintWriter;
import java.util.*;

public class Condition {
    protected Entry root;

    public Condition(Variable query, List<Variable> parents) {
        root = beg(query, parents, 0);
    }

    abstract public class Entry {
        abstract public void print(PrintWriter out, String prefix);
    }

    public class Data extends Entry {
        public Variable variable;
        public Map<Object, Entry> entries;
        public void print(PrintWriter out, String prefix) {
            for (Map.Entry<Object,Entry> entry : entries.entrySet()) {
                String newprefix = prefix + variable.getName() + "=" + entry.getKey() + "\t";
                entry.getValue().print(out, newprefix);
            }
        }
        public Data(Variable variable) {
            this.variable = variable;
            Domain domain = variable.getDomain();
            this.entries = new LinkedHashMap<>(domain.size());
        }
    }

    public class ProbabilityValue extends Entry {
        public double value;
        public ProbabilityValue(double value) {
            this.value = value;
        }

        public void print(PrintWriter out, String prefix) {
            out.print(prefix);
            out.println(value);
        }
    }


    protected ProbabilityValue find(Entry entry, Evidence evidence) throws NoSuchElementException {
        if (entry == null) {
            throw new NoSuchElementException();
        } else if (entry instanceof ProbabilityValue) {
            return (ProbabilityValue)entry;
        } else {
            Data dat = (Data)entry;
            Variable var = dat.variable;
            Object value = evidence.get(var);
            if (value == null) {
                throw new NoSuchElementException();
            } else {
                entry = dat.entries.get(value);
                if (entry == null) {
                    throw new NoSuchElementException();
                } else {
                    return find(entry, evidence);
                }
            }
        }
    }

    public Entry beg(Variable query, List<Variable> parents, int index) {
        if (index < parents.size()) {
            Variable given = parents.get(index);
            Data dat = new Data(given);
            for (Object value : given.getDomain()) {
                Entry entry = beg(query, parents, index+1);
                dat.entries.put(value, entry);
            }
            return dat;
        } else {

            Data data = new Data(query);
            for (Object value : query.getDomain()) {
                ProbabilityValue p = new ProbabilityValue(0.0);
                data.entries.put(value, p);
            }
            return data;
        }
    }
    public void set(Evidence e, double p) {
        ProbabilityValue pv = find(root, e);
        if (pv != null) {
            pv.value = p;
        } else {
            throw new NoSuchElementException();
        }
    }
    public double get(Evidence e) throws NoSuchElementException {
        ProbabilityValue pv = find(root, e);
        if (pv != null) {
            return pv.value;
        } else {
            throw new NoSuchElementException();
        }
    }


}
