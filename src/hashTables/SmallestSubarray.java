package hashTables;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//Problem 13.7
public class SmallestSubarray {
	
	public static class SubArray{
		public Integer startIdx;
		public Integer endIdx;
		
		public SubArray(Integer sIdx, Integer eIdx){
			this.startIdx = sIdx;
			this.endIdx = eIdx;
		}
	}
	
	//Always return the first entry
	private static Integer getFirstEntry(LinkedHashMap<String, Integer> idxSubStrs){
		Integer result = null;
		for(Map.Entry<String, Integer> e : idxSubStrs.entrySet()){
			result = e.getValue();
			break;
		}
		return result;
	}
	
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
			Integer newStartIdx = getFirstEntry(idxSubStrs);
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
}
