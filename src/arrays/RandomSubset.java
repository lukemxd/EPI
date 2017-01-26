package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//Problem 6.14
public class RandomSubset {
	
	public static List<Integer> randomSubset(int n, int k){
		Map<Integer, Integer> changedElements = new HashMap<>();
		Random random = new Random();
		for(int i = 0; i < k; ++i){
			int index = random.nextInt(n - i) + i;
			Integer num1 = changedElements.get(index);
			Integer num2 = changedElements.get(i);
			//Four conditions
			if(num1 == null && num2 == null){
				changedElements.put(i, index);
				changedElements.put(index, i);
			}
			else if(num1 == null && num2 != null){
				changedElements.put(i, index);
				changedElements.put(index, num2);
			}
			else if(num1 != null && num2 == null){
				changedElements.put(i, num1);
				changedElements.put(index, i);
			}
			else{
				changedElements.put(i, num1);
				changedElements.put(index, num2);
			}
		}
		
		List<Integer> output = new ArrayList<>(k);
		for(Integer integer : changedElements.values()){
			output.add(integer);
			if(output.size() == k)
				break;
		}
		
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0, k = 0;
		System.out.println("Enter the length of the input: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				n = Integer.parseInt(reader.readLine());
			}
			System.out.println("Enter the subset size k: ");
			reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				k = Integer.parseInt(reader.readLine());
			}
			
			System.out.println("The random subset is " + randomSubset(n, k));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
