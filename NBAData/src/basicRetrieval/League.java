package basicRetrieval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class League {
	private static String teamsUrl = "https://www.basketball-reference.com/teams/";
	private static String playersUrl = "https://www.basketball-reference.com/leagues/NBA_2019_per_game.html";
	private static ArrayList <Team> allTeams = new ArrayList<Team>();
	private static ArrayList <Player> allPlayers = new ArrayList<Player>();
	
	public static void main (String [] args) throws IOException {
		initPlayers();
		initTeams();
		
		// Collections.sort operates as a modified merge sort, O(nlogn)
//		Collections.sort(allPlayers, new SortByPPG());
//		for (int i = 0; i < allPlayers.size(); i++) {
//			System.out.print(allPlayers.get(i).getName() + ": " + 
//							allPlayers.get(i).getPPG() + "\n");
//		}
	}
	
	/*
	 * Initializes per-game statistics of all players for the current year
	 */
	private static void initPlayers() throws IOException{
		String nameSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat^=player]";
		String posSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat^=pos]";
		String ageSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=age]";
		String teamSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=team_id]";
		String gPSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=g]";
		String gSSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=gs]";
		String mPSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=mp_per_g]";
		String fGSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fg_per_g]";
		String fGASel =
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fga_per_g]";
		String fGPctSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fg_pct]";
		String threePSel =
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fg3_per_g]";
		String threePASel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fg3a_per_g]";
		String threePPctSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fg3_pct]";
		String twoPSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fg2_per_g]";
		String twoPASel =
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fg2a_per_g]";
		String twoPPctSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fg2_pct]";
		String eFGPctSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=efg_pct]";
		String fTSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=ft_per_g]";
		String fTASel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=fta_per_g]";
		String fTPctSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=ft_pct]";
		String oRBSel =
				"#per_game_stats > tbody > tr.full_table > td[data-stat=orb_per_g]";
		String dRBSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=drb_per_g]";
		String tRBSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=trb_per_g]";
		String aSTSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=ast_per_g]";
		String sTLSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=stl_per_g]";
		String bLKSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=blk_per_g]";
		String tOVSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=tov_per_g]";
		String pFSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=pf_per_g]";
		String PPGSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=pts_per_g]";	
		String pageSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=player] > a[href^=/players/]";
		
		
		Document connection = Jsoup.connect(playersUrl).get();
		Element refinedDoc = connection.body();
		
		Elements names = refinedDoc.select(nameSel);
		Elements positions = refinedDoc.select(posSel);
		Elements ages = refinedDoc.select(ageSel);
		Elements teams = refinedDoc.select(teamSel);
		Elements gs = refinedDoc.select(gPSel);
		Elements gStarts = refinedDoc.select(gSSel);
		Elements mPs = refinedDoc.select(mPSel);
		Elements fGs = refinedDoc.select(fGSel);
		Elements fGAs = refinedDoc.select(fGASel);
		Elements fGPcts = refinedDoc.select(fGPctSel);
		Elements threePs = refinedDoc.select(threePSel);
		Elements threePAs = refinedDoc.select(threePASel);
		Elements threePPcts = refinedDoc.select(threePPctSel);
		Elements twoPs = refinedDoc.select(twoPSel);
		Elements twoPAs = refinedDoc.select(twoPASel);
		Elements twoPPcts = refinedDoc.select(twoPPctSel);
		Elements eFGPcts = refinedDoc.select(eFGPctSel);
		Elements fTs = refinedDoc.select(fTSel);
		Elements fTAs = refinedDoc.select(fTASel);
		Elements fTPcts = refinedDoc.select(fTPctSel);
		Elements oRBs = refinedDoc.select(oRBSel);
		Elements dRBs = refinedDoc.select(dRBSel);
		Elements tRBs = refinedDoc.select(tRBSel);
		Elements aSTs = refinedDoc.select(aSTSel);
		Elements sTLs = refinedDoc.select(sTLSel);
		Elements bLKs = refinedDoc.select(bLKSel);
		Elements tOVs = refinedDoc.select(tOVSel);
		Elements pFs = refinedDoc.select(pFSel);
		Elements PPGs = refinedDoc.select(PPGSel);
		Elements pages = refinedDoc.select(pageSel);
		
		for (int i = 0; i < names.size(); i++) {
			Float fGPct;
			Float threePPct;
			Float twoPPct;
			Float eFGPct;
			Float fTPct;
			
			/**Players who have no data in % categories get -1 place holders**/
			if (fGPcts.get(i).text().equals("")) {
				fGPct = -1.0f;
			} else {
				fGPct = Float.parseFloat(fGPcts.get(i).text());
			}
			
			if (threePPcts.get(i).text().equals("")) {
				threePPct = -1.0f;
			} else {
				threePPct = Float.parseFloat(threePPcts.get(i).text());
			}
			
			if (twoPPcts.get(i).text().equals("")) {
				twoPPct = -1.0f;
			} else {
				twoPPct = Float.parseFloat(twoPPcts.get(i).text());
			}
			
			if (eFGPcts.get(i).text().equals("")) {
				eFGPct = -1.0f;
			} else {
				eFGPct = Float.parseFloat(eFGPcts.get(i).text());
			}
			
			if (fTPcts.get(i).text().equals("")) {
				fTPct = -1.0f;
			} else {
				fTPct = Float.parseFloat(fTPcts.get(i).text());
			}
			/************************************************************/
			
			/***********Image Retrieval*************/
			String playerLink = pages.get(i).absUrl("href");
			Document photoConn = Jsoup.connect(playerLink).get();
			Element refinedDoc2 = photoConn.body();
			String imageSel = 
					"#meta > div.media-item > img";		
			String photoLink = refinedDoc2.selectFirst(imageSel).absUrl("src"); 
			/****************************************/
			
			allPlayers.add(new Player(
					names.get(i).text(), 
					positions.get(i).text(), 
					Integer.parseInt(ages.get(i).text()), 
					teams.get(i).text(),
					Integer.parseInt(gs.get(i).text()),
					Integer.parseInt(gStarts.get(i).text()), 
					Float.parseFloat(mPs.get(i).text()), 
					Float.parseFloat(fGs.get(i).text()), 
					Float.parseFloat(fGAs.get(i).text()), 
					fGPct, 
					Float.parseFloat(threePs.get(i).text()), 
					Float.parseFloat(threePAs.get(i).text()), 
					threePPct, 
					Float.parseFloat(twoPs.get(i).text()),
					Float.parseFloat(twoPAs.get(i).text()), 
					twoPPct, 
					eFGPct, 
					Float.parseFloat(fTs.get(i).text()),
					Float.parseFloat(fTAs.get(i).text()),
					fTPct, 
					Float.parseFloat(oRBs.get(i).text()),
					Float.parseFloat(dRBs.get(i).text()), 
					Float.parseFloat(tRBs.get(i).text()), 
					Float.parseFloat(aSTs.get(i).text()), 
					Float.parseFloat(sTLs.get(i).text()), 
					Float.parseFloat(bLKs.get(i).text()), 
					Float.parseFloat(tOVs.get(i).text()), 
					Float.parseFloat(pFs.get(i).text()), 
					Float.parseFloat(PPGs.get(i).text()),
					photoLink));
		}	   
	}
	
	private static void initTeams() throws IOException {	
		String teamSelector = 
				"div[id=all_teams_active] [data-stat^=franch_name] > a[href^=/teams/]";
		
		/* Start */
		Document connection = Jsoup.connect(teamsUrl).get();
		Element refinedDoc = connection.body();	
		Elements teamNames = refinedDoc.select(teamSelector);	
		
		for (Element team: teamNames) {
			String teamLink = team.absUrl("href") + "2019.html";
			allTeams.add(new Team(teamLink, team.text(), allPlayers));			
		}
		
//		for (Team t: allTeams) {
//			System.out.println(t);
//		}
	}
}
