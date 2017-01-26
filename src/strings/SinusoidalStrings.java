package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 7.11
public class SinusoidalStrings {
	
	//If 3 rows then periodicity is 4
	public static String sinusoidalString(String s){
		StringBuilder result = new StringBuilder();
		//Peak points
		for(int i = 1; i < s.length(); i += 4){
			result.append(s.charAt(i));
		}
		//X-axis points
		for(int i = 0; i < s.length(); i += 2){
			result.append(s.charAt(i));
		}
		//Valley points
		for(int i = 3; i < s.length(); i += 4){
			result.append(s.charAt(i));
		}
		
		return result.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		
		System.out.println("Enter the input string: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				System.out.println("The sinusoidal output string is " + sinusoidalString(input));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
