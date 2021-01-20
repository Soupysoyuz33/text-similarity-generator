package ie.gmit.dip;

import java.io.IOException;
import java.util.*;
import java.text.DecimalFormat;

/**
 * Creates a menu for an application that compares two text files which are
 * provided in the form of file paths by the user. Prompts user to input a path
 * for both a subject and a query text file and has methods for parsing the text
 * (Parser class) and calculating the similarity by cosine distance (Calculator
 * class).
 * 
 * @author Darren McCartney
 * @version 1.0
 * @see Calculator
 * @see Parser
 * 
 */

public class Menu {
	private Scanner s;
	private String subjectFile;
	private String queryFile;
	private Parser p;
	private Calculator c;
	private static DecimalFormat df = new DecimalFormat("#.##");
	private Map<Integer, Integer> subject = new HashMap<>();
	private Map<Integer, Integer> query = new HashMap<>();

	/**
	 * Prints a basic text based UI, prompts input from the user for text file paths
	 * and stores paths
	 */

	public void printMenu() {
		System.out.println("*********** Text Comparison Application ***********");
		System.out.println("Enter Query File Path> ");
		s = new Scanner(System.in);
		queryFile = s.nextLine();
		System.out.println("Enter Subject File Path> ");
		subjectFile = s.nextLine();
		System.out.println("Processing... Please Wait...");
	}

	/**
	 * Parses the files depending on whether they are subject or query file
	 * 
	 * @param isSubjectFile boolean to determine if the file is the subject or query
	 *                      file
	 * @throws IOException
	 */

	public void parseFile(boolean isSubjectFile) throws IOException {
		p = new Parser();
		if (isSubjectFile) {
			subject = p.getMap(subjectFile);
		} else {
			query = p.getMap(queryFile);
		}
	}

	/**
	 * Calculates the similarity between the two files and prints it as a percentage
	 * to two decimal places
	 */

	public void calculatePercentage() {
		c = new Calculator();
		double result = (c.getSimilarity(subject, query) * 100);
		System.out.println("---------------------------------------------------");
		System.out.println("Percentage Similarity is " + df.format(result) + "%");
		System.out.println("---------------------------------------------------");
	}
}
