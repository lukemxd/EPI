package binaryTrees;

//Problem 10.16
public class SiblingTreeComputation {
	
	public static void siblingBuilder(BinaryTreeNode<Integer> root){
		BinaryTreeNode<Integer> current = root;
		//Perfect binary tree
		while(current.left != null && current.right != null){
			lowerLevelSiblingFinder(current);
			current = current.left;
		}
	}
	
	//Finder the sibling nodes level by level
	private static void lowerLevelSiblingFinder(BinaryTreeNode<Integer> leftStart){
		BinaryTreeNode<Integer> current = leftStart;
		while(current != null){
			current.left.next = current.right;
			if(current.next != null){
				current.right.next = current.next.left;
			}
			current = current.next;
		}
	}
	
	
	//Variant 1 
	public static void siblingBuilderV1(BinaryTreeNode<Integer> root){
		BinaryTreeNode<Integer> leftStart = root;
		//General binary tree
		while(leftStart.left != null || leftStart.right != null){
			lowerLevelSiblingFinderV1(leftStart);
			if(leftStart.left != null)
				leftStart = leftStart.left;
			else if(leftStart.right != null)
				leftStart = leftStart.right;
		}
	}
	
	private static void lowerLevelSiblingFinderV1(BinaryTreeNode<Integer> leftStart){
		BinaryTreeNode<Integer> current = leftStart;
		while(current != null){
			if(current.left != null && current.right != null){
				current.left.next = current.right;
				if(current.next != null){
					if(current.next.left != null)
						current.right.next = current.next.left;
					else if(current.next.right != null)
						current.right.next = current.next.right;
				}
			}
			else if(current.left != null && current.right == null){
				if(current.next != null){
					if(current.next.left != null)
						current.left.next = current.next.left;
					else if(current.next.right != null)
						current.left.next = current.next.right;
				}	
			}
			else if(current.left == null && current.right != null){
				if(current.next != null){
					if(current.next.left != null)
						current.right.next = current.next.left;
					else if(current.next.right != null)
						current.right.next = current.next.right;
				}
			}
			current = current.next;
		}
	}
}
