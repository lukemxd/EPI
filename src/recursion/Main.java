package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	//16.1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		System.out.println("Please enter ring number: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				int NumStep = HanoiTower.runHanoiTowerSolver(Integer.parseInt(input));	
				System.out.println("Total step number is " + NumStep);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
