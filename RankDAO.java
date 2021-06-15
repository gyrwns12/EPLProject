import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RankDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<RankVO> printClubRank() {
		ArrayList<RankVO> printClubRank = new ArrayList<RankVO>();
		try {
			connDB();

			String query = "SELECT * FROM club_rank ORDER BY points desc";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String club = rs.getString("club_name");
				int played = rs.getInt("played");
				int points = rs.getInt("points");
				int won = rs.getInt("won");
				int drawn = rs.getInt("drawn");
				int lost = rs.getInt("lost");
				int goalsfor = rs.getInt("goals_for");
				int goalsconceded = rs.getInt("goals_conceded");
				int goalsdifference = rs.getInt("goals_difference");

				RankVO data = new RankVO(club, played, points, won, drawn, lost, goalsfor, goalsconceded,
						goalsdifference);
				printClubRank.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return printClubRank;
	}

	public ArrayList<RankVO> printPlayerRank() {
		ArrayList<RankVO> printPlayerRank = new ArrayList<RankVO>();
		try {
			connDB();

			String query = "SELECT * FROM player_rank where rownum <= 20 ORDER BY goals desc";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String player_name = rs.getString("player_name");
				String club_name = rs.getString("club_name");
				int goals = rs.getInt("goals");
				int assist = rs.getInt("assist");
				int player_played = rs.getInt("player_played");

				RankVO data = new RankVO(player_name, club_name, goals, assist, player_played);
				printPlayerRank.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return printPlayerRank;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			// stmt = con.createStatement();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
