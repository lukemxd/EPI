package stacksAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

	//9.1
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] pushElements;
		Stack s = new Stack();
		System.out.println("Enter the input elements: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				pushElements = reader.readLine().split("");
				System.out.println("Stack Top / Max / Max Count");
				System.out.println("Pushing...");
				for(String i : pushElements){
					s.Push(Integer.parseInt(i));
					System.out.println(s.Peek() + " / " + s.Max() + " / " + s.MaxCount());
				}
				System.out.println("Poping...");
				for(int j = 0; j < 4; ++j){
					s.Pop();
					System.out.println(s.Peek() + " / " + s.Max() + " / " + s.MaxCount());
				}
			}
		}
		catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}*/
	
	//9.2
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String RPNExpression;
		System.out.println("Enter the RPN expression delimitted by comma: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				RPNExpression = reader.readLine();
				System.out.println("The RPN expression is " + RPNExpression.replace(',', ' '));
				System.out.println("Evaluating...");
				System.out.println(RPN.Evaluate(RPNExpression));
			}
		}
		catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}*/
	
	//9.3
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		System.out.println("Enter the input characters: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				System.out.println("The input string is " + input);
				if(FormatTester.isWellFormed(input))
					System.out.println("The string is well-formed.");	
				else
					System.out.println("The string is NOT well-formed.");	
			}
		}
		catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}*/
	
	//9.4
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		System.out.println("Enter the path that you want to normalize: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine();
				System.out.println("The input path is " + input);
				System.out.println("Normalizing...");
				System.out.println("The normalized path is" + Normalizer.pathNormalize(input));	
			}
		}
		catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}*/
	
	//9.6
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Enter the input building heights: (east to west)");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				List<BuildingWithHeight> buildings = new ArrayList<>();
				input = reader.readLine().split("");
				System.out.println("The buildings height are ");
				for(int i = 0; i < input.length; i++){
					BuildingWithHeight building = new BuildingWithHeight(i, Integer.parseInt(input[i]));
					buildings.add(building);
					System.out.print(building.height + " ");
				}
				System.out.println();
				System.out.println("The buildings with sunset view are ");
				Deque<BuildingWithHeight> results = BuildingWithHeight.BuildingHeightExamination(buildings);
				while(!results.isEmpty()){
					System.out.print(results.removeLast().height + " ");	
				}
			}
		}
		catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
