package binaryTrees;

import linkedLists.ListNode;

//Problem 10.14
public class ListOfLeaves {

	public ListNode<BinaryTreeNode<Integer>> create(BinaryTreeNode<Integer> root){
		ListNode<BinaryTreeNode<Integer>> leaves = new ListNode<>(null, null);
		addLeavesToList(root, leaves);
		return leaves;
	}
	
	private static void addLeavesToList(BinaryTreeNode<Integer> root, ListNode<BinaryTreeNode<Integer>> leaves){
		BinaryTreeNode<Integer> current = root;
		if(current != null){
			if(current.left == null && current.right == null){
				//Find the leaf node
				leaves.next = new ListNode<BinaryTreeNode<Integer>>(current, null);
			}else{
				addLeavesToList(current.left, leaves.next);
				addLeavesToList(current.right, leaves.next);		
			}
		}
		
	}
}
