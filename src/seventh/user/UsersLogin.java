package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import seventh.accout.BlankAccout;
import seventh.dbc.AccountDAO;
import seventh.until.ATMButton;

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

		//TODO T自动填卡号
		textField_CardNumber = new JTextField("656885452136697452");
		textField_CardNumber.setFont(new Font("微软雅黑 Light", Font.PLAIN, 28));
		textField_CardNumber.setBounds(380, 219, 294, 53);
		frameUserLogin.getContentPane().add(textField_CardNumber);
		textField_CardNumber.setColumns(10);

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
		textUserPswd.setColumns(10);

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(Color.RED);
		label_message.setFont(new Font("幼圆", Font.BOLD, 20));
		label_message.setBounds(380, 420, 288, 43);
		frameUserLogin.getContentPane().add(label_message);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(2, 0, 1089, 715);
		frameUserLogin.getContentPane().add(lblBg);
	}

	// 用户登陆监听器
	class UserLogin implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String card = textField_CardNumber.getText();
			String pawd = new String(textUserPswd.getPassword());
			label_message.setText("");
			if (!card.isEmpty()) {
				if(!pawd.isEmpty()){
					if(BlankAccout.getInstance().getAccountDAO().getCardExit(Long.parseLong(card))){
						if(accountDAO.checkPawd(Long.parseLong(card), Long.parseLong(pawd))){
							//如果账号密码正确，就获取账户状态
							String status = BlankAccout.getInstance().getAccountDAO().getCardStatu(Long.parseLong(card));
							if(status.equals("正常")||status.equals("冻结")){
							// 将用户账号保存下来
								BlankAccout.getInstance().setCardNum(Long.parseLong(card));
								BlankAccout.getInstance().setStatus(status);
								login();
							}else{
								label_message.setText("该账户已"+status);
							}
							
						}else{
							label_message.setText("密码不正确");
						}
					}else{
						label_message.setText("账户不存在");
					}
				}else{
					label_message.setText("请输入密码");
				}
			} else {
				label_message.setText("请输入账号");
			}


		}
		
		private void login() {
			frameUserLogin.setVisible(false);
			MainFrame.main(null);
			// 接下来这里调用数据库，将所有信息传入单例之中，如下
			// TODO D这里记得去除信息的设置
			//设置今日取款限额，设置透支额度，设置今日转账限额，设置账户余额，设置所属银行
			BlankAccout.getInstance().setWithdrawalsLimit(20000);
			BlankAccout.getInstance().setDepositLimit(50000);
			BlankAccout.getInstance().setOverdraft(5000);
			BlankAccout.getInstance().setBalance(100000);
			BlankAccout.getInstance().setBlank("中国银行");
			frameUserLogin.dispose();

		}
	}
}
