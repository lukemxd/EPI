package hashTables;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//Problem 13.5
public class TopK {
	
	public static List<String> findKMostUsed(List<String> input, int k){
		Map<String, Integer> numOfStrings = new HashMap<>();
		for(String s : input){
			if(!numOfStrings.containsKey(s))
				numOfStrings.put(s, 1);
			else
				numOfStrings.put(s, numOfStrings.get(s) + 1);
		}
		
		PriorityQueue<Map.Entry<String, Integer>> minHeap = 
				new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
						return Integer.compare(e1.getValue(), e2.getValue());
					}
		});
		
		for(Map.Entry<String, Integer> e : numOfStrings.entrySet()){
			if(minHeap.size() < k)
				minHeap.add(e);
			else{
				Map.Entry<String, Integer> first = minHeap.peek();
				if(e.getValue() > first.getValue()){
					minHeap.poll();
					minHeap.add(e);
				}
			}
		}
		
		List<String> result = new ArrayList<>();
		for(Map.Entry<String, Integer> e : minHeap){
			result.add(e.getKey());
		}
		
		return result;
	}

}
