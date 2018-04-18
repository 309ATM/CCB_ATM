package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import seventh.accout.BlankAccout;
import seventh.until.ATMButton;
import seventh.until.CountdownThread;

import java.awt.Color;

/**
 * ATM主菜单界面 包括五大功能 用户取款、用户存款、用户转账、用户查询余额、用户查询交易历史明细
 *
 */
public class MainFrame {

	public static String card;
	public static JFrame frameMain;

	private TakeChoseFrame takeChoseFrame = new TakeChoseFrame();
	private SaveFrame saveFrame = new SaveFrame();
	private TransferChoseFrame transferChoseFrame = new TransferChoseFrame();
	private QueryFrame queryFrame = new QueryFrame();
	private HistoryFrame historyFrame = new HistoryFrame();
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";
	private ATMButton btnQu;
	private ATMButton btnZhuan;

	// 声明线程变量
	private static JLabel countdownLabel;
	private static CountdownThread time;

	// 开始倒计时
	public static void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameMain, countdownLabel);
		time.start();
	}

	// 停止倒计时
	public static void stopCountdown() {
		time.stopThread();
		time = null;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainFrame window = new MainFrame();
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static JFrame getFrameMain() {
		return frameMain;
	}

	/**
	 * 初始化应用界面
	 */
	public MainFrame() {
		initialize();
		takeChoseFrame.getFrameChose().setVisible(false);
		transferChoseFrame.getFrameTransferChose().setVisible(false);
		saveFrame.getFrameSave().setVisible(false);
		queryFrame.getFrameQuery().setVisible(false);
		historyFrame.getFrameHistory().setVisible(false);
	}

	/**
	 * 添加控件
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameMain.setResizable(false);
		frameMain.setBounds(360, 150, 1095, 750);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);

		btnQu = new ATMButton("<html><center>取款<br>Cash</center></html>");
		btnQu.addActionListener(new ToTake());
		btnQu.setBounds(10, 250, 200, 80);
		frameMain.getContentPane().add(btnQu);

		ATMButton btnSave = new ATMButton("<html><center>存款<br>Deposit</center></html>");
		btnSave.addActionListener(new ToSave());
		btnSave.setBounds(10, 400, 200, 80);
		frameMain.getContentPane().add(btnSave);

		btnZhuan = new ATMButton("<html><center>转账<br>Transfer</center></html>");
		btnZhuan.addActionListener(new ToTransfer());
		btnZhuan.setBounds(10, 550, 200, 80);
		frameMain.getContentPane().add(btnZhuan);

		ATMButton button = new ATMButton("<html><center>查询余额<br>Query balance</center></html>");
		button.addActionListener(new ToQuery());
		button.setBounds(875, 250, 200, 80);
		frameMain.getContentPane().add(button);

		ATMButton button_1 = new ATMButton("<html><center>查询历史记录<br>Query history</center></html>");
		button_1.addActionListener(new ToHistory());
		button_1.setBounds(875, 400, 200, 80);
		frameMain.getContentPane().add(button_1);

		ATMButton button_2 = new ATMButton("<html><center>退出<br>Exit</center></html>");
		button_2.setForeground(Color.RED);
		button_2.addActionListener(new Exit());
		button_2.setBounds(875, 550, 200, 80);
		frameMain.getContentPane().add(button_2);

		countdownLabel = new JLabel("60");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("黑体", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameMain.getContentPane().add(countdownLabel);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameMain.getContentPane().add(lblBg);

		cardLock();
	}

	/**
	 * 判断账户状态，如果冻结，则不能使用取款和转账功能
	 */
	public void cardLock() {
		String status = BlankAccout.getInstance().getStatus();
		if (status.equals("冻结")) {
			// 调用MainFrame的方法，隐藏部分控件，实现功能消除
			btnQu.setVisible(false);
			btnZhuan.setVisible(false);
			// label提示账户已冻结
		}

	}

	/** 跳转至取款功能
	 * @author Admin
	 *
	 */
	class ToTake implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			takeChoseFrame.getFrameChose().setVisible(true);
			// 开始倒计时，停止当前窗口倒计时
			takeChoseFrame.startCountdown();
			stopCountdown();
			frameMain.setVisible(false);

		}
	}

	/** 跳转至存款功能
	 * @author Admin
	 *
	 */
	class ToSave implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			saveFrame.getFrameSave().setVisible(true);
			// 开始倒计时，停止当前窗口倒计时
			saveFrame.startCountdown();
			stopCountdown();
			frameMain.setVisible(false);

		}
	}

	/** 跳转至转账功能
	 * @author Admin
	 *
	 */
	class ToTransfer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			transferChoseFrame.getFrameTransferChose().setVisible(true);
			// 开始倒计时，停止当前窗口倒计时
			transferChoseFrame.startCountdown();
			stopCountdown();
			frameMain.dispose();

		}
	}

	/** 跳转至查询余额功能
	 * @author Admin
	 *
	 */
	class ToQuery implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			queryFrame.getFrameQuery().setVisible(true);
			queryFrame.showMessage();
			// 开始倒计时，停止当前窗口倒计时
			queryFrame.startCountdown();
			stopCountdown();
			frameMain.setVisible(false);
		}
	}
	
	/** 跳转至查询交易明细功能
	 * @author Admin
	 *
	 */
	class ToHistory implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			historyFrame.getFrameHistory().setVisible(true);
			// 开始倒计时，停止当前窗口倒计时
			historyFrame.startCountdown();
			stopCountdown();
			frameMain.setVisible(false);
		}
	}

	/** 用户退卡
	 * @author Admin
	 *
	 */
	class Exit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			stopCountdown();
			UsersLogin.main(null);
			frameMain.dispose();
		}
	}
}
