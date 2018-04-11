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
import seventh.until.ATMButton;

import java.awt.Color;

/**
 * �û���������
 *
 */
public class UsersLoginPwsd {

	private JFrame frameUserLoginPwsd;
	private JPasswordField textUserPswd;
//	private String File = "E:\\Code\\java\\CCB_ATM";
	 private String File = ".";

	public JFrame getFrameUserLoginPwsd() {
		return frameUserLoginPwsd;
	}

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

	public UsersLoginPwsd() {
		initialize();
	}

	private void initialize() {
		frameUserLoginPwsd = new JFrame();
		frameUserLoginPwsd.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
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

		JLabel lblInputcardnum = new JLabel("������6λ����:");
		lblInputcardnum.setForeground(Color.WHITE);
		lblInputcardnum.setFont(new Font("��Բ", Font.BOLD, 24));
		lblInputcardnum.setBounds(380, 282, 288, 43);
		frameUserLoginPwsd.getContentPane().add(lblInputcardnum);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameUserLoginPwsd.getContentPane().add(lblBg);
	}

	// �û���½������
	class UserLogin implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String cardNum = String.valueOf(BlankAccout.getInstance().getCardNum());
			String psd = new String(textUserPswd.getPassword());
			try {
				if (psd.length() == 6) {
					if (cardNum.equals("6221") & psd.equals("123456")) {
						JOptionPane.showMessageDialog(null, "��½�ɹ�", null, JOptionPane.INFORMATION_MESSAGE);
						frameUserLoginPwsd.setVisible(false);
						MainFrame.main(null);

						// ���û��˺ű�������
						BlankAccout.getInstance().setCardNum(Long.parseLong(cardNum));
						// ����������������ݿ⣬��������Ϣ���뵥��֮�У�����
						//TODO ����ǵ�ȥ����Ϣ������
						BlankAccout.getInstance().setWithdrawalsLimit(20000);
						BlankAccout.getInstance().setDepositLimit(50000); 
						BlankAccout.getInstance().setBalance(100000);
						BlankAccout.getInstance().setBlank("�й�����");
						
						frameUserLoginPwsd.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "�������", null, JOptionPane.ERROR_MESSAGE);
					} 
				}else {
					JOptionPane.showMessageDialog(null, "���볤�Ȳ���ȷ", null, JOptionPane.ERROR_MESSAGE);					
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

}
