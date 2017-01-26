package primitiveTypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 5.8
public class ReverDigits {
	
	private static long ReverseDigs(long x){
		boolean isNegative = x < 0;
		long result = 0;
		long xRemaining = Math.abs(x);
		while(xRemaining > 0){
			result = xRemaining % 10 + result * 10;
			xRemaining /= 10;
		}
		
		result = isNegative ? -result : result;
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		long x = 0;
		System.out.println("Enter the input number: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				x = Long.valueOf(input);
				
				System.out.println(ReverseDigs(x));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
