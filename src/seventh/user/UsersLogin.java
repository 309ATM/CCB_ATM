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
 * �û���������
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
		frameUserLogin.setTitle("�й���������ATM");
		frameUserLogin.setResizable(false);
		frameUserLogin.setBounds(360, 150, 1095, 750);
		frameUserLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ATMButton button_1 = new ATMButton("<html><center>ȷ��<br>Confirm<center></html>");
		button_1.setForeground(new Color(0, 128, 0));
		button_1.addActionListener(new UserLogin());
		frameUserLogin.getContentPane().setLayout(null);
		button_1.setBounds(875, 550, 200, 80);
		frameUserLogin.getContentPane().add(button_1);

		JLabel lblInputcardnum = new JLabel("�������˺�");
		lblInputcardnum.setForeground(Color.WHITE);
		lblInputcardnum.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputcardnum.setFont(new Font("��Բ", Font.BOLD, 24));
		lblInputcardnum.setBounds(380, 159, 288, 43);
		frameUserLogin.getContentPane().add(lblInputcardnum);

		// TODO T�Զ����
		textField_CardNumber = new JTextField("656885452136697452");
		textField_CardNumber.setFont(new Font("΢���ź� Light", Font.PLAIN, 28));
		textField_CardNumber.setBounds(380, 219, 294, 53);
		frameUserLogin.getContentPane().add(textField_CardNumber);
		textField_CardNumber.addKeyListener(new NumLimit());
		// textField_CardNumber.setDocument(new NumLengthLimit(18));

		JLabel lblInputpasswd = new JLabel("������6λ����:");
		lblInputpasswd.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputpasswd.setForeground(Color.WHITE);
		lblInputpasswd.setFont(new Font("��Բ", Font.BOLD, 24));
		lblInputpasswd.setBounds(380, 289, 288, 43);
		frameUserLogin.getContentPane().add(lblInputpasswd);

		textUserPswd = new JPasswordField();
		textUserPswd.setFont(new Font("΢���ź� Light", Font.PLAIN, 40));
		textUserPswd.setBounds(380, 339, 294, 53);
		frameUserLogin.getContentPane().add(textUserPswd);
		textUserPswd.addKeyListener(new NumLimit());
		textUserPswd.setDocument(new NumLengthLimit(6));

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(Color.RED);
		label_message.setFont(new Font("��Բ", Font.BOLD, 20));
		label_message.setBounds(380, 420, 294, 43);
		frameUserLogin.getContentPane().add(label_message);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(2, 0, 1089, 715);
		frameUserLogin.getContentPane().add(lblBg);
	}

	/** �û���½������
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
						// ��֤�����Ƿ����
						String loginTime = BankAccout.getInstance().getAccountDAO().getLoginTime(Long.parseLong(card));
						String newLoginTime = "";
						int loginCount = loginTime.charAt(10);// 48-51
						loginTime = loginTime.substring(0, 10);
						// �Ա����ڣ�������ǽ���ĵ�½��Ϣ������һ��
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						String today = df.format(new Date());
						if (!loginTime.equals(today)) {
							// �������ںʹ���
							loginTime = today;
							loginCount = 48;
						}
						if (loginTime.equals(today)) {
							// ������Ŵ��ڣ����жϵ�½ʧ����Ϣ
							if (loginCount < 51) {
								// �����½ʧ�ܴ���С��3���ж�����
								if (accountDAO.checkPawd(Long.parseLong(card), Long.parseLong(pawd))) {
									newLoginTime = today + (char) (0);
									BankAccout.getInstance().getAccountDAO().setLoginTime(Long.parseLong(card),
											newLoginTime);
									// ����˺�������ȷ���ͻ�ȡ�˻�״̬
									String status = BankAccout.getInstance().getAccountDAO()
											.getCardStatu(Long.parseLong(card));
									if (status.equals("����") || status.equals("����")) {
										// ���û��˺ű�������
										BankAccout.getInstance().setCardNum(Long.parseLong(card));
										BankAccout.getInstance().setStatus(status);
										login();
									} else {
										label_message.setText("���˻���" + status);
									}

								} else {
									label_message.setText("���벻��ȷ");
									newLoginTime = today + (char) (loginCount + 1);
									BankAccout.getInstance().getAccountDAO().setLoginTime(Long.parseLong(card),
											newLoginTime);
								}
							} else {
								// ��½ʧ��3���ˣ������ڲ����ٵ�½
								label_message.setText("��������������������ѳ�3��");
							}
						}

					} else {
						label_message.setText("�˻�������");
					}
				} else {
					label_message.setText("����������");
				}
			} else {
				label_message.setText("�������˺�");
			}

		}

		@SuppressWarnings("static-access")
		private void login() {
			Long card = BankAccout.getInstance().getCardNum();
			// ���ý���ȡ���޶����͸֧��ȣ�����ת���޶���ý���ת���޶�����˻��������������У��������п�����
			BankAccout.getInstance()
					.setWithdrawalsLimit(BankAccout.getInstance().getTradingrecDAO().getWithdrawalsLimit(card));

			BankAccout.getInstance()
					.setDepositLimit(BankAccout.getInstance().getTradingrecDAO().getDepositLimit(card));

			BankAccout.getInstance()
					.setTransferLimit(BankAccout.getInstance().getTradingrecDAO().getTransferLimit(card));

			BankAccout.getInstance().setOverdraft((BankAccout.getInstance().getAccountDAO().getCardOverdraft(card)));

			BankAccout.getInstance().setBalance(BankAccout.getInstance().getAccountDAO().getCardBalance(card));

			BankAccout.getInstance().setBlank(BankAccout.getInstance().getAccountDAO().getBanks(card));

			// ����������п�����

			frameUserLogin.setVisible(false);
			MainFrame mainFrame = new MainFrame();
			mainFrame.getFrameMain().setVisible(true);
			// ���õ���ʱ
			mainFrame.startCountdown();
			frameUserLogin.dispose();
		}
	}
}
