package sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem 14.7
public class PartitionSorting {

	public static class Person implements Comparable<Person>{
		public int age;
		public String name;
		
		public Person(int a, String n){
			this.age = a;
			this.name = n;
		}
		
		@Override
		public int compareTo(Person p){
			return Integer.compare(this.age, p.age);
		}
	}

	public static void reorderByAge(List<Person> people){
		//Collections.sort(people);
		//Hash to record the occurrence times of each distinct members
		Map<Integer, Integer> ageToCount = new HashMap<>();
		for(Person p : people){
			ageToCount.put(p.age, ageToCount.containsKey(p.age) ? ageToCount.get(p.age) + 1 : 1);
		}
		//Hash to record the offset
		int offSet = 0;
		Map<Integer, Integer> ageToOffset = new HashMap<>();
		for(Map.Entry<Integer, Integer> entry : ageToCount.entrySet()){
			ageToOffset.put(entry.getKey(), offSet);
			offSet += entry.getValue();
		}
		//Reorder the list by swap
		while(!ageToOffset.isEmpty()){
			Map.Entry<Integer, Integer> from = ageToOffset.entrySet().iterator().next();
			//ToAge is the age of the person whose position should be that for Key of from in people
			Integer toAge = people.get(from.getValue()).age;
			//ToValue is the final position of toAge
			Integer toValue = ageToOffset.get(toAge);
			Collections.swap(people, toValue, from.getValue());
			//Use ageToCount to see when we are finished with a particular age
			Integer count = ageToCount.get(toAge) - 1;
			ageToCount.put(toAge, count);
			if(count > 0){
				ageToOffset.put(toAge, ++toValue);
			}else
				ageToOffset.remove(toAge);
		}
	}
}
