package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Problem 6.4
public class AdvanceToEnd {
	
	private static boolean canReachEnd(List<Integer> A){
		int len = A.size();
		int furthestIndex = 0;
		for(int i = 0; i < len; ++i){
			if(i > furthestIndex){
				return false;
			} else{
				furthestIndex = Math.max(furthestIndex, i + A.get(i));
				if(furthestIndex >= len - 1){
					return true;
				}
			}
		}
		 return false;
		//return furthestIndex >= len - 1;
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
				
				System.out.println("The input array is " + A);
				if(canReachEnd(A)){
					System.out.println("The input array can advance to its end.");	
				} else {
					System.out.println("The input array can NOT advance to its end.");
				}	
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
