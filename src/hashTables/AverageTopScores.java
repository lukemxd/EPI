package hashTables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//Problem 13.11
public class AverageTopScores {
	
	public static class StudentWithScore{
		public String studentID;
		public Integer score;
		
		public StudentWithScore(String id, Integer score){
			this.studentID = id;
			this.score = score;
		}
	}
	//Calculate the sum of all the scores
	private static int sumOfScores(PriorityQueue<Integer> scores){
		int sum = 0;
		Iterator<Integer> iter = scores.iterator();
		while(iter.hasNext()){
			sum += iter.next();
		}
		return sum;
	}

	public static String findAverageTopScores(List<StudentWithScore> input){
		Map<String, PriorityQueue<Integer>> studentScores = new HashMap<>();
		//Iterate through the input and initialize the map
		for(StudentWithScore stu : input){
			PriorityQueue<Integer> scores = studentScores.get(stu);
			if(!studentScores.containsKey(stu) || 
					(studentScores.containsKey(stu) && studentScores.get(stu).size() < 3)){
				if(scores == null)
					scores = new PriorityQueue<>();
				scores.add(stu.score);
				studentScores.put(stu.studentID, scores);
			}else if(studentScores.get(stu).size() >= 3){
				if(stu.score > scores.peek()){
					scores.poll();
					scores.add(stu.score);
				}
			}
		}
		//Check the highest sum of the scores
		String topStudent = "No such student";
		int currentHighestScoreSum = 0;
		for(Map.Entry<String, PriorityQueue<Integer>> entry : studentScores.entrySet()){
			if(entry.getValue().size() == 3){
				int sum = sumOfScores(entry.getValue());
				if(currentHighestScoreSum < sum){
					currentHighestScoreSum = sum;
					topStudent = entry.getKey();
				}
			}
		}
		return topStudent;
	}
}
