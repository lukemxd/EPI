package hashTables;

import java.util.HashMap;
import java.util.Map;

//Problem 13.1,13.2
public class CharacterNumCompare {
	
	//13.1
	public static boolean isPalindromic(String s){
		Map<Character, Integer> numOfChars = new HashMap<>();
		char[] strArray = s.toCharArray();
		//Count the number of each char in s
		for(Character c : strArray){
			if(!numOfChars.containsKey(c)){
				numOfChars.put(c, 1);
			}else
				numOfChars.put(c, numOfChars.get(c) + 1);
		}
		//Odd count is at most 1
		int oddCount = 0;
		for(Map.Entry<Character, Integer> p : numOfChars.entrySet()){
			if(p.getValue() % 2 != 0 && ++oddCount > 1)
				return false;
		}
		
		return true;
	}
	
	//13.2
	public static boolean isLetterContructibleMagzine(String letter, String Magazine){
		Map<Character, Integer> numOfLetterChars = new HashMap<>();
		char[] charLetter = letter.toCharArray();
		char[] charMag = Magazine.toCharArray();
		//Count the number of letter
		for(char c : charLetter){
			if(!numOfLetterChars.containsKey(c)){
				numOfLetterChars.put(c, 1);
			}else
				numOfLetterChars.put(c, numOfLetterChars.get(c) + 1);
		}
		//Check appear times of char of magazine in letter
		for(char c : charMag){
			if(numOfLetterChars.containsKey(c)){
				numOfLetterChars.put(c, numOfLetterChars.get(c) - 1);
				if(numOfLetterChars.get(c) == 0)
					numOfLetterChars.remove(c);
				if(numOfLetterChars.isEmpty())
					break;
			}
		}
		//If numOFLetterChars is empty then true
		return numOfLetterChars.isEmpty();
	}
}
