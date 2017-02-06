package hashTables;

import java.util.HashSet;
import java.util.Set;

import binaryTrees.BinaryTreeNode;

//Problem 13.4
public class LCA {
	
	public static BinaryTreeNode<Integer> computeLCA(BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1){
		//Only need the key
		Set<BinaryTreeNode<Integer>> nodeHash = new HashSet<>();
		while(node0 != null || node1 != null){
			if(!nodeHash.add(node0))
				return node0;
			node0 = node0.parent;
			
			if(!nodeHash.add(node1))
				return node1;
			node1 = node1.parent;
		}
		throw new IllegalArgumentException("The nodes are NOT in the same tree");
	}

}
