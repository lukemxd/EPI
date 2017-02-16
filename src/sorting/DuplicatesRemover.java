package sorting;

import java.util.Collections;
import java.util.List;

//Problem 14.3
public class DuplicatesRemover {
	
	public static class Name implements Comparable<Name>{
		String firstName;
		String lastName;
		
		public int compareTo(Name name){
			int res = firstName.compareTo(name.firstName);
			if(res != 0)
				return res;
			return lastName.compareTo(name.lastName);
		}
	}
	
	public static void removeDuplicates(List<Name> input){
		//Sort the list
		Collections.sort(input);
		//Eliminate the duplicates
		int index = 0;
		for(int i = 1; i < input.size(); ++i){
			if(!input.get(i).firstName.equals(input.get(index))){
				input.set(++index, input.get(i));
			}
		}
		//Shrink the list remove the elements after index
		input.subList(++index, input.size()).clear();
		//return input.subList(0, ++index);
	}
}
