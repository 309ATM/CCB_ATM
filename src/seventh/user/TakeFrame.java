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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TakeFrame {

	public JFrame frameTake;
	private JTextField textField_money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TakeFrame window = new TakeFrame();
					window.frameTake.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrameTake() {
		return frameTake;
	}

	/**
	 * Create the application.
	 */
	public TakeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameTake = new JFrame();
		frameTake.setIconImage(
				Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
		frameTake.setTitle("中国建设银行ATM");
		frameTake.setResizable(false);
		frameTake.setBounds(360, 150, 1095, 750);
		frameTake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTake.getContentPane().setLayout(null);

		ATMButton btn_100 = new ATMButton("100");
		btn_100.addActionListener(new withdrawal("100"));
		btn_100.setBounds(14, 250, 200, 80);
		frameTake.getContentPane().add(btn_100);

		ATMButton btn_300 = new ATMButton("200");
		btn_300.addActionListener(new withdrawal("200"));
		btn_300.setBounds(14, 402, 200, 80);
		frameTake.getContentPane().add(btn_300);

		ATMButton btn_500 = new ATMButton("500");
		btn_500.addActionListener(new withdrawal("500"));
		btn_500.setBounds(14, 550, 200, 80);
		frameTake.getContentPane().add(btn_500);

		ATMButton btnBack = new ATMButton("<html>退出<br>Exit</html>");
		btnBack.addActionListener(new Back());
		btnBack.setBounds(875, 550, 200, 80);
		frameTake.getContentPane().add(btnBack);

		ATMButton btn_1000 = new ATMButton("1000");
		btn_1000.addActionListener(new withdrawal("1000"));
		btn_1000.setBounds(875, 250, 200, 80);
		frameTake.getContentPane().add(btn_1000);

		ATMButton btn_2000 = new ATMButton("2000");
		btn_2000.addActionListener(new withdrawal("2000"));
		btn_2000.setBounds(875, 402, 200, 80);
		frameTake.getContentPane().add(btn_2000);

		textField_money = new JTextField();
		textField_money.setFont(new Font("微软雅黑 Light", Font.PLAIN, 40));
		textField_money.setBounds(381, 277, 294, 53);
		frameTake.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		ATMButton btn_confirm = new ATMButton("<html>确认<br>Confirm<html>");
		btn_confirm.addActionListener(new withdrawal("2000"));
		btn_confirm.setBounds(425, 402, 200, 80);
		frameTake.getContentPane().add(btn_confirm);

		JLabel label = new JLabel("请输入金额");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("幼圆", Font.BOLD, 20));
		label.setBounds(381, 216, 294, 48);
		frameTake.getContentPane().add(label);

		JLabel lblBg2 = new JLabel("");
		lblBg2.setBounds(3, 0, 1086, 716);
		lblBg2.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\ATM_bg.png"));
		frameTake.getContentPane().add(lblBg2);
	}

	public String getMoney(){
		String moneys = textField_money.getText();
		
		return moneys;
		
	}
	
	class withdrawal implements ActionListener {
		String money;

		public withdrawal(String money) {
			// TODO 自动生成的构造函数存根
			this.money = money;
		}

		public void take(String money) {
			JOptionPane.showMessageDialog(null, "取款" + money, "提示", JOptionPane.INFORMATION_MESSAGE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			take(money);
		}

	}

	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameTake.dispose();
		}
	}
}
