import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUp extends WindowAdapter {
	private JFrame f;
	private JPanel jp;
	private JLabel lbId, lbPwd, lbClub;
	private JTextField tfId, tfPwd;
	private JButton btIdCheck, btSignUp;
	private JComboBox<String> cbClub;
	ArrayList<MemberVo> idcheck;
	ArrayList<MemberVo> signup;
	private String[] club = { "Arsenal", "Aston Villa", "Brighton & Hove Albion", "Burnley", "Chelsea",
			"Crystal Palace", "Everton", "Fulham", "Leeds United", "Leicester City", "Liverpool", "Manchester City",
			"Manchester United", "Newcastle United", "Sheffield United", "Southampton", "Tottenham Hotspur",
			"West Bromwich Albion", "West Ham United", "Wolverhampton Wanderers" };

	public SignUp() {
		f = new JFrame("회원 가입");
		
		jp = new JPanel();
		
		lbId = new JLabel("ID");
		lbPwd = new JLabel("Password");
		lbClub = new JLabel("Favorite Club");

		tfId = new JTextField();
		tfPwd = new JTextField();
		
		btIdCheck = new JButton("중복확인");
		btSignUp = new JButton("회원가입");

		cbClub = new JComboBox<String>(club);
	}

	public void startFrame() {
		MemberDAO dao = new MemberDAO();
		f.setSize(450, 400);
		
		jp.setSize(440, 370);
		jp.setBackground(Color.GRAY);
		jp.setLayout(null);

		lbId.setSize(30, 25);
		lbId.setLocation(100, 185);
		lbPwd.setSize(56, 25);
		lbPwd.setLocation(55, 230);
		lbClub.setSize(80, 25);
		lbClub.setLocation(35, 275);

		tfId.setSize(130, 25);
		tfId.setLocation(140, 185);
		tfPwd.setSize(130, 25);
		tfPwd.setLocation(140, 230);
		
		btIdCheck.setSize(90, 25);
		btIdCheck.setLocation(280, 185);
		btSignUp.setSize(90, 25);
		btSignUp.setLocation(280, 230);
		
		btIdCheck.setBackground(Color.WHITE);
		btSignUp.setBackground(Color.WHITE);
		
		btIdCheck.addActionListener(new ActionListener() { // 중복확인 구현
			public void actionPerformed(ActionEvent e) {
				idcheck = dao.idCheck(tfId.getText());
			}
		});
		
		btSignUp.addActionListener(new ActionListener() { // 회원가입 구현
			public void actionPerformed(ActionEvent e) {
				dao.signup(tfId.getText(), tfPwd.getText(), cbClub.getItemAt(cbClub.getSelectedIndex()));
			}
		});

		cbClub.setSize(140, 25);
		cbClub.setLocation(140, 275);
		cbClub.setBackground(Color.WHITE);
		
		jp.add(lbId);
		jp.add(lbPwd);
		jp.add(lbClub);
		jp.add(tfId);
		jp.add(tfPwd);
		jp.add(btIdCheck);
		jp.add(btSignUp);
		jp.add(cbClub);

		f.add(jp);
		
		f.addWindowListener(this);
		f.setLayout(null);
		f.setVisible(true);
	}
}
