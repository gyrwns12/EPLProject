import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main extends WindowAdapter {
	private JFrame f;
	private JPanel jp;
	private JMenuBar jmb;
	private JMenu jm;
	private JMenuItem jmiEpl, jmiClubInfo, jmiLastMatch;
	private JLabel jlbMain;
	private JButton jbtPlayer, jbtPlayerSearch, jbtClub, jbtClubSearch, jbtPlayerRank, jbtClubRank;
	private JTextField jtfPlayerSearch, jtfClubSearch;
	private ArrayList<SearchVO> SearchPlayer, SearchClub;

	public Main() {
		f = new JFrame("잉글랜드 프리미어리그");

		jp = new JPanel();

		jmb = new JMenuBar();
		jm = new JMenu("정보");
		jmiEpl = new JMenuItem("리그 홈페이지");
		jmiClubInfo = new JMenuItem("구단 정보");
		jmiLastMatch = new JMenuItem("경기 결과");

		jlbMain = new JLabel("20/21 England Premier League", JLabel.CENTER);

		jbtPlayer = new JButton("선수");
		jbtPlayerSearch = new JButton("선수검색");
		jbtClub = new JButton("클럽");
		jbtClubSearch = new JButton("클럽검색");
		jbtPlayerRank = new JButton("선수순위");
		jbtClubRank = new JButton("클럽순위");

		jtfPlayerSearch = new JTextField("선수 이름 입력", JTextField.CENTER);
		jtfClubSearch = new JTextField("클럽 이름 입력", JTextField.CENTER);
	}

// 440, 420
	public void mainFrame() {
		f.setSize(450, 500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.add(jp);
		f.setJMenuBar(jmb);

		jmb.setBackground(Color.WHITE);

		jmb.add(jm);
		jm.add(jmiEpl);
		jm.add(jmiClubInfo);
		jm.add(jmiLastMatch);

		jmiEpl.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				String urlLink = "https://www.premierleague.com/";

				try {
					Desktop.getDesktop().browse(new URI(urlLink));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});

		jmiClubInfo.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				String urlLink = "https://www.premierleague.com/clubs?se=363";

				try {
					Desktop.getDesktop().browse(new URI(urlLink));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});

		jmiLastMatch.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				String urlLink = "https://www.premierleague.com/results?co=1&se=363&cl=-1";

				try {
					Desktop.getDesktop().browse(new URI(urlLink));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});

		jp.setSize(440, 470);
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);

		jp.add(jlbMain);
		jp.add(jbtPlayer);
		jp.add(jbtPlayerSearch);
		jp.add(jbtClub);
		jp.add(jbtClubSearch);
		jp.add(jbtPlayerRank);
		jp.add(jbtClubRank);
		jp.add(jtfPlayerSearch);
		jp.add(jtfClubSearch);

		jlbMain.setSize(300, 30);
		jlbMain.setLocation(65, 50);
		jlbMain.setFont(new Font("", Font.BOLD, 18));

		jbtPlayer.setSize(80, 30);
		jbtPlayerSearch.setSize(80, 30);
		jbtClub.setSize(80, 30);
		jbtClubSearch.setSize(80, 30);
		jbtPlayerRank.setSize(80, 30);
		jbtClubRank.setSize(80, 30);

		jbtPlayer.setLocation(50, 220);
		jbtPlayerSearch.setLocation(320, 220);
		jbtClub.setLocation(50, 290);
		jbtClubSearch.setLocation(320, 290);
		jbtPlayerRank.setLocation(50, 360);
		jbtClubRank.setLocation(320, 360);

		jbtPlayer.setBackground(Color.WHITE);
		jbtPlayerSearch.setBackground(Color.WHITE);
		jbtClub.setBackground(Color.WHITE);
		jbtClubSearch.setBackground(Color.WHITE);
		jbtPlayerRank.setBackground(Color.WHITE);
		jbtClubRank.setBackground(Color.WHITE);

		jbtPlayer.setFont(new Font("", Font.BOLD, 11));
		jbtPlayerSearch.setFont(new Font("", Font.BOLD, 11));
		jbtClub.setFont(new Font("", Font.BOLD, 11));
		jbtClubSearch.setFont(new Font("", Font.BOLD, 11));
		jbtPlayerRank.setFont(new Font("", Font.BOLD, 11));
		jbtClubRank.setFont(new Font("", Font.BOLD, 11));

		jbtPlayer.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				AllPlayer sp = new AllPlayer();
				sp.AllPlayerFrame();
			}
		});

		jbtClub.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				AllClub ac = new AllClub();
				ac.AllClubFrame();
			}
		});

		jbtPlayerSearch.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				SearchDAO crDAO = new SearchDAO();
				SearchPlayer = crDAO.SearchPlayer(jtfPlayerSearch.getText());
				if (SearchPlayer.size() != 0) {
					SearchPlayer sp = new SearchPlayer();
					sp.SearchPlayerFrame();
				} else {
					JOptionPane.showMessageDialog(null, "찾을 수 없는 선수입니다.");
				}
			}
		});

		jbtClubSearch.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				SearchDAO crDAO = new SearchDAO();
				SearchClub = crDAO.SearchClub(jtfClubSearch.getText());

				if (SearchClub.size() != 0) {
					SearchClub sc = new SearchClub();
					sc.SearchClubFrame();
				} else {
					JOptionPane.showMessageDialog(null, "찾을 수 없는 클럽입니다.");
				}
			}
		});

		jbtPlayerRank.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				PlayerRank pr = new PlayerRank();
				pr.PlayerRankFrame();
			}
		});

		jbtClubRank.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				ClubRank cr = new ClubRank();
				cr.ClubRankFrame();
			}
		});

		jtfPlayerSearch.setSize(160, 30);
		jtfClubSearch.setSize(160, 30);

		jtfPlayerSearch.setLocation(145, 220);
		jtfClubSearch.setLocation(145, 290);

		jtfPlayerSearch.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				jtfPlayerSearch.setText("");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		jtfClubSearch.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				jtfClubSearch.setText("");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	class AllPlayer {
		private JFrame f;
		private JPanel jp;
		private JScrollPane jspPlayer;
		private JLabel jlbAllPlayer;
		private JTable jtbSearchPlayer;
		private DefaultTableModel modelPlayer;
		private String[] col = { "이름", "생년월일", "클럽", "국적", "포지션", "키", "몸무게" };
		private String[][] row = new String[0][7];

		public AllPlayer() {
			f = new JFrame("선수 검색 결과");

			jp = new JPanel();

			jlbAllPlayer = new JLabel("모든 선수", JLabel.CENTER);

			modelPlayer = new DefaultTableModel(row, col);
			jtbSearchPlayer = new JTable(modelPlayer);
			jspPlayer = new JScrollPane(jtbSearchPlayer);

		}

		public void AllPlayerFrame() {
			f.setSize(450, 450);
			f.setVisible(true);

			f.add("North", jp);
			f.add("Center", jspPlayer);

			jp.setBackground(Color.WHITE);
			jp.add(jlbAllPlayer);

			SearchDAO scDAO = new SearchDAO();
			ArrayList<SearchVO> list = scDAO.AllPlayer();

			for (SearchVO vo : list) {
				String[] data = { vo.getPlayer_name(), vo.getBirth(), vo.getClub(), vo.getNationality(), vo.getPosit(),
						vo.getHeight(), vo.getWeight() };
				modelPlayer.addRow(data);
			}
		}
	}

	class SearchPlayer {
		private JFrame jf;
		private JPanel jpMain, jpPlayer;
		private JLabel jlbMain, jlbImg, jlbName, jlbClub, jlbNationality, jlbPosition, jlbHeight, jlbWeight;
		private JLabel jlbSearchName, jlbSearchClub, jlbSearchNationality, jlbSearchPosition, jlbSearchHeight,
				jlbSearchWeight;

		public SearchPlayer() {
			jf = new JFrame("선수검색");

			jpMain = new JPanel();
			jpPlayer = new JPanel();

			jlbMain = new JLabel("선수", JLabel.CENTER);
			jlbImg = new JLabel();

			jlbName = new JLabel("이름", JLabel.LEFT);
			jlbClub = new JLabel("클럽", JLabel.LEFT);
			jlbNationality = new JLabel("국적", JLabel.LEFT);
			jlbPosition = new JLabel("포지션", JLabel.LEFT);
			jlbHeight = new JLabel("키", JLabel.LEFT);
			jlbWeight = new JLabel("몸무게", JLabel.LEFT);
		}

		public void SearchPlayerFrame() {
			jf.setSize(400, 650);
			jf.setLayout(null);
			jf.setVisible(true);

			jf.add(jpMain);
			jf.add(jpPlayer);

			jpMain.setSize(400, 300);
			jpMain.setLocation(0, 0);
			jpMain.setLayout(null);
			jpMain.setBackground(Color.WHITE);

			jpMain.add(jlbMain);
			jpMain.add(jlbImg);

			ImageIcon icon = new ImageIcon("C:/eplproject/player/" + jtfPlayerSearch.getText() + ".png");
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(220, 220, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);

			jlbImg.setIcon(changeIcon);
			jlbImg.setLocation(90, 80);
			jlbImg.setSize(220, 220);

			jlbMain.setFont(new Font("", Font.BOLD, 17));
			jlbMain.setSize(40, 40);
			jlbMain.setLocation(180, 10);

			jpPlayer.setSize(400, 330);
			jpPlayer.setLocation(0, 300);
			jpPlayer.setLayout(null);
			jpPlayer.setBackground(Color.WHITE);

			jpPlayer.add(jlbName);
			jpPlayer.add(jlbClub);
			jpPlayer.add(jlbNationality);
			jpPlayer.add(jlbPosition);
			jpPlayer.add(jlbHeight);
			jpPlayer.add(jlbWeight);

			jlbName.setSize(40, 30);
			jlbClub.setSize(40, 30);
			jlbNationality.setSize(40, 30);
			jlbPosition.setSize(40, 30);
			jlbHeight.setSize(40, 30);
			jlbWeight.setSize(40, 30);

			jlbName.setLocation(90, 20);
			jlbClub.setLocation(90, 65);
			jlbNationality.setLocation(90, 110);
			jlbPosition.setLocation(90, 155);
			jlbHeight.setLocation(90, 200);
			jlbWeight.setLocation(90, 245);

//			SearchDAO crDAO = new SearchDAO();
//			SearchPlayer = crDAO.SearchPlayer(jtfPlayerSearch.getText());

			for (int i = 0; i < SearchPlayer.size(); i++) {
				SearchVO data = (SearchVO) SearchPlayer.get(i);

				String player_name = data.getPlayer_name();
				String birth = data.getBirth();
				String club = data.getClub();
				String nationality = data.getNationality();
				String posit = data.getPosit();
				String height = data.getHeight();
				String weight = data.getWeight();

				jlbSearchName = new JLabel(player_name + "(" + birth + ")", JLabel.LEFT);
				jlbSearchClub = new JLabel(club, JLabel.LEFT);
				jlbSearchNationality = new JLabel(nationality, JLabel.LEFT);
				jlbSearchPosition = new JLabel(posit, JLabel.LEFT);
				jlbSearchHeight = new JLabel(height, JLabel.LEFT);
				jlbSearchWeight = new JLabel(weight, JLabel.LEFT);

				jlbSearchName.setSize(200, 30);
				jlbSearchClub.setSize(200, 30);
				jlbSearchNationality.setSize(200, 30);
				jlbSearchPosition.setSize(200, 30);
				jlbSearchHeight.setSize(200, 30);
				jlbSearchWeight.setSize(200, 30);

				jlbSearchName.setLocation(150, 20);
				jlbSearchClub.setLocation(150, 65);
				jlbSearchNationality.setLocation(150, 110);
				jlbSearchPosition.setLocation(150, 155);
				jlbSearchHeight.setLocation(150, 200);
				jlbSearchWeight.setLocation(150, 245);

				jlbSearchName.setFont(new Font("", Font.BOLD, 12));
				jlbSearchClub.setFont(new Font("", Font.BOLD, 12));
				jlbSearchNationality.setFont(new Font("", Font.BOLD, 12));
				jlbSearchPosition.setFont(new Font("", Font.BOLD, 12));
				jlbSearchHeight.setFont(new Font("", Font.BOLD, 12));
				jlbSearchWeight.setFont(new Font("", Font.BOLD, 12));
			}
			jpPlayer.add(jlbSearchName);
			jpPlayer.add(jlbSearchClub);
			jpPlayer.add(jlbSearchNationality);
			jpPlayer.add(jlbSearchPosition);
			jpPlayer.add(jlbSearchHeight);
			jpPlayer.add(jlbSearchWeight);
		}
	}

	class AllClub {
		private JFrame jf;
		private JPanel jp;
		private JScrollPane jsp;
		private JLabel jlbArsenal, jlbAston, jlbBrighton, jlbBurnley, jlbChelsea, jlbCrystal, jlbEverton, jlbFulham,
				jlbLeeds, jlbLeicester, jlbLiverpool, jlbManCity, jlbManUtd, jlbNewcastle, jlbSheffield,
				jlbSouthampton, jlbTottenham, jlbWBA, jlbWestHam, jlbWolver;
		private String[] club = { "Arsenal", "Aston Villa", "Brighton & Hove Albion", "Burnley", "Chelsea",
				"Crystal Palace", "Everton", "Fulham", "Leeds United", "Leicester City", "Liverpool",
				"Manchester City", "Manchester United", "Newcastle United", "Sheffield United", "Southampton",
				"Tottenham Hotspur", "West Bromwich Albion", "West Ham United", "Wolverhampton Wanderers" };

		public AllClub() {
			jf = new JFrame("모든 클럽");

			jp = new JPanel();
			
			jsp = new JScrollPane(jp ,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			for (int i = 0; i < club.length; i++) {
				ImageIcon icon = new ImageIcon("C:/eplproject/allclub/" + club[i] + ".JPG");
				Image img = icon.getImage();
				Image changeImg = img.getScaledInstance(200, 230, Image.SCALE_SMOOTH);
				ImageIcon changeIcon = new ImageIcon(changeImg);
				
				switch (i) {
				case 0:
					jlbArsenal = new JLabel();
					jlbArsenal.setIcon(changeIcon);
					break;
				case 1:
					jlbAston = new JLabel();
					jlbAston.setIcon(changeIcon);
					break;
				case 2:
					jlbBrighton = new JLabel();
					jlbBrighton.setIcon(changeIcon);
					break;
				case 3:
					jlbBurnley = new JLabel();
					jlbBurnley.setIcon(changeIcon);
					break;
				case 4:
					jlbChelsea = new JLabel();
					jlbChelsea.setIcon(changeIcon);
					break;
				case 5:
					jlbCrystal = new JLabel();
					jlbCrystal.setIcon(changeIcon);
					break;
				case 6:
					jlbEverton = new JLabel();
					jlbEverton.setIcon(changeIcon);
					break;
				case 7:
					jlbFulham = new JLabel();
					jlbFulham.setIcon(changeIcon);
					break;
				case 8:
					jlbLeeds = new JLabel();
					jlbLeeds.setIcon(changeIcon);
					break;
				case 9:
					jlbLeicester = new JLabel();
					jlbLeicester.setIcon(changeIcon);
					break;
				case 10:
					jlbLiverpool = new JLabel();
					jlbLiverpool.setIcon(changeIcon);
					break;
				case 11:
					jlbManCity = new JLabel();
					jlbManCity.setIcon(changeIcon);
					break;
				case 12:
					jlbManUtd = new JLabel();
					jlbManUtd.setIcon(changeIcon);
					break;
				case 13:
					jlbNewcastle = new JLabel();
					jlbNewcastle.setIcon(changeIcon);
					break;
				case 14:
					jlbSheffield = new JLabel();
					jlbSheffield.setIcon(changeIcon);
					break;
				case 15:
					jlbSouthampton = new JLabel();
					jlbSouthampton.setIcon(changeIcon);
					break;
				case 16:
					jlbTottenham = new JLabel();
					jlbTottenham.setIcon(changeIcon);
					break;
				case 17:
					jlbWBA = new JLabel();
					jlbWBA.setIcon(changeIcon);
					break;
				case 18:
					jlbWestHam = new JLabel();
					jlbWestHam.setIcon(changeIcon);
					break;
				case 19:
					jlbWolver = new JLabel();
					jlbWolver.setIcon(changeIcon);
					break;
				}
			}
		}
		
		public void AllClubFrame() {
			jf.setSize(900, 800);
			jf.setVisible(true);
			
			jf.add("Center", jsp);
			
			Dimension size = new Dimension();
			size.setSize(880, 1200);
			
			jp.setPreferredSize(size);
			jsp.setViewportView(jp);
			jsp.setBackground(Color.WHITE);
			
			jp.add(jlbArsenal);
			jp.add(jlbAston);
			jp.add(jlbBrighton);
			jp.add(jlbBurnley);
			jp.add(jlbChelsea);
			jp.add(jlbCrystal);
			jp.add(jlbEverton);
			jp.add(jlbFulham);
			jp.add(jlbLeeds);
			jp.add(jlbLeicester);
			jp.add(jlbLiverpool);
			jp.add(jlbManCity);
			jp.add(jlbManUtd);
			jp.add(jlbNewcastle);
			jp.add(jlbSheffield);
			jp.add(jlbSouthampton);
			jp.add(jlbTottenham);
			jp.add(jlbWBA);
			jp.add(jlbWestHam);
			jp.add(jlbWolver);			
			
			jlbArsenal.setSize(200, 230);
			jlbAston.setSize(200, 230);
			jlbBrighton.setSize(200, 230);
			jlbBurnley.setSize(200, 230);
			jlbChelsea.setSize(200, 230);
			jlbCrystal.setSize(200, 230);
			jlbEverton.setSize(200, 230);
			jlbFulham.setSize(200, 230);
			jlbLeeds.setSize(200, 230);
			jlbLeicester.setSize(200, 230);
			jlbLiverpool.setSize(200, 230);
			jlbManCity.setSize(200, 230);
			jlbManUtd.setSize(200, 230);
			jlbNewcastle.setSize(200, 230);
			jlbSheffield.setSize(200, 230);
			jlbSouthampton.setSize(200, 230);
			jlbTottenham.setSize(200, 230);
			jlbWBA.setSize(200, 230);
			jlbWestHam.setSize(200, 230);
			jlbWolver.setSize(200, 230);
			
			jlbArsenal.setLocation(10, 20);
			jlbAston.setLocation(220, 20);
			jlbBrighton.setLocation(430, 20);
			jlbBurnley.setLocation(640, 20);
			jlbChelsea.setLocation(10, 270);
			jlbCrystal.setLocation(220, 270);
			jlbEverton.setLocation(430, 270);
			jlbFulham.setLocation(640, 270);
			jlbLeeds.setLocation(10, 520);
			jlbLeicester.setLocation(220, 520);
			jlbLiverpool.setLocation(430, 520);
			jlbManCity.setLocation(640, 520);
			jlbManUtd.setLocation(10, 770);
			jlbNewcastle.setLocation(220, 770);
			jlbSheffield.setLocation(430, 770);
			jlbSouthampton.setLocation(640, 770);
			jlbTottenham.setLocation(10, 1020);
			jlbWBA.setLocation(220, 1020);
			jlbWestHam.setLocation(430, 1020);
			jlbWolver.setLocation(640, 1020);
		}
	}

	class SearchClub {
		private JFrame f;
		private JPanel jpClub, jpClubMain;
		private JLabel jlbClub;
		private JTextField jtfBackNumber, jtfName, jtfPosit, jtfNationality;
		private JLabel jlbBackNumber, jlbName, jlbPosit, jlbNationality;
		private GridLayout gl;

		public SearchClub() {
			f = new JFrame(jtfClubSearch.getText());

			jpClubMain = new JPanel();
			jpClub = new JPanel();

			ImageIcon icon = new ImageIcon("C:/eplproject/club/" + jtfClubSearch.getText() + ".jpg");
			Image img = icon.getImage();
			Image changeImg = img.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);

			jlbClub = new JLabel(jtfClubSearch.getText(), JLabel.CENTER);
			jlbClub.setIcon(changeIcon);

			jtfBackNumber = new JTextField("등번호");
			jtfName = new JTextField("이름");
			jtfPosit = new JTextField("포지션");
			jtfNationality = new JTextField("국적");
		}

		public void SearchClubFrame() {

			f.setSize(400, 800);
			f.setVisible(true);

			f.add("North", jpClubMain);
			f.add("Center", jpClub);

			jpClubMain.setSize(400, 50);
			jpClubMain.setBackground(Color.WHITE);
			jpClubMain.add(jlbClub);

			jlbClub.setFont(new Font("", Font.BOLD, 17));

			jtfBackNumber.setHorizontalAlignment(JTextField.CENTER);
			jtfName.setHorizontalAlignment(JTextField.LEFT);
			jtfPosit.setHorizontalAlignment(JTextField.LEFT);
			jtfNationality.setHorizontalAlignment(JTextField.LEFT);

			jtfBackNumber.setEditable(false);
			jtfName.setEditable(false);
			jtfPosit.setEditable(false);
			jtfNationality.setEditable(false);

			jtfBackNumber.setBackground(Color.WHITE);
			jtfName.setBackground(Color.WHITE);
			jtfPosit.setBackground(Color.WHITE);
			jtfNationality.setBackground(Color.WHITE);

			jtfBackNumber.setFont(new Font("", Font.BOLD, 12));
			jtfName.setFont(new Font("", Font.BOLD, 12));
			jtfPosit.setFont(new Font("", Font.BOLD, 12));
			jtfNationality.setFont(new Font("", Font.BOLD, 12));

			SearchDAO crDAO = new SearchDAO();
			SearchClub = crDAO.SearchClub(jtfClubSearch.getText());

			gl = new GridLayout(SearchClub.size() + 1, 4);

			jpClub.setSize(360, 600);
			jpClub.setLayout(gl);
			jpClub.setBackground(Color.WHITE);

			jpClub.add(jtfBackNumber);
			jpClub.add(jtfName);
			jpClub.add(jtfPosit);
			jpClub.add(jtfNationality);

			for (int i = 0; i < SearchClub.size(); i++) {
				SearchVO data = (SearchVO) SearchClub.get(i);

				String backnumber = data.getBacknumber();
				String player_name = data.getPlayer_name();
				String posit = data.getPosit();
				String nationality = data.getNationality();

				jlbBackNumber = new JLabel(backnumber, JLabel.CENTER);
				jlbName = new JLabel(player_name, JLabel.LEFT);
				jlbPosit = new JLabel(posit, JLabel.LEFT);
				jlbNationality = new JLabel(nationality, JLabel.LEFT);

				jlbBackNumber.setFont(new Font("", Font.BOLD, 10));
				jlbName.setFont(new Font("", Font.BOLD, 10));
				jlbPosit.setFont(new Font("", Font.BOLD, 10));
				jlbNationality.setFont(new Font("", Font.BOLD, 10));

				jpClub.add(jlbBackNumber);
				jpClub.add(jlbName);
				jpClub.add(jlbPosit);
				jpClub.add(jlbNationality);
			}
		}
	}
}
