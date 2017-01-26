package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 7.8
public class LookAndSay {
	
	private static String nextNumber(String s){
		StringBuilder next = new StringBuilder();
		int count = 1;
		for(int i = 0; i < s.length(); ++i){
			while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
				++count;
				++i;
			}
			next.append(count);
			next.append(s.charAt(i));
			count = 1;
		}
		
		return next.toString();
	}
	
	public static String lookAndSay(int n){
		String output = "1";
		for(int i = 1; i < n; ++i){
			output = nextNumber(output);
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number n : ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				Integer n = Integer.parseInt(reader.readLine());
				System.out.println("The " + n + "th entry is " + lookAndSay(n));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
