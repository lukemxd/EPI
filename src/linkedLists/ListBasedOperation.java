package linkedLists;

//Problem 8.13
public class ListBasedOperation {
	
	public static ListNode<Integer> Add(ListNode<Integer> L1, ListNode<Integer> L2){
		ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
		ListNode<Integer> current = dummyHead;
		int sum, carry = 0;
		while(L1 != null || L2 != null){
			sum = carry;
			if(L1 != null){
				sum += L1.data;	
				L1 = L1.next;
			}
			if(L2 != null){
				sum += L2.data;	
				L2 = L2.next;
			}
			current.next = new ListNode<Integer>(sum % 10, null);
			carry = sum / 10;
			current = current.next;
		}
		//Add additional node if last carry is nonzero
		if(carry > 0){
			current.next = new ListNode<Integer>(carry, null); 
		}
		
		return dummyHead.next;
	}

}
