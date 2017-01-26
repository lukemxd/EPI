package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem 6.9
public class ArrayPermutation {
	
	private static List<Integer> applyPermutation(List<Integer> A, List<Integer> perm){
		for(int i = 0; i < A.size(); ++i){
			int next = i;
			while(perm.get(next) >= 0){
				Collections.swap(A, i, perm.get(next));
				int temp = perm.get(next);
				perm.set(next, perm.get(next) - perm.size());
				next = temp;
			}
		}
		
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = null;
		List<Integer> A = new ArrayList<Integer>();
		List<Integer> perm = new ArrayList<Integer>();
		try{
			System.out.println("Enter the input array A: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split("");
				for(int i = 0; i < input.length; ++i){
					A.add(Integer.parseInt(input[i]));	
				}
				
				System.out.println("The input array is " + A);
			}
			System.out.println("Enter the permutation array perm: ");
			reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split("");
				for(int i = 0; i < input.length; ++i){
					perm.add(Integer.parseInt(input[i]));	
				}
				
				System.out.println("The permutation array is " + perm);
			}
			
			System.out.println("The output array is " + applyPermutation(A, perm));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
