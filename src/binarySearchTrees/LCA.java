package binarySearchTrees;

import binarySearchTrees.BinarySearchTree.BSTNode;

//Problem 15.4
public class LCA {
	
	public static BSTNode<Integer> computeLCA(BSTNode<Integer> root, BSTNode<Integer> a, BSTNode<Integer> b){
		BSTNode<Integer> LCA = root;
		//Assume a has the smaller key than b
		//LCA is in root's left or right subtree
		if(b.data < LCA.data || a.data > LCA.data){
			//LCA is in left subtree
			while(b.data < LCA.data)
				LCA = LCA.left;
			//LCA is in right subtree
			while(a.data > LCA.data)
				LCA = LCA.right;
		}
		//If while() is skipped then root must be the LCA
		return LCA;
	}
}
