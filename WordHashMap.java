package AssignmentDataStrctrs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 
 * @author CCastro
 * 
 * Description: The implementation of WordList
 * using the Java build-in HashMap methods.
 */
public class WordHashMap extends WordList{
	static HashMap<String, Integer> words = new HashMap<String, Integer>();
	
	/**
	 * Public constructor method WordHashMap
	 */
	public WordHashMap() {
		super();
	}
	
	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	public int findWord(String inWord) {
		
		if (words.containsKey(inWord)) {
			return words.get(inWord);
		}
		return 0;
	}
	
	/**
	 * Public method existsWord
	 * @param inWord String
	 * @return True if inWord exists in WordList, False if it doesn't
	 */
	public boolean existsWord(String inWord) {
		
		if (words.containsKey(inWord)) {
			return true;
		}
		return false;
	}

	/**
	 * Public method addWord
	 * @param inWord String
	 * @return 1 if inWord not found, new inWord count if found
	 */
	public int addWord(String inWord) {
		
		//If word found in hash list, add 1 to the count, else insert  inWord in hashmap
		if(words.containsKey(inWord)) {
			words.replace(inWord, words.get(inWord) + 1);
			super.incTotalAllWords();
		} else {
			words.put(inWord, 1);
			super.incNumUniqueWords();
			super.incTotalAllWords();
			return 1;
		}
		return words.get(inWord);
	}

	/**
	 * Public method incWord
	 * @param inWord String
	 * @return 0 if inWord not found, new inWord count if found
	 */
	public int incWord(String inWord) {
		
		// If inWord is present in HashMap, increase its count
		if(words.containsKey(inWord)) {
			words.replace(inWord, words.get(inWord) + 1);
			super.incTotalAllWords();
			return words.get(inWord);
		}
		return 0;
	}

	/**
	 * Public method printWordList
	 * @param inMinimum int
	 */
	public void printWordList(int inMinimum) {
		System.out.println("DataType: HashMap");
		System.out.println(super.toString());
		
		if (words.size() > 0) {
			Iterator hashIterator = words.entrySet().iterator();  //Create iterator for hash list
			
			//Iterator loop that prints an element if the value present in it is equal or more than inMinimum
			while (hashIterator.hasNext()) {
				Entry n = (Entry)hashIterator.next();
				int count = (int) (n.getValue());
				if (count >= inMinimum) {
					System.out.println(n.getKey() + ":" + count);
				}
			}
		}	
	}
} //END class
