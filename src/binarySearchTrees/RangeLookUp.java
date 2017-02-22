package binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

import binarySearchTrees.BinarySearchTree.BSTNode;

//Problem 15.12
public class RangeLookUp {
	
	private static void rangeLookUpInBSTHelper(BSTNode<Integer> root, List<Integer> results, int left, int right){
		if(root == null)
			return;
		BSTNode<Integer> current = root;
		if(left <= current.data && current.data <= right){
			//node lies within the interval do inorder traverse 
			rangeLookUpInBSTHelper(current.left, results, left, right);
			results.add(current.data);
			rangeLookUpInBSTHelper(current.right, results, left, right);
		}else if(current.data < left)
			rangeLookUpInBSTHelper(current.right, results, left, right);
		else //current.data > right 
			rangeLookUpInBSTHelper(current.left, results, left, right);
	}
	
	public static List<Integer> rangeLookUpInBST(BSTNode<Integer> root, int left, int right){
		List<Integer> results = new ArrayList<>();
		rangeLookUpInBSTHelper(root, results, left, right);
		return results;
	}
}
