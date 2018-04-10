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
	 * 启动后台管理系统
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
	 * 创建应用
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * 实例化组件
	 */
	public void initialize() {
		frameAdmin = new JFrame();
		frameAdmin.setResizable(false);
		frameAdmin.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameAdmin.setFont(new Font("幼圆", Font.PLAIN, 18));
		frameAdmin.setTitle("管理员登陆");
		frameAdmin.setBounds(500, 280, 742, 431);
		frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAdmin.getContentPane().setLayout(null);

		JLabel labelAccount = new JLabel("账号");
		labelAccount.setToolTipText("请输入账号");
		labelAccount.setFont(new Font("幼圆", Font.BOLD, 18));
		labelAccount.setBounds(345, 114, 57, 46);
		frameAdmin.getContentPane().add(labelAccount);

		JLabel labelAdminPswd = new JLabel("密码");
		labelAdminPswd.setFont(new Font("幼圆", Font.BOLD, 18));
		labelAdminPswd.setBounds(345, 188, 57, 46);
		frameAdmin.getContentPane().add(labelAdminPswd);

		textAdminAccount = new JTextField();
		textAdminAccount.setToolTipText("请输入账号");
		textAdminAccount.setHorizontalAlignment(SwingConstants.LEFT);
		textAdminAccount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textAdminAccount.setBounds(402, 114, 264, 46);
		frameAdmin.getContentPane().add(textAdminAccount);
		textAdminAccount.setColumns(10);

		textAdminPswd = new JPasswordField();
		textAdminPswd.setToolTipText("请输入密码");
		textAdminPswd.setHorizontalAlignment(SwingConstants.LEFT);
		textAdminPswd.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textAdminPswd.setColumns(10);
		textAdminPswd.setBounds(402, 188, 264, 46);
		textAdminPswd.addKeyListener(new KeyAdapter() { // 用户输入密码后，回车登陆。监听事件要设置在密码文本框
			@Override
			public void keyPressed(KeyEvent a) {
				if (a.getKeyChar() == KeyEvent.VK_ENTER) {
					AdminLogin();
				}
			}
		});
		frameAdmin.getContentPane().add(textAdminPswd);

		buttonLogin = new JButton("\u767B\u9646");

		buttonLogin.setFont(new Font("幼圆", Font.PLAIN, 18));
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
				JOptionPane.showMessageDialog(null, "登陆成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				frameAdmin.dispose();
				AdminUI.main(null);
			} else {
				JOptionPane.showMessageDialog(null, "请输入正确密码", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "请输入正确账号", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
