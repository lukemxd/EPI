package binarySearchTrees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

//Problem 15.13
public class ClientCredits {
	private int globalOffset = 0;
	private Map<String, Integer> ClientToCredits = new HashMap<>();
	private NavigableMap<Integer, Set<String>> creditsToClient = new TreeMap<>();
	
	public void insert(String clientId, int credit){
		this.remove(clientId);
		ClientToCredits.put(clientId, credit - globalOffset);
		Set<String> clients = creditsToClient.get(credit - globalOffset);
		if(clients == null){
			clients = new HashSet<>();
			creditsToClient.put(credit - globalOffset, clients);
		}
		clients.add(clientId);
	}
	
	public boolean remove(String clientId){
		Integer credits = ClientToCredits.get(clientId);
		if(credits != null){
			creditsToClient.get(credits).remove(clientId);
			if(creditsToClient.get(credits).isEmpty())
				creditsToClient.remove(credits);
			ClientToCredits.remove(clientId);
			return true;
		}
		//credits == null
		return false;
	}
	
	public int lookup(String clientId){
		Integer credits = ClientToCredits.get(clientId);
		return credits == null ? -1 : credits + globalOffset;
	}
	
	public void addAll(int credit){
		this.globalOffset += credit;
	}
	
	public String max(){
		return creditsToClient.isEmpty() ? "" :
			   creditsToClient.lastEntry().getValue().iterator().next();
	}
}
