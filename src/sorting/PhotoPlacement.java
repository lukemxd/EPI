package sorting;

import java.util.Collections;
import java.util.List;

//Problem 14.8
public class PhotoPlacement {
	
	public static class Player implements Comparable<Player>{
		public int height;
		
		public Player(int h){
			this.height = h;
		}
		
		public int compareTo(Player p){
			return Integer.compare(this.height, p.height);
		}
	}
	
	//Suppose A should be placed behind B
	public static boolean isPhotoPlacable(List<Player> A, List<Player> B){
		//Different sizes
		if(A.size() != B.size())
			return false;
		
		Collections.sort(A);
		Collections.sort(B);
		for(int i = 0; i < A.size(); ++i){
			if(A.get(i).compareTo(B.get(i)) <= 0)
				return false;
		}
		return true;
	}
}
