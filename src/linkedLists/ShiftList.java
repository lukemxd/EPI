package linkedLists;

//Problem 8.9
public class ShiftList {

	//Right shift
	public static ListNode<Integer> rightShift(ListNode<Integer> L, int k){
		ListNode<Integer> newHead = L;
		ListNode<Integer> tail = L;
		int n = 1;
		//Traverse the list to find the tail node
		while(tail.next != null){
			++n;
			tail = tail.next;
		}
		k %= n;
		if(k == 0)
			return newHead;
		else{
			tail.next = L;
			int m = n - k - 1;
			while(m-- > 0){
				L = L.next;
			}
			newHead = L.next;
			L.next = null;
		}
		
		return newHead;
	}
}
