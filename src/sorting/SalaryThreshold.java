package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem 14.10
public class SalaryThreshold {
	
	public static double computeSalaryCap(List<Double> salaries, double target){
		Collections.sort(salaries);
		double unadjustedSalarySum = 0;
		for(int i = 0; i < salaries.size(); ++i){
			final double adjustedSalarySum = salaries.get(i) * (salaries.size() - i);
			if(adjustedSalarySum + unadjustedSalarySum >= target){
				//Use the arithmetical expression
				return (target - unadjustedSalarySum) / (salaries.size() - i);
			}
			unadjustedSalarySum += salaries.get(i);
		}
		//Target is greater than largest payroll
		return -1.0;
	}
	
	//Variant 1
	public static double computeSalaryCapBS(List<Double> salaries, double target){
		Collections.sort(salaries);
		List<Double> payrolls = new ArrayList<>();
		double unadjustedSalarySum = 0;
		for(int i = 0; i < salaries.size(); ++i){
			double adjustedSalarySum = salaries.get(i) * (salaries.size() - i);
			payrolls.add(unadjustedSalarySum + adjustedSalarySum);
			unadjustedSalarySum += salaries.get(i);
		}
		//Do BS in the payrolls to find the index(right)
		int left = 0, right = payrolls.size() - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(payrolls.get(mid) >= target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		double preSum = 0;
		for(int j = 0; j <= right; ++j){
			preSum += salaries.get(j);
		}
		return (target - preSum) / (salaries.size() - right - 1);
	}
}
