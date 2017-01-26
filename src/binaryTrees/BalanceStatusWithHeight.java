package binaryTrees;


//Problem 10.1
public class BalanceStatusWithHeight {
	
	public boolean balanced;
	public int height;
	public static int depth = 0; //variant 1
	
	public BalanceStatusWithHeight(boolean balanced, int height){
		this.balanced = balanced;
		this.height = height;
	}
	
	public static boolean isBalanced(BinaryTreeNode<Integer> root){
		return checkBalanced(root).balanced; 
	}
	
	//Recursion
	public static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> root){
		if(root == null)
			return new BalanceStatusWithHeight(true, -1);
		//left subtree
		BalanceStatusWithHeight leftResult = checkBalanced(root.left);
		if(!leftResult.balanced)
			return leftResult;
		//right subtree
		BalanceStatusWithHeight rightResult = checkBalanced(root.right);
		if(!rightResult.balanced)
			return rightResult;

		boolean isBalanced = Math.abs(leftResult.height - rightResult.height) > 1 ? false : true;
		int height = Math.max(leftResult.height, rightResult.height) + 1;
		return new BalanceStatusWithHeight(isBalanced, height);
	}
	
	//Variant 1
	public static int sizeOfSubtree(BinaryTreeNode<Integer> root){
		int result = depthOfSubtree(root);
		if(result != -1)
			return 2^(result + 1) - 1;
		else
			return 2^(depth + 1) - 1;
	}
	
	private static int depthOfSubtree(BinaryTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		int leftHeight = depthOfSubtree(root.left);
		int rightHeight = depthOfSubtree(root.right);
		
		if(leftHeight != -1 && rightHeight != -1 && leftHeight == rightHeight)
			return leftHeight + 1;
		if(leftHeight != -1 && rightHeight == -1){
			depth = Math.max(leftHeight, depth);
		}
		if(leftHeight == -1 && rightHeight != -1){
			depth = Math.max(rightHeight, depth);
		} 
		return -1; //not complete
	}
	
	//Variant 2
	public static BinaryTreeNode<Integer> checkKBalanced(BinaryTreeNode<Integer> root, int k){
		if(root == null)
			return new BinaryTreeNode<Integer>(true, -1); 
		//left subtree
		BinaryTreeNode<Integer> leftResult = checkKBalanced(root.left, k);
		if(!leftResult.balanced)
			return leftResult;
		//right subtree
		BinaryTreeNode<Integer> rightResult = checkKBalanced(root.right, k);
		if(!rightResult.balanced)
			return rightResult;

		boolean isBalanced = Math.abs(leftResult.height - rightResult.height) >= k ? false : true;
		int height = Math.max(leftResult.height, rightResult.height) + 1;
		return new BinaryTreeNode<Integer>(isBalanced, height);
	}
	
}
