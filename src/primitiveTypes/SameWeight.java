package primitiveTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Problem 5.4
public class SameWeight {
	
	static final int NUM_UNSIGN_BITS = 63; 
	
	private static long sameWeight(long x){
		for(int i = 0; i < NUM_UNSIGN_BITS - 1; ++i){
			if(((x >>> i) & 1) != ((x >>> (i + 1)) & 1)){
				x ^= (1L << i) | (1L << (i + 1));
				return x;
			}
		}
		
		throw new IllegalArgumentException("All bit are 0 or 1");
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String input = null;
		long x = 0;

		System.out.println("Enter the input number: "); 
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			input = reader.readLine();
			x = Long.valueOf(input).longValue();
					
			System.out.println(sameWeight(x));
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}

}
