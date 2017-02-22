package binarySearchTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

//Problem 15.6
public class ClosestSortedArrayEntries {
	
	private static class ArrayEntry implements Comparable<ArrayEntry>{
		public int value;
		public int index;
		
		public ArrayEntry(int val, int idx){
			this.value = val;
			this.index = idx;
		}
		
		@Override
		public int compareTo(ArrayEntry ary){
			int result = Integer.compare(this.value, ary.value);
			if(result == 0)
				return Integer.compare(this.index, ary.index);
			return result;
		}
		
		@Override
		public boolean equals(Object obj){
			//Check the type
			if(obj == null || !(obj instanceof ArrayEntry))
				return false;
			//Check if it compares to itself
			if(this == obj)
				return true;
			//Other scenarios
			ArrayEntry ary = (ArrayEntry)obj;
			return this.value == ary.value && this.index == ary.index;
		}
		
		@Override
		public int hashCode(){
			return Objects.hash(this.value, this.index);
		}
	}

	public static int findMinDisSortedArrays(List<List<Integer>> input){
		//Indices into each of the sorted arrays
		List<Integer> headIdxes = new ArrayList<>(input.size());
		for(List<Integer> array : input){
			headIdxes.add(array.size() - array.size());
		}
		
		int result = Integer.MAX_VALUE;
		//Initialize the BST set with the first element from each sorted arrays
		NavigableSet<ArrayEntry> currentHeads = new TreeSet<>();
		for(int i = 0; i < input.size(); ++i){
			currentHeads.add(new ArrayEntry(input.get(i).get(headIdxes.get(i)), i));
		}
		
		while(true){
			result = Math.min(result, currentHeads.last().value - currentHeads.first().value);
			int nextMinIdx = currentHeads.first().index;
			headIdxes.set(nextMinIdx, headIdxes.get(nextMinIdx) + 1);
			//Return result if any of the sorted arrays is empty
			if(input.get(nextMinIdx).size() <= headIdxes.get(nextMinIdx)){
				return result;
			}
			//Remove the smallest and add the next from the array
			//where the removed smallest belongs to
			currentHeads.pollFirst();
			currentHeads.add(
					new ArrayEntry(input.get(nextMinIdx).get(headIdxes.get(nextMinIdx)), nextMinIdx));
		}
	}
}
