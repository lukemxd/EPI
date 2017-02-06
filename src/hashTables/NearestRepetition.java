package hashTables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem 13.6
public class NearestRepetition {

	public static int findNearestRepetition(List<String> input){
		Map<String, Integer> idxOfStrings = new HashMap<>();
		int nearestRepeatedDistance = 0;
		for(int i = 0; i < input.size(); ++i){
			if(idxOfStrings.containsKey(input.get(i))){
				int currentIdx = idxOfStrings.get(input.get(i));
				nearestRepeatedDistance = Math.min(i - currentIdx, nearestRepeatedDistance);
			}
			idxOfStrings.put(input.get(i), i);
		}
		return nearestRepeatedDistance;
	}
}
