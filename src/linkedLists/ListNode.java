package linkedLists;

public class ListNode<T> {
	
	/**********Properties**********/
	public T data;
	public ListNode<T> next;
	
	/**********Constructors**********/
	public ListNode (T d, ListNode<T> node){
		this.data = d;
		this.next = node;
	}
	
	/**********Methods**********/
	public ListNode<T> search(ListNode<T> L, T key){
		while(L != null && L.data != key){
			L = L.next;
		}
		//If key was not present in the list, L will have become NULL
		return L;
	}
	//Insert newNode after node
	public void insertAfter(ListNode<T> node, ListNode<T> newNode){
		newNode.next = node.next;
		node.next = newNode;
	}
	//Delete aNode (Problem 8.6)
	public void deleteNode(ListNode<T> aNode){
		aNode.data = aNode.next.data;
		aNode.next = aNode.next.next;
	}
	
	//Problem 8.7
	public void removeKthLast(ListNode<T> L, int k){
		ListNode<T> fast = L;
		ListNode<T> slow = L;
		//Fast advances k steps first
		while(k-- > 0){
			fast = fast.next;
		}
		//Tandem move
		do{
			fast = fast.next;
			slow = slow.next;
		} while(fast.next != null);
		
		slow.next = slow.next.next;
	}
	
	//Problem 8.8 
	public void removeDuplicates(ListNode<T> L){
		//L must be sorted
		ListNode<T> current = L;
		ListNode<T> temp = L.next;
		
		while(temp != null){
			if(current.data != temp.data){
				current.next = temp;
				temp = temp.next;
				current = current.next;
			}
			else{
				temp = temp.next;
			}
		}
		//Remove the tail duplicates
		current.next = null;
	}
}
