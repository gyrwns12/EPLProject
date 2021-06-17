
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<MemberVo> login(String name) {
		ArrayList<MemberVo> login = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM id";
			if (name != null) {
				query += " where id='" + name.toLowerCase() + "'";
			}
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				while (rs.next()) {
					String id = rs.getString("id");
					String password = rs.getString("password");
					String favorite_club = rs.getString("favorite_club");

					MemberVo data = new MemberVo(id, password, favorite_club);
					login.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;
	}

	public ArrayList<MemberVo> idCheck(String id) {
		ArrayList<MemberVo> idCheck = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM id";
			if (id != null) {
				query += " where id='" + id.toLowerCase() + "'";
			}
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() >= 1) {
				JOptionPane.showMessageDialog(null, "중복된 ID 입니다.");
			} else {
				JOptionPane.showMessageDialog(null, "사용 가능한 ID 입니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return idCheck;
	}

	public ArrayList<MemberVo> signup(String id, String pwd, String club) {
		ArrayList<MemberVo> signup = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "INSERT INTO id(id, password, favorite_club) VALUES (";
			if (id != null && pwd != null && club != null) {
				query += "'" + id + "', '" + pwd + "', '" + club + "')";
			}
			rs = stmt.executeQuery(query);
			JOptionPane.showMessageDialog(null, "가입되셨습니다.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "가입을 실패했습니다.");
			e.printStackTrace();
		}
		return signup;
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
