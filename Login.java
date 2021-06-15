import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends WindowAdapter {
	private JFrame f;
	private JPanel jp;
	private JLabel lbID, lbPwd, lbimg;
	private JTextField inpId, inpPwd, msg;
	private JButton btLogin, btSignUp;
	ArrayList<MemberVo> login;

	public Login() { // 로그인 화면 컴포넌트 구현
		f = new JFrame("로그인");

		jp = new JPanel();
		
		lbID = new JLabel("ID");
		lbPwd = new JLabel("Password");
		lbimg = new JLabel();

		inpId = new JTextField("아이디를 입력하세요");
		inpPwd = new JPasswordField("패스워드를 입력하세요");
		msg = new JTextField();

		btLogin = new JButton("로그인");
		btSignUp = new JButton("회원가입");
	}

	public void startFrame() { // 로그인 프레임 컴포넌트 사이즈, 위치 조정
		MemberDAO dao = new MemberDAO();
		
		ImageIcon icon = new ImageIcon("C:/eplproject/club/premier league.jpg");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(300, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		f.setSize(450, 400);
		f.add(jp);
		
		jp.setSize(440, 370);
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);

		lbID.setSize(30, 25);
		lbPwd.setSize(56, 25);
		lbID.setLocation(100, 230);
		lbPwd.setLocation(55, 275);
		
		lbID.setFont(new Font("", Font.BOLD, 12));
		lbPwd.setFont(new Font("", Font.BOLD, 12));
		
		lbimg.setSize(300, 130);
		lbimg.setLocation(60, 30);
		lbimg.setIcon(changeIcon);

		inpId.setSize(130, 25);
		inpPwd.setSize(130, 25);
		inpId.setLocation(140, 230);
		inpPwd.setLocation(140, 275);

		inpId.addMouseListener(new MouseListener() { // id 입력 텍스트필드에 마우스를 갖다대면 빈칸으로 바꿈
			public void mouseClicked(MouseEvent e) {
				inpId.setText("");
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

		inpPwd.addMouseListener(new MouseListener() { // Password 입력칸에 마우스를 갖다대면 빈칸으로 바꿈
			public void mouseClicked(MouseEvent e) {
				inpPwd.setText("");
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

		msg.setEditable(false);
		msg.setSize(230, 25);
		msg.setLocation(140, 320);

		btLogin.setSize(90, 25);
		btSignUp.setSize(90, 25);
		btLogin.setLocation(280, 230);
		btSignUp.setLocation(280, 275);
		
		btLogin.setBackground(Color.WHITE);
		btSignUp.setBackground(Color.WHITE);
		
		btLogin.setFont(new Font("", Font.BOLD, 12));
		btSignUp.setFont(new Font("", Font.BOLD, 12));

		btLogin.addActionListener(new ActionListener() { // 로그인 버튼 구현
			public void actionPerformed(ActionEvent e) {

				if (inpId.getText().equals("")) {
					msg.setText("ID를 입력하세요.");
				} else if (inpPwd.getText().equals("")) {
					msg.setText("Password를 입력하세요.");
				} else {
					msg.setText("등록되지 않은 ID입니다.");
				}
				login = dao.login(inpId.getText());

				for (int i = 0; i < login.size(); i++) {
					MemberVo data = (MemberVo) login.get(i);
					String id = data.getId();
					String password = data.getPassword();
					System.out.println(id + " : " + password);
					if (id.equals(inpId.getText()) && password.equals(inpPwd.getText())) {
						msg.setText("로그인 성공");

						Main mi = new Main();
						mi.mainFrame();

						f.dispose();
					} else {
						msg.setText("ID 또는 Password를 확인하세요");
					}
				}
			}
		});

		btSignUp.addActionListener(new ActionListener() { // 회원가입 버튼 구현
			public void actionPerformed(ActionEvent e) {
				SignUp su = new SignUp();
				su.startFrame();
			}
		});

		jp.add(lbID);
		jp.add(lbPwd);
		jp.add(inpId);
		jp.add(inpPwd);
		jp.add(msg);
		jp.add(btLogin);
		jp.add(btSignUp);
		jp.add(lbimg);

		f.addWindowListener(this);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
