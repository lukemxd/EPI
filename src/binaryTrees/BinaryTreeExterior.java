package binaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem 10.15
public class BinaryTreeExterior {

	public static List<BinaryTreeNode<Integer>> computeExterior(BinaryTreeNode<Integer> root){
		List<BinaryTreeNode<Integer>> exterior = new ArrayList<>();
		if(root != null){
			exterior.add(root);
			//Add all the leftmost nodes and left subtree leaves
			exterior.addAll(leftNodesAndLeaves(root.left, true));
			//Add all the right subtree leaves and rightmost nodes
			List<BinaryTreeNode<Integer>> rightBoundary = rightLeavesAndNodes(root.right, true);
			exterior.addAll(rightBoundary);
			
			Collections.reverse(rightBoundary);
			//exterior.addAll(rightBoundary);
		}
		return exterior;
	}
	
	private static List<BinaryTreeNode<Integer>> leftNodesAndLeaves(BinaryTreeNode<Integer> subRoot, boolean isBoundary){
		List<BinaryTreeNode<Integer>> leftBoundary = new ArrayList<>();
		if(subRoot != null){
			//Add to the list if either it is a boundary node or leaf
			if(isBoundary || isLeaf(subRoot))
				leftBoundary.add(subRoot);
			else{
				leftBoundary.addAll(leftNodesAndLeaves(subRoot.left, isBoundary));
				leftBoundary.addAll(leftNodesAndLeaves(subRoot.right, isBoundary && subRoot.left == null));
			}
		}		
		return leftBoundary;
	}
	
	private static List<BinaryTreeNode<Integer>> rightLeavesAndNodes(BinaryTreeNode<Integer> subRoot, boolean isBoundary){
		List<BinaryTreeNode<Integer>> rightBoundary = new ArrayList<>();
		if(subRoot != null){
			//Add to the list if either it is a boundary node or leaf
			rightBoundary.addAll(rightLeavesAndNodes(subRoot.left, isBoundary && subRoot.right == null));
			rightBoundary.addAll(rightLeavesAndNodes(subRoot.right, isBoundary));
			if(isBoundary || isLeaf(subRoot))
				rightBoundary.add(subRoot);
			/*
			//Reverse the result before adding to the final result
			if(isBoundary || isLeaf(subRoot))
				rightBoundary.add(subRoot);
			rightBoundary.addAll(rightLeavesAndNodes(subRoot.left, isBoundary && subRoot.right == null));
			rightBoundary.addAll(rightLeavesAndNodes(subRoot.right, isBoundary));
			*/
		}
		return rightBoundary;
	}
	
	private static boolean isLeaf(BinaryTreeNode<Integer> node){
		return node.left == null && node.right == null;
	}
}
