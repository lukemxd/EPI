package stacksAndQueues;

//Auxiliary class for stack MAX value
public class MaxWithCount<T extends Comparable<T>> {
	public T max;
	public Integer count;
	
	public MaxWithCount(T max, Integer count){
		this.max = max;
		this.count = count;
	}
}
