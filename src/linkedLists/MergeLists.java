package linkedLists;

import java.util.Arrays;
import java.util.List;

import linkedLists.ListNode;


public class MergeLists {
	
	//Problem 8.1
	public static ListNode<Integer> Merge(ListNode<Integer> L1, ListNode<Integer> L2){
		ListNode<Integer> dummyHead = new ListNode<Integer>(null, null);
		ListNode<Integer> current = dummyHead;
		ListNode<Integer> p1 = L1, 	p2 = L2;
		//Merge sorting
		while(p1 != null && p2 != null){
			if(p1.data <= p2.data){
				current.next = p1;
				p1 = p1.next;
			}
			else{
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}
		
		current.next = p1 != null ? p1 : p2;
		
		return dummyHead.next; 
	}
	
	//Problem 8.10
	public static ListNode<Integer> evenOddMerge(ListNode<Integer> L){
		ListNode<Integer> dummyEvenHead = new ListNode<Integer>(0, null);
		ListNode<Integer> dummyOoddHead = new ListNode<Integer>(0, null);
		ListNode<Integer> current = L;
		List<ListNode<Integer>> tails = Arrays.asList(dummyEvenHead, dummyOoddHead);
		int turn = 0;
		//traverse L 
		while(current != null){
			tails.get(turn).next = current;
			tails.set(turn, tails.get(turn).next);
			turn ^= 1; //XOR flip
			current = current.next;
		}
		
		/*for(ListNode<Integer> current = L; current != null; current = current.next){
			
		}*/

		//merge the two lists
		tails.get(0).next = dummyOoddHead.next;
		tails.get(1).next = null;
		
		return dummyEvenHead.next;
	}

}
