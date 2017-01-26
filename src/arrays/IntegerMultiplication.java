package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Problem 6.3
public class IntegerMultiplication {
	
	private static List<Integer> multiply(List<Integer> A, List<Integer> B){
		//Immutable initial list with length of A + B
		int len = A.size() + B.size();
		List<Integer> product = new ArrayList<>(Collections.nCopies(len, 0)); 
		
		//Get the absolute value and extract the minus sign (2 approaches)
		int sign = A.get(0) < 0 ^ B.get(0) < 0 ? -1 : 1;
		//int sign = A.get(0) * B.get(0) > 0 ? 1 : -1;
		A.set(0, Math.abs(A.get(0)));
		B.set(0, Math.abs(B.get(0)));
		
		//Calculate the product
		for(int i = A.size() - 1; i >= 0 ; --i){
			for(int j = B.size() - 1; j >= 0; --j){
				product.set(i + j + 1, product.get(i + j + 1) + A.get(i) * B.get(j)); 
				product.set(i + j, product.get(i + j) + product.get(i + j + 1) / 10); //carry-in
				product.set(i + j + 1, product.get(i + j + 1) % 10); //after carry-out
			}
		}
		
		//Check if there are any MSB == 0
		int zero = 0;
		while (zero < product.size() && product.get(zero) == 0){
			++zero;
		}
		product = product.subList(zero, product.size());
		if(product.isEmpty()){
			return Arrays.asList(0);
		}
		
		product.set(0, product.get(0) * sign);
		
		return product;
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		String[] s = null;
		List<Integer> A = new ArrayList<Integer>();
		List<Integer> B = new ArrayList<Integer>();
		System.out.println("Enter the input array A and B separate by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				s = input.split(" ")[0].split("");
				for(int i = 0; i < s.length; ++i){
					if(s[i].startsWith("-")){
						A.add(Integer.parseInt(s[i] + s[i + 1]));
						++i;
					}else{
						A.add(Integer.parseInt(s[i]));
					}
				}
				s = input.split(" ")[1].split("");
				for(int i = 0; i < s.length; ++i){
					if(s[i].startsWith("-")){
						B.add(Integer.parseInt(s[i] + s[i + 1]));
						++i;
					}else{
						B.add(Integer.parseInt(s[i]));
					}
						
				}
				
				System.out.println("The orignal input array A is " + A);
				System.out.println("The orignal input array B is " + B);
				System.out.println("The product of A and B is " + multiply(A, B));	
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
