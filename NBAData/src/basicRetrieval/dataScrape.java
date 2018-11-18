package basicRetrieval;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class dataScrape {
	private static String url = "https://www.basketball-reference.com/teams/";
	private static String playersUrl = "https://www.basketball-reference.com/leagues/NBA_2019_per_game.html";
	private static ArrayList <Team> allTeams = new ArrayList<Team>();
	private static ArrayList <Player> allPlayers = new ArrayList<Player>();
	
	public static void main (String [] args) throws IOException {
		initPlayers();
		//initTeams();
	}
	
	private static void initPlayers() throws IOException{
		String nameSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat^=player]";
		String posSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat^=pos]";
		String ageSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=age]";
		String teamSel = 
				"#per_game_stats > tbody > tr.full_table > td[data-stat=team_id] > a";
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
		
		System.out.println("Player size: " + names.size());
		System.out.println("Position size: " + positions.size());
		System.out.println("Age size: " + ages.size());
		System.out.println("Teams size: " + teams.size());
		System.out.println("Number of players with PPG: " + PPGs.size());
		
		for (int i = 0; i < names.size(); i++) {
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
					Float.parseFloat(fGPcts.get(i).text()), 
					Float.parseFloat(threePs.get(i).text()), 
					Float.parseFloat(threePAs.get(i).text()), 
					Float.parseFloat(threePPcts.get(i).text()), 
					Float.parseFloat(twoPs.get(i).text()),
					Float.parseFloat(twoPAs.get(i).text()), 
					Float.parseFloat(twoPPcts.get(i).text()), 
					Float.parseFloat(eFGPcts.get(i).text()), 
					Float.parseFloat(fTs.get(i).text()),
					Float.parseFloat(fTAs.get(i).text()),
					Float.parseFloat(fTPcts.get(i).text()), 
					Float.parseFloat(oRBs.get(i).text()),
					Float.parseFloat(dRBs.get(i).text()), 
					Float.parseFloat(tRBs.get(i).text()), 
					Float.parseFloat(aSTs.get(i).text()), 
					Float.parseFloat(sTLs.get(i).text()), 
					Float.parseFloat(bLKs.get(i).text()), 
					Float.parseFloat(tOVs.get(i).text()), 
					Float.parseFloat(pFs.get(i).text()), 
					Float.parseFloat(PPGs.get(i).text())));
		}	   
	}
	
	private static void initTeams() throws IOException {	
		String teamSelector = 
				"div[id=all_teams_active] [data-stat^=franch_name] > a[href^=/teams/]";
		
		/* Start */
		Document connection = Jsoup.connect(url).get();
		Element refinedDoc = connection.body();	
		Elements teamNames = refinedDoc.select(teamSelector);	
		
	}
}
