package binaryTrees;

public class BinaryTreeNode<T> {
	
	/**********Properties**********/
	public T data;
	public BinaryTreeNode<T> left, right, parent;
	public boolean balanced;
	public int height;
	
	/**********Constructors**********/
	public BinaryTreeNode (boolean balanced, int height){
		this.balanced = balanced;
		this.height = height; 
	}
	
	//Without parent
	public BinaryTreeNode (T d, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
		this.data = d;
		this.left = left;
		this.right = right;
	}
	
	//With parent
	public BinaryTreeNode (T d, BinaryTreeNode<T> left, BinaryTreeNode<T> right, BinaryTreeNode<T> parent){
		this.data = d;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	//Problem 10.2
	public static boolean isSymmetric(BinaryTreeNode<Integer> root){
		return checkSymmetry(root.left, root.right);  
	}
	
	private static boolean checkSymmetry(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right){
		if(left == null && right == null)
			return true;
		else if(left != null && right != null){
			return left.data == right.data && checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);
		}
		
		return false;
	}
	
}


