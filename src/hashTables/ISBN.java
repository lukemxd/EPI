package hashTables;

import java.util.LinkedHashMap;
import java.util.Map;

//Problem 13.3
public class ISBN {
	
	private Map<String, Double> ISBNTOPrice;
	
	@SuppressWarnings("serial")
	public ISBN(final int capacity){
		//True for access order, false for insertion order
		this.ISBNTOPrice = new LinkedHashMap<String, Double>(capacity, 1.0f, true){
			@Override
			protected boolean removeEldestEntry(Map.Entry<String, Double> e){
				return this.size() > capacity;
			}
		};
	}
	
	//LookUp
	public Double lookUp(String isbn){
		if(this.ISBNTOPrice.containsKey(isbn)){
			return this.ISBNTOPrice.get(isbn);
		}else
			return null;
	}
	
	//Insert
	public boolean insert(String isbn, double price){
		if(!this.ISBNTOPrice.containsKey(isbn)){
			this.ISBNTOPrice.put(isbn, price);
			return true;
		}else
			return false;
	}
	
	//Remove
	public Double remove(String isbn){
		return this.ISBNTOPrice.remove(isbn);
	}

}
