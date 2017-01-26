package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem 6.1
public class DutchNationalFlag {
	
	public static enum Color {RED, WHITE, BLUE} //color Enum
	
	//Two-pass
	/*private static void dutchFlagPartition(int pivotIndex, List<Color> A){
		//Color pivot = A.get(pivotIndex);
		Color pivot = Color.WHITE; //Use the middle value as pivot
		//First pass
		int smaller = 0;
		for(int i = 0; i < A.size(); ++i){
			if(A.get(i).ordinal() < pivot.ordinal()){
				Collections.swap(A, smaller++, i);
			}
		}
		//Second pass
		int larger = A.size() - 1;
		for(int j = A.size() - 1; j >= 0; --j){
			if(A.get(j).ordinal() > pivot.ordinal()){
				Collections.swap(A, larger--, j);
			}
		}
		
	}*/
	
	//One-pass
	private static void dutchFlagPartition(int pivotIndex, List<Color> A){
		//Color pivot = A.get(pivotIndex);
		Color pivot = Color.WHITE; //Use the middle value as pivot
		int smaller = 0, equal = 0, larger = A.size();
		//Unclassified sub-array is (equal, larger), eliminate it
		while(equal < larger){
			if(A.get(equal).ordinal() < pivot.ordinal()){
				Collections.swap(A, smaller++, equal++);
			} else if(A.get(equal).ordinal() == pivot.ordinal()){
				++equal;
			} else {
				Collections.swap(A, equal, --larger);
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String input = null;
		List<Color> A = new ArrayList<Color>();
		int pivotIndex = 0;
		System.out.println("Enter the input color array A followed by the pivot index d: (format = A,d, where A must be 0, 1 or 2)");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				String a = input.split(",")[0];
				for(int i = 0; i < a.length(); ++i){
					switch (a.charAt(i)) {
					case '0':
						A.add(Color.RED);
						break;
					case '1':
						A.add(Color.WHITE);
						break;
					case '2':
						A.add(Color.BLUE);
						break;
					default:
						throw new IllegalArgumentException("Input has invalid number(s).");
					}
				}
				pivotIndex = Integer.valueOf(input.split(",")[1]);
				
				if(pivotIndex >= a.length()){
					System.out.println("Error: pivot index cannot exceed or equal to the length of the input.");
				}
				else{
					System.out.println("The orignal color array is " + A);
					dutchFlagPartition(pivotIndex, A);
					System.out.println("The sorted color array is " + A);	
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
