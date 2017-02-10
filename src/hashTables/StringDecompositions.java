package hashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem 13.12
public class StringDecompositions {
	
	private static boolean isSubStringMatched(Map<String, Integer> dict, String sentence, int startIdx, int size){
		Map<String, Integer> tempDict = new HashMap<>();
		for(int i = startIdx; i + size < sentence.length(); i += size){
			String subStr = sentence.substring(i, i + size);
			Integer num = dict.get(subStr);
			if(num == null)
				return false;
			else{
				tempDict.put(subStr, tempDict.containsKey(subStr) ? tempDict.get(subStr) + 1 : 0);
				//Sub string occurs more times than expected
				if(tempDict.get(subStr) > num){
					return false;
				}
			}
		}
		return true;
	}
	
	public static List<Integer> findAllStringConcatenations(String sentence, List<String> sub){
		Map<String, Integer> dict = new HashMap<>();
		for(String str : sub){
			dict.put(str, dict.containsKey(str) ? dict.get(str) + 1 : 0);
		}
		
		int subSize = sub.get(0).length(); //Substring length
		List<Integer> results = new ArrayList<>();
		for(int i = 0; i + sub.size() * subSize <= sentence.length(); ++i){
			if(isSubStringMatched(dict, sentence, i, subSize)){
				results.add(i);
			}	
		}
		return results;
	}
}
