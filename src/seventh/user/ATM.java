package seventh.user;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import seventh.until.ATMButton;

/**
 * 用户输入卡号
 *
 */
public class ATM {

	private JFrame frameUserLoginCard;
	private UsersLogin usersLoginPwsd = new UsersLogin();
	private String File = "E:\\Code\\java\\CCB_ATM";
//	 private String File = ".";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ATM window = new ATM();
					window.frameUserLoginCard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATM() {
		initialize();
		usersLoginPwsd.getFrameUserLoginPwsd().setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUserLoginCard = new JFrame();
		frameUserLoginCard.setTitle("中国建设银行ATM");
		frameUserLoginCard.setIconImage(
				Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameUserLoginCard.setResizable(false);
		frameUserLoginCard.setBounds(360, 150, 1095, 750);
		frameUserLoginCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUserLoginCard.getContentPane().setLayout(null);

		ATMButton button_1 = new ATMButton("<html><center>用户登陆<br>User Login</center><html>");
		button_1.addActionListener(new CardNum());
		button_1.setBounds(875, 550, 200, 80);
		frameUserLoginCard.getContentPane().add(button_1);



		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameUserLoginCard.getContentPane().add(lblBg);
	}

	public Boolean poundage(String card) {
		// 判断所属银行
		return true;
	}
 
	class CardNum implements ActionListener {
		boolean flag = true;
		@Override
		public void actionPerformed(ActionEvent e) {
	
		}
	}
}
