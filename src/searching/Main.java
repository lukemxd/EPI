package searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	//12.1
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the sorted input array delimited by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<Integer> sortedArray = new ArrayList<>();
				System.out.print("The input array is ");
				for(String s : input){
					sortedArray.add(Integer.parseInt(s));
					System.out.print(s + " ");
				}
				System.out.println();
				System.out.println("Please enter the number to search: ");
				Integer target = Integer.parseInt(reader.readLine());
				
				System.out.print("The index of the target integer in the input is " 
								  + ArraySearch.findFirstGreaterOccurence(sortedArray, target));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//12.2
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the sorted input array delimited by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<Integer> sortedArray = new ArrayList<>();
				System.out.print("The input array is ");
				for(String s : input){
					sortedArray.add(Integer.parseInt(s));
					System.out.print(s + " ");
				}
				System.out.println();
				System.out.print("The element which equals its index is " 
								  + ArraySearch.searchEqualIndexElement(sortedArray, 0, sortedArray.size() - 1));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
