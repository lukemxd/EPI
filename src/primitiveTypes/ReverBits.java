package primitiveTypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 5.3
public class ReverBits {
	
	private static long ReverseBits(long x){
		
		final int WORD_SIZE = 16;
		final int BIT_MASK = 0xFFFF;
		int [] LookUp = new int[65536];
		
		return LookUp[(int)(x & BIT_MASK)] << WORD_SIZE * 3
			 | LookUp[(int)((x >>> WORD_SIZE) & BIT_MASK)] << WORD_SIZE * 2
			 | LookUp[(int)((x >>> WORD_SIZE * 2) & BIT_MASK)] << WORD_SIZE
			 | LookUp[(int)((x >>> WORD_SIZE * 3) & BIT_MASK)];
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String input = null;
		long x = 0;
		System.out.println("Enter the input number: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				x = Long.valueOf(input).longValue();
				
				System.out.print(ReverseBits(x));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
