package basicRetrieval;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 ******This code is unused.****** 
 * Was initially used to extract player images.
 * Initialization code was eventually reconfigured
 * to include image retrieval.
 */

public class ImageRetrieval {
	public static void main (String [] args) throws IOException {
				String playerPage = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=player] > a[href^=/players/]";
		
		Document connection = Jsoup.connect("https://www.basketball-reference.com/leagues/NBA_2019_per_game.html").get();
		Element refinedDoc = connection.body();
		Elements playerPages = refinedDoc.select(playerPage);
		
		for (Element player: playerPages) {
			String imageSel = 
					"#meta > div.media-item > img";
			String playerLink = player.absUrl("href");
			//System.out.println(playerLink);
			
			Document conn2 = Jsoup.connect(playerLink).get();
			Element refinedDoc2 = conn2.body();
			Elements teamImages = refinedDoc2.select(imageSel);
			
			for (Element image: teamImages) {
				System.out.println(image.absUrl("src"));
			}
		}
	}
}
