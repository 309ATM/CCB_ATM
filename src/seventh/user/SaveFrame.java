package seventh.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import seventh.accout.BankAccout;
import seventh.until.ATMButton;
import seventh.until.CountdownThread;
import seventh.until.NumLengthLimit;
import seventh.until.NumLimit;

/**
 * ATM存款功能
 *
 */
public class SaveFrame {

	private JFrame frameSave;
	private MessageFrame messageFrame = new MessageFrame();
	private String[] message = new String[4];
	private JTextField textField_money;
	//private String File = "E:\\Code\\java\\CCB_ATM";
	private JLabel label_message;
	private String File = ".";
	
	public JFrame getFrameSave() {
		return frameSave;
	}

	// 声明线程变量
		private JLabel countdownLabel;
		private CountdownThread time;

		// 开始倒计时
		public void startCountdown() {
			time = new CountdownThread();
			time.setCom(frameSave, countdownLabel);
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
					SaveFrame window = new SaveFrame();
					window.frameSave.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 初始化应用界面
	 */
	public SaveFrame() {
		initialize();
	}

	/**
	 * 添加控件
	 */
	private void initialize() {
		frameSave = new JFrame();
		frameSave.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameSave.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameSave.setResizable(false);
		frameSave.setBounds(360, 150, 1095, 750);
		frameSave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSave.getContentPane().setLayout(null);
		
		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("黑体", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameSave.getContentPane().add(countdownLabel);

		JLabel label = new JLabel("请输入金额");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("幼圆", Font.BOLD, 28));
		label.setBounds(381, 260, 294, 48);
		frameSave.getContentPane().add(label);

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(Color.red);
		label_message.setFont(new Font("幼圆", Font.BOLD, 20));
		label_message.setBounds(381, 406, 294, 48);
		frameSave.getContentPane().add(label_message);

		textField_money = new JTextField();
		textField_money.setFont(new Font("微软雅黑 Light", Font.PLAIN, 40));
		textField_money.setBounds(380, 330, 294, 53);
		frameSave.getContentPane().add(textField_money);
		textField_money.addKeyListener(new NumLimit());
		textField_money.setDocument(new NumLengthLimit(5));

		ATMButton btn_confirm = new ATMButton("<html><center>确认<br>Exit</center></html>");
		btn_confirm.setForeground(new Color(0, 128, 0));
		btn_confirm.addActionListener(new SaveMoney());
		btn_confirm.setBounds(875, 550, 200, 80);
		frameSave.getContentPane().add(btn_confirm);

		ATMButton btn_exit = new ATMButton("<html><center>退出<br>Exit</center></html>");
		btn_exit.setForeground(Color.RED);
		btn_exit.addActionListener(new Back());
		btn_exit.setBounds(14, 550, 200, 80);
		frameSave.getContentPane().add(btn_exit);

		JLabel lblBg = new JLabel("");
		lblBg.setFont(new Font("微软雅黑 Light", Font.PLAIN, 36));
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameSave.getContentPane().add(lblBg);
	}

	/** 存款方法
	 * @param card 存入卡号
	 * @param money 存款金额
	 * @param fees 手续费
	 */
	public void deposit(Long card, float money, float fees) {
		// 存款方法
		// 更改 bank account 中的值
		BankAccout.getInstance().setBalance(BankAccout.getInstance().getBalance() + money - fees);
		BankAccout.getInstance().setTargetCard(BankAccout.getInstance().getCardNum());
		// 更新数据库的余额部分，增加交易记录
		BankAccout.getInstance().getAccountDAO().setCardBalance(BankAccout.getInstance().getCardNum(),
				BankAccout.getInstance().getBalance());
		BankAccout.getInstance().getTradingrecDAO().insertRecording(BankAccout.getInstance().getCardNum(), money,
				"存款", BankAccout.getInstance().getTargetCard(), fees);

	}

	/** 存款按钮事件监听器
	 * @author Admin
	 *
	 */
	class SaveMoney implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			label_message.setText("");
			String moneys = textField_money.getText().trim();
			try {
				float money = Float.parseFloat(moneys);
				// BlankAccout.getInstance().setDepositLimit(4000);
				// BlankAccout.getInstance().setBlank("中国银行");
				if (money % 100 != 0 || money <= 0) {
					label_message.setText("金额数必须是100的正整数倍");
				} else if (money > 10000) {
					label_message.setText("单笔存款最多为10,000元");
				} else if (money > BankAccout.getInstance().getDepositLimit()) {
					label_message.setText("存款数额大于今日限额");
				} else {
					// 判断银行，手续费计算
					if (BankAccout.getInstance().getBlank() == true) {
						// 直接调用数据库存款方法
						deposit(BankAccout.getInstance().getCardNum(), money, 0);
					} else {
						// 非本行，计算手续费
						float fees = 0;
						fees = money * 1 / 100;
						deposit(BankAccout.getInstance().getCardNum(), money, fees);
					}
					BankAccout.getInstance().setDepositLimit(BankAccout.getInstance().getDepositLimit() - money);

					textField_money.setText("");
					message[0] = "存款";
					message[1] = moneys; // 存款数
					message[2] = Float.toString(BankAccout.getInstance().getBalance());// 账户余额
					message[3] = Float.toString(BankAccout.getInstance().getDepositLimit());// 今日可存款额度
					
					// 停止当前倒计时
					stopCountdown();
					messageFrame.startCountdown();
					
					messageFrame.getFrameMessage().setVisible(true);
					messageFrame.showMessage(message);
					frameSave.dispose();
				}
			} catch (NumberFormatException e) {
				label_message.setText("请输入数字");
			}
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
			frameSave.setVisible(false);

			// 开始主界面倒计时
			MainFrame.startCountdown();
			// 停止当前倒计时
			stopCountdown();
			
			textField_money.setText("");
			label_message.setText("");
		}
	}
}
