package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 7.2
public class BaseConversion {
	
	private static String constructFromBase(int x, int base){
		return x == 0 ? "" : constructFromBase(x / base, base) + (char)(x % base >= 10 ? 'A' + x % base - 10 : '0' + x % base);
	}
	
	public static String baseConversion(String s, String s1, String s2){
		int b1 = Integer.parseInt(s1);
		int b2 = Integer.parseInt(s2);
		boolean isNegative = s.startsWith("-");
		int x = 0;
		for(int i = isNegative ? 1 : 0; i < s.length(); ++i){
			x = x * b1 + (Character.isDigit(s.charAt(i)) ? s.charAt(i) - '0' : s.charAt(i) - 'A' + 10); 
		}
		
		return (isNegative ? "-" : "") + (x == 0 ? "" : constructFromBase(x, b2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the input integer as a string in base b1 and the target base b2 (format:input b1 b2): ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				 String[] input = reader.readLine().split(" ");
				 System.out.println("The converted integer as a string in base b2 is " + baseConversion(input[0], input[1], input[2]));
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
