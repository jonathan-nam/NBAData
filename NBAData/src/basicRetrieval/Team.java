package basicRetrieval;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Team {
	private static final int NUM_PLAYERS = 15;
	private String name;
	private ArrayList <Player> players = new ArrayList <Player>(NUM_PLAYERS);
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
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void initTeam() throws IOException {	
		/* These team links are not correctly updated on Basketball Reference. */
		if (teamLink.equals("https://www.basketball-reference.com/teams/NJN/2019.html")) {
			this.teamLink = ("https://www.basketball-reference.com/teams/BRK/2019.html");
		} else if (teamLink.equals("https://www.basketball-reference.com/teams/CHA/2019.html")) {
			this.teamLink = ("https://www.basketball-reference.com/teams/CHO/2019.html");
		} else if (teamLink.equals("https://www.basketball-reference.com/teams/NOH/2019.html")) {
			this.teamLink = ("https://www.basketball-reference.com/teams/NOP/2019.html");
		}
	
		Document teamConn = Jsoup.connect(teamLink).ignoreHttpErrors(true).get();
		System.out.println(teamConn.text().toString());
		Elements playerNames = teamConn.select
				("div[id=all_roster]  tr [data-stat^=player] > a[href^=/players/]");
		
		for (Element player : playerNames) {
			players.add(new Player(player.text()));
		}	
	}
	
	public StringBuilder printPlayers() {
		StringBuilder allPlayers = new StringBuilder("");
		
		for (int i = 0; i < players.size(); i++) {
			allPlayers.append(players.get(i) + "\n");
		}
		
		return allPlayers;
	}
	
	public String toString() {
		return "\nName: " + name + "\nURL: " + teamLink + "\n" + printPlayers(); 
	}
	
	//*[@id="per_game_stats"]/tbody/tr[3]/td[1]
	//#per_game_stats > tbody > tr:nth-child(3) > td:nth-child(2)
}
