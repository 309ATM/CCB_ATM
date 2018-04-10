package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import seventh.accout.BlankAccout;

import javax.swing.SwingConstants;
import java.awt.Color;

<<<<<<< HEAD
=======
/**
 * �û����뿨��
 *
 */
>>>>>>> Jachin
public class UserLoginCardNum {

	private JFrame frameUserLoginCard;
	private JTextField textField_CardNumber;
	private UsersLoginPwsd usersLoginPwsd = new UsersLoginPwsd();
	private JLabel label;
<<<<<<< HEAD
=======
	private String File = "E:\\Code\\java\\CCB_ATM";
	// private String File = ".";
>>>>>>> Jachin

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UserLoginCardNum window = new UserLoginCardNum();
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
	public UserLoginCardNum() {
		initialize();
		usersLoginPwsd.getFrameUserLoginPwsd().setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUserLoginCard = new JFrame();
		frameUserLoginCard.setTitle("�й���������ATM");
		frameUserLoginCard.setIconImage(
<<<<<<< HEAD
				Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\CCB_ATM\\img\\CCB.png"));
=======
				Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
>>>>>>> Jachin
		frameUserLoginCard.setResizable(false);
		frameUserLoginCard.setBounds(360, 150, 1095, 750);
		frameUserLoginCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUserLoginCard.getContentPane().setLayout(null);

		ATMButton button_1 = new ATMButton("<html>ȷ��<br>Confirm<html>");
		button_1.addActionListener(new CardNum());
		button_1.setBounds(875, 550, 200, 80);
		frameUserLoginCard.getContentPane().add(button_1);

		textField_CardNumber = new JTextField();
		textField_CardNumber.setFont(new Font("΢���ź� Light", Font.PLAIN, 40));
		textField_CardNumber.setBounds(380, 338, 294, 53);
		frameUserLoginCard.getContentPane().add(textField_CardNumber);
		textField_CardNumber.setColumns(10);

		JLabel lblInputcardnum = new JLabel("�����뿨��");
		lblInputcardnum.setForeground(Color.WHITE);
		lblInputcardnum.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputcardnum.setFont(new Font("��Բ", Font.BOLD, 24));
		lblInputcardnum.setBounds(380, 282, 288, 43);
		frameUserLoginCard.getContentPane().add(lblInputcardnum);
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("��Բ", Font.BOLD, 24));
		label.setBounds(380, 404, 288, 43);
		label.setVisible(false);
		frameUserLoginCard.getContentPane().add(label);

		JLabel lblBg = new JLabel("");
<<<<<<< HEAD
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\ATM_bg.png"));
=======
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
>>>>>>> Jachin
		lblBg.setBounds(3, 0, 1086, 715);
		frameUserLoginCard.getContentPane().add(lblBg);
	}

	public Boolean poundage(String card) {
		// �ж���������
		return true;
	}

	public void deposit(String card, int money) {
		// ����
	}
 
	class CardNum implements ActionListener {

		

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!textField_CardNumber.getText().isEmpty()) {
				// TODO �жϿ����Ƿ����
				//����
				BlankAccout.getInstance().setCardNum(Long.parseLong(textField_CardNumber.getText().trim()));
				frameUserLoginCard.dispose();
				usersLoginPwsd.getFrameUserLoginPwsd().setVisible(true);
				//���Ų�����
				//TODO ��ʾ���Ų����ڴ���,��������else_block��д��
			} else {
				label.setText("���ѣ������뿨��!");
				label.setVisible(true);
			}
		}
	}
}