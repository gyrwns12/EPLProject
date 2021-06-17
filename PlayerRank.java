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

public class PlayerRank {
	private JFrame f;
	private JPanel jpPlayerRankMain, jpPlayerRank;
	private JLabel jlbPlayerRankMain;
	private JTextField jtfRank, jtfPlayer_Name, jtfClub_Name, jtfGoals, jtfAssist, jtfPlayer_Played;
	private JLabel jlbRank, jlbPlayer_Name, jlbClub_Name, jlbGoals, jlbAssist, jlbPlayer_Played;
	private GridLayout gl;
	ArrayList<RankVO> printPlayerRank;

	public PlayerRank() {
		f = new JFrame("잉글랜드 프리미어리그 선수 순위");

		jpPlayerRankMain = new JPanel();
		jpPlayerRank = new JPanel();

		jlbPlayerRankMain = new JLabel("20/21 잉글랜드 프리미어 리그 선수 순위", JLabel.CENTER);

		jtfRank = new JTextField("순위");
		jtfPlayer_Name = new JTextField("이름");
		jtfClub_Name = new JTextField("클럽명");
		jtfGoals = new JTextField("골");
		jtfAssist = new JTextField("어시스트");
		jtfPlayer_Played = new JTextField("경기수");
	}

	public void PlayerRankFrame() {
		gl = new GridLayout(21, 6);

		f.setSize(610, 700);
		f.setVisible(true);

		f.add("Center", jpPlayerRank);
		f.add("North", jpPlayerRankMain);

//		jpPlayerRank.setSize(600, 500);
//		jpPlayerRank.setLocation(0, 150);

		jpPlayerRankMain.setBackground(Color.WHITE);

		jpPlayerRankMain.add(jlbPlayerRankMain);

		jpPlayerRank.setLayout(gl);
		jpPlayerRank.setVisible(true);
		jpPlayerRank.setBackground(Color.WHITE);

		jpPlayerRank.add(jtfRank);
		jpPlayerRank.add(jtfPlayer_Name);
		jpPlayerRank.add(jtfClub_Name);
		jpPlayerRank.add(jtfGoals);
		jpPlayerRank.add(jtfAssist);
		jpPlayerRank.add(jtfPlayer_Played);

		jlbPlayerRankMain.setSize(400, 30);
		jlbPlayerRankMain.setLocation(50, 30);
		jlbPlayerRankMain.setFont(new Font("", Font.BOLD, 17));

		jtfRank.setFont(new Font("", Font.BOLD, 11));
		jtfPlayer_Name.setFont(new Font("", Font.BOLD, 11));
		jtfClub_Name.setFont(new Font("", Font.BOLD, 11));
		jtfGoals.setFont(new Font("", Font.BOLD, 11));
		jtfAssist.setFont(new Font("", Font.BOLD, 11));
		jtfPlayer_Played.setFont(new Font("", Font.BOLD, 11));

		jtfRank.setBackground(Color.WHITE);
		jtfPlayer_Name.setBackground(Color.WHITE);
		jtfClub_Name.setBackground(Color.WHITE);
		jtfGoals.setBackground(Color.WHITE);
		jtfAssist.setBackground(Color.WHITE);
		jtfPlayer_Played.setBackground(Color.WHITE);

		jtfRank.setHorizontalAlignment(JTextField.CENTER);
		jtfPlayer_Name.setHorizontalAlignment(JTextField.LEFT);
		jtfClub_Name.setHorizontalAlignment(JTextField.LEFT);
		jtfGoals.setHorizontalAlignment(JTextField.CENTER);
		jtfAssist.setHorizontalAlignment(JTextField.CENTER);
		jtfPlayer_Played.setHorizontalAlignment(JTextField.CENTER);

		jtfRank.setEditable(false);
		jtfPlayer_Name.setEditable(false);
		jtfClub_Name.setEditable(false);
		jtfGoals.setEditable(false);
		jtfAssist.setEditable(false);
		jtfPlayer_Played.setEditable(false);

		RankDAO crDAO = new RankDAO();
		printPlayerRank = crDAO.printPlayerRank();

		for (int i = 0; i < printPlayerRank.size(); i++) {
			RankVO data = (RankVO) printPlayerRank.get(i);
			String player_name = data.getPlayer_name();
			String club_name = data.getClub_name();
			int goals = data.getGoals();
			int assist = data.getAssist();
			int player_played = data.getPlayer_played();

			jlbRank = new JLabel(Integer.toString(i + 1), JLabel.CENTER);
			jlbPlayer_Name = new JLabel(player_name, JLabel.LEFT);
			jlbClub_Name = new JLabel(club_name, JLabel.LEFT);
			jlbGoals = new JLabel(Integer.toString(goals), JLabel.CENTER);
			jlbAssist = new JLabel(Integer.toString(assist), JLabel.CENTER);
			jlbPlayer_Played = new JLabel(Integer.toString(player_played), JLabel.CENTER);

			ImageIcon icon = new ImageIcon("C:/eplproject/club/" + club_name + ".jpg");
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);

			jlbClub_Name.setIcon(changeIcon);

			jlbRank.setFont(new Font("", Font.BOLD, 10));
			jlbPlayer_Name.setFont(new Font("", Font.BOLD, 8));
			jlbClub_Name.setFont(new Font("", Font.BOLD, 8));
			jlbGoals.setFont(new Font("", Font.BOLD, 10));
			jlbAssist.setFont(new Font("", Font.BOLD, 10));
			jlbPlayer_Played.setFont(new Font("", Font.BOLD, 10));

			jpPlayerRank.add(jlbRank);
			jpPlayerRank.add(jlbPlayer_Name);
			jpPlayerRank.add(jlbClub_Name);
			jpPlayerRank.add(jlbGoals);
			jpPlayerRank.add(jlbAssist);
			jpPlayerRank.add(jlbPlayer_Played);
		}
	}
}
