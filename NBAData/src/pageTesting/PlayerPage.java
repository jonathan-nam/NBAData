package pageTesting;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PlayerPage {
	static String url = "https://www.basketball-reference.com/players/"; 
	
	public static void main (String [] args) throws Exception{
		Document connection = Jsoup.connect(url).get();
		Element refinedDoc = connection.body();	
		//System.out.println(refinedDoc.toString());
		//Elements teamNames = refinedDoc.select(teamSelector);	
		
		Elements activePlayers = refinedDoc.getElementsByTag("strong");
		for (Element e: activePlayers) {
			System.out.println(e.toString());
		}
	}
}	
