package searching;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Problem 12.0-12.5
public class BinarySearch {
	
	/*****12.0*****/
	public static class Student {
		public String name;
		public double GPA;
		
		public Student(String name, double gpa){
			this.name = name;
			this.GPA = gpa;
		}
	}
	//Customized comparator
	private static final Comparator<Student> compareGPA = new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2){
			if(s1.GPA != s2.GPA){
				return Double.compare(s1.GPA, s2.GPA);	
			}
			return s1.name.compareTo(s2.name);
		}
	};
	
	public static boolean searchStudent(List<Student> students, Student target){
		return Collections.binarySearch(students, target, compareGPA) >= 0;
	}
	/*****12.0*****/
	
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
		return input.get(left);
	}
	
	//12.4
	public static int integerSquareRoot(int k){
		int left = 0, right = k - 1;
		while(left <= right){
			int mid = left + ((right -left) / 2);
			int midSquare = mid * mid;
			if(k >= midSquare)
				left = mid + 1;
			else if(k < midSquare)
				right = mid - 1;
		}
		return (int)left - 1;
	}
	
	//12.5
	private static enum Ordering {SMALLER, EQUAL, LARGER};
	
	private static Ordering compare(double a, double b){
		final double EPSILON = 0.00001;
		double diff = (a - b) / b;
		return diff < -EPSILON ? Ordering.SMALLER 
					: (diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL);
	}
	
	public static double squareRoot(double k){
		double left, right;
		//Determine the lower and upper bound
		if(k < 1.0){
			left = k;
			right = 1.0;
		}
		else{
			left = 1.0;
			right = k;
		}
		
		//while(left <= right){
		while(compare(left, right) == Ordering.SMALLER){
			double mid = left + ((right - left) / 2);
			double midSquare = mid * mid;
			if(compare(midSquare, k) == Ordering.SMALLER)
			//if(midSquare < k)
				left = mid;
			else if(compare(midSquare, k) == Ordering.LARGER)
			//else if(midSquare > k)
			right = mid;
			else {
				return mid;
			}
		}
		return left;
	}

}
