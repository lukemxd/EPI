package heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Problem 11.1
public class MergeFiles {
	
	public static class ArrayEntry {
		public Integer arrayId;
		public Integer value; 
		
		public ArrayEntry(int id, int value){
			this.arrayId = id;
			this.value = value;
		}
	}
	
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays){
		List<Integer> result = new ArrayList<>();
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, new Comparator<ArrayEntry>() {
			public int compare(ArrayEntry a1, ArrayEntry a2){
				return Integer.compare(a1.value, a2.value);
			}
		});
		//Initialize the min-heap and the node counter list
		List<Integer> numOfNodes = new ArrayList<>(arrays.size());
		for(int i = 0; i < arrays.size(); ++i){
			if(arrays.get(i).size() > 0){
				minHeap.add(new ArrayEntry(i, arrays.get(i).get(0)));
				numOfNodes.set(i, 1);	
			}else
				numOfNodes.set(i, 0);
		}
		
		ArrayEntry head;
		List<Integer> smallestHeadArray;
		while((head = minHeap.poll()) != null){
			smallestHeadArray = arrays.get(head.arrayId);
			//Check if the corresponding array in the nodes counter array has the smaller size than the input array
			if(numOfNodes.get(head.arrayId) < smallestHeadArray.size()){
				minHeap.add(new ArrayEntry(head.arrayId, smallestHeadArray.get(numOfNodes.get(head.arrayId))));
				numOfNodes.set(head.arrayId, numOfNodes.get(head.arrayId) + 1);
			}
			result.add(head.value);
		}
		return result;
	}

}
