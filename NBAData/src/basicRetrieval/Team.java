package basicRetrieval;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Team {
	private static final int NUM_PLAYERS = 15;
	private String name;
	private String [] players;
	private String teamLink;
	
	public Team (String teamLink, String name) throws IOException {
		this.teamLink = teamLink;
		this.name = name;
		initTeam();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String[] getPlayers() {
		return players;
	}
	
	public void setPlayers(String[] players) {
		this.players = players;
	}
	
	public void initTeam() throws IOException {
		Document teamConn = Jsoup.connect(teamLink).ignoreHttpErrors(true).get();
		Element refinedDoc = teamConn.body();
		
		System.out.println(refinedDoc.toString());
	}
	
	public StringBuilder printPlayers() {
		StringBuilder allPlayers = new StringBuilder("");
		
		for (int i = 0; i < players.length; i++) {
			allPlayers.append(players[i] + "\n");
		}
		
		return allPlayers;
	}
	
	public String toString() {
		return "Name: " + name + "\nURL: " + teamLink + "\n"; 
	}
}
