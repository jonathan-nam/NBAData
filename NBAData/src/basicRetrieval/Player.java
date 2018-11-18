package basicRetrieval;

public class Player {
	/* General information */
	private String name;
	private String pos;
	private int age;
	private String team;
	private int games, gamesStarted;
	private float minPlayed;
	
	/* Field goal-related numbers */
	private float fGGame;
	private float fGAttempted;
	private float fGPercent;	
	private float threePtrsGame;
	private float threePtrsAtt;
	private float threePtrsPct;
	private float twoPtrsGame;
	private float twoPtrsAtt;
	private float twoPtrsPct;
	private float eFG;
	private float fTGame;
	private float fTAtt;
	private float fTPct;
	
	/* Rebounding numbers */
	private float oRB;
	private float dRB;
	
	/* Big 5 */
	private float PPG;
	private float tRB;
	private float aST;
	private float sTL;
	private float bLK;
	
	/* Player errors */
	private float tOV;
	private float persFouls;
	
	
	public Player(String name, String pos, int age, String team, int games, int gamesStarted, float minPlayed, float fGGame,
			float fGAttempted, float fGPercent, float threePtrsGame, float threePtrsAtt, float threePtrsPct,
			float twoPtrsGame, float twoPtrsAtt, float twoPtrsPct, float eFG, float fTGame, float fTAtt, float fTPct,
			float oRB, float dRB, float tRB, float aST, float sTL, float bLK, float tOV, float persFouls, float PPG) {
		this.name = name;
		this.pos = pos;
		this.age = age;
		this.team = team;
		this.games = games;
		this.gamesStarted = gamesStarted;
		this.minPlayed = minPlayed;
		this.fGGame = fGGame;
		this.fGAttempted = fGAttempted;
		this.fGPercent = fGPercent;
		this.threePtrsGame = threePtrsGame;
		this.threePtrsAtt = threePtrsAtt;
		this.threePtrsPct = threePtrsPct;
		this.twoPtrsGame = twoPtrsGame;
		this.twoPtrsAtt = twoPtrsAtt;
		this.twoPtrsPct = twoPtrsPct;
		this.eFG = eFG;
		this.fTGame = fTGame;
		this.fTAtt = fTAtt;
		this.fTPct = fTPct;
		this.oRB = oRB;
		this.dRB = dRB;
		this.tRB = tRB;
		this.aST = aST;
		this.sTL = sTL;
		this.bLK = bLK;
		this.tOV = tOV;
		this.persFouls = persFouls;
		this.PPG = PPG;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPos() {
		return pos;
	}

	public int getAge() {
		return age;
	}
	
	public String getTeam() {
		return team;
	}

	public int getGames() {
		return games;
	}

	public int getGamesStarted() {
		return gamesStarted;
	}

	public float getMinPlayed() {
		return minPlayed;
	}
	
	public float getfGGame() {
		return fGGame;
	}

	public float getfGAttempted() {
		return fGAttempted;
	}

	public float getfGPercent() {
		return fGPercent;
	}

	public float getThreePtrsGame() {
		return threePtrsGame;
	}

	public float getThreePtrsAtt() {
		return threePtrsAtt;
	}
	
	public float getThreePtrsPct() {
		return threePtrsPct;
	}

	public float getTwoPtrsGame() {
		return twoPtrsGame;
	}

	public float getTwoPtrsAtt() {
		return twoPtrsAtt;
	}
	
	public float getTwoPtrsPct() {
		return twoPtrsPct;
	}

	public float geteFG() {
		return eFG;
	}

	public float getfTGame() {
		return fTGame;
	}

	public float getfTAtt() {
		return fTAtt;
	}

	public float getfTPct() {
		return fTPct;
	}

	public float getoRB() {
		return oRB;
	}
	
	public float getdRB() {
		return dRB;
	}

	public float gettRB() {
		return tRB;
	}

	public float getaST() {
		return aST;
	}

	public float getsTL() {
		return sTL;
	}

	public float getbLK() {
		return bLK;
	}

	public float gettOV() {
		return tOV;
	}

	public float getPersFouls() {
		return persFouls;
	}
	
	public float getPPG() {
		return PPG;
	}
	
	public String toString() {
		return name;
	}
}
