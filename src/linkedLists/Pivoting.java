package linkedLists;

//Problem 8.12
public class Pivoting {
	
	public static ListNode<Integer> ListPivoting(ListNode<Integer> L, int pivot){
		ListNode<Integer> lessHead = new ListNode<Integer>(0, null);
		ListNode<Integer> equalHead = new ListNode<Integer>(0, null);
		ListNode<Integer> greaterHead = new ListNode<Integer>(0, null);
		ListNode<Integer> lessCur = lessHead;
		ListNode<Integer> equalCur = equalHead;
		ListNode<Integer> greaterCur = greaterHead;
		
		//Populate three sublists
		ListNode<Integer> current = L;
		while(current != null){
			if(current.data < pivot){
				//Less sublist	
				lessCur.next = current;
				lessCur = current;
			}
			else if(current.data == pivot){
				//Equal sublist	
				equalCur.next = current;
				equalCur = current;
			}
			else{
				//Greater sublist	
				greaterCur.next = current;
				greaterCur = current;
			}
			
			current = current.next;
		}
		
		//Combine
		greaterCur.next = null;
		equalCur.next = greaterHead.next;
		lessCur.next = equalHead.next;
		
		return lessHead.next;
	}

}
