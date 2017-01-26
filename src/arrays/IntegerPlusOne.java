package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Problem 6.2
public class IntegerPlusOne {
	
	private static void plusOne(List<Integer> A){
		int len = A.size();
		int n = len - 1;
		A.set(n, A.get(n) + 1);
		//Check if it is 10
		while(A.get(n) == 10){
			A.set(n, 0);
			if(n != 0){
				A.set(n - 1, A.get(n - 1) + 1);
				--n;
			}else{
				A.add(0, 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				
				System.out.println("The orignal input array is " + A);
				plusOne(A);
				System.out.println("The incremented input array is " + A);	
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
