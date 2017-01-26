package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 7.11
public class RabinKarp {
	
	public static int rabinKarp(String input, String sub){
		if(input.length() < sub.length()){
			return -1;
		}
		
		final int BASE = 26;
		int tHash = 0, sHash = 0;
		int sPower = 1;
		//Compute the hash of the first substring in T and constant hash of S
		for(int i = 0; i < sub.length(); i++){
			sPower = i > 0 ? sPower * BASE : 1;
			tHash = tHash * BASE + input.charAt(i);
			sHash = sHash * BASE + sub.charAt(i);
		}
		
		for(int i = sub.length(); i < input.length(); i++){
			if(tHash == sHash && input.substring(i - sub.length(), i).equals(sub)){
				return i - sub.length();
			}
			//Not match compute the rolling hash for next substring
			tHash = tHash - input.charAt(i - sub.length()) * sPower;
			tHash = tHash * BASE + input.charAt(i);
		}
		//For the last substring because substring exclude the end index
		if(tHash == sHash && input.substring(input.length() - sub.length()).equals(sub)){
			return input.length() - sub.length();
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		String sub = null;
		System.out.println("Enter the searching string T (case-insensitive): ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				System.out.println("Enter the occurrence string S (case-insensitive): ");
				if(reader != null){
					sub = reader.readLine();
				}
				System.out.println("The searching string T is " + input.toLowerCase());
				System.out.println("The occurrence string S is " + sub.toLowerCase());
				System.out.println("Calculating......please wait");
				int result = rabinKarp(input.toLowerCase(), sub.toLowerCase());
				if(result != -1){
					System.out.println("The first index of S in T is " + result);	
				}
				else
					System.out.println("S is not a substring of T");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
