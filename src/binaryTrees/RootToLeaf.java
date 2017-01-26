package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {
	
	//Problem 10.5
	public static int sumRootToLeaf(BinaryTreeNode<Integer> root, int partialSum){
		if(root == null)
			return 0;
		
		partialSum = partialSum * 2 + root.data;
		//Leaf
		if(root.left == null && root.right == null)
			return partialSum;
		//Non-leaf
		int leftResult = sumRootToLeaf(root.left, partialSum);
		int rightResult = sumRootToLeaf(root.right, partialSum);
		
		return leftResult + rightResult;
	}
	
	//Problem 10.6
	public static boolean hasPathWeightNode(BinaryTreeNode<Integer> root, int partialWeight, int targetWeight){
		if(root == null)
			return false;
		
		partialWeight += root.data;
		//Leaf
		if(root.left == null && root.right == null)
			return partialWeight == targetWeight;
		//Non-leaf
		return hasPathWeightNode(root.left, partialWeight, targetWeight) || hasPathWeightNode(root.right, partialWeight, targetWeight);
	}
	
	//Variant 1
	public static List<linkedLists.ListNode<Integer>> pathNodesWithWeight(BinaryTreeNode<Integer> root, int targetWeight){
		List<linkedLists.ListNode<Integer>> results = new ArrayList<>();
		pathNodesWithWeightFinder(root, 0, targetWeight, results, new linkedLists.ListNode<Integer>(0, null));
		return results;
	}
	
	private static void pathNodesWithWeightFinder(BinaryTreeNode<Integer> root, int partialWeight, int targetWeight, List<linkedLists.ListNode<Integer>> results, linkedLists.ListNode<Integer> temp){
		
		if(root == null)
			return;
		
		partialWeight += root.data;
		temp.next = new linkedLists.ListNode<Integer>(root.data, null);
		temp = temp.next;
		//Leaf
		if(root.left == null && root.right == null){
			if(partialWeight == targetWeight){
				results.add(temp);
				//temp = new ListNode<Integer>(0, null);
			}
		}	
		//Non-leaf
		pathNodesWithWeightFinder(root.left, partialWeight, targetWeight, results, temp);
		pathNodesWithWeightFinder(root.right, partialWeight, targetWeight, results, temp);
	}
}
