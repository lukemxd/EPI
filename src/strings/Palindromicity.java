package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 7.5
public class Palindromicity {

	public static boolean isPalindrome(String s){
		int i = 0, j = s.length() - 1;
		while(i < j){
			//Skip non-alphanumeric chars
			while(!Character.isLetterOrDigit(s.charAt(i)) && i < j){
				++i;
			}
			while(!Character.isLetterOrDigit(s.charAt(j)) && i < j){
				--j;
			}
			//Compare
			if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
			{
				return false;
			}
			++i;
			--j;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		
		System.out.println("Enter the input string: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				
				if(isPalindrome(input)){
					System.out.println("The input string is palindrome.");	
				}
				else
					System.out.println("The input string is NOT palindrome.");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
