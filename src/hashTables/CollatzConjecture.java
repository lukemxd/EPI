package hashTables;

import java.util.HashSet;
import java.util.Set;

//Problem 13.13
public class CollatzConjecture {

	//Store the numbers that have been checked as true
	private static Set<Long> checkedOddNumbers = new HashSet<>();
	
	public static boolean isCollatzCinjecture(int n){
		//1 and 2 hold the hypothesis
		for(int i = 3; i <= n; i += 2){
			Set<Long> numberEncountered = new HashSet<>();
			long temp = i;
			while(temp >= i){
				//Falls into loop
				if(!numberEncountered.add(temp))
					return false;
				if(temp % 2 == 1){
					if(!checkedOddNumbers.add(temp))
						break;
					long nextTemp = temp * 3 + 1;
					if(nextTemp <= temp)
						throw new ArithmeticException("Collatz conjecture overflow for " + i);
					temp = nextTemp;
				}else
					temp /= 2;
			}
		}
		return true;
	}
}
