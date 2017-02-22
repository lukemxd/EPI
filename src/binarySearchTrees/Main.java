package binarySearchTrees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	//Default array for tree initialization
	private static Integer[] array = new Integer[]{2, 5, 13, 31, 41, 53, 47, 37, 29, 17, 3, 11, 23, 43, 19, 7};

	//15.6
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the sorted arrays delimited by comma: ");
	
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(",");
				List<List<Integer>> inputArrays = new ArrayList<>();
				for(String s : input){
					String[] array = s.split(" ");
					List<Integer> sortedArray = new ArrayList<>();
					for(String str : array){
						sortedArray.add(Integer.parseInt(str));
					}
					inputArrays.add(sortedArray);
				}
				System.out.println("The minimum distance is " + ClosestSortedArrayEntries.findMinDisSortedArrays(inputArrays));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//15.8
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the pages delimited by space: ");
	
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<String> inputArrays = Arrays.asList(input);
				System.out.println("Please enter the number of k: ");
				int k = Integer.parseInt(reader.readLine());
				System.out.println("The most visited page is " + TopK.findKMostUsed(inputArrays, k));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//15.10
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		List<Integer> results = new ArrayList<>();
		BinarySearchTree tree = new BinarySearchTree();
		System.out.println("Please enter the numbers to insert delimtted by space: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<Integer> inputArray = new ArrayList<>();
				for(String s : input){
					inputArray.add(Integer.parseInt(s));
				}
				tree.initialization(inputArray);
				tree.display(tree.root, results);
				System.out.println("The BST is " + results);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//15.12
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		BinarySearchTree tree = new BinarySearchTree();
		tree.initialization(Arrays.asList(array));
		System.out.println("Please enter the left and right limit if the interval delimtted by space: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				int left = Integer.parseInt(input[0]);
				int right = Integer.parseInt(input[1]);
				List<Integer> results = RangeLookUp.rangeLookUpInBST(tree.root, left, right);
				System.out.println("All the nodes lie in the interval are " + results);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
