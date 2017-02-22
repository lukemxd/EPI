package binarySearchTrees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

//Problem 15.8
public class TopK {
	
	private static SortedSet<Map.Entry<String, Integer>> createBST(List<String> input){
		SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
				int result = Integer.compare(e1.getValue(), e2.getValue());
				if(result == 0)
					return e2.getKey().compareTo(e1.getKey()); 
				return result;
			}
		});
		SortedMap<String, Integer> unsortedMap = new TreeMap<>();
		//Iterate through the input
		for(String s : input){
			if(!unsortedMap.containsKey(s)){
				unsortedMap.put(s, 0);
			}else{
				unsortedMap.put(s, unsortedMap.get(s) + 1);
			}
		}
		//Sort
		sortedSet.addAll(unsortedMap.entrySet());
		return sortedSet;
	}

	public static List<String> findKMostUsed(List<String> input, int k){
		List<String> results = new ArrayList<>(k);
		SortedSet<Map.Entry<String, Integer>> sortedSet = createBST(input);
		while(results.size() < k){
			results.add(sortedSet.last().getKey());
			sortedSet.remove(sortedSet.last());
		}
		return results;
	}
}
