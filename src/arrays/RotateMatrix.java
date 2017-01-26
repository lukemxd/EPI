package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Problem 6.18
public class RotateMatrix {
	
	private List<List<Integer>> rotatedMatrix;
	
	//Default constructor
	public RotateMatrix(List<List<Integer>> originalArray) {
		// TODO Auto-generated constructor stub
		this.rotatedMatrix = originalArray;
	}
	
	//generate input n*n 2D array
	private static List<List<Integer>> generate2DArray(int n){

		List<List<Integer>> input = new ArrayList<>(n);
			
		for(int i = 0; i < n; ++i){
			List<Integer> row = new ArrayList<>(n);
			for(int j = i * n; j < (i + 1)* n; ++j){
				row.add(j + 1);
			}
			input.add(row);
		}
			
		return input;
	}
	
	//write into the array
	private void writeEntry(int x, int y, int value){
		this.rotatedMatrix.get(x).set(y, value);
	}
	
	//read from the array
	private int readEntry(List<List<Integer>> input, int x, int y){
		return input.get(input.size() - 1 - y).get(x); 
		
		//Variant
		//return input.get(input.size() - 1 - x).get(y); //horizontal symmetry
		//return input.get(x).get(input.size() - 1 - y); //vertical symmetry
		//return input.get(y).get(x); //diagonal symmetry top-left to bottom-right
		//return input.get(input.size() - 1 - y).get(input.size() - 1 - x); //diagonal symmetry top-right to bottom-left
	}
	
	public List<List<Integer>> rotate2DArray(List<List<Integer>> input){		
		for(int i = 0; i < input.size(); ++i){
			for(int j = 0; j < input.size(); ++j){
				writeEntry(i, j, readEntry(input, i, j));
			}
		}
		return this.rotatedMatrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		
		System.out.println("Enter the number n for n*n 2D array: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				n = Integer.parseInt(reader.readLine());
				
				RotateMatrix rMatrix = new RotateMatrix(generate2DArray(n));

				System.out.println("The input 2D array is " + rMatrix.rotatedMatrix);
				System.out.println("The rotate 2D array is " + rMatrix.rotate2DArray(generate2DArray(n)));
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
