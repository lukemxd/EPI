package hashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Problem 13.7 - 13.10
public class SmallestSubarray {
	
	public static class SubArray{
		public Integer startIdx;
		public Integer endIdx;
		
		public SubArray(Integer sIdx, Integer eIdx){
			this.startIdx = sIdx;
			this.endIdx = eIdx;
		}
	}
	
	//Return the first entry key
	private static String getFirstEntryKey(LinkedHashMap<String, Integer> idxSubStrs){
		String result = null;
		for(Map.Entry<String, Integer> e : idxSubStrs.entrySet()){
			result = e.getKey();
			break;
		}
		return result;
	}
	
	//Return the first entry value
	private static Integer getFirstEntryValue(LinkedHashMap<String, Integer> idxSubStrs){
		Integer result = null;
		for(Map.Entry<String, Integer> e : idxSubStrs.entrySet()){
			result = e.getValue();
			break;
		}
		return result;
	}
	
	//13.7
	public static SubArray findSmallestSubarray(List<String> text, List<String> sub){
		LinkedHashMap<String, Integer> idxSubStrs = new LinkedHashMap<>();
		//Initial the linked hash map
		for(String s : sub){
			idxSubStrs.put(s, null);
		}
		
		int idx = 0; //current index
		int numOfSubStrsCovered = 0;
		SubArray result = new SubArray(-1, -1);
		for(String s : text){
			if(idxSubStrs.containsKey(s)){
				Integer lastestOccurence = idxSubStrs.get(s);	
				if(lastestOccurence == null){
					//First occurrence
					++numOfSubStrsCovered;
				}
				//Reinsert won't affect the order so need to remove first then insert again
				idxSubStrs.remove(s);
				idxSubStrs.put(s, idx);
			}
			Integer newStartIdx = getFirstEntryValue(idxSubStrs);
			if(numOfSubStrsCovered == sub.size()){
				if((result.startIdx == -1 && result.endIdx == -1) || 
						idx - newStartIdx.intValue() < result.endIdx - result.startIdx){
					result.startIdx = newStartIdx.intValue();
					result.endIdx = idx;
				}
			}
			++idx;
		}
		return result;
	}

	//Variant 5
	public static SubArray findLongestDistinctSubarray(List<String> text){
		LinkedHashMap<String, Integer> dict = new LinkedHashMap<>();
		int numOfDistinctStr = 0, longest = 0;
		SubArray result = new SubArray(-1, -1);
		for(int i = 0; i < text.size(); ++i){
			if(!dict.containsKey(text.get(i))){
				dict.put(text.get(i), i);
				++numOfDistinctStr;
			}else{
				if(i - dict.get(text.get(i)) >= numOfDistinctStr){
					dict.remove(text.get(i));
					dict.put(text.get(i), i);
				}else{
					//Compare and update the current longest length
					if(longest < numOfDistinctStr){
						longest = numOfDistinctStr;
						result.startIdx = getFirstEntryValue(dict);
						result.endIdx = i - 1;	
					}
					//Remove all the key before the duplicate key
					while(true){
						String key = getFirstEntryKey(dict);
						String s = text.get(i);
						if(!key.equals(s)){
							dict.remove(key);
							--numOfDistinctStr;
						}else{
							dict.remove(key);
							dict.put(s, i);
							break;
						}
					}
				}
			}
		}
		//Check the longest
		if(longest < numOfDistinctStr){
			result.startIdx = getFirstEntryValue(dict);
			result.endIdx = text.size() - 1;
		}
		return result;
	}

	
	//13.8
	public static SubArray findSmallestSubarrayWithOrder(List<String> text, List<String> sub){
		//Keyword index in the keyword array
		Map<String, Integer> keywordToIdx = new HashMap<>(sub.size());
		//Latest occurrence of each keyword
		List<Integer> latestoccurrence = new ArrayList<>(sub.size());
		//Shortest subarray length ending at the keyword index
		List<Integer> shortestSubarrayLength = new ArrayList<>(sub.size());
		
		//Initialization
		for(int i = 0; i < sub.size(); ++i){
			keywordToIdx.put(sub.get(i), i);
			latestoccurrence.add(-1);
			shortestSubarrayLength.add(Integer.MAX_VALUE);
		}
		
		int shortestDistance = Integer.MAX_VALUE;
		SubArray result = new SubArray(-1, -1);
		for(int i = 0; i < text.size(); ++i){
			Integer subIdx = keywordToIdx.get(text.get(i));
			//Check if subIdx exists in keywordToIdx
			if(subIdx != null){
				if(subIdx == 0){
					//First sub word
					shortestSubarrayLength.set(0, 1);
				}
				//Check the order make the previous one has been traversed
				else if(shortestSubarrayLength.get(subIdx - 1) != Integer.MAX_VALUE){ 
					int disToPreSub = i - latestoccurrence.get(subIdx - 1);
					shortestSubarrayLength.set(subIdx, 
							disToPreSub + shortestSubarrayLength.get(subIdx - 1));
				}
				latestoccurrence.set(subIdx, i);
				
				//Last word
				if(subIdx == sub.size() - 1 && 
						shortestSubarrayLength.get(sub.size() - 1) < shortestDistance){
					shortestDistance = shortestSubarrayLength.get(sub.size() - 1);
					result.startIdx = i - shortestSubarrayLength.get(sub.size() - 1) + 1;
					result.endIdx = i;
				}
			}
		}
		return result;
	}

	//13.9
	public static int findLengthOfLongestSubarray(List<String> text){
		Map<String, Integer> latestOccurrence = new HashMap<>();
		int result = 0, currentLongestSubStartIdx = 0;
		for(int i = 0; i < text.size(); ++i){
			//Return the previous value associated with the key
			Integer dupIdx = latestOccurrence.put(text.get(i), i);
			if(dupIdx != null){
				if(dupIdx >= currentLongestSubStartIdx){
					result = Math.max(result, i - currentLongestSubStartIdx);
					currentLongestSubStartIdx = dupIdx + 1;
				}
			}
		}
		//Check for last string
		result = Math.max(result, text.size() - currentLongestSubStartIdx);
		return result;
	}
	
	//13.10
	public static int findLongestInterval(List<Integer> input){
		Set<Integer> entries = new HashSet<>(input);
		int longestInterval = 0;
		while(!entries.isEmpty()){
			Integer entry = entries.iterator().next();
			entries.remove(entry);
			//Check the existence of adjacent numbers of entry
			int lowerBound = entry - 1;
			while(entries.contains(lowerBound)){
				entries.remove(lowerBound);
				--lowerBound;
			}
			int upperBound = entry + 1;
			while(entries.contains(upperBound)){
				entries.remove(upperBound);
				--upperBound;
			}
			longestInterval = Math.max(longestInterval, upperBound - lowerBound + 1);
		}
		return longestInterval;
	}
}
