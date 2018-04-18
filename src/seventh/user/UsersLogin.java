package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import seventh.accout.BankAccout;
import seventh.dbc.AccountDAO;
import seventh.until.ATMButton;
import seventh.until.NumLengthLimit;
import seventh.until.NumLimit;

import java.awt.Color;

/**
 * 用户输入密码
 *
 */
public class UsersLogin {

	private JFrame frameUserLogin;
	private JPasswordField textUserPswd;
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";
	private JTextField textField_CardNumber;
	private JLabel label_message;
	private AccountDAO accountDAO = new AccountDAO();

	public JFrame getFrameUserLoginPwsd() {
		return frameUserLogin;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UsersLogin window = new UsersLogin();
					window.frameUserLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UsersLogin() {
		initialize();
	}

	private void initialize() {
		frameUserLogin = new JFrame();
		frameUserLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameUserLogin.setTitle("中国建设银行ATM");
		frameUserLogin.setResizable(false);
		frameUserLogin.setBounds(360, 150, 1095, 750);
		frameUserLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ATMButton button_1 = new ATMButton("<html><center>确认<br>Confirm<center></html>");
		button_1.setForeground(new Color(0, 128, 0));
		button_1.addActionListener(new UserLogin());
		frameUserLogin.getContentPane().setLayout(null);
		button_1.setBounds(875, 550, 200, 80);
		frameUserLogin.getContentPane().add(button_1);

		JLabel lblInputcardnum = new JLabel("请输入账号");
		lblInputcardnum.setForeground(Color.WHITE);
		lblInputcardnum.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputcardnum.setFont(new Font("幼圆", Font.BOLD, 24));
		lblInputcardnum.setBounds(380, 159, 288, 43);
		frameUserLogin.getContentPane().add(lblInputcardnum);

		// TODO T自动填卡号
		textField_CardNumber = new JTextField("656885452136697452");
		textField_CardNumber.setFont(new Font("微软雅黑 Light", Font.PLAIN, 28));
		textField_CardNumber.setBounds(380, 219, 294, 53);
		frameUserLogin.getContentPane().add(textField_CardNumber);
		textField_CardNumber.addKeyListener(new NumLimit());
		// textField_CardNumber.setDocument(new NumLengthLimit(18));

		JLabel lblInputpasswd = new JLabel("请输入6位密码:");
		lblInputpasswd.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputpasswd.setForeground(Color.WHITE);
		lblInputpasswd.setFont(new Font("幼圆", Font.BOLD, 24));
		lblInputpasswd.setBounds(380, 289, 288, 43);
		frameUserLogin.getContentPane().add(lblInputpasswd);

		textUserPswd = new JPasswordField();
		textUserPswd.setFont(new Font("微软雅黑 Light", Font.PLAIN, 40));
		textUserPswd.setBounds(380, 339, 294, 53);
		frameUserLogin.getContentPane().add(textUserPswd);
		textUserPswd.addKeyListener(new NumLimit());
		textUserPswd.setDocument(new NumLengthLimit(6));

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(Color.RED);
		label_message.setFont(new Font("幼圆", Font.BOLD, 20));
		label_message.setBounds(380, 420, 294, 43);
		frameUserLogin.getContentPane().add(label_message);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(2, 0, 1089, 715);
		frameUserLogin.getContentPane().add(lblBg);
	}

	/** 用户登陆监听器
	 * @author Jachin
	 *
	 */
	class UserLogin implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String card = textField_CardNumber.getText();
			String pawd = new String(textUserPswd.getPassword());
			label_message.setText("");
			if (!card.isEmpty()) {
				if (!pawd.isEmpty()) {
					if (BankAccout.getInstance().getAccountDAO().getCardExit(Long.parseLong(card))) {
						// 验证卡号是否存在
						String loginTime = BankAccout.getInstance().getAccountDAO().getLoginTime(Long.parseLong(card));
						String newLoginTime = "";
						int loginCount = loginTime.charAt(10);// 48-51
						loginTime = loginTime.substring(0, 10);
						// 对比日期，如果不是今天的登陆信息，则下一步
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						String today = df.format(new Date());
						if (!loginTime.equals(today)) {
							// 重设日期和次数
							loginTime = today;
							loginCount = 48;
						}
						if (loginTime.equals(today)) {
							// 如果卡号存在，则判断登陆失败信息
							if (loginCount < 51) {
								// 如果登陆失败次数小于3，判断密码
								if (accountDAO.checkPawd(Long.parseLong(card), Long.parseLong(pawd))) {
									newLoginTime = today + (char) (0);
									BankAccout.getInstance().getAccountDAO().setLoginTime(Long.parseLong(card),
											newLoginTime);
									// 如果账号密码正确，就获取账户状态
									String status = BankAccout.getInstance().getAccountDAO()
											.getCardStatu(Long.parseLong(card));
									if (status.equals("正常") || status.equals("冻结")) {
										// 将用户账号保存下来
										BankAccout.getInstance().setCardNum(Long.parseLong(card));
										BankAccout.getInstance().setStatus(status);
										login();
									} else {
										label_message.setText("该账户已" + status);
									}

								} else {
									label_message.setText("密码不正确");
									newLoginTime = today + (char) (loginCount + 1);
									BankAccout.getInstance().getAccountDAO().setLoginTime(Long.parseLong(card),
											newLoginTime);
								}
							} else {
								// 登陆失败3次了，今日内不可再登陆
								label_message.setText("今日允许输入密码次数已超3次");
							}
						}

					} else {
						label_message.setText("账户不存在");
					}
				} else {
					label_message.setText("请输入密码");
				}
			} else {
				label_message.setText("请输入账号");
			}

		}

		@SuppressWarnings("static-access")
		private void login() {
			Long card = BankAccout.getInstance().getCardNum();
			// 设置今日取款限额，设置透支额度，设置转账限额，设置今日转账限额，设置账户余额，设置所属银行，设置银行卡类型
			BankAccout.getInstance()
					.setWithdrawalsLimit(BankAccout.getInstance().getTradingrecDAO().getWithdrawalsLimit(card));

			BankAccout.getInstance()
					.setDepositLimit(BankAccout.getInstance().getTradingrecDAO().getDepositLimit(card));

			BankAccout.getInstance()
					.setTransferLimit(BankAccout.getInstance().getTradingrecDAO().getTransferLimit(card));

			BankAccout.getInstance().setOverdraft((BankAccout.getInstance().getAccountDAO().getCardOverdraft(card)));

			BankAccout.getInstance().setBalance(BankAccout.getInstance().getAccountDAO().getCardBalance(card));

			BankAccout.getInstance().setBlank(BankAccout.getInstance().getAccountDAO().getBanks(card));

			// 添加设置银行卡类型

			frameUserLogin.setVisible(false);
			MainFrame mainFrame = new MainFrame();
			mainFrame.getFrameMain().setVisible(true);
			// 设置倒计时
			mainFrame.startCountdown();
			frameUserLogin.dispose();
		}
	}
}
