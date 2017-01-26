package stacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

//Problem 9.3
public class FormatTester {

	public static boolean isWellFormed(String input){
		Deque<Character> s = new LinkedList<>();
		for(int i = 0; i < input.length(); ++i){
			Character c = input.charAt(i);
			if(c == '(' || c == '[' || c == '{'){
				s.addFirst(c);
			} else{
					if(!s.isEmpty()){
						Character first = s.peekFirst();
						if((c == ')' && first == '(')
						 || (c == ']' && first == '[')
						 || (c == '}' && first == '{')){
							s.removeFirst();
						}
						else
							return false;
					}
					else
						throw new IllegalStateException("empty stack");
				}
			}
	
		return s.isEmpty();
	}
}
