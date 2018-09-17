package basicRetrieval;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class dataScrape {
	private static final String year = "2019.html";
	private static final int NUM_TEAMS = 30;
	private static String url = "https://www.basketball-reference.com/teams/";
	private static ArrayList <Team> teams = new ArrayList<Team>(NUM_TEAMS);
	
	public static void main (String [] args) throws IOException {
		init();
	}
	
	private static void init() throws IOException {	
		String teamSelector = 
				"div[id=all_teams_active] [data-stat^=franch_name] > a[href^=/teams/]";
		
		/* Start */
		Document connection = Jsoup.connect(url).get();
		Element refinedDoc = connection.body();
		System.out.println(refinedDoc.toString());
			
		Elements teamNames = refinedDoc.select(teamSelector);	
		
		/* initialize list of teams */
		int count = 0;
		for (Element teamName : teamNames) {
			String teamLink = teamName.absUrl("href") + year;
			String name = teamName.text();
			
			Team team = new Team(teamLink, name);
			teams.add(count, team);
			count++;
		}
		System.out.println(teams);
	}
}
