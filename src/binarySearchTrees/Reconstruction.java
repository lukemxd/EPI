package binarySearchTrees;

import java.util.List;

import binarySearchTrees.BinarySearchTree.BSTNode;

//Problem 15.5, 15.9
public class Reconstruction {
	
	//15.5
	private static Integer rootIdx;
	
	public static BSTNode<Integer> reconstructFromPreorder(List<Integer> keys){
		rootIdx = 0; //rootIdx = keys.size() - 1 if postorder
		return reconstructFromPreorderHelper(keys, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	
	private static BSTNode<Integer> reconstructFromPreorderHelper(List<Integer> keys,
			Integer lower, Integer upper){
		if(rootIdx == keys.size()) //rootIdx == 0 if postorder
			return null;
		Integer root = keys.get(rootIdx);
		//Violate the value constraints
		if(root < lower || root > upper)
			return null;
		++rootIdx; //--rootIdx if postorder
		//Since reconstructFromPreorderHelper updates the rootIdx
		//so need to make sure the order of the subsequent calls
		return new BSTNode<Integer>(root, 
									reconstructFromPreorderHelper(keys, lower, root),
									reconstructFromPreorderHelper(keys, root, upper));
	}

	
	//15.9
	public static BSTNode<Integer> reconstructMinHeightBST(List<Integer> input){
		return reconstructMinHeightBSTHelper(input, 0, input.size());
	}
	
	private static BSTNode<Integer> reconstructMinHeightBSTHelper(List<Integer> input, int start, int end){
		if(start >= end)
			return null;
		int mid = start + ((end - start) / 2); 
		return new BSTNode<Integer>(input.get(mid), 
									reconstructMinHeightBSTHelper(input, start, mid), 
									reconstructMinHeightBSTHelper(input, mid + 1, end));
	}
}
