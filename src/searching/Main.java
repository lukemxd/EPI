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
				System.out.print("The element which equals its index is " 
								  + ArraySearch.searchEqualIndexElement(sortedArray, 0, sortedArray.size() - 1));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//12.3
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the sorted input cyclical array delimited by space: ");
		
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
				System.out.print("The smallest element is " 
								  + BinarySearch.searchCyclicSmallest(sortedArray));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//12.4, 12.5
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		System.out.println("Please enter the number to compute its square root: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				//System.out.println("The square root is " 
				//				  + BinarySearch.integerSquareRoot(Integer.parseInt(input)));
				System.out.println("The float square root is " 
						  + BinarySearch.squareRoot(Double.parseDouble(input)));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//12.7
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter input array delimited by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<Integer> inputArray = new ArrayList<>();
				for(String s : input){
					inputArray.add(Integer.parseInt(s));
				}
				System.out.print(GeneralizedSearch.findMinMax(inputArray));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/	
	
	//12.8
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter input array delimited by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<Integer> inputArray = new ArrayList<>();
				for(String s : input){
					inputArray.add(Integer.parseInt(s));
				}
				System.out.println("Enter k: ");
				Integer k = Integer.parseInt(reader.readLine());
				System.out.println("The " + k + "th largest element is " + GeneralizedSearch.findKLargest(inputArray, k));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}	
}
