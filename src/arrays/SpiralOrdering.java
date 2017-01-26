package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Problem 6.17
public class SpiralOrdering {
	
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
	
	public static List<Integer> spiralOrdering(List<List<Integer>> input){
		
		final int[][] shift = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		List<Integer> output = new ArrayList<>();
		int dir = 0, x = 0, y = 0;
		
		for(int i = 0; i < input.size() * input.size(); ++i){
			output.add(input.get(x).get(y));
			input.get(x).set(y, 0);
			int nextX = x + shift[dir][0];
			int nextY = y + shift[dir][1];
			if(nextX < 0 || nextX >= input.size() || nextY < 0 || nextY >= input.size() || input.get(nextX).get(nextY) == 0){
				dir = (dir + 1) % 4;
				nextX = x + shift[dir][0];
				nextY = y + shift[dir][1];
			}
			x = nextX;
			y = nextY;
		}
		
		return output;
	}
	
	//Variant 1 & 2 
	public static List<List<Integer>> generateSpiralOrdering2DArray(int n){
		
		final int[][] shift = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		List<List<Integer>> output = generate2DArray(n);
		List<List<Integer>> flag = generate2DArray(n);
		int dir = 0, x = 0, y = 0;
		
		for(int i = 1; i <= n * n; ++i){
			output.get(x).set(y, i); //for 2: use the input sequence P instead of i
			flag.get(x).set(y, 0);
			int nextX = x + shift[dir][0];
			int nextY = y + shift[dir][1];
			if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || flag.get(nextX).get(nextY) == 0){
				dir = (dir + 1) % 4;
				nextX = x + shift[dir][0];
				nextY = y + shift[dir][1];
			}
			x = nextX;
			y = nextY;
		}
		
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		
		System.out.println("Enter the number n for n*n 2D array: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				n = Integer.parseInt(reader.readLine());
				
				List<List<Integer>> input = generate2DArray(n);

				System.out.println("The input 2D array is " + input);
				System.out.println("The output 2D array is " + spiralOrdering(input));
				System.out.println("The output in spiral order is " + generateSpiralOrdering2DArray(n));
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		
	}

}
