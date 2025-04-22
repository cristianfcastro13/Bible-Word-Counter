package AssignmentDataStrctrs;
import java.util.ArrayList;

/**
 * 
 * @author TMyatt
 * 
 * Description: The implementation of WordList
 * using the Java build-in ArrayList dynamic arrays.
 */
public class WordArrayList extends WordList {
	static ArrayList<String> words = new ArrayList<String>();
	static ArrayList<Integer> count = new ArrayList<Integer>();
	static int lastIndex = 0;
	
	/**
	 * Public constructor method WordArrayList
	 */
	public WordArrayList() {
		super();
		lastIndex = 0;
	}
	
	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	public int findWord(String inWord) {
		boolean foundWord = false;
		int index = 0;

		for (index = 0; index < lastIndex; index++) {
			if (inWord.compareTo(words.get(index)) == 0) {
				foundWord = true;
				break;
			}
		}
		if (foundWord) {
			return count.get(index);
		} else {
			return 0;
		}
	}
	
	/**
	 * Public method existsWord
	 * @param inWord String
	 * @return True if inWord exists in WordList
	 */
	public boolean existsWord(String inWord) {
		if (findWord(inWord) == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Public method addWord
	 * @param inWord String
	 * @return 1 if inWord not found, new inWord count if found
	 */
	public int addWord(String inWord) {
		boolean foundWord = false;
		int index = 0;

		for (index = 0; index < lastIndex; index++) {
			if (inWord.compareTo(words.get(index)) == 0) {
				foundWord = true;
				break;
			}
		}
		if (foundWord) {
			super.incTotalAllWords();
			count.set(index, count.get(index)+1);
		} else {
			super.incNumUniqueWords();
			super.incTotalAllWords();
			index = lastIndex;
			words.add(index, String.valueOf(inWord));
			count.add(index, 1);
			lastIndex += 1;
		}
		return count.get(index);
	}
	
	/**
	 * Public method incWord
	 * @param inWord String
	 * @return 0 if inWord not found, new inWord count if found
	 */
	public int incWord(String inWord) {
		boolean foundWord = false;
		int index = 0;

		for (index = 0; index < lastIndex; index++) {
			if (inWord.compareTo(words.get(index)) == 0) {
				foundWord = true;
				break;
			}
		}
		if (foundWord) {
			super.incTotalAllWords();
			count.set(index, count.get(index)+1);
			return count.get(index);
		} else {
			return 0;
		}
	}
	
	/**
	 * Public method printWordList
	 * @param inMinimum int
	 */
	public void printWordList(int inMinimum) {
		System.out.println("DataType: ArrayList");
		System.out.println(super.toString());
		for (int i = 0; i < lastIndex; i++) {
			if (count.get(i) >= inMinimum) {
				System.out.println(words.get(i) + 
						":"+ count.get(i));
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
}
