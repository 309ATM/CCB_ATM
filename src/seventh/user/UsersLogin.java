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

		//TODO T�Զ����
		textField_CardNumber = new JTextField("656885452136697452");
		textField_CardNumber.setFont(new Font("΢���ź� Light", Font.PLAIN, 28));
		textField_CardNumber.setBounds(380, 219, 294, 53);
		frameUserLogin.getContentPane().add(textField_CardNumber);
		textField_CardNumber.setColumns(10);

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
		textUserPswd.setColumns(10);

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(Color.RED);
		label_message.setFont(new Font("��Բ", Font.BOLD, 20));
		label_message.setBounds(380, 420, 288, 43);
		frameUserLogin.getContentPane().add(label_message);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(2, 0, 1089, 715);
		frameUserLogin.getContentPane().add(lblBg);
	}

	// �û���½������
	class UserLogin implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String card = textField_CardNumber.getText();
			String pawd = new String(textUserPswd.getPassword());
			label_message.setText("");
			if (!card.isEmpty()) {
				if(!pawd.isEmpty()){
					if(BlankAccout.getInstance().getAccountDAO().getCardExit(Long.parseLong(card))){
						if(accountDAO.checkPawd(Long.parseLong(card), Long.parseLong(pawd))){
							//����˺�������ȷ���ͻ�ȡ�˻�״̬
							String status = BlankAccout.getInstance().getAccountDAO().getCardStatu(Long.parseLong(card));
							if(status.equals("����")||status.equals("����")){
							// ���û��˺ű�������
								BlankAccout.getInstance().setCardNum(Long.parseLong(card));
								BlankAccout.getInstance().setStatus(status);
								login();
							}else{
								label_message.setText("���˻���"+status);
							}
							
						}else{
							label_message.setText("���벻��ȷ");
						}
					}else{
						label_message.setText("�˻�������");
					}
				}else{
					label_message.setText("����������");
				}
			} else {
				label_message.setText("�������˺�");
			}


		}
		
		private void login() {
			frameUserLogin.setVisible(false);
			MainFrame.main(null);
			// ����������������ݿ⣬��������Ϣ���뵥��֮�У�����
			// TODO D����ǵ�ȥ����Ϣ������
			//���ý���ȡ���޶����͸֧��ȣ����ý���ת���޶�����˻���������������
			BlankAccout.getInstance().setWithdrawalsLimit(20000);
			BlankAccout.getInstance().setDepositLimit(50000);
			BlankAccout.getInstance().setOverdraft(5000);
			BlankAccout.getInstance().setBalance(100000);
			BlankAccout.getInstance().setBlank("�й�����");
			frameUserLogin.dispose();

		}
	}
}
