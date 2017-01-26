package primitiveTypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 5.7
public class YPowerOfX {
	
	private static double ComputeXPowerX(double x, int y){
		double result = 1.0;
		int power = y;
		if(y < 0){
			power = -power;
			x = 1.0/x;
		}
		while(power != 0){
			if((power & 1) != 0){
				result *= x;
			}
			x *= x;
			power >>>= 1;
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String input = null;
		double x = 0;
		int y = 0;
		System.out.println("Enter the input number: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				x = Double.valueOf(input.split(" ")[0]);
				y = Integer.valueOf(input.split(" ")[1]);
				
				System.out.println(ComputeXPowerX(x, y));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
