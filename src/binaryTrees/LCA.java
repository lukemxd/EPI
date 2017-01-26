package binaryTrees;


public class LCA {
	
	public int numOfNodes;
	public BinaryTreeNode<Integer> ancestor;
	
	public LCA(int num, BinaryTreeNode<Integer> node){
		this.numOfNodes = num;
		this.ancestor = node;
	}
	
	//Problem 10.3
	public static BinaryTreeNode<Integer> LCAWithoutParent(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1){
		return LCAFinder(root, node0, node1).ancestor;
	}
	
	private static LCA LCAFinder(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1){
		if(root == null)
			return new LCA(0, null);
		
		LCA leftResult = LCAFinder(root.left, node0, node1);
		if(leftResult.numOfNodes == 2)
			return leftResult;
		
		LCA rightResult = LCAFinder(root.right, node0, node1);
		if(rightResult.numOfNodes == 2)
			return rightResult;
		
		int num = leftResult.numOfNodes + rightResult.numOfNodes + (root == node0 ? 1 : 0) + (root == node1 ? 1 : 0);
		return new LCA(num, num == 2 ? root : null);
	}
	
	//Problem 10.4
	public static BinaryTreeNode<Integer> LCAWithParent(BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1){
		int depth0 = getDepth(node0), depth1 = getDepth(node1);
		//Compare the depths if not same makes node0 as the deeper node 
		if(depth1 > depth0){
			BinaryTreeNode<Integer> temp = node0;
			node0 = node1;
			node1 = temp;	
		}
		//Calculate the depth difference
		int depDiff = Math.abs(depth0 - depth1);
		while(depDiff-- > 0){
			node0 = node0.parent;
		}
		//Move in tandem
		while(node0 != node1){
			node0 = node0.parent;
			node1 = node1.parent;
		}
		
		return node0;
	}
	
	private static int getDepth(BinaryTreeNode<Integer> node){
		int depth = 0;
		while(node.parent != null){
			node = node.parent;
			++depth;
		}
		return depth;
	}

}
