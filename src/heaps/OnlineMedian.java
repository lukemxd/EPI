package heaps;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

//Problem 11.5
public class OnlineMedian {

	private static final int DEFAULT_INITIAL_CAPACITY =16;
	
	public static double computeMedian(List<Integer> input){
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = 
				new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, Collections.reverseOrder());
		
		Iterator<Integer> iter = input.iterator();
		//Proceed the input sequence
		while(iter.hasNext()){
			int next = iter.next();
			if(minHeap.isEmpty())
				minHeap.add(next);
			else if(next > minHeap.peek())
				minHeap.add(next);
			else {
				maxHeap.add(next);
			}
		}
		//Check the size of two heaps make sure the size difference is not greater than 2
		if(minHeap.size() > maxHeap.size() + 1){
			maxHeap.add(minHeap.poll());
		}else if(maxHeap.size() > minHeap.size())
			minHeap.add(maxHeap.poll());
		
		return maxHeap.size() == minHeap.size() ? 
				0.5 * (maxHeap.peek() + minHeap.peek()) : minHeap.peek();
	}
}
