package stacksAndQueues;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

//Problem 9.4
public class Normalizer {

	public static String pathNormalize(String input){
		Deque<String> path = new LinkedList<>();
		//Code see the book on Page 139-140
		
		//Iteration on a stack
		StringBuilder result =  new StringBuilder();
		Iterator<String> it = path.descendingIterator();
		String prev = it.next();
		while(it.hasNext()){
			result.append(prev);
			prev = it.next();
		}
		
		return result.toString();
	}
}
