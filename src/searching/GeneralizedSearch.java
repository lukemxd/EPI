package searching;

import java.util.List;

//Problem 12.6-12.10
public class GeneralizedSearch {
	
	//12.6
	public static boolean matrixSearch(List<List<Integer>> sortedMatrix, Integer target){
		int row = 0, col = sortedMatrix.get(0).size() - 1;
		while(row < sortedMatrix.size() && col >= 0){
			if(sortedMatrix.get(row).get(col) == target)
				return true;
			else if(sortedMatrix.get(row).get(col) > target)
				--col; //Eliminate the column
			else {
				++row; //Eliminate the row
			}
		}
		return false;
	}
	
	//12.7
	
}
