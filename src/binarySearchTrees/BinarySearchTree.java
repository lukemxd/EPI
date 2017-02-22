package binarySearchTrees;

import java.util.List;

//Problem 15.10
public class BinarySearchTree {
	
	public static class BSTNode<T> {
		
		/**********Properties**********/
		public T data;
		public BSTNode<T> left, right;
		
		
		/**********Constructors**********/
		public BSTNode (T d, BSTNode<T> l, BSTNode<T> r){
			this.data = d;
			this.left = l;
			this.right = r;
		}
	}
	
	public BSTNode<Integer> root = null;
	
	/**********Methods**********/
	//Search initially pass BinarySearchTree.root as first parameter
	public BSTNode<Integer> searchNode(BSTNode<Integer> tree, int key){
		if(tree == null || tree.data == key)
			return tree;
		return tree.data > key ? searchNode(tree.left, key) 
							   : searchNode(tree.right, key);
	}
	
	//Insertion
	public boolean insert(Integer key){
		if(root == null)
			root = new BSTNode<Integer>(key, null, null);
		else{
			BSTNode<Integer> current = root;
			BSTNode<Integer> parent = null;
			//Find the node with a sub left or right tree to insert the key
			while(current != null){
				parent = current;
				int res = Integer.compare(key, current.data);
				if(res == 0)
					return false; //duplicate
				else if(res < 0)
					current = current.left;
				else
					current = current.right;
			}
			//Compare key with the parent data
			if(Integer.compare(key, parent.data) > 0)
				parent.right = new BSTNode<Integer>(key, null, null);
			else
				parent.left = new BSTNode<Integer>(key, null, null);
		}
		return true;
	}
	
	//Deletion
	public boolean delete(Integer key){
		//Find the node to delete
		BSTNode<Integer> current = root, parent = null;
		while(current != null && Integer.compare(key, current.data) != 0){
			parent = current;
			current = Integer.compare(key, current.data) > 0 ? current.right : current.left;
		}
		//No node found
		if(current == null)
			return false;
		//Find the node and now delete
		BSTNode<Integer> nodeToDel = current;
		if(nodeToDel.right != null){
			//Find the minimum of the right subtree
			current = nodeToDel.right;
			parent = nodeToDel;
			while(current.left != null){
				parent = current;
				current = current.left;
			}
			nodeToDel.data = current.data;
			//Move the link
			if(parent.left == current)
				parent.left = current.right;
			else
				parent.right = current.right;
			//Delete the link to its right
			current.right = null;
		}else{
			//Update root if needed
			if(nodeToDel == root){
				root = nodeToDel.left;
			}else{
				if(parent.left == nodeToDel){
					parent.left = nodeToDel.left;
				}else if(parent.right == nodeToDel){
					parent.right = nodeToDel.left;
				}
			}
			//Delete the link to its left
			nodeToDel.left = null;	
		}
		return true;
	}

	//Display inorder traverse
	public void display(BSTNode<Integer> root, List<Integer> results){
		if(root != null){
			display(root.left, results);
			results.add(root.data);
			display(root.right, results);
		}
	}
	
	//Initialization
	public void initialization(List<Integer> input){
		for(Integer key : input)
			this.insert(key);
	}
}
