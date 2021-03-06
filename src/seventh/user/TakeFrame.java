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

import seventh.accout.BankAccout;
import seventh.until.ATMButton;
import seventh.until.CountdownThread;
import seventh.until.NumLengthLimit;
import seventh.until.NumLimit;

import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * ATM取款功能
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

	// 声明线程变量
	private JLabel countdownLabel;
	private CountdownThread time;

	// 开始倒计时
	public void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameTake, countdownLabel);
		time.start();
	}

	// 停止倒计时
	public void stopCountdown() {
		time.stopThread();
		time = null;
	}

	/**
	 * 主函数
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
	 * 初始化应用
	 */
	public TakeFrame() {
		initialize();
	}

	/**
	 * 添加控件
	 */
	private void initialize() {
		frameTake = new JFrame();
		frameTake.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameTake.setTitle("中国建设银行ATM");
		frameTake.setResizable(false);
		frameTake.setBounds(360, 150, 1095, 750);
		frameTake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTake.getContentPane().setLayout(null);

		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("黑体", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameTake.getContentPane().add(countdownLabel);

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
		textField_money.addKeyListener(new NumLimit());
		textField_money.setDocument(new NumLengthLimit(5));

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
					} else if (money > BankAccout.getInstance().getWithdrawalsLimit()) {
						label_message.setText("取款数额大于今日限额");
					} else {
						// 取款方法
						take(moneys);
					}
				} else {
					if (money % 100 != 0) {
						label_message.setText("金额数必须是100的整数倍");
					} else if (money > 5000) {
						label_message.setText("透支上限为5000元");
					} else if (money > BankAccout.getInstance().getOverdraft()) {
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
	 * 普通取款
	 * 
	 * @param moneys 取款金额
	 */
	public void take(String moneys) {
		float money = Float.parseFloat(moneys);
		float fees = 0;// 手续费

		if (BankAccout.getInstance().getBlank() != true) {
			fees = money * 1 / 100;
		}
		if (BankAccout.getInstance().getBalance() > (money + fees)) {
			// 设置目标账号为自己
			BankAccout.getInstance().setTargetCard(BankAccout.getInstance().getCardNum());
			// 修改今日取款额度
			BankAccout.getInstance().setWithdrawalsLimit(BankAccout.getInstance().getWithdrawalsLimit() - money);
			// 修改余额
			BankAccout.getInstance().setBalance(BankAccout.getInstance().getBalance() - (money + fees));
			BankAccout.getInstance().getTradingrecDAO().insertRecording(BankAccout.getInstance().getCardNum(), money,
					"取款", BankAccout.getInstance().getTargetCard(), fees);
			BankAccout.getInstance().getAccountDAO().loadBalance(BankAccout.getInstance().getCardNum(), money - fees);
			// 取款成功，发送消息给取款成功提示界面
			message[0] = "取款";
			message[1] = moneys; // 取款数
			message[2] = Float.toString(BankAccout.getInstance().getBalance());// 账户余额
			message[3] = Float.toString(BankAccout.getInstance().getWithdrawalsLimit());// 今日可取款额度
			
			// 停止当前倒计时
			stopCountdown();
			messageFrame.startCountdown();
			
			messageFrame.getFrameMessage().setVisible(true);
			messageFrame.showMessage(message);
			frameTake.dispose();
		} else {
			label_message.setText("你的余额不足");
		}

	}

	/** 透支取款
	 * @param moneys 透支取款金额
	 */
	public void Overdraft(String moneys) {
		float money = Float.parseFloat(moneys);
		float fees = 0;// 手续费
		if (BankAccout.getInstance().getBlank() != true) {
			fees = money * 1 / 100;
		}
		if (BankAccout.getInstance().getOverdraft() > money + fees) {
			// 设置目标账号为自己
			BankAccout.getInstance().setTargetCard(BankAccout.getInstance().getCardNum());
			// 修改透支额
			BankAccout.getInstance().setOverdraft(BankAccout.getInstance().getOverdraft() - money - fees);
			// 修改今日取款额度
			BankAccout.getInstance().setWithdrawalsLimit(BankAccout.getInstance().getWithdrawalsLimit() - money);
			// 调用数据库方法，交易记录表增加一项，修改数据库中的透支额
			BankAccout.getInstance().getTradingrecDAO().insertRecording(BankAccout.getInstance().getCardNum(), money,
					"透支取款", BankAccout.getInstance().getTargetCard(), fees);
			BankAccout.getInstance().getAccountDAO().setCardOverdraft(BankAccout.getInstance().getCardNum(),
					BankAccout.getInstance().getOverdraft());
			// 取款成功，发送消息给取款成功提示界面
			message[0] = "透支取款";
			message[1] = moneys; // 取款数
			message[2] = Float.toString(BankAccout.getInstance().getBalance());// 账户余额
			message[3] = Float.toString(BankAccout.getInstance().getOverdraft());// 今日可透支取款额度
			
			// 停止当前倒计时
			stopCountdown();
			messageFrame.startCountdown();
			messageFrame.getFrameMessage().setVisible(true);
			messageFrame.showMessage(message);
			frameTake.dispose();
		} else {
			label_message.setText("您的透支额度不足");
		}
	}

	/** 退出按钮事件监听器
	 * @author Admin
	 *
	 */
	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			
			// 开始主界面倒计时
			MainFrame.startCountdown();
			// 停止当前倒计时
			stopCountdown();
			
			frameTake.dispose();
			textField_money.setText("");
			label_message.setText("");
		}
	}
	
}
