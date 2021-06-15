import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClubRank {
	private JFrame f;
	private JPanel jpClubRankMain, jpClubRank;
	private JLabel jlbClubRank;
	private JTextField jtfRank, jtfClub, jtfPlayed, jtfPoints, jtfWon, jtfDrawn, jtfLost, jtfGoals_For,
			jtfGoals_Conceded, jtfGoals_Difference;
	private JLabel jlbRank, jlbClub, jlbPlayed, jlbPoints, jlbWon, jlbDrawn, jlbLost, jlbGoals_For, jlbGoals_Conceded,
			jlbGoals_Difference;
	private GridLayout gl;
	ArrayList<RankVO> printClubRank;

	public ClubRank() {
		f = new JFrame("잉글랜드 프리미어리그 클럽 순위");

		jpClubRankMain = new JPanel();
		jpClubRank = new JPanel();

		jlbClubRank = new JLabel("20/21 잉글랜드 프리미어리그 순위", JLabel.CENTER);

		jtfRank = new JTextField("순위");
		jtfClub = new JTextField("클럽명");
		jtfPlayed = new JTextField("경기수");
		jtfPoints = new JTextField("승점");
		jtfWon = new JTextField("승");
		jtfDrawn = new JTextField("무");
		jtfLost = new JTextField("패");
		jtfGoals_For = new JTextField("득점");
		jtfGoals_Conceded = new JTextField("실점");
		jtfGoals_Difference = new JTextField("득실차");
	}

	public void ClubRankFrame() {

		gl = new GridLayout(21, 10);

		f.setSize(1000, 700);
		f.setVisible(true);

		f.add("North", jpClubRankMain);
		f.add("Center", jpClubRank);

		jpClubRankMain.setSize(350, 30);
		jpClubRankMain.add(jlbClubRank);
		jpClubRankMain.setBackground(Color.WHITE);
		
		jpClubRank.setSize(990, 600);
		jpClubRank.setLocation(0, 70);
		jpClubRank.setLayout(gl);
		jpClubRank.setVisible(true);
		jpClubRank.setBackground(Color.WHITE);

		jpClubRank.add(jtfRank);
		jpClubRank.add(jtfClub);
		jpClubRank.add(jtfPlayed);
		jpClubRank.add(jtfPoints);
		jpClubRank.add(jtfWon);
		jpClubRank.add(jtfDrawn);
		jpClubRank.add(jtfLost);
		jpClubRank.add(jtfGoals_For);
		jpClubRank.add(jtfGoals_Conceded);
		jpClubRank.add(jtfGoals_Difference);

		jlbClubRank.setSize(350, 30);
		jlbClubRank.setLocation(225, 30);
		jlbClubRank.setFont(new Font("", Font.BOLD, 17));

		jtfRank.setHorizontalAlignment(JTextField.CENTER);
		jtfClub.setHorizontalAlignment(JTextField.LEFT);
		jtfPlayed.setHorizontalAlignment(JTextField.CENTER);
		jtfPoints.setHorizontalAlignment(JTextField.CENTER);
		jtfWon.setHorizontalAlignment(JTextField.CENTER);
		jtfDrawn.setHorizontalAlignment(JTextField.CENTER);
		jtfLost.setHorizontalAlignment(JTextField.CENTER);
		jtfGoals_For.setHorizontalAlignment(JTextField.CENTER);
		jtfGoals_Conceded.setHorizontalAlignment(JTextField.CENTER);
		jtfGoals_Difference.setHorizontalAlignment(JTextField.CENTER);

		jtfRank.setEditable(false);
		jtfClub.setEditable(false);
		jtfPlayed.setEditable(false);
		jtfPoints.setEditable(false);
		jtfWon.setEditable(false);
		jtfDrawn.setEditable(false);
		jtfLost.setEditable(false);
		jtfGoals_For.setEditable(false);
		jtfGoals_Conceded.setEditable(false);
		jtfGoals_Difference.setEditable(false);
		
		jtfRank.setFont(new Font("", Font.BOLD, 12));
		jtfClub.setFont(new Font("", Font.BOLD, 12));
		jtfPlayed.setFont(new Font("", Font.BOLD, 12));
		jtfPoints.setFont(new Font("", Font.BOLD, 12));
		jtfWon.setFont(new Font("", Font.BOLD, 12));
		jtfDrawn.setFont(new Font("", Font.BOLD, 12));
		jtfLost.setFont(new Font("", Font.BOLD, 12));
		jtfGoals_For.setFont(new Font("", Font.BOLD, 12));
		jtfGoals_Conceded.setFont(new Font("", Font.BOLD, 12));
		jtfGoals_Difference.setFont(new Font("", Font.BOLD, 12));
		
		jtfRank.setBackground(Color.WHITE);
		jtfClub.setBackground(Color.WHITE);
		jtfPlayed.setBackground(Color.WHITE);
		jtfPoints.setBackground(Color.WHITE);
		jtfWon.setBackground(Color.WHITE);
		jtfDrawn.setBackground(Color.WHITE);
		jtfLost.setBackground(Color.WHITE);
		jtfGoals_For.setBackground(Color.WHITE);
		jtfGoals_Conceded.setBackground(Color.WHITE);
		jtfGoals_Difference.setBackground(Color.WHITE);
			
		RankDAO crDAO = new RankDAO();
		printClubRank = crDAO.printClubRank();

		for (int i = 0; i < printClubRank.size(); i++) {
			RankVO data = (RankVO) printClubRank.get(i);
			String club = data.getClub();
			int played = data.getPlayed();
			int points = data.getPoints();
			int won = data.getWon();
			int drawn = data.getDrawn();
			int lost = data.getLost();
			int goalsfor = data.getGoalsfor();
			int goalsconceded = data.getGoalsconceded();
			int goalsdifference = data.getGoalsdifference();

			jlbRank = new JLabel(Integer.toString(i + 1), JLabel.CENTER);
			jlbClub = new JLabel(club, JLabel.LEFT);
			jlbPlayed = new JLabel(Integer.toString(played), JLabel.CENTER);
			jlbPoints = new JLabel(Integer.toString(points), JLabel.CENTER);
			jlbWon = new JLabel(Integer.toString(won), JLabel.CENTER);
			jlbDrawn = new JLabel(Integer.toString(drawn), JLabel.CENTER);
			jlbLost = new JLabel(Integer.toString(lost), JLabel.CENTER);
			jlbGoals_For = new JLabel(Integer.toString(goalsfor), JLabel.CENTER);
			jlbGoals_Conceded = new JLabel(Integer.toString(goalsconceded), JLabel.CENTER);
			jlbGoals_Difference = new JLabel(Integer.toString(goalsdifference), JLabel.CENTER);
			
			ImageIcon icon = new ImageIcon("C:/eplproject/club/" + club + ".jpg");
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			
			jlbClub.setIcon(changeIcon);

			jlbRank.setFont(new Font("", Font.BOLD, 10));
			jlbClub.setFont(new Font("", Font.BOLD, 8));
			jlbPlayed.setFont(new Font("", Font.BOLD, 10));
			jlbPoints.setFont(new Font("", Font.BOLD, 10));
			jlbWon.setFont(new Font("", Font.BOLD, 10));
			jlbDrawn.setFont(new Font("", Font.BOLD, 10));
			jlbLost.setFont(new Font("", Font.BOLD, 10));
			jlbGoals_For.setFont(new Font("", Font.BOLD, 10));
			jlbGoals_Conceded.setFont(new Font("", Font.BOLD, 10));
			jlbGoals_Difference.setFont(new Font("", Font.BOLD, 10));

			jpClubRank.add(jlbRank);
			jpClubRank.add(jlbClub);
			jpClubRank.add(jlbPlayed);
			jpClubRank.add(jlbPoints);
			jpClubRank.add(jlbWon);
			jpClubRank.add(jlbDrawn);
			jpClubRank.add(jlbLost);
			jpClubRank.add(jlbGoals_For);
			jpClubRank.add(jlbGoals_Conceded);
			jpClubRank.add(jlbGoals_Difference);
		}
	}
}
