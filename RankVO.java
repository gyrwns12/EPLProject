
public class RankVO {
	private String club;
	private int played, points, won, drawn, lost, goalsfor, goalsconceded, goalsdifference;

	private String player_name, club_name;
	private int goals, assist, player_played;

	public RankVO(String club, int played, int points, int won, int drawn, int lost, int goalsfor,
			int goalsconceded, int goalsdifference) {
		this.club = club;
		this.played = played;
		this.points = points;
		this.won = won;
		this.drawn = drawn;
		this.lost = lost;
		this.goalsfor = goalsfor;
		this.goalsconceded = goalsconceded;
		this.goalsdifference = goalsdifference;
	}

	public RankVO(String player_name, String club_name, int goals, int assist, int player_played) {
		this.player_name = player_name;
		this.club_name = club_name;
		this.goals = goals;
		this.assist = assist;
		this.player_played = player_played;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public String getClub_name() {
		return club_name;
	}

	public int getGoals() {
		return goals;
	}

	public int getAssist() {
		return assist;
	}

	public int getPlayer_played() {
		return player_played;
	}

	public String getClub() {
		return club;
	}

	public int getPlayed() {
		return played;
	}

	public int getPoints() {
		return points;
	}

	public int getWon() {
		return won;
	}

	public int getDrawn() {
		return drawn;
	}

	public int getLost() {
		return lost;
	}

	public int getGoalsfor() {
		return goalsfor;
	}

	public int getGoalsconceded() {
		return goalsconceded;
	}

	public int getGoalsdifference() {
		return goalsdifference;
	}
}
