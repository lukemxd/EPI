package hashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem 13.0
public class BootCamp {
	
	public static List<List<String>> findAnagrams(List<String> input){
		Map<String, List<String>> sortedStringAnagrams = new HashMap<>();
		//Sort the input strings and add to the hash map
		for(String s : input){
			char[] sortedCharArray = s.toCharArray();
			Arrays.sort(sortedCharArray);
			String strKey = new String(sortedCharArray);
			if(!sortedStringAnagrams.containsKey(strKey))
				sortedStringAnagrams.put(strKey, new ArrayList<>());
			sortedStringAnagrams.get(strKey).add(s);
		}
		
		List<List<String>> anagrams = new ArrayList<>();
		for(Map.Entry<String, List<String>> p : sortedStringAnagrams.entrySet()){
			if(p.getValue().size() > 1){
				//Found anagrams
				anagrams.add(p.getValue());
			}
		}
		return anagrams;
	}
	
	

}
