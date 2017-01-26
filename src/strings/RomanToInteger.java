package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Problem 7.9
public class RomanToInteger {
	
	private static @SuppressWarnings("serial")
	Map<Character, Integer> mapping = new HashMap<Character, Integer>(){
		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}
	};
	
	private static @SuppressWarnings("serial")
	TreeMap<Integer, String> mapping2 = new TreeMap<Integer, String>(){
		{
			put(1000, "M");
			put(900, "CM");
			put(500, "D");
			put(400, "CD");
			put(100, "C");
			put(90, "XC");
			put(50, "L");
			put(40, "XL");
			put(10, "X");
			put(9, "IX");
			put(5, "V");
			put(4, "IV");
			put(1, "I");
		}
	};
		
	public static int romanToInt(String roman){
		//Exception flag variant 1
		Integer exception = 0;
		Integer output = mapping.get(roman.charAt(roman.length() - 1));
		//From right to left
		for(int i = roman.length() - 2; i >= 0; --i){
			if(mapping.get(roman.charAt(i)) >= mapping.get(roman.charAt(i + 1))){
				output += mapping.get(roman.charAt(i));
				if(exception > 0)
					--exception;
			}
			else{
				output -= mapping.get(roman.charAt(i));
				++exception;
			}
			//Check exceptions
			if(exception > 1){
				return -1;
			}
		}
		
		return output;
	}

	//Variant 2
	public static String intToRoman(int n){
		if(n > 0){
			int l = mapping2.floorKey(n);
			return mapping2.get(l) + intToRoman(n - l);	
		}
		else
			return "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the mode number(0-Integer to Roman, 1-Roman to Ingeter): ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				Integer n = Integer.parseInt(reader.readLine());
				if(n > 0)
				{
					System.out.println("Enter the roman string n: ");
					//Roman to Integer
					String roman = reader.readLine();
					int result = romanToInt(roman);
					if(result != -1){
						System.out.println("The decimal value for " + roman + " is " + result);	
					}
					else
						System.out.println("The input is not a valid roman number ");
				}
				else{
					//Variant 2 Integer to Roman
					System.out.println("Enter the integer n: ");
					Integer integer = Integer.parseInt(reader.readLine());
				    System.out.println("The roman string for " + integer + " is " + intToRoman(integer));
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
