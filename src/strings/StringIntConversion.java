package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 7.1
public class StringIntConversion {
	
	public static int stringToInt(String s){
		int output = 0;
		boolean isNegative = s.charAt(0) == '-';
		for(int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i ){
			int digit = s.charAt(i) - '0';
			output = output * 10 + digit;
		}
		
		if(isNegative){
			output = -output;
		}
		
		return output;
	}
	
	public static String intToString(int x){
		StringBuilder s = new StringBuilder();
		boolean isNegative = false;
		if(x < 0){
			x = -x;
			isNegative = true;
		}
		
		do{
			s.append((char)('0' + x % 10));
			x /= 10;			
		} while(x != 0);
		
		if(isNegative){
			s.append('-');
		}
		
		s.reverse();
		return s.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Choose what you want to enter: (1 - Integer, 0 - String): ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				int input = Integer.parseInt(reader.readLine());
				if(input > 0){
					System.out.println("Enter the integer you want to convert to string: ");
					int x = Integer.parseInt(reader.readLine());
					System.out.println("The converted string is " + intToString(x));
				}
				else{
					System.out.println("Enter the string you want to convert to integer: ");
					String s = reader.readLine();
					System.out.println("The converted interger is " + stringToInt(s));
				}
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
