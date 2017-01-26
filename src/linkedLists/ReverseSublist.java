package linkedLists;

import linkedLists.ListNode;

//Problem 8.2
public class ReverseSublist {
	//Sublist
	public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int startIdx, int endIdx){
		if(startIdx == endIdx)
			return L;
		
		ListNode<Integer> dummyHead = new ListNode<Integer>(null, L);
		ListNode<Integer> sublistHead = dummyHead;
		int k = 1;
		while(k++ < startIdx){
			sublistHead = sublistHead.next;
		}
		
		//Reverse sublist
		ListNode<Integer> sublistNode = sublistHead.next;
		while(startIdx ++ < endIdx){
			ListNode<Integer> temp = sublistNode.next;
			sublistNode.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next = temp;
		}
		
		return dummyHead.next;
	}
	
	//Entire list Variant 1
	public static ListNode<Integer> Reverse(ListNode<Integer> L){
		ListNode<Integer> dummyHead = new ListNode<Integer>(null, L);
		ListNode<Integer> sublistNode = dummyHead.next;
		ListNode<Integer> temp = sublistNode.next;
		while(sublistNode.next != null){
			temp = sublistNode.next;
			sublistNode.next = temp.next;
			temp.next = dummyHead.next;
			dummyHead.next = temp;
		}
		
		return dummyHead.next;	
	}
	
}
