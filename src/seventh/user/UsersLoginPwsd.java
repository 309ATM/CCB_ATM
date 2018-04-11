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
 * 用户输入密码
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
		frameUserLoginPwsd.setTitle("中国建设银行ATM");
		frameUserLoginPwsd.setResizable(false);
		frameUserLoginPwsd.setBounds(360, 150, 1095, 750);
		frameUserLoginPwsd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ATMButton button_1 = new ATMButton("<html><center>确认<br>Confirm<center></html>");
		button_1.addActionListener(new UserLogin());
		button_1.setBounds(875, 550, 200, 80);
		frameUserLoginPwsd.getContentPane().add(button_1);

		textUserPswd = new JPasswordField();
		textUserPswd.setFont(new Font("微软雅黑 Light", Font.PLAIN, 40));
		textUserPswd.setBounds(380, 338, 294, 53);
		frameUserLoginPwsd.getContentPane().add(textUserPswd);
		textUserPswd.setColumns(10);

		JLabel lblInputcardnum = new JLabel("请输入6位密码:");
		lblInputcardnum.setForeground(Color.WHITE);
		lblInputcardnum.setFont(new Font("幼圆", Font.BOLD, 24));
		lblInputcardnum.setBounds(380, 282, 288, 43);
		frameUserLoginPwsd.getContentPane().add(lblInputcardnum);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameUserLoginPwsd.getContentPane().add(lblBg);
	}

	// 用户登陆监听器
	class UserLogin implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String cardNum = String.valueOf(BlankAccout.getInstance().getCardNum());
			String psd = new String(textUserPswd.getPassword());
			try {
				if (psd.length() == 6) {
					if (cardNum.equals("6221") & psd.equals("123456")) {
						JOptionPane.showMessageDialog(null, "登陆成功", null, JOptionPane.INFORMATION_MESSAGE);
						frameUserLoginPwsd.setVisible(false);
						MainFrame.main(null);

						// 将用户账号保存下来
						BlankAccout.getInstance().setCardNum(Long.parseLong(cardNum));
						// 接下来这里调用数据库，将所有信息传入单例之中，如下
						//TODO 这里记得去除信息的设置
						BlankAccout.getInstance().setWithdrawalsLimit(20000);
						BlankAccout.getInstance().setDepositLimit(50000); 
						BlankAccout.getInstance().setBalance(100000);
						BlankAccout.getInstance().setBlank("中国银行");
						
						frameUserLoginPwsd.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "密码错误", null, JOptionPane.ERROR_MESSAGE);
					} 
				}else {
					JOptionPane.showMessageDialog(null, "密码长度不正确", null, JOptionPane.ERROR_MESSAGE);					
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

}
