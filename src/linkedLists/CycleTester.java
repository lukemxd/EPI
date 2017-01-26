package linkedLists;

//Problem 8.3
public class CycleTester {
	
	public static ListNode<Integer> hasCycle(ListNode<Integer> head){
		ListNode<Integer> slow = head, fast = head;
		
		while(fast != null && fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				int length = 0;
				do{
					++length;
					fast = fast.next;
				} while(fast != slow);
				
				//Find the cycle start
				ListNode<Integer> starter = head;
				while(length-- > 0){
					starter = starter.next;
				}
				ListNode<Integer> iter = head;
				while(iter != starter){
					iter = iter.next;
					starter = starter.next;
				}
				
				return iter;
				
				//Variant 
				/*slow = head;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				
				return slow;*/
			}
		}
		
		return null; //no cycle
	}

}
