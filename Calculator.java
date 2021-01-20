package ie.gmit.dip;

import java.util.*;

/**
 * Uses cosine distance to calculate the similarity between two separate maps
 * and returns a double between 0 and 1
 * 
 * @author Darren McCartney
 * @version 1.0
 *
 */

public class Calculator {

	/**
	 * Takes two separate maps of Integer keys and values and returns a double
	 * between 0 and 1. This value represents the cosine distance between the two
	 * maps.
	 * 
	 * @param m1 one map to be compared using cosine distance
	 * @param m2 other map for cosine distance comparison
	 * @return a double which represents cosine distance
	 */

	public double getSimilarity(Map<Integer, Integer> m1, Map<Integer, Integer> m2) {
		Collection<Integer> m1Frequencies = m1.values();
		double m1Total = 0;
		for (Integer f : m1Frequencies) {
			m1Total += Math.pow(f, 2);
		}

		Collection<Integer> m2Frequencies = m2.values();
		double m2Total = 0;
		for (Integer f : m2Frequencies) {
			m2Total += Math.pow(f, 2);
		}

		double dotProduct = 0;
		HashSet<Integer> intersection = new HashSet<>(m1.keySet());
		intersection.retainAll(m2.keySet());

		for (Integer i : intersection) {
			dotProduct += m1.get(i) * m2.get(i);
		}

		double cosDistance = (dotProduct / Math.sqrt(m1Total * m2Total));
		return cosDistance;
	}
}
