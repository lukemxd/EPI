package stacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

//Problem 9.1
public class Stack<T extends Comparable<T>> {
	private Deque<MaxWithCount<T>> auxiliary = new LinkedList<>();
	private Deque<T> elements = new LinkedList<>();
	
	public boolean Empty(){
		return elements.isEmpty();
	}
	
	public T Max(){
		if(Empty()){
			throw new IllegalStateException("Max(): empty stack");
		}
		else{
			return auxiliary.peekFirst().max;
		}
	}
	
	public Integer MaxCount(){
		if(Empty()){
			throw new IllegalStateException("MaxCount(): empty stack");
		}
		else{
			return auxiliary.peekFirst().count;
		}
	} 
	
	public T Pop(){
		if(Empty()){
			throw new IllegalStateException("Pop(): empty stack");	
		}
		else{
		 T popElement = elements.removeFirst();
		 if(popElement.equals(auxiliary.peekFirst().max)){
			 auxiliary.peekFirst().count -= 1;
		 }
		 if(auxiliary.peekFirst().count.equals(0)){
			 auxiliary.removeFirst();
		 }
		 return popElement;
		}
	} 
	
	public void Push(T x){
		elements.addFirst(x);
		if(!auxiliary.isEmpty()){
			if(auxiliary.peekFirst().max == x){
				auxiliary.peekFirst().count += 1;
			}else if(auxiliary.peekFirst().max.compareTo(x) < 0){
				auxiliary.addFirst(new MaxWithCount<T>(x, 1));
			}
		}
		else{
			auxiliary.addFirst(new MaxWithCount<T>(x, 1));
		}
	}
	
	
	public T Peek(){
		if(Empty()){
			throw new IllegalStateException("Peek(): empty stack");	
		}
		else{
			return elements.peekFirst();
		}
	}
}
