package binaryTrees;

//Problem 10.17
public class BinaryTreeNodeWithLock {
	
	public BinaryTreeNodeWithLock left, right, parent;
	public boolean isLocked = false;
	private int numOfLcokedDescendants = 0;
	
	//Check if locked
	public boolean isLocked(){
		return isLocked;
	}
	
	//Lock the node
	public boolean lock(){
		//Check descendants
		if(numOfLcokedDescendants > 0 || isLocked)
			return false;
		//Check ancestors
		for(BinaryTreeNodeWithLock node = parent; node != null; node = node.parent){
			if(node.isLocked)
				return false;
		}
		
		//Lock the node and increase the numOfLockedDescendents for its ancestors
		for(BinaryTreeNodeWithLock node = parent; node != null; node = node.parent){
			++node.numOfLcokedDescendants;
		}
		isLocked = true;
		return true;		
	}
	
	//Unlock the node
	public void unlock(){
		if(isLocked)
		{
			isLocked = false;
			for(BinaryTreeNodeWithLock node = parent; node != null; node = node.parent){
				--node.numOfLcokedDescendants;
			}	
		}
	}
}
