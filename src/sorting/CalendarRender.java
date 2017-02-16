package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem 14.4
public class CalendarRender {

	public static class Event{
		public int start, end;
		
		public Event(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	public static class Endpoint implements Comparable<Endpoint>{
		public int time;
		public boolean isStart; //T - Start, F - End
		
		public Endpoint(int t, boolean is){
			this.time = t;
			this.isStart = is;
		}
		
		public int compareTo(Endpoint e){
			if(time != e.time)
				return Integer.compare(time, e.time);
			//If times are equal, an endpoint that starts an interval comes first
			return isStart && !e.isStart ? -1 : !isStart && e.isStart ? 1 : 0;
		}
	}
	
	public static int findMaxConcurrentEvents(List<Event> input){
		int currentEvent = 0, maxEvent = 0;
		List<Endpoint> endpoints = new ArrayList<>();
		for(Event e : input){
			endpoints.add(new Endpoint(e.start, true));
			endpoints.add(new Endpoint(e.end, false));
		}
		//Sort the endpoint list by ascending order
		Collections.sort(endpoints);
		//currentEvent increases if the endpoint is Start
		for(Endpoint e : endpoints){
			if(e.isStart) {
				//Start
				++currentEvent;
				maxEvent = Math.max(maxEvent, currentEvent);
			}
			else
				--currentEvent;
		}
		return maxEvent;
	}
}
