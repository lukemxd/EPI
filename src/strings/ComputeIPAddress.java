package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Problem 7.10
public class ComputeIPAddress {
	
	private static boolean isValidPart(String s){
		int value = Integer.parseInt(s);
		if(s.length() > 3){
			return false;
		}
		if(s.startsWith("0") && s.length() > 1){
			return false;
		}
		if(value > 255 || value < 0){
			return false;
		}
		return true;
	}
	
	public static  List<String> getAllIPs(String s){
		List<String> IPAddresses = new ArrayList<>();
		//first period
		for(int i = 1; i < s.length() - 2 && i < 4; ++i){
			String first = s.substring(0, i);
			if(isValidPart(first)){
				//second period
				for(int j = i + 1; j < s.length() - 1 && j < i + 4; ++j){
					String second = s.substring(i, j);
					if(isValidPart(second)){
						//third and fourth period
						for(int k = j + 1; k < s.length() && k < j + 4; ++k){
							String third = s.substring(j, k);
							String fourth = s.substring(k, s.length());
							if(isValidPart(third) && isValidPart(fourth)){
								String IPAddress = first + "." + second + "." + third + "." + fourth;
								IPAddresses.add(IPAddress);
							}
						}
					}
				}
			}
		}
		return IPAddresses;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		
		System.out.println("Enter the input decimal string: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				List<String> results = getAllIPs(input);
				System.out.println("All the valid IP addresses are " + results);
				System.out.println("The total number is " + results.size());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
