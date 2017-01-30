package heaps;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

//Problem 11.7
public class StackByHeap {
	
	public static class StackEntry {
		public Integer order;
		public Integer value;
		
		public StackEntry(Integer order, Integer value){
			this.order = order;
			this.value = value;
		}	
	}
	
	public static class Compare implements Comparator<StackEntry>{
		@Override
		public int compare(StackEntry s1, StackEntry s2){
			return Integer.compare(s2.order, s1.order);
		}
		
		public static final Compare COMPARE_HEAP_ENTRIES = new Compare(); 
	}
	
	private int timeStamp = 0;
	private PriorityQueue<StackEntry> maxHeap = new PriorityQueue<>(Compare.COMPARE_HEAP_ENTRIES);
	
	public void push(Integer i){
		maxHeap.add(new StackEntry(timeStamp++, i));
	}
	
	public Integer remove() throws NoSuchElementException{
		return maxHeap.poll().value;
	}
	
	public Integer pop(){
		if(!maxHeap.isEmpty())
			return maxHeap.poll().value;
		else
			return null;
	}
	
	public Integer peek(){
		if(!maxHeap.isEmpty())
			return maxHeap.peek().value;
		else
			return null;
	}
	
	public boolean isEmpty(){
		return maxHeap.isEmpty();
	}

}
