package searching;

import java.util.List;

//Problem 12.1-12.3
public class ArraySearch {
	
	//12.1
	public static int findFirstOccurence(List<Integer> input, Integer target){
		int left = 0, right = input.size() - 1, result = -1;
		while(left <= right){
			int mid = left + ((right - left) / 2);
			if(input.get(mid) > target)
				right = mid - 1;
			else if(input.get(mid) < target)
				left = mid + 1;
			else{
				result = mid;
				right = mid - 1;	
			}
		}
		return result;
	}
	
	//Variant 1
	public static int findFirstGreaterOccurence(List<Integer> input, Integer target){
		int left = 0, right = input.size() - 1, result = -1;
		while(left <= right){
			int mid = left + ((right - left) / 2);
			if(input.get(mid) > target)
				right = mid - 1;
			else if(input.get(mid) < target)
				left = mid + 1;
			else{
				result = mid;
				left = mid + 1;	
			}
		}
		return result + 1;
	}
	
	
	//12.2
	public static int searchEqualIndexElement(List<Integer> input){
		int left = 0, right = input.size() - 1, result = -1;
		while(left <= right){
			int mid = left + ((right - left) / 2);
			if(input.get(mid) > mid)
				right = mid - 1;
			else if(input.get(mid) < mid)
				left = mid + 1;
			else{
				result = mid;
			}
		}
		return result + 1;	
	}
	
	//Variant
	public static int searchEqualIndexElement(List<Integer> input, int left, int right){
		int result = -1;
		if(left <= right){
			int mid = left + ((right - left) / 2);
			if(input.get(mid) == mid)
				result = mid;
			else{
				int leftResult = searchEqualIndexElement(input, left, mid - 1);
				if(leftResult != -1)
					result = leftResult;
				int rightResult = searchEqualIndexElement(input, mid + 1, right);
				if(rightResult != -1)
					result = rightResult;
			}
		}
		return result;
	}
	
	
	//12.3
	public static int searchCyclicSmallest(List<Integer> input){
		int left = 0, right = input.size() - 1; 
		while(left < right){
			int mid = left + ((right - left) / 2);
			if(input.get(mid) > input.get(right))
				left = mid + 1;
			else{
				right = mid;
			}
		}
		return left;
	}

}
