package ie.gmit.dip;

import java.io.IOException;

/**
 * Runs a threaded application which allows for the user to compare how similar
 * the content of two text files is using cosine distance calculations
 * 
 * @author Darren McCartney
 * @version 1.0
 *
 */

public class Runner {
	private static Menu m = new Menu();

	/**
	 * Prints the menu and calculates the similarity between the two text files
	 * inputed
	 * 
	 * @param args string array of arguments
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
		m.printMenu();
		new Runner().go();
		m.calculatePercentage();
	}

	/**
	 * Threaded run of two tasks
	 * 
	 * @throws Exception
	 */

	public void go() throws Exception {
		Thread t1 = new Thread(new Task(false), "T-1");
		Thread t2 = new Thread(new Task(true), "T-2");

		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}

	private class Task implements Runnable {
		private boolean b;

		public Task(boolean b) {
			this.b = b;
		}

		public void run() {
			try {
				m.parseFile(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
