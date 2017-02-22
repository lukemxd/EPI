package binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

import binarySearchTrees.BinarySearchTree.BSTNode;

//Problem 15.2, 15.3
public class BSTSearching {

	//15.2
	public static BSTNode<Integer> findFirstGreaterNode(BSTNode<Integer> root, Integer key){
		BSTNode<Integer> current = root, firstSoFar = null;
		while(current != null){
			if(current.data > key){
				firstSoFar = current;
				current = current.left;
			}else //Ignore the smaller nodes than key and go the right child
				current = current.right;
		}
		return firstSoFar;
	}
	
	//Variant
	public static BSTNode<Integer> findFirstEqualNode(BSTNode<Integer> root, Integer key){
		BSTNode<Integer> current = root, firstSoFar = null;
		while(current != null){
			if(current.data > key)
				current = current.left;
			else if(current.data < key){
				if(firstSoFar != null && firstSoFar.data == key)
					return firstSoFar;
				current = current.right;
			}
			else{//current.data == key, since inorder so check its left child
				firstSoFar = current;
				current = current.left;
			}
		}
		//No node found
		return firstSoFar;
	}


	//15.3
	public static List<BSTNode<Integer>> findKLargests(BSTNode<Integer> root, int k){
		List<BSTNode<Integer>> results = new ArrayList<>();
		findKLargestsHelper(root, k, results);
		return results;
	}
	
	private static void findKLargestsHelper(BSTNode<Integer> root, int k, List<BSTNode<Integer>> results){
		//Perform reverse inorder traverse
		if(root != null && results.size() != k){
			findKLargestsHelper(root.right, k, results);
			if(results.size() < k){
				results.add(root);
				findKLargestsHelper(root.left, k, results);
			}
		}
	}
}
