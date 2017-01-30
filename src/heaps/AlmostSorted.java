package heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

//Problem 11.3
public class AlmostSorted {
	
	public static List<Integer> sortAlmostSortedArray(List<Integer> input, int k){
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		Iterator<Integer> iter = input.iterator();
		int smallest;
		//Process the almost sorted array
		while(iter.hasNext()){
			if(minHeap.size() < k + 1)
				minHeap.add(iter.next());
			else{
				smallest = minHeap.poll();
				result.add(smallest);
			}
		}
		//Process the remaining elements in the heap
		while(!minHeap.isEmpty()){
			smallest = minHeap.poll();
			result.add(smallest);
		}
		
		return result;
	}

}
