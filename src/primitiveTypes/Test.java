package primitiveTypes;

import java.io.*;

//Problem 5.1
public class Test {
	
	private static short parityCheck(long x){
		/*
		short result = 0;
		while(x != 0){
			
			//Masking and shifting
			result ^= (x & 1);
			x >>>= 1;  //O(n)
			
			//Erase the Lowest set bit
			//result ^= 1;
			//x &= (x - 1);  //O(k) k = # of 1's
		}
		
		return result;*/   
		
		//XOR
		/*x ^= x >>> 32;
		x ^= x >>> 16;
		x ^= x >>> 8;
		x ^= x >>> 4;
		x ^= x >>> 2;
		x ^= x >>> 1;
		
		return (short)(x & 0x1);*/ //O(log(n))
		
		//LookUp Table
		final int WORD_SIZE = 16;
		final int BIT_MASK = 0xFFFF;
		int[] LookUp = new int[65536]; //Precached parity table
		
		return (short)(LookUp[(int)((x >>> WORD_SIZE * 3) & BIT_MASK)]
					  ^LookUp[(int)((x >>> WORD_SIZE * 2) & BIT_MASK)]
					  ^LookUp[(int)((x >>> WORD_SIZE) & BIT_MASK)]
			          ^LookUp[(int)(x & BIT_MASK)]);  //O(n/L) L = WORD_SIZE
	}

	public static void main(String[] args) throws Exception{
		
		String input = null;
		long x = 0;

		System.out.println("Enter the input number: "); 
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			input = reader.readLine();
			//x = Long.valueOf(input).longValue();
			x = Integer.decode(input);
					
			
			System.out.println(parityCheck(x));
		}
		catch (Exception ex){
			ex.printStackTrace();
		}

	}

}
