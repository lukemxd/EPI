package heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

//Problem 11.0
public class TopK {
	
	public static List<String> findTopK(Iterator<String> items, int k){
		PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
			public int compare(String s1, String s2){
				return Integer.compare(s1.length(), s2.length());
			}
		});
		
		/*while(items.hasNext()){
			minHeap.add(items.next());
			if(minHeap.size() > k){
				//Remove the smallest element
				minHeap.poll();
			}
		}*/
		//Improvement
		while(items.hasNext()){
			if(minHeap.size() < k){
				minHeap.add(items.next());
			}
			else{
				//Compare the next length with the top one's
				String s = minHeap.peek();
				if(s.length() < items.next().length()){
					minHeap.poll();
					minHeap.add(items.next());
				}
			}
		}
		return new ArrayList<>(minHeap);
	}

}
