package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Problem 6.6-6.7
public class MaxProfit {
	
	private static double findMaxProfit(List<Double> A){
		double maxProfit = 0.0, minPrice = Double.MAX_VALUE;
		for(Double price : A){
			maxProfit = Math.max(maxProfit, price - minPrice);
			minPrice = Math.min(minPrice, price);
		}
		
		return maxProfit;
	}
	
	private static double findMaxProfitTwice(List<Double> A){
		double maxTotalProfit = 0.0, minPrice = Double.MAX_VALUE, maxPrice = Double.MIN_VALUE;
		/**Additional O(n) space complexity
		List<Double> firstDayProfits = new ArrayList<Double>();
		//First day profit
		for(Double price : A){
			maxTotalProfit = Math.max(maxTotalProfit, price - minPrice);
			minPrice = Math.min(minPrice, price);
			firstDayProfits.add(maxTotalProfit);
		}
		//Second buy and sell
		for(int i = A.size() - 1; i > 0; --i){
			maxPrice = Math.max(maxPrice, A.get(i));
			maxTotalProfit = Math.max(maxTotalProfit, maxPrice - A.get(i) + firstDayProfits.get(i - 1));
		}*/
		
		/**Additional O(1) space complexity*/
		for(int i = 1; i < A.size(); ++i){
			maxPrice = Math.max(maxPrice, A.get(A.size() - i));
			maxTotalProfit = Math.max(maxTotalProfit, A.get(i - 1) - minPrice + maxPrice - A.get(i)); 
			minPrice = Math.min(minPrice, A.get(i - 1));
			

		}
		
		return maxTotalProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = null;
		List<Double> A = new ArrayList<Double>();
		System.out.println("Enter the input array A: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(",");
				for(int i = 0; i < input.length; ++i){
					A.add(Double.parseDouble(input[i]));	
				}
				
				System.out.println("The input array is " + A);
				System.out.println("The max profit once can be found is " + findMaxProfit(A));	
				System.out.println("The max profit twice can be found is " + findMaxProfitTwice(A));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
