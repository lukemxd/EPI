package binaryTrees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Problem 10.7-10.9
public class Traversal {
	
	public static List<Integer> results = new ArrayList<>();
	
	/******Preorder******/
	//Recursion
	public static void preOrderRecursion(BinaryTreeNode<Integer> root){
		if(root != null){
			results.add(root.data);
			preOrderRecursion(root.left);
			preOrderRecursion(root.right);
		}
	}
	
	//Iteration
	public static void preOrderIteration(BinaryTreeNode<Integer> root){
		Deque<BinaryTreeNode<Integer>> s = new LinkedList<>();
		if(root != null)
			s.addFirst(root);
		
		while(!s.isEmpty()){
			BinaryTreeNode<Integer> current = s.removeFirst();
			if(current != null){
				results.add(current.data);
				if(current.right != null)
					s.addFirst(current.right);
				if(current.left != null)
					s.addFirst(current.left);
			}
		}
		
	}
	
	/******Inorder******/
	//Recursion
	public static void inOrderRecursion(BinaryTreeNode<Integer> root){
		if(root != null){
			preOrderRecursion(root.left);
			results.add(root.data);
			preOrderRecursion(root.right);
		}
	}
	
	//Iteration
	public static void inOrderIteration(BinaryTreeNode<Integer> root){
		Deque<BinaryTreeNode<Integer>> s = new LinkedList<>();
		BinaryTreeNode<Integer> current = root;
		while(!s.isEmpty() || current != null){
			if(current != null){
				s.addFirst(current);
				current = current.left;	
			}
			else{
				current = s.removeFirst();
				results.add(current.data);
				current = current.right;
			}
		}
	}	
	
	//Problem 10.11 O(1)
	public static void inOrderIterationWithParent(BinaryTreeNode<Integer> root){
		BinaryTreeNode<Integer> current = root;
		/*if(current != null && !results.contains(current.data)){
			while(current.left != null){
				current = current.left;
			}
			results.add(current.data);
			//Write the data if it is NOT the right subtree of its parent
			if(current != current.parent.right){
				results.add(current.parent.data);
				current = current.parent;
			}
			else
				current = current.parent.parent;
			if(current.right != null){
				current = current.right;
			}
		}*/
		BinaryTreeNode<Integer> prev = null;
		while(current != null){
			BinaryTreeNode<Integer> next;
			if(current.parent == prev){
				//Going to leftmost
				if(current.left != null){
					next = current.left;
				}else{
					//Leftmost
					results.add(current.data);
					next = current.right == null ? current.parent : current.right;
				}
			}
			//Left subtree is traversed
			else if(current.left == prev){
				results.add(current.data);
				next = current.right == null ? current.parent : current.right;
			}
			else{
				//Both children are traversed
				next = current.parent;
			}
			
			prev = current;
			current = next;
		}
	}
	
	//Reuse 10.10 for 10.11
	public static void inOrderIterationWithSuccessor(BinaryTreeNode<Integer> root){
		BinaryTreeNode<Integer> current = root;
		if(current != null){
			//Find the leftmost node
			while(current.left != null){
				current = current.left;
			}	
			while(current != null){
				results.add(current.data);
				//10.10
				current = SuccessorComputation.successorFinder(current);
			}
		}
		
	}
	
	//Problem 10.9
	public static BinaryTreeNode<Integer> getKthNode(BinaryTreeNode<Integer> root, int k){
		BinaryTreeNode<Integer> current = root;
		while(current != null){
			//Test which subtree is k in
			int leftSize = current.left != null ? current.left.data : 0;
			if(leftSize > k - 1){
				//Left subtree
				current = current.left;
			}
			else if(leftSize < k - 1){
				current = current.right;
				k = k - leftSize - 1;
			}
			else{
				return current;
			}
		}
		//If k > tree size or < 1
		return null;
	}
	
	/******Postorder******/
	//Recursion
	public static void postOrderRecursion(BinaryTreeNode<Integer> root){
		if(root != null){
			preOrderRecursion(root.left);
			preOrderRecursion(root.right);
			results.add(root.data);
		}
	}	
	
	//Iteration using 2 stacks
	public static void postOrderIterationWithTwoStacks(BinaryTreeNode<Integer> root){
		Deque<BinaryTreeNode<Integer>> inS = new LinkedList<>();
		Deque<BinaryTreeNode<Integer>> outS = new LinkedList<>();
		if(root != null)
			inS.addFirst(root);
		while(!inS.isEmpty()){
			BinaryTreeNode<Integer> current = inS.removeFirst();
			outS.addFirst(current);
			if(current.left != null)
				inS.addFirst(current.left);
			if(current.right != null)
				inS.addFirst(current.right);
		}
	
		while(!outS.isEmpty()){
			results.add(outS.removeFirst().data);
		}
	}
}
