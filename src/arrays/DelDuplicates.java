package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem 6.5
public class DelDuplicates {
	
	/**
	 * Delete the duplicates from the given input A
	 * @param A is an integer array
	 * */
	private static List<Integer> deleteDuplicates(List<Integer> A){
		int newIndex = 1;
		if(A.isEmpty()){
			return Arrays.asList(0);
		} else{
			for(int i = 1; i < A.size(); ++i){
				if(A.get(i) != A.get(newIndex - 1)){
					A.set(newIndex, A.get(i));
					newIndex++;
				}
			}
			
		}
		
		return A.subList(0, newIndex);
	}
	
	/**
	 * Delete the given key value from the given input A
	 * @param A is an integer array
	 * @param key is the element needs to be deleted
	 * */
	private static List<Integer> deleteDuplicates(List<Integer> A, int key){
		int newIndex = 0;
		if(A.isEmpty()){
			return Arrays.asList(0);
		} else{
			for(int i = 0; i < A.size(); ++i){
				if(key != A.get(i)){
					if(i != newIndex){
						A.set(newIndex, A.get(i));
					}
					++newIndex;
				}
			}
		}
		
		return A.subList(0, newIndex);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line = null;
		String[] input = null;
		int key = 0;
		List<Integer> A = new ArrayList<Integer>();
		System.out.println("Enter the input array A: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				line = reader.readLine();
				input = line.split(" ")[0].split(","); 
				for(int i = 0; i < input.length; ++i){
					A.add(Integer.parseInt(input[i]));	
				}
				key = Integer.valueOf(line.split(" ")[1]);
				
				System.out.println("The input array is " + A);
				List<Integer> result = deleteDuplicates(A, key);
				System.out.println("The output array without the key is " + result);
				System.out.println("The number of valid elements is " + result.size());
				//Reset A
				for(int i = 0; i < input.length; ++i){
					A.set(i, Integer.parseInt(input[i]));	
				}
				List<Integer> result2 = deleteDuplicates(A);
				System.out.println("The output array without any duplicates is " + result2);
				System.out.println("The number of valid elements is " + result2.size());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
