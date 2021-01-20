package ie.gmit.dip;

import java.io.*;
import java.util.*;

/**
 * Takes a file as input and produces map of values from the text content of the
 * file
 * 
 * @author Darren McCartney
 * @version 1.0
 *
 */

public class Parser {
	private Map<Integer, Integer> textMap = new HashMap<>();

	/**
	 * Creates a map of Integers from the text in a text file by creating a hashcode
	 * of each word and mapping that to frequency of its occurrence within the text
	 * 
	 * @param file a string of the file path
	 * @return a map of hashcode (key) to frequency (value) of words in input text
	 * @throws IOException
	 */

	public Map<Integer, Integer> getMap(String file) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] words = line.split(" ");
				for (String word : words) {
					int hashcode = word.hashCode();
					int frequency = 1;
					if (textMap.containsKey(hashcode)) {
						frequency += textMap.get(hashcode);
					}
					textMap.put(hashcode, frequency);
				}
			}
		}
		return textMap;
	}
}
