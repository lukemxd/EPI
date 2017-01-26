package primitiveTypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 5.2
public class BitSwap {
	
	private static long swapBits(long x, int i, int j){
		//Extract i-th and j-th bits and compare
		if(((x >>> i) & 1) != ((x >>> j) & 1)){
			long bitMask = (1L << i) | (1L << j);
			x ^= bitMask;
		}
		
		return x;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String input = null;
		long x = 0;
		int i = 0;
		int j = 0;

		System.out.println("Enter the input number: "); 
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			input = reader.readLine();

			x = Long.valueOf(input.split(" ")[0]).longValue();
			i = Integer.valueOf(input.split(" ")[1]).intValue();
			j = Integer.valueOf(input.split(" ")[2]).intValue();
			
			System.out.println(swapBits(x, i, j));
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
