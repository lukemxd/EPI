package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem 6.16
public class SudokuChecker {
	
	public static boolean isValidSudoku(List<List<Integer>> partialSudoku){
		//check rows 
		for(int i = 0; i < partialSudoku.size(); ++i){
			if(hasDuplicate(partialSudoku, i, i + 1, 0, partialSudoku.size())){
				return false;
			}
		}
		//check columns
		for(int j = 0; j < partialSudoku.size(); ++j){
			if(hasDuplicate(partialSudoku, 0, partialSudoku.size(), j, j + 1)){
				return false;
			}
		}
		//check sub-regions
		int regionSize = (int)Math.sqrt(partialSudoku.size());
		for(int I = 0; I < regionSize; ++I){
			for(int J = 0; J < regionSize; ++J){
				if(hasDuplicate(partialSudoku, I * regionSize, (I + 1) * regionSize, J * regionSize , (J + 1) * regionSize)){
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static boolean hasDuplicate(List<List<Integer>> partialSudoku, int startRow, int endRow, int startCol, int endCol){
		List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(partialSudoku.size() + 1, false));
		for(int i = startRow; i < endRow; ++i){
			for(int j = startCol; j < endCol; ++j){
				if(partialSudoku.get(i).get(j) != 0 && isPresent.get(partialSudoku.get(i).get(j))){
					return true;
				}
				isPresent.set(partialSudoku.get(i).get(j), true);
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> partialSudoku = new ArrayList<>(9);
		System.out.println("Enter the partial Sudoku to check (format: 1st row numbers 2nd row numbers...9th row numbers, use 0 for blank value and row separated by space): ");
		
		try{
			//Use 530070000 600195000 098000060 800060003 400803001 700020006 060000280 000419005 000080079 as test entries
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				for(String rowNums : reader.readLine().split(" ")){
					List<Integer> row = new ArrayList<>();
					if(rowNums.length() != 9){
						System.err.println("Error: Please check the entries and make sure every row has 9 numbers.");
						return;
					}
					else{
						for(String rowNum : rowNums.split("")){
							row.add(Integer.parseInt(rowNum));	
						}
						partialSudoku.add(row);
					}
				}
			}
			
			System.out.println("Processing: checking if this is a valid sudoku....");
			System.out.println(isValidSudoku(partialSudoku));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
