package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//Problem 7.4
public class ReplaceAndRemove {
	
	public static String replaceAndRemove(char[] s){
		//Remove 'b' by forward iteration
		int aCount = 0, writeIndex = 0;
		for(int i = 0; i < s.length; ++i){
			if(s[i] != 'b'){
				s[writeIndex++] = s[i];
			}			
			if(s[i] == 'a'){
				++aCount;
			}
		}
		
		//Replace 'a' by backward iteration
		int curIndex = writeIndex - 1;
		writeIndex = curIndex + aCount;
		char[] ch = new char[writeIndex + 1];
		
		for(int j = curIndex; j >= 0; --j){
			if(s[j] == 'a'){
				ch[writeIndex--] = 'd';
				ch[writeIndex--] = 'd';
			}
			else{
				ch[writeIndex--] = s[j];
			}
		}
		
		StringBuilder output = new StringBuilder();
		for(char c : ch){
			output.append(c);
		}
		
		return output.toString();
	}

	//Variant 2
	public static void merge(int[] A, int start, int mid, int end){
		int[] temp = new int[A.length];
		int left = start, right = mid, index = start;
		while(left < mid && right < end){
			if(A[left] < A[right]){
				temp[index++] = A[left++];
			}
			else{
				temp[index++] = A[right++];
			}
		}
		while(left < mid){
			temp[index++] = A[left++];
		}
		while(right < end){
			temp[index++] = A[right++];
		}
		for(index = start; index < end; ++index){
			A[index] = temp[index];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char[] input = null;
		
		//System.out.println("Enter the input string: ('b' will be removed and 'a' will be replaced by two 'd's.) ");
		//Variant 2
		System.out.println("Enter the input integer array A and B split by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				//input = reader.readLine().toCharArray();
				//System.out.println("The output string is: " + replaceAndRemove(input));
				
				//Variant 2
				String line = reader.readLine();
				int[] A = new int[line.replaceAll("\\s", "").length()]; 
				for(int i = 0; i < A.length; ++i){
					A[i] = line.replaceAll("\\s", "").charAt(i) - '0';
				}
				
				System.out.println("The input array C is: " + Arrays.toString(A));
				
				merge(A, 0, line.split(" ")[0].length(), A.length);
				System.out.println("The merged sorted result is: " + Arrays.toString(A));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
