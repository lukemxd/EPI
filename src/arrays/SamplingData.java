package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

//Problem 6.11-6.13
public class SamplingData {
	
	//6.11
	public static List<Integer> samplingOfflineData(List<Integer> A, int k){
		
		Random random = new Random(); //random number generator
		
		//Optimization
		/*if(k > A.size() / 2){
			k = A.size() - k;
			for(int i = 0; i < k; ++i){
				int j = random.nextInt(A.size() - i);
				Collections.swap(A, i, i + j);
			}
			
			return A.subList(k, A.size());
		}*/
		//else{
			for(int i = 0; i < k; ++i){
				int j = random.nextInt(A.size() - i);
				Collections.swap(A, i, i + j);
			}
			
			return A.subList(0, k);	
		//}
	}
	
	//6.12
	public static List<Integer> samplingOnlineData(Iterator<Integer> A, int k){
		List<Integer> onlineSample = new ArrayList<>(k);
		for(int i = 0; i < k && A.hasNext(); ++i){
			onlineSample.add(A.next());
		}
		int numTotal = k;		
		Random random = new Random(); //random number generator
		while(A.hasNext()){
			++numTotal;
			int x = A.next();
			int next = random.nextInt(numTotal);
			if(next < k){
				onlineSample.set(next, x);
			}
		}

		return onlineSample;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 0;
		List<Integer> A = new ArrayList<Integer>();
		System.out.println("Enter the input set A: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				for(String s : reader.readLine().split("")){
					A.add(Integer.parseInt(s));	
				}
			}
			System.out.println("Enter the subset size k: ");
			reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				k = Integer.parseInt(reader.readLine());
			}
			
			System.out.println("The output subset is " + samplingOfflineData(A, k));
			//System.exit(0);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
