package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//Problem 14.2, 14.5, 14.6
public class MergeSorting {
	
	//14.2
	public static void mergeSortedArray(List<Integer> A, List<Integer> B, int n){
		//n is the non-zero number of elements in A
		int m = B.size() - 1, writeIdx = A.size() - 1;
		while(m >= 0 && n >= 0){
			A.set(writeIdx--, A.get(n) > B.get(m) ? A.get(n--) : B.get(m--));
		}
		//Check if B is not empty
		while(m >= 0){
			A.set(writeIdx--, B.get(m--));
		}
	}
	
	
	//14.5
	public static class Interval{
		public int left, right;
		
		public Interval(int l, int r){
			this.left = l;
			this.right = r;
		}
	}
	
	public static List<Interval> mergeIntervals(List<Interval> intervals, Interval target){
		int i = 0;
		List<Interval> result = new ArrayList<>();
		//Processes the intervals come before the target
		while(i < intervals.size() && target.left > intervals.get(i).right){
			result.add(intervals.get(i++));
		}
		//Processes the intervals which intersect with the target
		while(i < intervals.size() && target.right >= intervals.get(i).left){
			target = new Interval(Math.min(target.left, intervals.get(i).left), 
					Math.max(target.right, intervals.get(i).right));
			++i;
		}
		result.add(target);
		//Processes the intervals come after the target
		result.addAll(intervals.subList(i, intervals.size()));
		return result;
	}
	
	
	//14.6
	public static class IntervalWithClosed implements Comparable<IntervalWithClosed>{
		public Endpoint left, right; 

		public IntervalWithClosed(Endpoint l, Endpoint r){
			this.left = l;
			this.right = r;
		}
		
		public static class Endpoint{
			public boolean isClosed;
			public int value;
			
			public Endpoint(boolean is, int val){
				this.isClosed = is;
				this.value = val;
			}
		}
		
		public int compareTo(IntervalWithClosed i){
			if(Integer.compare(this.left.value, i.left.value) != 0)
				return this.left.value - i.left.value; 
			
			//If left points are equal, closed one should come first
			return this.left.isClosed && !i.left.isClosed ? 
					-1 : !this.left.isClosed && i.left.isClosed ? 1 : 0;
		}
		
		@Override
		public boolean equals(Object obj){
			if(obj == null || !(obj instanceof IntervalWithClosed))
				return false;
			if(this == obj)
				return true;
			IntervalWithClosed that = (IntervalWithClosed)obj;
			return this.left.value == that.left.value && this.left.isClosed == that.left.isClosed;
		}
		
		@Override
		public int hashCode(){
			return Objects.hash(this.left.value, this.left.isClosed);
		}
	}
	
	public static List<IntervalWithClosed> unionOfInterVals(List<IntervalWithClosed> interVals){
		//Return empty list if empty input
		if(interVals.isEmpty())
			return Collections.emptyList();
		//Sort the input
		Collections.sort(interVals);
		List<IntervalWithClosed> result = new ArrayList<>();
		IntervalWithClosed current = interVals.get(0);
		for(int i = 0; i < interVals.size(); ++i){
			//Union the intervals
			if(interVals.get(i).left.value < current.right.value
					|| (interVals.get(i).left.value == current.right.value && 
					(interVals.get(i).left.isClosed || current.right.isClosed))){
				//Update the right value
				if(interVals.get(i).right.value > current.right.value
						|| (interVals.get(i).right.value == current.right.value &&
						interVals.get(i).right.isClosed))
					current.right = interVals.get(i).right;
			}else{
				//Add current to the result
				result.add(current);
				current = interVals.get(i);
			}
		}
		//Check for last interval
		if(current != null)
			result.add(current);
		return result;
	}
}
