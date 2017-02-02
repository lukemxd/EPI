package searching;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

//Problem 12.6-12.10
public class GeneralizedSearch {
	
	//12.6
	public static boolean matrixSearch(List<List<Integer>> sortedMatrix, Integer target){
		int row = 0, col = sortedMatrix.get(0).size() - 1;
		while(row < sortedMatrix.size() && col >= 0){
			if(sortedMatrix.get(row).get(col) == target)
				return true;
			else if(sortedMatrix.get(row).get(col) > target)
				--col; //Eliminate the column
			else {
				++row; //Eliminate the row
			}
		}
		return false;
	}
	
	
	//12.7
	public static String findMinMax(List<Integer> input){
		int globalMax, globalMin;
		if(input.size() <= 1){
			globalMax = input.get(0);
			globalMin = input.get(0);
		}
		//Initialize the global min and max if size > 1
		if(Integer.compare(input.get(0), input.get(1)) > 0){
			globalMax = input.get(0);
			globalMin = input.get(1);
		}else{
			globalMax = input.get(1);
			globalMin = input.get(0);
		}
		//Make sure if input has odd number of elements it won't cause overflow	
		for(int i = 2; i + 1 < input.size(); i+=2){
			int localMax, localMin;
			if(Integer.compare(input.get(i), input.get(i + 1)) > 0){
				localMax = input.get(i);
				localMin = input.get(i + 1);
			}else{
				localMax = input.get(i + 1);
				localMin = input.get(i);
			}
			globalMax = Math.max(globalMax, localMax);
			globalMin = Math.min(globalMin, localMin);
		}
		//If odd number of elements
		if(input.size() % 2 != 0){
			globalMax = Math.max(globalMax, input.get(input.size() - 1));
			globalMin = Math.min(globalMin, input.get(input.size() - 1));	
		}
		return "The max is " + globalMax + ", min is " + globalMin;
	}
	
	
	//12.8
	public static int findKLargest(List<Integer> input, int k){
		int left = 0, right = input.size() - 1;
		Random r = new Random(0);
		while (left <= right) {
			int pivotIdx = r.nextInt(right - left + 1) + left;
			//Partition
			int newPivotIdx = partition(input, left, right, pivotIdx);
			/*if(newPivotIdx == k - 1)
				return input.get(newPivotIdx);
			else if(newPivotIdx < k - 1)
				left = newPivotIdx + 1;
			else
				right = newPivotIdx - 1;*/
			if(newPivotIdx == input.size() - k)
				return input.get(newPivotIdx);
			else if(newPivotIdx < input.size() - k)
				left = newPivotIdx + 1;
			else
				right = newPivotIdx - 1;
		}
		return -1;
	}
	
	private static int partition(List<Integer> input, int left, int right, int pivotIdx){
		int pivotValue = input.get(pivotIdx);
		int newPivotIdx = left;
		//Move the pivot to the right
		Collections.swap(input, pivotIdx, right);
		for(int i = left; i < right; ++i){
			//After partitioning, [larger, pivot, smaller]
			//if(input.get(i) > pivotValue){
			//	Collections.swap(input, i, newPivotIdx++);
			//}
			//After partitioning, [smaller, pivot, larger]
			if(input.get(i) <= pivotValue){
				Collections.swap(input, i, newPivotIdx++);
			}
		}
		Collections.swap(input, right, newPivotIdx);
		return newPivotIdx;
	}
	
	//Variant 3
	public static class building{
		public Integer numOfResidence;
		public Integer distance;
		
		public building(Integer num, Integer dis){
			this.numOfResidence = num;
			this.distance = dis;
		}
	}

	private static int totalDistance(List<building> buildings, int k){
		int totalDis = 0;
		for(int i = 0; i < buildings.size(); ++i){
			totalDis += buildings.get(i).numOfResidence * Math.abs(buildings.get(i).distance - k);
		}
		return totalDis;
	}
	
	public static int findMinMailbox(List<building> buildings){
		//Calculate all the candidates of total distance
		Hashtable<Integer, Integer> totalDistances = new Hashtable<>();
		//k - The distance from the mailbox to the start of the street
		for(int k = 0; k < buildings.size() - 1; ++k){
			totalDistances.put(totalDistance(buildings, k), k);
		}
		//Form a list by the distance
		List<Integer> distances = new ArrayList<>();
		Set<Integer> keys = totalDistances.keySet();
		for(Integer key : keys){
			distances.add(key);
		}
		//Call 12.8 to get the smallest element
		int smallest = findKLargest(distances, buildings.size());
		return totalDistances.get(smallest);
	}
	
	
	//12.9
	private static final int NUM_BUCKET = 1 << 16;
	
	public static int findMissingIP(Iterable<Integer> sequence){
		int[] counter = new int[NUM_BUCKET];
		Iterator<Integer> iter = sequence.iterator();
		//Count the number of entries for each 2^16 MSB 
		while(iter.hasNext()){
			int x = iter.next() >>> 16;
			++counter[x];
		}
		
		for(int i = 0; i < counter.length; ++i){
			//Look for a bucket that has a value smaller than 2^16
			//Meaning there is missing IPs start with this MSB
			if(counter[i] < NUM_BUCKET){
				BitSet bitVec = new BitSet(NUM_BUCKET);
				iter = sequence.iterator();
				while(iter.hasNext()){
					int x = iter.next();
					//Store the LSB if the MSB matches
					if(i == x >>> 16){
						bitVec.set((NUM_BUCKET - 1) & x); //Gets the 2^16 bits LSB
					}
				}
				//Check from 0-2^16 in bitVec, if false then missing one found
				for(int j = 0; j < (1 << 16); ++j){
					if(!bitVec.get(j))
						return (i << 16) | j;
				}
			}
		}
		return -1; //No missing IP is found
	}
	
	
	//12.10
	public static String findDuplicateAndMissing(List<Integer> input){
		int duplicate = 0, missing = 0;
		int[] counter = new int[input.size()];
		Iterator<Integer> iter = input.iterator();
		while(iter.hasNext()){
			int x = iter.next();
			if(counter[x] == 1)
				//Finds the duplicate
				duplicate = x;
			else
				++counter[x];
		}
		//Finds the missing
		iter = input.iterator();
		while(iter.hasNext()){
			int y = iter.next();
			if(counter[y] == 0)
				missing = y;
		}
		return "The duplicate is " + duplicate + " and the missing is " + missing;
	}
	
}
