package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem 6.10
public class NextPermutation {
	
	public static List<Integer> findNextPerm(List<Integer> A){
		int k = A.size() - 2;
		//Step 1 
		while(k >= 0 && A.get(k) >= A.get(k + 1)){
			--k;
		}
		if(k == -1){
			return Collections.emptyList();
		}
		//Step 2
		for(int i = A.size() - 1; i > k; --i){
			if(A.get(i) > A.get(k)){
				Collections.swap(A, i, k);
				break;
			}
		}		
		//Step 3
		//Collections.reverse(A.subList(k + 1, A.size()));
		for(int i = 0; i < (A.size() - k) / 2; ++i){
			Collections.swap(A.subList(k + 1, A.size()), i, A.size() - k - 2 - i);
		}
		return A;
	}
	
	//Variant 1
	public static List<Integer> findKthPerm(List<Integer> A, int k){
		for(int i = 0; i < k; ++i){
			A = findNextPerm(A);
		}
		
		return A;
	}
	
	//Variant 2
	public static List<Integer> findPrevPerm(List<Integer> A){
		int k =A.size() - 2;
		
		//Step 1
		while(k >= 0 && A.get(k) <= A.get(k + 1)){
			--k;
		}
		if(k == -1){
			return Collections.emptyList();
		}
		//Step 2
		Collections.reverse(A.subList(k + 1, A.size()));
		//Step 3
		for(int i = A.size() - 1; i > k; --i){
			if(A.get(i) > A.get(k)){
				Collections.swap(A, i + 1, k);
				break;
			}
			if(i == k + 1){
				Collections.swap(A, i, k);
			}
		}
		
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 1; //smallest value
		String[] input = null;
		List<Integer> A = new ArrayList<Integer>();
		System.out.println("Enter the input array A: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split("");
				for(int i = 0; i < input.length; ++i){
					A.add(Integer.parseInt(input[i]));	
				}
			}
			
			System.out.println("Enter the number k for kth perm: ");
			reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				k = Integer.parseInt(reader.readLine());
			}
			
			System.out.println("The next permutation is " + findNextPerm(A));
			System.out.println("The prev permutation is " + findPrevPerm(A));
			System.out.println("The "+ k + "th permutation is " + findKthPerm(A, k));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
