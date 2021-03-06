package seventh.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import seventh.accout.BankAccout;
import seventh.until.ATMButton;
import seventh.until.CountdownThread;

/**
 * ATM查询余额功能
 *
 */
public class QueryFrame {

	private JFrame frameQuery;
	private JLabel label;
	//private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";

	// 声明线程变量
	private JLabel countdownLabel;
	private CountdownThread time;

	// 开始倒计时
	public void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameQuery, countdownLabel);
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
					QueryFrame window = new QueryFrame();
					window.frameQuery.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrameQuery() {
		return frameQuery;
	}

	/**
	 * 初始化应用界面
	 */
	public QueryFrame() {
		initialize();
	}

	/**
	 * 添加控件
	 */
	private void initialize() {
		frameQuery = new JFrame();
		frameQuery.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameQuery.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameQuery.setResizable(false);
		frameQuery.setBounds(360, 150, 1095, 750);
		frameQuery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameQuery.getContentPane().setLayout(null);

		ATMButton button_1 = new ATMButton("<html><center>退出<br>Confirm</center></html>");
		button_1.setForeground(new Color(255, 0, 0));
		button_1.addActionListener(new Back());
		button_1.setBounds(875, 550, 200, 80);
		frameQuery.getContentPane().add(button_1);
		
		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("黑体", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameQuery.getContentPane().add(countdownLabel);

		label = new JLabel("您的余额信息：");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("幼圆", Font.BOLD, 26));
		label.setBounds(304, 181, 464, 271);
		frameQuery.getContentPane().add(label);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameQuery.getContentPane().add(lblBg);
	}

	/**
	 * 显示用户余额信息
	 * 包括当前可用余额、可透支额度
	 * 当日可存款、取款、转账额度
	 */
	public void showMessage() {
		float balance = BankAccout.getInstance().getBalance();
		float overdraft = BankAccout.getInstance().getOverdraft();
		float withdrawalsLimit = BankAccout.getInstance().getWithdrawalsLimit();
		float depositLimit = BankAccout.getInstance().getDepositLimit();
		float transferLimit = BankAccout.getInstance().getTransferLimit();

		String messages = "<html>您的余额为：{0}元<br>" + "您的透支额度为：{1}元<br>" + "您今日存款限额还剩：{2}元<br>" + "您今日取款限额还剩：{3}元<br>"
				+ "您今日转账限额还剩：{4}元";// 显示信息还要修改
		messages = messages.replace("{0}", String.valueOf(balance));// message[0-3]换成上面的money等
		messages = messages.replace("{1}", String.valueOf(overdraft));
		messages = messages.replace("{2}", String.valueOf(depositLimit));
		messages = messages.replace("{3}", String.valueOf(withdrawalsLimit));
		messages = messages.replace("{4}", String.valueOf(transferLimit));

		label.setText(messages);
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
			
			frameQuery.dispose();
		}
	}
}
