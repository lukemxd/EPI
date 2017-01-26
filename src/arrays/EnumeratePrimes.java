package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem 6.8
public class EnumeratePrimes {
	
	private static List<Integer> generatePrimes(Integer a){
		List<Integer> primes = new ArrayList<Integer>();
		List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(a + 1, true));
		isPrime.set(0, false);
		isPrime.set(1, false);
		
		for(int i = 2; i <= a; ++i){
			if(isPrime.get(i)){
				primes.add(i);
				//Seize p's multiples
				for(int j = i; j <= a; j += i){
					isPrime.set(j, false);
				}
			}
		}
		
		return primes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer input = 0;
		System.out.println("Enter the input number: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = Integer.valueOf(reader.readLine());
				System.out.println("All the primes between 1 and " + input + " are " + generatePrimes(input));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
