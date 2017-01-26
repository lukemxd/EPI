package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 7.3
public class SpreadSheetDecode {
	
	public static Integer spreadSheetDecoding(String s){
		int output = 0;
		for(int i = 0; i < s.length(); ++i){
			char c = s.charAt(i);
			output = output * 26 + c - 'A' + 1; //Remove 1 if A = 0;
		}
		
		return output;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		
		System.out.println("Enter the input spreadsheet column Id: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				
				System.out.println("The corresponding integer is " + spreadSheetDecoding(input));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
