package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Problem 6.19
public class PascalTriangle {
	
	public static List<List<Integer>> generatePascalTriangle(int rowNum){
		List<List<Integer>> pascalTriangle = new ArrayList<>();
		for(int i = 0; i < rowNum; ++i){
			List<Integer> currentRow = new ArrayList<>(i + 1);
			for(int j = 0; j <= i; ++j){
				//first or last entry of each row is 1
				//if(j == 0 || j == i)
				//	currentRow.add(1);
				//else
				//{
				//	int entry = pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j);
				//	currentRow.add(entry);	
				//}
				
				//Alternative expression
				currentRow.add((j > 0 && j < i) ? pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j) : 1);
			}
			pascalTriangle.add(currentRow);
		}
		
		return pascalTriangle;
	}

	//Variant
	public static List<Integer> generateNthRow(int rowNum){
		List<Integer> nthRow = new ArrayList<>(rowNum);
		
		for(int k = 0; k < rowNum; ++k){
			//kth entry equals (k - 1)th entry times (n - k)/k
			nthRow.add((k > 0 && k < rowNum - 1 ? nthRow.get(k - 1) * (rowNum - k) / k : 1));
		}
		
		return nthRow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		
		System.out.println("Enter the number of rows n: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				n = Integer.parseInt(reader.readLine());
		
				//System.out.println("The input 2D array is " + generatePascalTriangle(n));
				System.out.println("The " + n + "th row is " + generateNthRow(n));
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
