package recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Problem 16.1
public class HanoiTower {
	
	//Record the number of steps
	private static int numOfSteps = 0;
	
	public static int runHanoiTowerSolver(int numOfRings){
		List<Deque<Integer>> pegs = new ArrayList<>();
		//Initialize pegs 
		for(int i = 0; i < 3; i++){
			pegs.add(new LinkedList<Integer>());
		}
		//Add rings to first peg
		for(int i = numOfRings; i >= 1; i--){
			pegs.get(0).addFirst(i);
		}
		runHanoiTowerSolverHelper(pegs, numOfRings, 0, 1, 2);
		return numOfSteps;
	}
	//from is the from peg, to is the to peg and temp is the interstage peg
	//First part is to move all the rings except the last one from from peg to temp peg
	//Second part is to move all the rings from temp peg to to peg
	private static void runHanoiTowerSolverHelper(List<Deque<Integer>> pegs, int numOfRingsToMove, int from, int to, int temp){
		if(numOfRingsToMove > 0){
			//first part
			runHanoiTowerSolverHelper(pegs, numOfRingsToMove - 1 , from, temp, to);
			pegs.get(to).addFirst(pegs.get(from).removeFirst());
			System.out.println("Move from peg " + from + " to peg " + to);
			++numOfSteps;
			//second part
			runHanoiTowerSolverHelper(pegs, numOfRingsToMove - 1 , temp, to, from);
		}
	}
}
