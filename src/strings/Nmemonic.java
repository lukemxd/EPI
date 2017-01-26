package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Problem 7.7
public class Nmemonic {
	
	private static final String[] mapping = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	
	private static void generateNmemonic(String phoneNumber, char[] tempChars, List<String> nmemonics, int digit){
		if(digit == phoneNumber.length()){
			nmemonics.add(new String(tempChars));
		}
		else{
			for(int i = 0; i < mapping[phoneNumber.charAt(digit) - '0'].length(); ++i){ //ASCII code conversion
				char c = mapping[phoneNumber.charAt(digit) - '0'].charAt(i);
				tempChars[digit] = c;
				generateNmemonic(phoneNumber, tempChars, nmemonics, digit + 1);
			}
		}
	}
	
	public static List<String> phoneNmemonic(String phoneNumber){
		char[] tempChars = new char[phoneNumber.length()];
		List<String> nmemonics = new ArrayList<>();
		generateNmemonic(phoneNumber, tempChars, nmemonics, 0);
		return nmemonics;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		
		System.out.println("Enter the phone number: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				List<String> results = phoneNmemonic(input);
				System.out.println("The nmemonic for this phone number is " + results);
				System.out.println("The total result number is " + results.size());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
