package seventh.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginUI {

	private JFrame frameAdmin;
	private JTextField textAdminAccount;
	private JTextField textAdminPswd;
	private JButton buttonLogin;
	private JLabel labelMainBG;
<<<<<<< HEAD:src/seventh/admin/LoginUI.java
	private String File = "E:\\Code\\java\\Eclipse-ATM\\CCB_ATM";
=======
	private String File = "E:\\Code\\java\\CCB_ATM";
>>>>>>> Jachin:src/seventh/admin/LoginUI.java
	// private String File = ".";

	/**
	 * ������̨����ϵͳ
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LoginUI window = new LoginUI();
					window.frameAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ����Ӧ��
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * ʵ�������
	 */
	public void initialize() {
		frameAdmin = new JFrame();
		frameAdmin.setResizable(false);
		frameAdmin.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameAdmin.setFont(new Font("��Բ", Font.PLAIN, 18));
		frameAdmin.setTitle("����Ա��½");
		frameAdmin.setBounds(500, 280, 742, 431);
		frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAdmin.getContentPane().setLayout(null);

		JLabel labelAccount = new JLabel("�˺�");
		labelAccount.setToolTipText("�������˺�");
		labelAccount.setFont(new Font("��Բ", Font.BOLD, 18));
		labelAccount.setBounds(345, 114, 57, 46);
		frameAdmin.getContentPane().add(labelAccount);

		JLabel labelAdminPswd = new JLabel("����");
		labelAdminPswd.setFont(new Font("��Բ", Font.BOLD, 18));
		labelAdminPswd.setBounds(345, 188, 57, 46);
		frameAdmin.getContentPane().add(labelAdminPswd);

		textAdminAccount = new JTextField();
		textAdminAccount.setToolTipText("�������˺�");
		textAdminAccount.setHorizontalAlignment(SwingConstants.LEFT);
		textAdminAccount.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		textAdminAccount.setBounds(402, 114, 264, 46);
		frameAdmin.getContentPane().add(textAdminAccount);
		textAdminAccount.setColumns(10);

		textAdminPswd = new JPasswordField();
		textAdminPswd.setToolTipText("����������");
		textAdminPswd.setHorizontalAlignment(SwingConstants.LEFT);
		textAdminPswd.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		textAdminPswd.setColumns(10);
		textAdminPswd.setBounds(402, 188, 264, 46);
		textAdminPswd.addKeyListener(new KeyAdapter() { // �û���������󣬻س���½�������¼�Ҫ�����������ı���
			@Override
			public void keyPressed(KeyEvent a) {
				if (a.getKeyChar() == KeyEvent.VK_ENTER) {
					AdminLogin();
				}
			}
		});
		frameAdmin.getContentPane().add(textAdminPswd);

		buttonLogin = new JButton("\u767B\u9646");

		buttonLogin.setFont(new Font("��Բ", Font.PLAIN, 18));
		buttonLogin.setBounds(560, 268, 77, 35);
		frameAdmin.getContentPane().add(buttonLogin);

		labelMainBG = new JLabel("");
		labelMainBG.setVerticalAlignment(SwingConstants.TOP);
		labelMainBG.setHorizontalAlignment(SwingConstants.LEFT);
		labelMainBG.setIcon(new ImageIcon(File + "\\img\\backGround2.png"));
		labelMainBG.setBounds(0, 0, 736, 396);
		frameAdmin.getContentPane().add(labelMainBG);
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (a.getSource() == buttonLogin) {
					AdminLogin();
				}
			}
		});
	}

	public void AdminLogin() {
		String adminid = "root";
		String passwd = "12345";
		String account = textAdminAccount.getText();
		String password = textAdminPswd.getText();

		if (account.equals(adminid)) {
			if (password.equals(passwd)) {
				JOptionPane.showMessageDialog(null, "��½�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				frameAdmin.dispose();
				AdminUI.main(null);
			} else {
				JOptionPane.showMessageDialog(null, "��������ȷ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "��������ȷ�˺�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
