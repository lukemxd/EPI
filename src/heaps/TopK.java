package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

//Problem 11.0, 11.4, 11.6
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
	
	//11.6
	public static class HeapEntry {
		public Integer index;
		public Integer value;
		
		public HeapEntry(Integer idx, Integer value){
			this.index = idx;
			this.value = value;
		}
	}
	
	private static class Compare implements Comparator<HeapEntry> {
		@Override
		public int compare(HeapEntry he1, HeapEntry he2){
			return Integer.compare(he2.value, he1.value);
		}
		
		public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
	}
	
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public static List<Integer> findKLargestEntries(List<Integer> input, int k){
		if(k <= 0)
			return Collections.emptyList();
		
		List<Integer> result = new ArrayList<>();
		PriorityQueue<HeapEntry> candidatesMaxHeap = 
				new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, Compare.COMPARE_HEAP_ENTRIES);
		//Add the root 
		candidatesMaxHeap.add(new HeapEntry(0, input.get(0)));
		for(int i = 0; i < k; ++i){
			int candidateIdx = candidatesMaxHeap.peek().index;
			result.add(candidatesMaxHeap.poll().value);
			//Calculate the left child index
			int leftChildIdx = 2 * candidateIdx + 1;
			if(leftChildIdx < input.size())
				candidatesMaxHeap.add(new HeapEntry(leftChildIdx, input.get(leftChildIdx)));
			//Calculate the right child index
			int rightChildIdx = 2 * candidateIdx + 2;
			if(rightChildIdx < input.size())
				candidatesMaxHeap.add(new HeapEntry(rightChildIdx, input.get(rightChildIdx)));
		}
		
		return result;
	}

}
