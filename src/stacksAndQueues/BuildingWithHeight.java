package stacksAndQueues;

import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

//Problem 9.6
public class BuildingWithHeight {
	public Integer id;
	public Integer height;
	
	public BuildingWithHeight(int id, int h){
		this.id = id;
		this.height = h;
	}

	
	public static Deque<BuildingWithHeight> BuildingHeightExamination(List<BuildingWithHeight> buildings){
		Deque<BuildingWithHeight> buildingsWithSunset = new LinkedList<>();
		for(int i = 0; i < buildings.size(); ++i){
			while(!buildingsWithSunset.isEmpty() && buildingsWithSunset.peekFirst().height <= buildings.get(i).height){
				buildingsWithSunset.removeFirst();
			}
			buildingsWithSunset.addFirst(buildings.get(i));
		}		
		return buildingsWithSunset;		
	}
}
