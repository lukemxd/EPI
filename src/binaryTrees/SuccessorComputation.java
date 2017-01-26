package binaryTrees;

public class SuccessorComputation {
	
	public static BinaryTreeNode<Integer> successorFinder(BinaryTreeNode<Integer> targetNode){
		
		BinaryTreeNode<Integer> current = targetNode;
		if(current == null)
			return null;
		//Non-empty right subtree
		if(current.right != null){
			current = current.right;
			while(current.left != null){
				current = current.left;
			}
			return current;
		}
		//Empty right subtree
		while(current.parent != null && current != current.parent.left){
			current = current.parent;
		}
		//Null if the target node is the rightmost node of the tree thus does not have a successor
		return current.parent; 
	}

}
