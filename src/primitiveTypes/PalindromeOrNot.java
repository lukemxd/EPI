package primitiveTypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 5.9
public class PalindromeOrNot {
	
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
	
	private static boolean checkPalin(long x){
		
		//Use reverse digits
		if(x == ReverseDigs(x)){
			return true;
		}
		
		//Extract LSD and MSD constraint: x is less than 64bits
		if(x < 0){
			return false;
		}
		else if(x == 0){
			return true;
		}
		else{
			final int numDigits = (int)(Math.floor(Math.log10(x))) + 1;
			long msdMask = (long)Math.pow(10, numDigits - 1);
			for(int i = 0; i < (numDigits/2); ++i){
				if(x % 10 != x / msdMask){
					return false;
				}
				x %= msdMask; //Remove MSD
				x /= 10; //Remove LSD
				msdMask /= 100;
			}
		}
		
		return true;
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
				
				System.out.println((checkPalin(x)));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
