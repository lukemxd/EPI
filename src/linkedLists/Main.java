package linkedLists;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	//8.1
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = null;
		
		System.out.println("Enter the elements for the input sorted linked list L1 and L2 separate by space: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l1 = input[0].toCharArray();
				char[] l2 = input[1].toCharArray();
				ListNode<Integer> L1 = new ListNode<Integer>(null, null);
				ListNode<Integer> L2 = new ListNode<Integer>(null, null);
				ListNode<Integer> current = L1;
				for(char c : l1){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
					}
				}
				current = L2;
				for(char c : l2){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
					}
				}
				System.out.print("L1 is ");
				current = L1.next;
				while(current != null){
					if(current != L1.next){
						System.out.print(",");	
					}
					System.out.print(current.data);
					current = current.next;
				}
				System.out.println();
				System.out.print("L2 is ");
				current = L2.next;
				while(current != null){
					if(current != L2.next){
						System.out.print(",");	
					}
					System.out.print(current.data);
					current = current.next;
				}
				System.out.println();
				System.out.print("The merged sorted list is ");
				current = MergeLists.Merge(L1.next, L2.next);
				while(current != null){
					System.out.print(current.data + " ");
					current = current.next;
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	*/
	
	//8.2
	/*public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] input = null;
		
		//System.out.println("Enter the elements for the input sorted linked list L and start end index(format: L start end): ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l = input[0].toCharArray();
				//int start = Integer.parseInt(input[1]);
				//int end = Integer.parseInt(input[2]);
				ListNode<Integer> L = new ListNode<Integer>(null, null);
				ListNode<Integer> current = L;
				for(char c : l){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
					}
				}
				current = L.next;
				System.out.print("L is ");
				while(current != null){
					System.out.print(current.data + " ");
					current = current.next;
				}
				
				System.out.println();
				//System.out.print("The new list with reversed sublist from index " + start + " to " + end + " is ");
				//current = ReverseSublist.reverseSublist(L.next, start, end);
				//current = ReverseSublist.Reverse(L.next); //Variant 1
				while(current != null){
					System.out.print(current.data + " ");
					current = current.next;
				}
				
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}*/

	//8.3
	/*public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] input = null;
		
		System.out.println("Enter the elements for the input sorted linked list L and cycle length: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l = input[0].toCharArray();
				int cycleLength = Integer.parseInt(input[1]);
				ListNode<Integer> L = new ListNode<Integer>(null, null);
				ListNode<Integer> current = L;
				System.out.print("L is ");
				for(char c : l){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
						//System.out.print(current.data + " ");
					}
				}
				//Build the cycle
				if(cycleLength > 0 && cycleLength < l.length){
					ListNode<Integer> cycleStart = L.next;
					for(int i = 0; i < l.length - cycleLength; ++i){
						cycleStart = cycleStart.next;
					}
					current.next = cycleStart;
				}
				current = L.next;
				for(int j = 0; j < 50; ++j){
					if(current != null){
						System.out.print(current.data + " ");
						current = current.next;		
					}
					else{
						break;
					}
				}
				//Test the cycle
				System.out.println();
				System.out.println("Running the cycle tester....");
				ListNode<Integer> node = CycleTester.hasCycle(L.next);
				if(node != null){
					System.out.println("The list has a cycle and the cycle start node is " + node.data);	
				}
				else{
					System.out.println("The list has no cycle.");
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}*/
	
	//8.4
	/*public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] input = null;
		ListNode<Integer> current;
		System.out.println("Enter the elements for the input list L1 and partail L2 without overlapping: (format: L1 L2)");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l1 = input[0].toCharArray();
				char[] l2 = input[1].toCharArray();
				ListNode<Integer> L1 = new ListNode<Integer>(null, null);
				ListNode<Integer> L2 = new ListNode<Integer>(null, null);
				current = L1;
				//Build L1
				System.out.print("L1 is ");
				for(char c : l1){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
						System.out.print(current.data + " ");
					}
				}
				System.out.println();
				//Build L2
				current = L2;
				System.out.print("L2 is ");
				for(char c : l2){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
						//System.out.print(current.data + " ");
					}
				}
				//Build the overlap
				current.next = L1.next.next;
				current = L2;
				while(current.next != null){
					current = current.next;
					System.out.print(current.data + " ");	
				}
				//Test the overlap
				System.out.println();
				System.out.println("Running the overlapping tester....");
				ListNode<Integer> node = OverlappingTester.hasOverlappingWithoutCycle(L1.next, L2.next);
				if(node != null){
					System.out.println("The list has an overlap which starts at node " + node.data);	
				}
				else{
					System.out.println("The list has no overlap.");
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/	
	
	//8.7
	/*public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] input = null;
		ListNode<Integer> current;
		System.out.println("Enter the list L and number k for the purpose that removes the kth last element from L (format: L k): ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l = input[0].toCharArray();
				int k = Integer.parseInt(input[1]);
				ListNode<Integer> L = new ListNode<Integer>(null, null);
				current = L;
				//Build L
				System.out.print("L is ");
				for(char c : l){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
						System.out.print(current.data + " ");
					}
				}
				System.out.println();
				L.removeKthLast(L.next, k);
				System.out.print("After removing the last " + k + "th element, the list is ");
				current = L;
				while(current.next != null){
					current = current.next;
					System.out.print(current.data + " ");
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//8.8
	/*public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] input = null;
		ListNode<Integer> current;
		System.out.println("Enter the sorted list L with duplicates: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l = input[0].toCharArray();
				ListNode<Integer> L = new ListNode<Integer>(null, null);
				current = L;
				//Build L
				System.out.print("L is ");
				for(char c : l){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
						System.out.print(current.data + " ");
					}
				}
				System.out.println();
				L.removeDuplicates(L.next);
				System.out.print("After removing the duplicates the list is ");
				current = L;
				while(current.next != null){
					current = current.next;
					System.out.print(current.data + " ");
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/	
	
	//8.9
	/*public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] input = null;
		ListNode<Integer> current;
		System.out.println("Enter the list L and number k for right shift (format: L k): ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l = input[0].toCharArray();
				int k = Integer.parseInt(input[1]);
				ListNode<Integer> L = new ListNode<Integer>(null, null);
				current = L;
				//Build L
				System.out.print("L is ");
				for(char c : l){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
						System.out.print(current.data + " ");
					}
				}
				System.out.println();
				current = ShiftList.rightShift(L.next, k);
				System.out.print("After right shifting " + k + "th element, the list is ");
				while(current != null){
					System.out.print(current.data + " ");
					current = current.next;
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/	
	
	//8.10
	/*public static void main(String[] args){
		// TODO Auto-generated method stub
		ListNode<Integer> current;
		System.out.println("Enter the length of list: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				String input = reader.readLine();
				int k = Integer.parseInt(input);
				ListNode<Integer> L = new ListNode<Integer>(null, null);
				current = L;
				//Build L
				System.out.print("The list is ");
				for(int i = 0; i < k; ++i){
					ListNode<Integer> next = new ListNode<Integer>(i, null);
					if(current.next == null){
						current.next = next;
						current = current.next;
						System.out.print(current.data + " ");
					}
				}
				System.out.println();
				current = MergeLists.evenOddMerge(L.next);
				System.out.print("After even-odd merge the list is ");
				while(current != null){
					System.out.print(current.data + " ");
					current = current.next;
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//8.11
	/*public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] input = null;
		ListNode<Integer> current;
		System.out.println("Enter the list L: ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l = input[0].toCharArray();
				ListNode<Integer> L = new ListNode<Integer>(null, null);
				current = L;
				//Build L
				System.out.print("L is ");
				for(char c : l){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
						System.out.print(current.data + " ");
					}
				}
				System.out.println();
				System.out.println("Running the palindorme tester....");
				if(PalindromeTester.isPalindromic(L.next))
					System.out.print("L is palindromic");
				else
					System.out.print("L is NOT palindromic");
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
	}*/
	
	//8.12
	/*public static void main(String[] args){
		// TODO Auto-generated method stub
		String[] input = null;
		ListNode<Integer> current;
		System.out.println("Enter the list L and pivot value p (format:L p): ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l = input[0].toCharArray();
				int p = Integer.parseInt(input[1]);
				ListNode<Integer> L = new ListNode<Integer>(null, null);
				current = L;
				//Build L
				System.out.print("L is ");
				for(char c : l){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
						System.out.print(current.data + " ");
					}
				}
				System.out.print("Pivot value is " + p);
				System.out.println();
				System.out.println("Running the pivoting program....");
				current = Pivoting.ListPivoting(L.next, p);
			    System.out.print("After pivoting L is ");
			    while(current != null){
					System.out.print(current.data + " ");
					current = current.next;
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/

	//8.13
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = null;
		
		System.out.println("Enter the input list L1 and L2 separate by space (LSB comes first): ");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				char[] l1 = input[0].toCharArray();
				char[] l2 = input[1].toCharArray();
				ListNode<Integer> L1 = new ListNode<Integer>(null, null);
				ListNode<Integer> L2 = new ListNode<Integer>(null, null);
				ListNode<Integer> current = L1;
				for(char c : l1){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
					}
				}
				current = L2;
				for(char c : l2){
					ListNode<Integer> next = new ListNode<Integer>(c - '0', null);
					if(current.next == null){
						current.next = next;
						current = current.next;
					}
				}
				System.out.print("L1 is ");
				current = L1;
				while(current != null){
					if(current.data != null){
						System.out.print(current.data + " ");	
					}
					current = current.next;
				}
				System.out.println();
				System.out.print("L2 is ");
				current = L2;
				while(current != null){
					if(current.data != null){
						System.out.print(current.data + " ");	
					}
					current = current.next;
				}
				System.out.println();
				System.out.print("L1 + L2 is ");
				//current = ReverseSublist.Reverse(ListBasedOperation.Add(L1.next, L2.next)); 
				//Variant
				current = ReverseSublist.Reverse(ListBasedOperation.Add(ReverseSublist.Reverse(L1.next), ReverseSublist.Reverse(L2.next))); 
				while(current != null){
					System.out.print(current.data + " ");
					current = current.next;
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
