package seventh.user;

import seventh.accout.BankAccout;
import seventh.until.ATMButton;
import seventh.until.CountdownThread;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

/** 选择转账类型跳转界面，当前用户为建行，则可以选择行内转或跨行转，为其他银行用户，则只能选择跨行转，并会收取一定手续费。
 * @author Admin
 *
 */
public class TransferChoseFrame {

	private JFrame frameTransferChose;
	private TransferFrame transferFrame = new TransferFrame();
//	private String File = "E:\\Code\\java\\CCB_ATM";
	private ATMButton button;
	 private String File = ".";

	public JFrame getFrameTransferChose() {
		return frameTransferChose;
	}

	// 声明线程变量
	private JLabel countdownLabel;
	private CountdownThread time;

	// 开始倒计时
	public void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameTransferChose, countdownLabel);
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
					TransferChoseFrame window = new TransferChoseFrame();
					window.frameTransferChose.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 初始化应用
	 */
	public TransferChoseFrame() {
		initialize();
		transferFrame.getFrameTransfer().setVisible(false);
		if (!BankAccout.getInstance().getBlank()) {
			button.setVisible(false);
		}

	}

	/**
	 * 添加控件
	 */
	private void initialize() {
		frameTransferChose = new JFrame();
		frameTransferChose.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameTransferChose.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameTransferChose.setResizable(false);
		frameTransferChose.setBounds(360, 150, 1095, 750);
		frameTransferChose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTransferChose.getContentPane().setLayout(null);
		
		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("黑体", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameTransferChose.getContentPane().add(countdownLabel);
		
		button = new ATMButton("<html><center>建行转建行<br>Transfer</center></html>");
		button.addActionListener(new ToTransfer());
		button.setBounds(14, 330, 200, 80);
		frameTransferChose.getContentPane().add(button);

		ATMButton overdeaftButton = new ATMButton("<html><center>跨行转账<br>Cross Bank</center></html>");
		overdeaftButton.setActionCommand("跨行转账");
		overdeaftButton.addActionListener(new ToTransfer());
		overdeaftButton.setBounds(875, 330, 200, 80);
		frameTransferChose.getContentPane().add(overdeaftButton);

		ATMButton button_2 = new ATMButton("<html>退出<br>Exit</html>");
		button_2.setForeground(Color.RED);
		button_2.addActionListener(new Back());
		button_2.setBounds(875, 550, 200, 80);
		frameTransferChose.getContentPane().add(button_2);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameTransferChose.getContentPane().add(lblBg);
	}

	/** 按钮事件监听器，设置用户选择哪种转账类型，并跳转界面
	 * @author Jachin
	 *
	 */
	class ToTransfer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// 判断是哪一种转账
			if (e.getActionCommand().equals("跨行转账")) {
				transferFrame.isCross = true;
			} else {
				transferFrame.isCross = false;
			}
			// 停止当前倒计时
			stopCountdown();
			transferFrame.startCountdown();
			transferFrame.getFrameTransfer().setVisible(true);
			frameTransferChose.dispose();
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
			
			frameTransferChose.dispose();
		}
	}
}
