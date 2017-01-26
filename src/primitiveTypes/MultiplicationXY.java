package primitiveTypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 5.5
public class MultiplicationXY {
	
	private static long multiply(long x, long y){
		long sum = 0;
		
		while(x != 0){
			//Examines each bit of x
			if((x & 1) != 0){
				sum = add(sum, y);
			}
			
			x >>>= 1;
			y <<= 1;
		}
		
		return sum;
	}
	
	private static long add(long x, long y){
		long sum = 0, tempA = x, tempB = y, k = 1, carryIn = 0;
		while (tempA != 0 || tempB != 0){
			long xk = x & k, yk = y & k;
			long carryOut = (xk & yk) | (xk & carryIn) | (yk & carryIn);
			sum |= (xk ^ yk ^ carryIn);
			carryIn = carryOut << 1;
			k <<= 1;
			tempA >>>= 1;
			tempB >>>= 1;
		}
		
		return sum | carryIn;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String input = null;
		long x = 0;
		long y = 0;

		System.out.println("Enter the input number: "); 
				
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			input = reader.readLine();

			x = Long.valueOf(input.split(" ")[0]).longValue();
			y = Long.valueOf(input.split(" ")[1]).longValue();
					
			System.out.println(multiply(x, y));
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
	}

}
