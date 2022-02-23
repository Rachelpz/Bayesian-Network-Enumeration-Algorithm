package util;

import Bayes_Net.Evidence;
import Bayes_Net.Variable;


public class common {




	public static String convert(String s) {
		s = s.toUpperCase();
		if (s.startsWith("-"))
			return s.substring(1) + "=F";
		else
			return s + "=T";
	}
	

	public static String parseQuery(String query) {
		String[] q = query.split("\\(")[1].split("\\)")[0].split("\\|");

		String ret = common.convert(q[0]) + " | ";

		if (q.length > 1) {
			String[] evidences = q[1].split(",");
			for (int i = 0; i < evidences.length; i++)
				ret += common.convert(evidences[i]) + ", ";
			if (evidences.length > 0)
				ret = ret.substring(0, ret.length() - 2);
		}
		return ret;
	}



	public static Evidence parseEvidence(String[] args) {
		Evidence evidence = new Evidence();
		Variable v = null;
		boolean val = true;
		for(int i = 0; i < args.length; i++) {
			if(val) {
				v = new Variable(args[i]);
			} else {
				evidence.put(v, args[i]);
			}
			val = !val;
		}
		return evidence;
	}
}
