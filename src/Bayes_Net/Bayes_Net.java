package Bayes_Net;

import util.ArraySet;
import java.util.*;

public class Bayes_Net {


    public class  Node {

        public Variable variable;
        public Set<Node> childrens = new ArraySet<>();
        public Condition cond;
        public List<Node> parents;

        public Node(Variable variable) {
            this.variable = variable;
        }


    }

    protected Set<Node> nodes = new ArraySet<>();

    public void add(Variable var) {

        nodes.add(new Node(var));
    }
    public List<Variable> getVariableList() {
        List<Variable> vars = new ArrayList<>(nodes.size());
        for (Node node : nodes) {
            vars.add(node.variable);
        }
        return vars;
    }
    public Variable getVariable(String name) {
        for (Node node : nodes) {
            Variable var = node.variable;
            if (var.getName().equals(name)) {
                return var;
            }
        }
        throw new NoSuchElementException();
    }

    public void connection(Variable var, List<Variable> parents, Condition cond) {
        Node node = getNodeForV(var);
        node.parents = new ArrayList<>(parents.size());
        for (Variable pvar : parents) {
            Node pnode = getNodeForV(pvar);
            node.parents.add(pnode);
            pnode.childrens.add(node);
        }
        node.cond = cond;
    }
    public Node getNodeForV(Variable var) {
        for (Node node : nodes) {
            if (node.variable == var) {
                return node;
            }
        }
        throw new NoSuchElementException();
    }

    public double getProb(Variable X, Evidence e) {
        Node node = getNodeForV(X);
        return node.cond.get(e);

    }

}


