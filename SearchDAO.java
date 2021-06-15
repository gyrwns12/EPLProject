import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<SearchVO> AllPlayer() {
		ArrayList<SearchVO> searchPlayer = new ArrayList<SearchVO>();
		try {
			connDB();

			String query = "SELECT player_name, birth, club_name, nationality, posit, height, weight FROM player ";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String player_name = rs.getString("player_name");
				String birth = rs.getString("birth").substring(0, 10);
				String club = rs.getString("club_name");
				String nationality = rs.getString("nationality");
				String posit = rs.getString("posit");
				String height = Integer.toString(rs.getInt("height"));
				String weight = Integer.toString(rs.getInt("weight"));

				SearchVO data = new SearchVO(player_name, birth, club, nationality, posit, height, weight);
				searchPlayer.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchPlayer;
	}
	
	public ArrayList<SearchVO> SearchPlayer(String name) {
		ArrayList<SearchVO> searchPlayer = new ArrayList<SearchVO>();
		try {
			connDB();
			String name2 = name.replace("'", "''");
			String query = "SELECT player_name, birth, club_name, nationality, posit, height, weight FROM player WHERE player_name = '" + name2 + "'";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String player_name = rs.getString("player_name");
				String birth = rs.getString("birth").substring(0, 10);
				String club = rs.getString("club_name");
				String nationality = rs.getString("nationality");
				String posit = rs.getString("posit");
				String height = Integer.toString(rs.getInt("height"));
				String weight = Integer.toString(rs.getInt("weight"));

				SearchVO data = new SearchVO(player_name, birth, club, nationality, posit, height, weight);
				searchPlayer.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchPlayer;
	}

	public ArrayList<SearchVO> SearchClub(String name) {
		ArrayList<SearchVO> searchPlayer = new ArrayList<SearchVO>();
		try {
			connDB();

			String query = "SELECT player_name, backnumber, posit, nationality FROM player WHERE club_name = \'" + name + "\'";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String backnumber = Integer.toString(rs.getInt("backnumber"));
				String player_name = rs.getString("player_name");
				String posit = rs.getString("posit");
				String nationality = rs.getString("nationality");

				SearchVO data = new SearchVO(backnumber, player_name, posit, nationality);
				searchPlayer.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchPlayer;
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
