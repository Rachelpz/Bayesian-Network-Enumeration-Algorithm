package Bayes_Net;


public class Variable {

    protected String name;
    protected Domain domain;

    public Variable(String name, Domain domain) {
        this.name = name;
        this.domain = domain;
    }
    public Variable(String name) {
        this(name, new Domain());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }


}
