package binaryTrees;

import java.util.LinkedList;
import java.util.List;

//Problem 10.14
public class ListOfLeaves {

	public List<BinaryTreeNode<Integer>> create(BinaryTreeNode<Integer> root){
		List<BinaryTreeNode<Integer>> leaves = new LinkedList<>();
		addLeavesToList(root, leaves);
		return leaves;
	}
	
	private static void addLeavesToList(BinaryTreeNode<Integer> root, List<BinaryTreeNode<Integer>> leaves){
		BinaryTreeNode<Integer> current = root;
		if(current != null){
			if(current.left == null && current.right == null){
				//Find the leaf node
				leaves.add(current);
			}else{
				addLeavesToList(current.left, leaves);
				addLeavesToList(current.right, leaves);		
			}
		}
		
	}
}
