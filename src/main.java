import Bayes_Net.Bayes_Net;
import Bayes_Net.Domain;
import Bayes_Net.Variable;
import Bayes_Net.Condition;
import java.util.ArrayList;
import Bayes_Net.Evidence;

import java.util.List;
import java.util.Map;

import static util.common.parseEvidence;

public class main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args)  {

        Bayes_Net red = new Bayes_Net();

        Variable OccupationType = new Variable("OccupationType");
        OccupationType.setDomain(new Domain("Office", "NonOffice"));

        Variable ExposureToToxics = new Variable("ExposureToToxics");
        ExposureToToxics.setDomain(new Domain("T", "F"));

        Variable Gender = new Variable("Gender");
        Gender.setDomain(new Domain("M", "F"));

        Variable Smoking = new Variable("Smoking");
        Smoking.setDomain(new Domain("T", "F"));

        Variable LungCancer = new Variable("LungCancer");
        LungCancer.setDomain(new Domain("T", "F"));

        Variable XRayResult = new Variable("XRayResult");
        XRayResult.setDomain(new Domain("Normal", "Abnormal"));

        Variable SerumCalcium = new Variable("SerumCalcium");
        SerumCalcium.setDomain(new Domain("Normal", "Abnormal"));

        List<Variable> noParents = new ArrayList<Variable>(0);

        List<Variable> noParents1 = new ArrayList<Variable>(0);

        List<Variable> parents = new ArrayList<Variable>(2);
        parents.add(Gender);
        parents.add(OccupationType);

        List<Variable> parents1 = new ArrayList<Variable>(1);
        parents1.add(OccupationType);

        List<Variable> parents2 = new ArrayList<Variable>(2);
        parents2.add(Smoking);
        parents2.add(ExposureToToxics);

        List<Variable> parents3 = new ArrayList<Variable>(1);
        parents3.add(LungCancer);

        List<Variable> parents4 = new ArrayList<Variable>(1);
        parents4.add(LungCancer);


        Condition cond0 = new Condition(OccupationType, noParents);
        Condition cond1 = new Condition(Gender, noParents1);
        Condition cond2 = new Condition(Smoking, parents);
        Condition cond3 = new Condition(ExposureToToxics, parents1);
        Condition cond4 = new Condition(LungCancer, parents2);
        Condition cond5 = new Condition(XRayResult, parents3);
        Condition cond6 = new Condition(SerumCalcium, parents4);

        red.add(OccupationType);
        red.add(Gender);
        red.add(ExposureToToxics);
        red.add(Smoking);
        red.add(LungCancer);
        red.add(XRayResult);
        red.add(SerumCalcium);

        red.connection(OccupationType,noParents,cond0);
        red.connection(Gender,noParents,cond1);
        red.connection(Smoking,parents,cond2);
        red.connection(ExposureToToxics,parents1,cond3);
        red.connection(LungCancer,parents2,cond4);
        red.connection(XRayResult,parents3,cond5);
        red.connection(SerumCalcium,parents4,cond6);

        Evidence e0 = new Evidence();
        e0.put(OccupationType, "Office");
        cond0.set(e0, 0.25);

        Evidence e1 = new Evidence();
        e1.put(OccupationType, "NonOffice");
        cond0.set(e1, 0.75);

        Evidence e2 = new Evidence();
        e2.put(Gender, "M");
        cond1.set(e2, 0.5);

        Evidence e3 = new Evidence();
        e3.put(Gender, "F");
        cond1.set(e3, 0.5);

        Evidence e4 = new Evidence();
        e4.put(ExposureToToxics, "T");
        e4.put(OccupationType, "Office");
        cond3.set(e4, 0.05);

        Evidence e5 = new Evidence();
        e5.put(ExposureToToxics, "F");
        e5.put(OccupationType, "Office");
        cond3.set(e5, 0.95);

        Evidence e6 = new Evidence();
        e6.put(ExposureToToxics, "T");
        e6.put(OccupationType, "NonOffice");
        cond3.set(e6, 0.1);

        Evidence e7 = new Evidence();
        e7.put(ExposureToToxics, "F");
        e7.put(OccupationType, "NonOffice");
        cond3.set(e7, 0.9);

        Evidence e8 = new Evidence();
        e8.put(Smoking, "T");
        e8.put(OccupationType, "Office");
        e8.put(Gender, "M");
        cond2.set(e8, 0.1);

        Evidence e9 = new Evidence();
        e9.put(Smoking, "F");
        e9.put(OccupationType, "Office");
        e9.put(Gender, "M");
        cond2.set(e9, 0.9);

        Evidence e11 = new Evidence();
        e11.put(Smoking, "T");
        e11.put(OccupationType, "NonOffice");
        e11.put(Gender, "M");
        cond2.set(e11, 0.2);

        Evidence e12 = new Evidence();
        e12.put(Smoking, "F");
        e12.put(OccupationType, "NonOffice");
        e12.put(Gender, "M");
        cond2.set(e12, 0.8);

        Evidence e13 = new Evidence();
        e13.put(Smoking, "T");
        e13.put(OccupationType, "Office");
        e13.put(Gender, "F");
        cond2.set(e13, 0.05);

        Evidence e14 = new Evidence();
        e14.put(Smoking, "F");
        e14.put(OccupationType, "Office");
        e14.put(Gender, "F");
        cond2.set(e14, 0.95);

        Evidence e15 = new Evidence();
        e15.put(Smoking, "T");
        e15.put(OccupationType, "NonOffice");
        e15.put(Gender, "F");
        cond2.set(e15, 0.1);

        Evidence e16 = new Evidence();
        e16.put(Smoking, "F");
        e16.put(OccupationType, "NonOffice");
        e16.put(Gender, "F");
        cond2.set(e16, 0.9);


        Evidence e17 = new Evidence();
        e17.put(LungCancer, "T");
        e17.put(Smoking, "T");
        e17.put(ExposureToToxics, "T");
        cond4.set(e17, 0.25);

        Evidence e18 = new Evidence();
        e18.put(LungCancer, "F");
        e18.put(Smoking, "T");
        e18.put(ExposureToToxics, "T");
        cond4.set(e18, 0.75);

        Evidence e19 = new Evidence();
        e19.put(LungCancer, "T");
        e19.put(Smoking, "T");
        e19.put(ExposureToToxics, "F");
        cond4.set(e19, 0.1);

        Evidence e20 = new Evidence();
        e20.put(LungCancer, "F");
        e20.put(Smoking, "T");
        e20.put(ExposureToToxics, "F");
        cond4.set(e20, 0.9);

        Evidence e21 = new Evidence();
        e21.put(LungCancer, "T");
        e21.put(Smoking, "F");
        e21.put(ExposureToToxics, "T");
        cond4.set(e21, 0.15);

        Evidence e22= new Evidence();
        e22.put(LungCancer, "F");
        e22.put(Smoking, "F");
        e22.put(ExposureToToxics, "T");
        cond4.set(e22, 0.85);

        Evidence e23= new Evidence();
        e23.put(LungCancer, "T");
        e23.put(Smoking, "F");
        e23.put(ExposureToToxics, "F");
        cond4.set(e23, 0.01);

        Evidence e24= new Evidence();
        e24.put(LungCancer, "F");
        e24.put(Smoking, "F");
        e24.put(ExposureToToxics, "F");
        cond4.set(e24, 0.99);

        Evidence e25 = new Evidence();
        e25.put(XRayResult, "Normal");
        e25.put(LungCancer, "T");
        cond5.set(e25, 0.05);

        Evidence e26 = new Evidence();
        e26.put(XRayResult, "Normal");
        e26.put(LungCancer, "F");
        cond5.set(e26, 0.9);

        Evidence e27 = new Evidence();
        e27.put(XRayResult, "Abnormal");
        e27.put(LungCancer, "T");
        cond5.set(e27, 0.95);

        Evidence e28 = new Evidence();
        e28.put(XRayResult, "Abnormal");
        e28.put(LungCancer, "F");
        cond5.set(e28, 0.1);


        Evidence e29 = new Evidence();
        e29.put(SerumCalcium, "Normal");
        e29.put(LungCancer, "T");
        cond6.set(e29, 0.15);

        Evidence e30 = new Evidence();
        e30.put(SerumCalcium, "Normal");
        e30.put(LungCancer, "F");
        cond6.set(e30, 0.95);

        Evidence e31 = new Evidence();
        e31.put(SerumCalcium, "Abnormal");
        e31.put(LungCancer, "T");
        cond6.set(e31, 0.85);

        Evidence e32 = new Evidence();
        e32.put(SerumCalcium, "Abnormal");
        e32.put(LungCancer, "F");
        cond6.set(e32, 0.05);

        //P(X|M,-N) es lo mismo que query="M"(Aclaracion la variable solamente), y
        //args1[]={"M", valordeM , "N" ,valorDeN}
        //esto con el objetivo que detecte cualquier cadena de caracteres como valor no solo T O F

        String query = "ExposureToToxics";
        String valueReq="T";
        String args1[] = {"LungCancer", "T" ,"Smoking","F"};

        Evidence evidence = parseEvidence(args1);
        Enumeration_Algorithm enume = new Enumeration_Algorithm();
        Double result = enume.Enumeration_ask(query,evidence,valueReq,red);
        result=result*100;

        System.out.printf("La probabilidad para la variable "+ query+" con el estado "+ valueReq+ " es de un: "+ ANSI_RED+"%.2f%%"+ANSI_RESET+" dadas las evidencias:",result);
        System.out.println("");
        for (Map.Entry<Variable, Object> e:
            evidence.entrySet() ) {
            System.out.println(e.getKey().getName() +" con el estado "+e.getValue().toString());
        }


        String query1 = "LungCancer";
        String valueReq1="T";
        String args2[] = {"SerumCalcium", "Abnormal" ,"XRayResult","Normal","OccupationType","Office"};

        Evidence evidence1 = parseEvidence(args2);
        Enumeration_Algorithm enume1 = new Enumeration_Algorithm();
        Double result1 = enume1.Enumeration_ask(query1,evidence1,valueReq1,red);
        result1=result1*100;

        System.out.printf("La probabilidad para la variable "+ query1+" con el estado "+ valueReq1+ " es de un: "+ ANSI_RED+"%.2f%%"+ANSI_RESET+" dadas las evidencias:",result1);
        System.out.println("");
        for (Map.Entry<Variable, Object> e:
                evidence1.entrySet() ) {
            System.out.println(e.getKey().getName() +" con el estado "+e.getValue().toString());
        }

        //ejemplo red 2


        Bayes_Net red2 = new Bayes_Net();

        Variable Robo = new Variable("Robo");
        Robo.setDomain(new Domain("T", "F"));

        Variable Terremoto = new Variable("Terremoto");
        Terremoto.setDomain(new Domain("T", "F"));

        Variable Alarma = new Variable("Alarma");
        Alarma.setDomain(new Domain("T", "F"));

        Variable Juanllama = new Variable("Juanllama");
        Juanllama.setDomain(new Domain("T", "F"));

        Variable Mariallama = new Variable("Mariallama");
        Mariallama.setDomain(new Domain("T", "F"));


        List<Variable> noParents2 = new ArrayList<Variable>(0);

        List<Variable> noParents3 = new ArrayList<Variable>(0);

        List<Variable> parents5 = new ArrayList<Variable>(2);
        parents5.add(Robo);
        parents5.add(Terremoto);

        List<Variable> parents6 = new ArrayList<Variable>(1);
        parents6.add(Alarma);

        Condition cond7 = new Condition(Robo, noParents2);
        Condition cond8 = new Condition(Terremoto, noParents3);
        Condition cond9 = new Condition(Alarma, parents5);
        Condition cond10 = new Condition(Juanllama, parents6);
        Condition cond11 = new Condition(Mariallama, parents6);

        red2.add(Robo);
        red2.add(Terremoto);
        red2.add(Alarma);
        red2.add(Juanllama);
        red2.add(Mariallama);

        red2.connection(Robo,noParents2,cond7);
        red2.connection(Terremoto,noParents3,cond8);
        red2.connection(Alarma,parents5,cond9);
        red2.connection(Juanllama,parents6,cond10);
        red2.connection(Mariallama,parents6,cond11);

        Evidence ev0 = new Evidence();
        ev0.put(Robo, "T");
        cond7.set(ev0, 0.001);

        Evidence ev1 = new Evidence();
        ev1.put(Robo, "F");
        cond7.set(ev1, 0.999);

        Evidence ev2 = new Evidence();
        ev2.put(Terremoto, "T");
        cond8.set(ev2, 0.002);

        Evidence ev3 = new Evidence();
        ev3.put(Terremoto, "F");
        cond8.set(ev3, 0.998);

        Evidence ev4 = new Evidence();
        ev4.put(Robo, "T");
        ev4.put(Terremoto, "T");
        ev4.put(Alarma, "T");
        cond9.set(ev4, 0.95);

        Evidence ev5 = new Evidence();
        ev5.put(Robo, "T");
        ev5.put(Terremoto, "T");
        ev5.put(Alarma, "F");
        cond9.set(ev5, 0.05);

        Evidence ev6 = new Evidence();
        ev6.put(Robo, "T");
        ev6.put(Terremoto, "F");
        ev6.put(Alarma, "T");
        cond9.set(ev6, 0.94);

        Evidence ev7 = new Evidence();
        ev7.put(Robo, "T");
        ev7.put(Terremoto, "F");
        ev7.put(Alarma, "F");
        cond9.set(ev7, 0.06);

        Evidence ev8 = new Evidence();
        ev8.put(Robo, "F");
        ev8.put(Terremoto, "T");
        ev8.put(Alarma, "T");
        cond9.set(ev8, 0.29);

        Evidence ev9 = new Evidence();
        ev9.put(Robo, "F");
        ev9.put(Terremoto, "T");
        ev9.put(Alarma, "F");
        cond9.set(ev9, 0.71);

        Evidence ev10 = new Evidence();
        ev10.put(Robo, "F");
        ev10.put(Terremoto, "F");
        ev10.put(Alarma, "T");
        cond9.set(ev10, 0.001);

        Evidence ev11 = new Evidence();
        ev11.put(Robo, "F");
        ev11.put(Terremoto, "F");
        ev11.put(Alarma, "F");
        cond9.set(ev11, 0.999);

        Evidence ev12 = new Evidence();
        ev12.put(Alarma, "T");
        ev12.put(Juanllama, "T");
        cond10.set(ev12, 0.9);

        Evidence ev13 = new Evidence();
        ev13.put(Alarma, "T");
        ev13.put(Juanllama, "F");
        cond10.set(ev13, 0.1);

        Evidence ev14 = new Evidence();
        ev14.put(Alarma, "F");
        ev14.put(Juanllama, "F");
        cond10.set(ev14, 0.95);

        Evidence ev15 = new Evidence();
        ev15.put(Alarma, "F");
        ev15.put(Juanllama, "T");
        cond10.set(ev15, 0.05);



        Evidence ev16 = new Evidence();
        ev16.put(Alarma, "T");
        ev16.put(Mariallama, "T");
        cond11.set(ev16, 0.7);

        Evidence ev17 = new Evidence();
        ev17.put(Alarma, "T");
        ev17.put(Mariallama, "F");
        cond11.set(ev17, 0.3);

        Evidence ev18 = new Evidence();
        ev18.put(Alarma, "F");
        ev18.put(Mariallama, "F");
        cond11.set(ev18, 0.99);

        Evidence ev19 = new Evidence();
        ev19.put(Alarma, "F");
        ev19.put(Mariallama, "T");
        cond11.set(ev19, 0.01);


        String query2 = "Alarma";
        String valueReq2="T";
        String args3[] = {"Robo", "F" , "Mariallama","T","Terremoto","F"};

        Evidence evidence2 = parseEvidence(args3);
        Enumeration_Algorithm enume2 = new Enumeration_Algorithm();
        Double result2 = enume2.Enumeration_ask(query2,evidence2,valueReq2,red2);
        result2=result2*100;

        System.out.printf("La probabilidad para la variable "+ query2+" con el estado "+ valueReq2+ " es de un: "+ ANSI_RED+"%.2f%%"+ANSI_RESET+" dadas las evidencias:",result2);
        System.out.println("");
        for (Map.Entry<Variable, Object> e:
                evidence2.entrySet() ) {
            System.out.println(e.getKey().getName() +" con el estado "+e.getValue().toString());
        }

    }
}
