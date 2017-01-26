package linkedLists;

//Problem 8.11
public class PalindromeTester {
	
	public static boolean isPalindromic(ListNode<Integer> L){
		if(L == null)
			return false;
		//Find second half of L
		ListNode<Integer> slow = L, fast = L;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//Reverse second half
		ListNode<Integer> secondHalf = ReverseSublist.Reverse(slow);
		//Compare
		ListNode<Integer> firstHalf = L;
		while(firstHalf != null && secondHalf != null){
			if(firstHalf.data != secondHalf.data)
				return false;
			else{
				firstHalf = firstHalf.next;
				secondHalf = secondHalf.next;
			}
		}
		return true;
	}
}
