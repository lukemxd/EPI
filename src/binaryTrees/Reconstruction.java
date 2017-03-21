package binaryTrees;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem 10.12-10.13
public class Reconstruction {
	
	//Problem 10.12
	public static BinaryTreeNode<Integer> createBinaryTreeFromPreInorder(List<Integer> preorder, List<Integer> inorder){
		Map<Integer, Integer> indexOfInorderNode = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.size(); ++i ){
			indexOfInorderNode.put(inorder.get(i), i);
		}
		
		return binaryTreeFromPreInorderHelper(preorder, 0, preorder.size(), 0, inorder.size(), indexOfInorderNode);
	}
	
	private static BinaryTreeNode<Integer> binaryTreeFromPreInorderHelper(List<Integer> preorder, 
			int preorderStart, int preorderEnd, int inorderStart, int inorderEnd, Map<Integer, Integer> indexOfInorderNode){
		
		if(preorderStart >= preorderEnd || inorderStart >= inorderEnd)
			return null;
		
		int rootInorderIndex = indexOfInorderNode.get(preorder.get(preorderStart));
		int leftSubtreeSize = rootInorderIndex - inorderStart;
		
		return new BinaryTreeNode<Integer>(preorder.get(preorderStart), 
				//Recursively build left subtree
				binaryTreeFromPreInorderHelper(preorder, preorderStart + 1, preorderStart + 1 + leftSubtreeSize, inorderStart, rootInorderIndex, indexOfInorderNode), 
				//Recursively build right subtree
				binaryTreeFromPreInorderHelper(preorder, preorderStart + 1 + leftSubtreeSize, preorderEnd, rootInorderIndex + 1, inorderEnd, indexOfInorderNode));
	}
	
	
	
	
	//Variant 1
	public static BinaryTreeNode<Integer> createBinaryTreeFromPostInorder(List<Integer> postorder, List<Integer> inorder){
		Map<Integer, Integer> indexOfInorderNode = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.size(); ++i ){
			indexOfInorderNode.put(inorder.get(i), i);
		}
		
		return binaryTreeFromPostInorderHelper(postorder, 0, postorder.size(), 0, inorder.size(), indexOfInorderNode);
	}
	
	private static BinaryTreeNode<Integer> binaryTreeFromPostInorderHelper(List<Integer> postorder, 
			int postorderStart, int postorderEnd, int inorderStart, int inorderEnd, Map<Integer, Integer> indexOfInorderNode){
	
		if(postorderStart >= postorderEnd || inorderStart >= inorderEnd)
			return null;
		
		int rootInorderIndex = indexOfInorderNode.get(postorderEnd);
		int leftSubtreeSize = rootInorderIndex - inorderStart;
		
		return new BinaryTreeNode<Integer>(postorder.get(postorderEnd), 
				binaryTreeFromPreInorderHelper(postorder, postorderStart, postorderStart + leftSubtreeSize, inorderStart, rootInorderIndex, indexOfInorderNode), 
				binaryTreeFromPreInorderHelper(postorder, postorderStart + leftSubtreeSize, postorderEnd - 1, rootInorderIndex + 1, inorderEnd, indexOfInorderNode));
	}
	
	
	
	
	
	//Variant 2
	public static BinaryTreeNode<Integer> createBinaryFromList(List<Integer> nodes){
		Map<Integer, Integer> indexOfNode = new HashMap<Integer, Integer>();
		for(int i = 0; i < nodes.size(); ++i ){
			indexOfNode.put(nodes.get(i), i);
		}	
		
		return binaryTreeFromNodesHelper(nodes, 0, nodes.size(), indexOfNode); 
	}
	
	private static BinaryTreeNode<Integer> binaryTreeFromNodesHelper(List<Integer> nodes, int startIndex, int endIndex, Map<Integer, Integer> indexOfNode){
		
		if(startIndex >= endIndex)
			return null;
		
		int max = Collections.max(nodes.subList(startIndex, endIndex)); //Find the max number
		int rootIndex = indexOfNode.get(max);
		
		return new BinaryTreeNode<Integer>(max, 
				binaryTreeFromNodesHelper(nodes, startIndex, rootIndex, indexOfNode), 
				binaryTreeFromNodesHelper(nodes, rootIndex + 1, endIndex, indexOfNode));
	}




	//Problem 10.13
	public static BinaryTreeNode<Integer> binaryTreeFromNullNode(List<Integer> nodes){
		int subtreeIndex = 0;
		return binaryTreeFromNullNodeHelper(nodes, subtreeIndex);
	}
	
	private static BinaryTreeNode<Integer> binaryTreeFromNullNodeHelper(List<Integer> nodes, int subtreeIndex){
		
		Integer nodeKey = nodes.get(subtreeIndex);
		subtreeIndex++;
		if(nodeKey == null)
			return null;
		
		return new BinaryTreeNode<Integer>(nodeKey, 
				binaryTreeFromNullNodeHelper(nodes, subtreeIndex), 
				binaryTreeFromNullNodeHelper(nodes, subtreeIndex));
	}

}
