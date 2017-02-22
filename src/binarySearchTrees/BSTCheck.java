package binarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

import binarySearchTrees.BinarySearchTree.BSTNode;
import binaryTrees.BinaryTreeNode;

//Problem 15.1, 15.11
public class BSTCheck {
	
	//15.1
	//Recursion
	public static boolean isBST(BinaryTreeNode<Integer> root, int lower, int upper){
		//lower is MIN_VALUE and upper is MAX_VALUE when initially called
		if(root == null)
			return true;
		else if(Integer.compare(root.data, lower) < 0
				|| Integer.compare(root.data, upper) > 0)
			return false;
		
		return isBST(root.left, lower, root.data) 
			&& isBST(root.right, root.data, upper); 
	}
	
	//BFS
	public static class QueueEntry{
		public BinaryTreeNode<Integer> node;
		public Integer lower, upper;
		
		public QueueEntry(BinaryTreeNode<Integer> node, Integer l, Integer u){
			this.node = node;
			this.lower = l;
			this.upper = u;
		}
	}
	
	public static boolean isBSTByBFS(BinaryTreeNode<Integer> root){
		Queue<QueueEntry> BFSQueue = new LinkedList<>();
		//Enqueue the root node with MIN_VALUE and MAX_VALUE
		BFSQueue.add(new QueueEntry(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		QueueEntry headEntry;
		while((headEntry = BFSQueue.poll()) != null){
			if(headEntry != null){
				if(Integer.compare(headEntry.node.data, headEntry.lower) < 0
				   || Integer.compare(headEntry.node.data, headEntry.upper) > 0)
					return false;
				//Enqueue the root's left and right child
				BFSQueue.add(new QueueEntry(headEntry.node.left, 
											headEntry.lower, 
											headEntry.node.data));
				BFSQueue.add(new QueueEntry(headEntry.node.right, 
											headEntry.node.data, 
											headEntry.upper));
			}
		}
		return true;
	}


	//15.11
	private static boolean searchPath(BSTNode<Integer> from, BSTNode<Integer> target){
		while(from != null && from != target){
			from = Integer.compare(from.data, target.data) > 0 ? from.left : from.right;
		}
		return from == target;
	}
	
	public static boolean canFindPathToMiddleFromPairs(BSTNode<Integer> candidate0, BSTNode<Integer> candidate1, BSTNode<Integer> middle){
		BSTNode<Integer> search0 = candidate0, search1 = candidate1;
		//Perform interleaved searching for middle from both candidates
		while(search0 != candidate1 && search0 != middle && 
			  search1 != candidate0 && search1 != middle &&
			  (search0 != null || search1 != null)){
			if(search0 != null)
				search0 = Integer.compare(search0.data, middle.data) > 0 ? search0.left : search0.right;
			if(search1 != null)
				search1 = Integer.compare(search1.data, middle.data) > 0 ? search1.left : search1.right;
		}
		//Failed to find the links to middle from both candidates
		if(search0 == candidate1 || search1 == candidate0 || 
		   (search0 != middle && search1 != middle))
			return false;
		//Found the link to middle from either candidate 
		//then find the link from middle to the other candidate 
		return search0 == middle ? searchPath(middle, search1) : searchPath(middle, search0);	
	}
}
