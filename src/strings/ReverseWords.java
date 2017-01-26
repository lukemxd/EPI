package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Problem 7.6
public class ReverseWords {
	
	//Find the end index of each word
	private static int find(char[] s, char x, int startIdx){
		for(int i = startIdx; i < s.length; ++i){
			if(s[i] == x)
				return i;
		}
		
		return s.length; 
	}

	private static void reverseWords(char[] s, int startIdx, int endIdx){
		int i = startIdx, j = endIdx;
		char temp = ' ';
		//Reverse each of the chars
		while(i < j){
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			++i;
			--j;
		}
	}
	
	public static void reverseChars(char[] s){
		//Reverse each of the chars
		reverseWords(s, 0, s.length - 1);
		
		int startIdx = 0, endIdx;
		//Reverse each of the words		
		while((endIdx = find(s, ' ', startIdx)) != -1){
			reverseWords(s, startIdx, endIdx - 1);
			if(endIdx == s.length)
			{
				break;
			}
			else
				startIdx = endIdx + 1;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input = null;
		
		System.out.println("Enter the input string: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().toCharArray();
				reverseChars(input);
				StringBuilder output = new StringBuilder();
				for(char c : input){
					output.append(c);
				}
				System.out.println("The reversed string is " + output.toString());	
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
