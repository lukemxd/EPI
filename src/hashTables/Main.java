package hashTables;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	//13.0
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter input strings delimited by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<String> inputArray = new ArrayList<>();
				for(String s : input){
					inputArray.add(s);
				}
				List<List<String>> results = BootCamp.findAnagrams(inputArray);
				System.out.println("The anagram group are: ");
				for(List<String> strs : results){
					for(String str : strs){
						System.out.print(str + " ");	
					}
					System.out.println();	
				}
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//13.1
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		System.out.println("Please enter input string: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				if(CharacterNumCompare.isPalindromic(input))
					System.out.println("The string is palindromic");
				else
					System.out.println("The string is NOT palindromic");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/

}
