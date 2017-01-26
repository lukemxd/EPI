package stacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

//Problem 9.5
public class JumpNextSearching {

	//Recursion
	public static void JumpNextRecursion(linkedLists.ListNode<Integer> L){
		JumpNextRecursionHelper(L, 0);	
	}
	
	private static int JumpNextRecursionHelper(linkedLists.ListNode<Integer> L, int order){
		if(L != null && L.data == -1){
			L.data = order++;
			//order = JumpNextRecursionHelper(L.jump, order); //Suppose L has jump node
			order = JumpNextRecursionHelper(L.next, order);
		}
		return order;
	}
	
	//Iteration
	public static void JumpNextIteration(linkedLists.ListNode<Integer> L){
		
		Deque<linkedLists.ListNode<Integer>> stack = new LinkedList<>();
		int order = 0;
		stack.addFirst(L);
		
		while(!stack.isEmpty()){
			linkedLists.ListNode<Integer> node = stack.removeFirst();
			if(node != null && node.data == -1){
				stack.peekFirst().data = order++;	
				stack.addFirst(L.next);
				//stack.addFirst(L.jump); //Suppose L has jump node
			}
		}
	}
}
