package pageTesting;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TeamPage {
	static String url = "https://www.basketball-reference.com/teams/TOR/2018.html"; 
	
	public static void main (String [] args) throws Exception{
		Document connection = Jsoup.connect(url).get();
		Element refinedDoc = connection.body();	
		System.out.println(refinedDoc.toString());
		//Elements teamNames = refinedDoc.select(teamSelector);	
	}
}
