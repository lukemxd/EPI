package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 7.12
public class RunLengthEncoding {
	
	public static String encoding(String s){
		StringBuilder output = new StringBuilder();
		int count = 1;
		for(int i = 0; i < s.length(); ++i){
			while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
				++count;
				++i;
			}
			output.append(count);
			output.append(s.charAt(i));
			count = 1;
		}
		
		return output.toString();
	}
	
	public static String decoding(String s){
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < s.length(); i += 2){
			if(!Character.isDigit(s.charAt(i))){
				return "-1";
			}
			int count = s.charAt(i) - '0';
			if(!Character.isLetter(s.charAt(i + 1))){
				return "-1";
			}
			char letter = s.charAt(i + 1);
			for(int j = 0; j < count; ++j){
				output.append(letter);
			}
		}
		
		return output.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Choose what you want to enter: (1 - Encoding, 0 - Decoding): ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				int input = Integer.parseInt(reader.readLine());
				if(input > 0){
					System.out.println("Enter the string you want to encode: ");
					String x = reader.readLine();
					System.out.println("The encoded string is " + encoding(x));
				}
				else{
					System.out.println("Enter the string you want to decode: ");
					String s = reader.readLine();
					String result = decoding(s);
					if(result != "-1"){
						System.out.println("The decoded is " + result);	
					}
					else{
						System.out.println("Invalid input string");
					}
					
				}
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
