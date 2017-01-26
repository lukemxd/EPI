package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Problem 6.15
public class NonuniformNumbers {
	
	public static int generateNonuniformNumber(List<Integer> numbers, List<Double> probabilities){
		List<Double> endpoints = new ArrayList<>();
		endpoints.add(0.0); //start point
		//create cutoff end points
		for(Double p : probabilities){
			endpoints.add(endpoints.get(endpoints.size() - 1) + p);
		}
		
		Random random = new Random();
		double d = random.nextDouble();
		//find index of the interval that d lies in
		//binary search result will be (-index - 1)
		//where index is the index of the interval in the list
		int index = Collections.binarySearch(endpoints, d);  
		if(index > 0){
			return numbers.get(index); 
		}
		else{
			int validIndex = Math.abs(index + 1) - 1;
			return numbers.get(validIndex);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = new ArrayList<>();
		List<Double> B = new ArrayList<>();
		System.out.println("Enter the input array A: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				for(String s : reader.readLine().split("")){
					A.add(Integer.parseInt(s));
				}
			}
			
			System.out.println("Enter the probabilitiy array for A separate by space: ");
			reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				for(String s : reader.readLine().split(" ")){
					B.add(Double.parseDouble(s));
				}
			}
			
			System.out.println("The output number is " + generateNonuniformNumber(A, B));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
