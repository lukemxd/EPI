package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem 14.1
public class ArrayIntersection {
	
	//mlog(n) or nlog(m)
	public static List<Integer> computeIntersectionByBS(List<Integer> A, List<Integer> B){
		List<Integer> intersection = new ArrayList<>();
		for(int i = 0; i < A.size(); ++i){
			if(i == 0 || A.get(i - 1) != A.get(i) 
					&& Collections.binarySearch(B, A.get(i)) >= 0){
				intersection.add(A.get(i));
			}
		}
		return intersection;
	}
	
	//m + n
	public static List<Integer> computeIntersectionByTandem(List<Integer> A, List<Integer> B){
		List<Integer> intersection = new ArrayList<>();
		int i = 0, j = 0;
		while(i < A.size() && j < B.size()){
			//Remove the duplicates
			if(A.get(i) == B.get(j) && (i == 0 || A.get(i - 1) != A.get(i))){
				intersection.add(A.get(i));
				++i;
				++j;
			}else if(A.get(i) < B.get(j))
				++i;
			else
				++j;
		}
		return intersection;
	}
}
