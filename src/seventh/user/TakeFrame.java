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
import seventh.until.ATMButton;

import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * 取款
 *
 */
public class TakeFrame {

	public JFrame frameTake;
	private MessageFrame messageFrame = new MessageFrame();
	private JTextField textField_money;
	private String[] message = new String[4];
	// 是不是透支取款
	Boolean isOverdeaft;
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";
	private JLabel label_message;

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
		frameTake.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameTake.setTitle("中国建设银行ATM");
		frameTake.setResizable(false);
		frameTake.setBounds(360, 150, 1095, 750);
		frameTake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTake.getContentPane().setLayout(null);

		ATMButton btn_100 = new ATMButton("100");
		btn_100.addActionListener(new withdrawal("100"));
		btn_100.setBounds(14, 220, 160, 70);
		frameTake.getContentPane().add(btn_100);

		ATMButton btn_300 = new ATMButton("200");
		btn_300.addActionListener(new withdrawal("200"));
		btn_300.setBounds(14, 330, 160, 70);
		frameTake.getContentPane().add(btn_300);

		ATMButton btn_500 = new ATMButton("500");
		btn_500.addActionListener(new withdrawal("500"));
		btn_500.setBounds(14, 440, 160, 70);
		frameTake.getContentPane().add(btn_500);

		ATMButton btnBack = new ATMButton("<html><center>退出<br>Exit</center></html>");
		btnBack.setForeground(Color.RED);
		btnBack.addActionListener(new Back());
		btnBack.setBounds(14, 550, 160, 70);
		frameTake.getContentPane().add(btnBack);

		ATMButton btn_1000 = new ATMButton("1000");
		btn_1000.addActionListener(new withdrawal("1000"));
		btn_1000.setBounds(915, 220, 160, 70);
		frameTake.getContentPane().add(btn_1000);

		ATMButton btn_2000 = new ATMButton("2000");
		btn_2000.addActionListener(new withdrawal("2000"));
		btn_2000.setBounds(915, 330, 160, 70);
		frameTake.getContentPane().add(btn_2000);

		textField_money = new JTextField();
		textField_money.setFont(new Font("微软雅黑 Light", Font.PLAIN, 40));
		textField_money.setBounds(381, 277, 294, 53);
		frameTake.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		ATMButton btn_confirm = new ATMButton("<html><center>确认<br>Confirm</center></html>");
		btn_confirm.setForeground(new Color(0, 128, 0));
		btn_confirm.addActionListener(new CustomWithdrawal());
		btn_confirm.setBounds(915, 550, 160, 70);
		frameTake.getContentPane().add(btn_confirm);

		JLabel label = new JLabel("请输入金额");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("幼圆", Font.BOLD, 20));
		label.setBounds(381, 216, 294, 48);
		frameTake.getContentPane().add(label);

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(Color.red);
		label_message.setFont(new Font("幼圆", Font.BOLD, 20));
		label_message.setBounds(381, 341, 294, 48);
		frameTake.getContentPane().add(label_message);

		JLabel lblBg2 = new JLabel("");
		lblBg2.setBounds(3, 0, 1086, 716);
		lblBg2.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		frameTake.getContentPane().add(lblBg2);
	}

	/**
	 * 通过按钮取款时的监听器
	 *
	 */
	class withdrawal implements ActionListener {
		String money;

		public withdrawal(String money) {
			this.money = money;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			textField_money.setText(money);
		}

	}

	/**
	 * 用户输入数字取款时的监听器。
	 *
	 */
	class CustomWithdrawal implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label_message.setText("");
			String moneys = textField_money.getText();
			if (!moneys.isEmpty()) {
				float money = Float.parseFloat(moneys);
				// 如果不是透支取款
				if (!isOverdeaft) {
					if (money % 100 != 0 || money <= 0) {
						label_message.setText("金额数必须是100的正整数倍");
					} else if (money > 5000) {
						label_message.setText("单笔取款最多为5000元");
					} else if (money > BlankAccout.getInstance().getWithdrawalsLimit()) {
						label_message.setText("取款数额大于今日限额");
					}else {
						// 取款方法
						take(moneys);
					}
				} else {
					if (money % 100 != 0) {
						label_message.setText("金额数必须是100的整数倍");
					} else if (money > 5000) {
						label_message.setText("透支上限为5000元");
					} else if (money > BlankAccout.getInstance().getOverdraft()) {
						label_message.setText("透支数额大于可用透支额度");
					} else {
						// 透支取款方法
						Overdraft(moneys);
					}
				}
			} else {
				label_message.setText("请输入金额");
			}
			textField_money.setText("");

		}

	}

	/**
	 * 调用数据库方法写入数据，修改 BankAccount
	 * 
	 * @param moneys
	 */
	public void take(String moneys) {
		float money = Float.parseFloat(moneys);
		float fees = 0;// 手续费
		
		if (BlankAccout.getInstance().getBlank() != "建设银行") {
			fees = money * 1 / 100;
		}
		if(BlankAccout.getInstance().getBalance() > (money+fees)) {
			// 设置目标账号为自己
			BlankAccout.getInstance().setTargetCard(BlankAccout.getInstance().getCardNum());
			// 修改今日取款额度
			BlankAccout.getInstance().setWithdrawalsLimit(BlankAccout.getInstance().getWithdrawalsLimit() - money);
			// 修改余额
			BlankAccout.getInstance().setBalance(BlankAccout.getInstance().getBalance() - (money + fees));
			//TODO D调用数据库方法，交易记录表增加一项，修改数据库中的余额
			// 取款成功，发送消息给取款成功提示界面
			message[0] = "取款";
			message[1] = moneys; // 取款数
			message[2] = Float.toString(BlankAccout.getInstance().getBalance());// 账户余额
			message[3] = Float.toString(BlankAccout.getInstance().getWithdrawalsLimit());// 今日可取款额度
			// TODO 跳转取款成功界面
			messageFrame.getFrameMessage().setVisible(true);
			messageFrame.showMessage(message);
			frameTake.dispose();
		}else {
			label_message.setText("你的余额不足");
		}

	}

	public void Overdraft(String moneys) {
		// TODO 透支取款的方法
		float money = Float.parseFloat(moneys);
		float fees = 0;// 手续费
		// TODO D调用数据库方法，交易记录表增加一项，修改数据库中的余额和透支额
		if (BlankAccout.getInstance().getBlank() != "建设银行") {
			fees = money * 1 / 100;
		}
		if (BlankAccout.getInstance().getOverdraft() > money + fees) {
			// 设置目标账号为自己
			BlankAccout.getInstance().setTargetCard(BlankAccout.getInstance().getCardNum());
			// 修改透支额
			BlankAccout.getInstance().setOverdraft(BlankAccout.getInstance().getOverdraft() - money - fees);
			// 取款成功，发送消息给取款成功提示界面
			message[0] = "透支取款";
			message[1] = moneys; // 取款数
			message[2] = Float.toString(BlankAccout.getInstance().getBalance());// 账户余额
			message[3] = Float.toString(BlankAccout.getInstance().getOverdraft());// 今日可透支取款额度
			// TODO 跳转取款成功界面
			messageFrame.getFrameMessage().setVisible(true);
			messageFrame.showMessage(message);
			frameTake.dispose();
		} else {
			label_message.setText("您的透支额度不足");
		}
	}

	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameTake.dispose();
			textField_money.setText("");
			label_message.setText("");
		}
	}
}
