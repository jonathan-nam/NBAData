package basicRetrieval;

import java.util.HashMap;

public class Player {
	private String playerLink;
	private String name;
	private HashMap<String, String> stats;
	
	public String getPlayerLink() {
		return playerLink;
	}
	
	public void setPlayerLink(String playerLink) {
		this.playerLink = playerLink;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
