package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import seventh.accout.BlankAccout;

import java.awt.Color;

<<<<<<< HEAD
=======
/**
 * �û���������
 *
 */
>>>>>>> Jachin
public class UsersLoginPwsd {

	private JFrame frameUserLoginPwsd;
	private JPasswordField textUserPswd;
	public static String CardNumber; // TODO ����ģʽ��ȡ����
<<<<<<< HEAD
=======
	private String File = "E:\\Code\\java\\CCB_ATM";
	// private String File = ".";
>>>>>>> Jachin

	public JFrame getFrameUserLoginPwsd() {
		return frameUserLoginPwsd;
	}

<<<<<<< HEAD
	/**
	 * Launch the application.
	 */
=======
>>>>>>> Jachin
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersLoginPwsd window = new UsersLoginPwsd();
					window.frameUserLoginPwsd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

<<<<<<< HEAD
	/**
	 * Create the application.
	 */
=======
>>>>>>> Jachin
	public UsersLoginPwsd() {
		initialize();
	}

<<<<<<< HEAD
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUserLoginPwsd = new JFrame();
		frameUserLoginPwsd.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\CCB_ATM\\img\\CCB.png"));
=======
	private void initialize() {
		frameUserLoginPwsd = new JFrame();
		frameUserLoginPwsd.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
>>>>>>> Jachin
		frameUserLoginPwsd.setTitle("�й���������ATM");
		frameUserLoginPwsd.setResizable(false);
		frameUserLoginPwsd.setBounds(360, 150, 1095, 750);
		frameUserLoginPwsd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ATMButton button_1 = new ATMButton("<html><center>ȷ��<br>Confirm<center></html>");
		button_1.addActionListener(new UserLogin());
		button_1.setBounds(875, 550, 200, 80);
		frameUserLoginPwsd.getContentPane().add(button_1);

		textUserPswd = new JPasswordField();
		textUserPswd.setFont(new Font("΢���ź� Light", Font.PLAIN, 40));
		textUserPswd.setBounds(380, 338, 294, 53);
		frameUserLoginPwsd.getContentPane().add(textUserPswd);
		textUserPswd.setColumns(10);

		JLabel lblInputcardnum = new JLabel("��������:");
		lblInputcardnum.setForeground(Color.WHITE);
		lblInputcardnum.setFont(new Font("��Բ", Font.BOLD, 24));
		lblInputcardnum.setBounds(380, 282, 288, 43);
		frameUserLoginPwsd.getContentPane().add(lblInputcardnum);

		JLabel lblBg = new JLabel("");
<<<<<<< HEAD
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\ATM_bg.png"));
=======
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
>>>>>>> Jachin
		lblBg.setBounds(3, 0, 1086, 715);
		frameUserLoginPwsd.getContentPane().add(lblBg);
	}

	// �û���½������
	class UserLogin implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String cardNum = String.valueOf(BlankAccout.getInstance().getCardNum());
			@SuppressWarnings("deprecation")
			String psd = textUserPswd.getText().trim();
			try {
				if (cardNum.equals("6221") & psd.equals("123")) {
					JOptionPane.showMessageDialog(null, "��½�ɹ�", null, JOptionPane.INFORMATION_MESSAGE);
					frameUserLoginPwsd.setVisible(false);
					MainFrame.main(null);
					
					// ���û��˺ű�������
					BlankAccout.getInstance().setCardNum(Long.parseLong(cardNum));
					// ����������������ݿ⣬��������Ϣ���뵥��֮�У�����
					// BlankAccout.getInstance().setDepositLimit(4000);
					// BlankAccout.getInstance().setBlank("�й�����");
					// ����ʲô��
					frameUserLoginPwsd.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "�������", null, JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

}