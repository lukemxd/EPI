package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import sorting.CalendarRender.Event;
import sorting.MergeSorting.Interval;
import sorting.MergeSorting.IntervalWithClosed;
import sorting.MergeSorting.IntervalWithClosed.Endpoint;
import sorting.PartitionSorting.Person;

public class Main {

	//14.1
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the sorted input array A delimited by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<Integer> A = new ArrayList<>();
				for(String s : input){
					A.add(Integer.parseInt(s));
				}
				System.out.println("Please enter the sorted input array B delimited by space: ");
				input = reader.readLine().split(" ");
				List<Integer> B = new ArrayList<>();
				for(String s : input){
					B.add(Integer.parseInt(s));
				}
				List<Integer> intersection = ArrayIntersection.computeIntersectionByTandem(A, B);
				System.out.println("The intersection array is ");
				for(Integer i : intersection){
					System.out.print(i + " ");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//14.2
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the sorted input array A delimited by space: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<Integer> A = new ArrayList<>();
				for(String s : input){
					A.add(Integer.parseInt(s));
				}
				System.out.println("Please enter the sorted input array B delimited by space: ");
				input = reader.readLine().split(" ");
				List<Integer> B = new ArrayList<>();
				for(String s : input){
					B.add(Integer.parseInt(s));
				}
				for(int i = 0; i < A.size(); ++i){
					B.add(0);
				}
				MergeSorting.mergeSortedArray(B, A, input.length - 1);
				System.out.println("The merged array is ");
				for(Integer i : B){
					System.out.print(i + " ");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//14.4
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the events delimited by comma: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(",");
				List<Event> events = new ArrayList<>();
				for(String s : input){
					int start = Integer.parseInt(s.split(" ")[0]);
					int end = Integer.parseInt(s.split(" ")[1]);
					events.add(new Event(start, end));
				}
				System.out.println("The maximum number of events happen at the same time is "
						+ CalendarRender.findMaxConcurrentEvents(events));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//14.5
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the intervals delimited by comma: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(",");
				List<Interval> intervals = new ArrayList<>();
				for(String s : input){
					int left = Integer.parseInt(s.split(" ")[0]);
					int right = Integer.parseInt(s.split(" ")[1]);
					intervals.add(new Interval(left, right));
				}
				System.out.println("Please enter the target interval: ");
				input = reader.readLine().split(" ");
				Interval target = new Interval(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
				List<Interval> result = MergeSorting.mergeIntervals(intervals, target);
				System.out.println("The mergerd intervals are ");
				for(Interval inter : result){
					System.out.print(inter.left + " " + inter.right + ",");	
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//14.6
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the intervals with closed delimited by comma: ");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(",");
				List<IntervalWithClosed> intervals = new ArrayList<>();
				for(String s : input){
					String[] endpoint = s.split(" ");
					Endpoint left = new Endpoint(endpoint[0].charAt(0) == 'T' ? true : false, Integer.parseInt(endpoint[0].substring(1)));
					Endpoint right = new Endpoint(endpoint[1].charAt(0) == 'T' ? true : false, Integer.parseInt(endpoint[1].substring(1)));
					intervals.add(new IntervalWithClosed(left, right));
				}				
				List<IntervalWithClosed> result = MergeSorting.unionOfInterVals(intervals);
				System.out.println("The mergerd intervals are ");
				for(IntervalWithClosed inter : result){
					System.out.print(String.valueOf(inter.left.isClosed) + 
									 inter.left.value + " " + String.valueOf(inter.right.isClosed) + 
									 inter.right.value + ", ");	
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//14.7
	/*public static void main(String[] args) {
	// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the person info delimited by comma: ");
	
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(",");
				List<Person> people = new ArrayList<>();
				for(String s : input){
					int age = Integer.parseInt(s.split(" ")[0]);
					String name = s.split(" ")[1];
					people.add(new Person(age, name));
				}
				PartitionSorting.reorderByAge(people);
				System.out.println("The reordered people are: ");
				for(Person p : people){
					System.out.print(p.age + " " + p.name + ",");
				}		
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	//14.10
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		String[] input;
		System.out.println("Please enter the salaries delimited by space: ");
	
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			if(reader != null){
				input = reader.readLine().split(" ");
				List<Double> salaries = new ArrayList<>();
				for(String s : input){
					salaries.add(Double.parseDouble(s));
				}
				System.out.println("Please enter the target cap: ");
				double target = Double.parseDouble(reader.readLine());
				System.out.println("The salary cap is " + SalaryThreshold.computeSalaryCap(salaries, target));
				System.out.println("The salary cap by BS is " + SalaryThreshold.computeSalaryCapBS(salaries, target));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
