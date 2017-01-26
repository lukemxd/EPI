package primitiveTypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 5.6
public class DivisionXY {
	
	private static String divide(long x, long y){
		long result = 0;
		long remainder = 0;
		int power = 32;
		long yPower = y << power;
		while(x >= y){
			while(yPower > x){
				yPower >>>= 1;
				power --;
			}
			
			result += 1L << power; 
			x -= yPower;
		}
		remainder = x;
		
		return "The quotient is " + result + " and the remainder is " + remainder;
	}

	public static void main(String[] args) {
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
					
			System.out.println(divide(x, y));
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
	}

}
