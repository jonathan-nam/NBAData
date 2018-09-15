package basicRetrieval;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class dataScrape {
	private static final int NUM_TEAMS = 30;
	private static final int NUM_PLAYERS = 15;
	private static String [][] allTeams = new String [NUM_TEAMS][NUM_PLAYERS];
	private static String url = "https://www.basketball-reference.com/teams/";
	private static String teamSelector = 
			"div[id=all_teams_active] [data-stat^=franch_name] > a[href^=/teams/]";
	
	public static void main (String [] args) throws IOException {
		Document connection = Jsoup.connect(url).get();
		Element refinedDoc = connection.body();
		//System.out.println(refinedDoc.toString());
				
		Elements teamNames = refinedDoc.select(teamSelector);
		
		for (int i = 0; i < teamNames.size(); i++) {
			allTeams[i][0] = teamNames.get(i).text();
			System.out.println(teamNames.get(i));
			
			String teamLink = teamNames.get(i).absUrl("href") + "2019.html";
			System.out.println("LINK: " + teamLink);
			addPlayers(teamLink, i);
		}
		
		//printArray(allTeams);
	}
	
	private static void addPlayers(String teamUrl, int i) throws IOException {
		Document teamConn = Jsoup.connect(teamUrl).ignoreHttpErrors(true).get();
		
		System.out.println("URL: " + teamUrl + "\nindex: " + i);
		//System.out.println(refinedDoc.toString());
		
	}
//	-----------------HELPER METHODS-----------------
	
	private static void printArray(String [][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
