package AssignmentDataStrctrs;

import java.util.*;

/**
 * WordCountNode class - The data portion of the linked list
 */
class WordCountNode {
	String word;
	int count;
	
	/**
	 * WordCountNode constructor
	 * @param inWord
	 */
	public WordCountNode(String inWord) {
		word = inWord;
		count = 1;
	}	
	
	/**
	 * @return the object word datum
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * @return the object count datum
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the object count auto-incremented
	 */
	public int incrementCount() {
		count++;
		return count;
	}
}

/**
 * 
 * @author CCastro
 * 
 * Description: The implementation of WordList
 * using the Java build-in LinkedList methods.
 */
public class WordLinkedList extends WordList {
	static java.util.LinkedList<WordCountNode> words = new java.util.LinkedList<WordCountNode>();
	
	/**
	 * Public constructor method WordLinkedList
	 */
	public WordLinkedList() {
		super();
	}

	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	public int findWord(String inWord) {
		
		// Create an iterator for the 'while' iteration
		ListIterator<WordCountNode> listIte = words.listIterator();
		
		while (listIte.hasNext()) {
			
			// temp - Temporary value that represents the next object in the list
			WordCountNode temp = (WordCountNode) listIte.next(); 
			if (inWord.compareTo(temp.getWord()) == 0) {
				return temp.getCount();
			}
		}
		return 0;
	}

	/**
	 * Public method existsWord
	 * @param inWord String
	 * @return True if inWord exists in WordList, False if it doesn't
	 */
	public boolean existsWord(String inWord) {
		boolean foundWord = false;
		
		// Create an iterator for the 'while' iteration
		ListIterator<WordCountNode> listIte = words.listIterator();
		while (listIte.hasNext()) {
			
			// Temporary value that represents the next object in the list
			WordCountNode temp = (WordCountNode) listIte.next();
			if (inWord.compareTo(temp.getWord()) == 0) {
				foundWord = true;
				break;
			}
		}
		return foundWord;
	}

	/**
	 * Public method addWord
	 * @param inWord String
	 * @return 1 if inWord not found, new inWord count if found
	 */
	public int addWord(String inWord) {
		boolean foundWord = false;
		
		// Create an iterator for the 'while' iteration
		ListIterator<WordCountNode> listIte = words.listIterator();
		while (listIte.hasNext()) {
			
			// Temporary value that represents the next object in the list
			WordCountNode temp = (WordCountNode) listIte.next();
			if (inWord.compareTo(temp.getWord()) == 0) {
				foundWord = true;
				temp.incrementCount();
				super.incTotalAllWords();
				return temp.getCount();
			}
		}
		
		if(!foundWord) {
			words.add(new WordCountNode(inWord));
			super.incNumUniqueWords();
			super.incTotalAllWords();
			return 1;
		}
		return 0;
	}

	/**
	 * Public method incWord
	 * @param inWord String
	 * @return 0 if inWord not found, new inWord count if found
	 */
	public int incWord(String inWord) {
		
		// Create an iterator for the 'while' iteration
		ListIterator<WordCountNode> listIte = words.listIterator();
		
		while (listIte.hasNext()) {
			
			// temp - Temporary value that represents the next object in the list
			WordCountNode temp = (WordCountNode) listIte.next(); 
			if (inWord.compareTo(temp.getWord()) == 0) {
				temp.incrementCount();
				super.incTotalAllWords();
				return temp.getCount();
			}
		}
		return 0;
	}

	/**
	 * Public method printWordList
	 * @param inMinimum int
	 */
	public void printWordList(int inMinimum) {
		System.out.println("DataType: LinkedList");
		System.out.println(super.toString());
		
		// For loop that parses all the elements of the linked list and prints only the ones with a count of >= inMinimum
		for (int i = 0; i < words.size(); i++) {
			WordCountNode asd = words.get(i);
			if (asd.getCount() >= inMinimum) {
				System.out.println(asd.getWord() + ":" + asd.getCount());
			}
		}
	}

	/**
	 * Public string method toString
	 * @return A string with Unique Words and Total Word Count
	 */
	public String toString() {
		return super.toString();
	}

} // END class
