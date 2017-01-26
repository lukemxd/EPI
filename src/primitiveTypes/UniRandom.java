package primitiveTypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 5.10
public class UniRandom {
	
	//Provided 0/1 generator 
	private static long zeroOrOne(boolean a){
		//long result = 0;
		if(a){ //some condition
			return 1;
		}
		
		return 0;
	}
	
	private static long uniformRandom(long x, long y){
		long result = 0;
		long numOfOutcomes = y - x + 1;

		while(result >= numOfOutcomes){
			result = 0;
			for(int i = 0; (1 << i) < numOfOutcomes; ++i){
				result = (result << 1) | zeroOrOne(true);
			}
		}
		
		return result + x; //[0,b-a] => plus a for result [a,b]
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		long lowerBound = 0;
		long upperBound = 0;
		System.out.println("Enter the input number: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				lowerBound = Long.valueOf(input.split(" ")[0]).longValue();
				upperBound = Long.valueOf(input.split(" ")[1]).longValue();
				
				System.out.println(uniformRandom(lowerBound, upperBound));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
