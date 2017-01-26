package binaryTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static BinaryTreeNode<Integer> createBinaryTree(List<Integer> nodes){
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(nodes.get(0), null, null);
		nodes.remove(0);
		//BinaryTreeNode<Integer> current = root;
		while(!nodes.isEmpty()){

		}
		
		return root;
	}
	
	//10.1
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		List<Integer> nodes = new ArrayList<>();
		System.out.println("Enter the binary tree node values in preorder: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				int[] input = Stream.of(reader.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
				for(int i : input){
					nodes.add(i);
				}
				BinaryTreeNode<Integer> root = createBinaryTree(nodes);
				if(BalanceStatusWithHeight.isBalanced(root)){
					System.out.println("The input binary is height balanced.");	
				}
				else
					System.out.println("The input binary is NOT height balanced.");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
