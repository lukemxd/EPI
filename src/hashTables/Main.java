package hashTables;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import hashTables.SmallestSubarray.SubArray;

public class Main {

	//13.0
	/*public static void main(String[] args) {
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
	}*/
	
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
	
	//13.7
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter input text strings delimited by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<String> textArray = new ArrayList<>();
				for(String s : input){
					textArray.add(s);
				}
				System.out.println("Please enter subarray strings delimited by space: ");
				input = reader.readLine().split(" ");
				List<String> subArray = new ArrayList<>();
				for(String s : input){
					subArray.add(s);
				}
				//SubArray result = SmallestSubarray.findSmallestSubarray(textArray, subArray);
				SubArray result = SmallestSubarray.findSmallestSubarrayWithOrder(textArray, subArray);
				System.out.println("The smallest subarray string starts at index " + result.startIdx
						   + " and ends at index " + result.endIdx);
				//Variant 5
				//SubArray result = SmallestSubarray.findLongestDistinctSubarray(textArray);
				//System.out.println("The longest subarray string starts at index " + result.startIdx
				//				   + " and ends at index " + result.endIdx);
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/

	//13.12
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter input text string: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				String text = reader.readLine();
				System.out.println("Please enter subarray strings delimited by space: ");
				input = reader.readLine().split(" ");
				List<String> subArray = new ArrayList<>();
				for(String s : input){
					subArray.add(s);
				}
				List<Integer> results = StringDecompositions.findAllStringConcatenations(text, subArray);
				System.out.println("All sub strings concatenation starting indexes are ");
				for(Integer s : results){
					System.out.print(s + " ");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}	
}
