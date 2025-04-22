package AssignmentDataStrctrs;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * WordListMain class
 * @author TMyatt and CCastro
 */
public class WordListMain {
	static WordList wordList;

	/**
	 * static method getVerse
	 * @param inLine String
	 * @return verse
	 */
	static String getVerse(String inLine) {
		String[] ver = inLine.split("\t");
		return ver[1];
	}
	
	/**
	 * static method dataType
	 * @param type
	 */
	static void dataType(String type) {
		
		switch (type) {
		case "A":
		case "a":
			wordList = new WordArrayList();
			break;
		case "L":
		case "l":
			wordList = new WordLinkedList();
			break;
		case "H":
		case "h":
			wordList = new WordHashMap();
			break;
		}
	}
	
	/**
	 * WordList main()
	 * @param args String[]
	 */
	public static void main(String[] args) {
		Instant start = Instant.now();
		try {
			// Open the required text file for sequential read
			Scanner inputFile = new Scanner (new File(args[0]));
			dataType(args[1]);

			// Check for EOF, read the next line, and display it
			while (inputFile.hasNextLine()) {
				String inLine, verse;
				String[] verseParsed;
				
				inLine = inputFile.nextLine();
				verse = getVerse(inLine);
				verseParsed = verse.split("[ :;,.'!?()-]+");
				
				for (String s: verseParsed) {
					wordList.addWord(s.toLowerCase());
				}
			}		
			// Close the required file when EOF is reached
			inputFile.close();
			wordList.printWordList(Integer.parseInt(args[2]));
		} // END try
		catch (Exception e) {
			// All Exceptions come here for graceful termination
			System.out.println("PsalmsReaderMain Error: " + e);
		} // END catch
		Instant stop = Instant.now(); //Timer stops here
		long timeElapsed = Duration.between(start, stop).toMillis(); //The time is converted to milliseconds and then assigned to a variable for output 
		System.out.println("Timer (ms): " + timeElapsed);
	} // END main
} // END class
