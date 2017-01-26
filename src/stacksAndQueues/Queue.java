package stacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import binaryTrees.BinaryTreeNode;

public class Queue {
	
	//Problem 9.7
	public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> Tree){
		Deque<BinaryTreeNode<Integer>> processingNodes = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> oneLevel = new ArrayList<>();
		//Inject the root tree node
		processingNodes.add(Tree);
		int sizeOfCurrentLevel = processingNodes.size();
		
		while(!processingNodes.isEmpty()){
			BinaryTreeNode<Integer> current = processingNodes.poll();
			--sizeOfCurrentLevel;
			if(current != null){
				oneLevel.add(current.data);
				//Inject the children
				processingNodes.add(current.left);
				processingNodes.add(current.right);
			}
			//Check if all the nodes at current level have been processed
			if(sizeOfCurrentLevel == 0){
				sizeOfCurrentLevel = processingNodes.size();
				if(!oneLevel.isEmpty()){
					result.add(new ArrayList<>(oneLevel));
					oneLevel.clear();	
				}
			}
		}

		return result;
	}
	
	//Problem 9.8
	public static class CircularQueue {
		private int head = 0, tail = 0, numOfSize = 0;
		private static final int SCALE_FACTOR = 2;
		private Integer[] entries;
		
		public CircularQueue(int capacity){
			this.entries = new Integer[capacity];
		}
		
		public void enqueue(Integer x){
			//Resize if full
			if(numOfSize == entries.length){
				Collections.rotate(Arrays.asList(entries), -head);
				head = 0;
				tail = numOfSize;
				entries = Arrays.copyOf(entries, numOfSize * SCALE_FACTOR);
			}
			entries[tail] = x;
			tail = (tail + 1) % entries.length;
			++numOfSize;
		}
		
		public Integer dequeue(){
			if(numOfSize != 0){
				Integer output = entries[head];
				head = (head + 1) % entries.length;
				--numOfSize;
				return output;
			}
			
			throw new NoSuchElementException("Dequeue called on an empty queue.");
		}
		
		public int size(){
			return this.numOfSize;
		}
		
	}
	
	//Problem 9.9
	public static class QueueUsingStacks {
		Deque<Integer> enqueueStack = new LinkedList<>();
		Deque<Integer> dequeueStack = new LinkedList<>();
		
		public void enqueue(Integer x){
			enqueueStack.addFirst(x);
		}
		
		public Integer dequeue(){
			//Push onto dequeue if it's empty
			if(dequeueStack.isEmpty()){
				while(!enqueueStack.isEmpty()){
					dequeueStack.addFirst(enqueueStack.removeFirst());
				}
			}
			
			if(!dequeueStack.isEmpty()){
				return dequeueStack.removeFirst();	
			}
			
			throw new NoSuchElementException("Empty queue.");
		}
		
	}
	
	//Problem 9.10 similar like 9.1
	public static class QueueWithMax<T extends Comparable<T>> {
		private Deque<T> queue = new LinkedList<>();
		private Deque<T> maxQueue = new LinkedList<>();
		
		public void equeue(T x){
			queue.add(x);
			
			while(!maxQueue.isEmpty()){
				if(maxQueue.getLast().compareTo(x) >= 0){
					break;
				}
				maxQueue.removeLast();
			}
			maxQueue.add(x);
		}
		
		public T dequeue(){
			if(!queue.isEmpty()){
				if(queue.getFirst().compareTo(maxQueue.getFirst()) == 0){
					maxQueue.removeFirst();
				}				
				return queue.removeFirst();
			}
			
			throw new NoSuchElementException("Queue dequeue(): empty queue");
		}
		
		public T max(){
			if(!maxQueue.isEmpty()){
				return maxQueue.getFirst();
			}
			throw new NoSuchElementException("Queue max(): empty queue");
		}
		
	}
	
	//Problem 9.10 using 9.1 + 9.9
	public static class QueueWithStackMax {
		private Stack<Integer> enqueue = new Stack<>();
		private Stack<Integer> dequeue = new Stack<>();
		
		public void enqueue(Integer x){
			enqueue.Push(x);
		}
		
		public Integer dequeue(){
			if(dequeue.Empty()){
				while(!enqueue.Empty()){
					dequeue.Push(enqueue.Pop());
				}
			}
			if(!dequeue.Empty()){
				return dequeue.Pop();
			}
			throw new NoSuchElementException("Queue dequeue(): empty queue");
		}
		
		public Integer max(){
			if(!enqueue.Empty() && !dequeue.Empty()){
				return Math.max(enqueue.Max(), dequeue.Max()); 
			}
			else if(!enqueue.Empty()){
				return enqueue.Max();
			}
			else if(!dequeue.Empty()){
				return dequeue.Max();
			}
			throw new NoSuchElementException("Queue max(): empty queue");
		}
	}
	
}
