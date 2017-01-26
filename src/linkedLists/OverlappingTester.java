package linkedLists;

//Problem 8.4-8.5
public class OverlappingTester {

	//8.4
	public static ListNode<Integer> hasOverlappingWithoutCycle(ListNode<Integer> L1, ListNode<Integer> L2){
		
		int length1 = length(L1), length2 = length(L2);
		//Advance the longer list by length difference
		if(length1 > length2){
			L1 = advanceListByK(length1 - length2, L1);
		}
		else{
			L2 = advanceListByK(length2 - length1, L2);
		}

		//Advance in tandem
		while(L1 != null && L2 != null && L1 != L2 ){
			L1 = L1.next;
			L2 = L2.next;
		}
		
		return L1; //return null if no overlapping
	}
	
	//8.5
	public static ListNode<Integer> hasOverlapping(ListNode<Integer> L1, ListNode<Integer> L2){
		//Cycle start nodes
		ListNode<Integer> root1 = CycleTester.hasCycle(L1);
		ListNode<Integer> root2 = CycleTester.hasCycle(L2);
		if(root1 == null && root2 == null){
			//No cycle ==> 8.4
			return hasOverlappingWithoutCycle(L1, L2);	
		}
		else if((root1 != null && root2 == null) || (root2 != null && root1 == null)){
			//One has cycle one does not so no potential overlap
			return null;
		}
		
		//Both have cycles 
		ListNode<Integer> temp = root1;
		do{
			temp = temp.next;
		} while(temp != root1 && temp != root2);
		//!!!If in the same cycle, root2 must be met before reaching root1 again!!!
		if(temp != root2){
			return null; //two lists are not in the same cycle
		}
		
		int length1 = distance(root1, L1), length2 = distance(root2, L2);
		//Advance the longer list by length difference
		if(length1 > length2){
			L1 = advanceListByK(length1 - length2, L1);
		}
		else{
			L2 = advanceListByK(length2 - length1, L2);
		}

		//Advance in tandem
		while(L1 != root1 && L2 != root2 && L1 != L2 ){
			L1 = L1.next;
			L2 = L2.next;
		}
		
		return L1 == L2 ? L1 : root2;
	}
	
	private static int length(ListNode<Integer> L){
		int len = 0;
		while(L != null){
			++len;
			L = L.next;
		}
		return len;
	}	
	
	private static int distance(ListNode<Integer> root, ListNode<Integer> L){
		int dis = 0;
		while(root != L){
			++dis;
			L = L.next;
		}
		return dis;
	}
	
	private static ListNode<Integer> advanceListByK(int k, ListNode<Integer> L){
		while(k-- > 0){
			L = L.next;
		}
		return L;
	}
}
