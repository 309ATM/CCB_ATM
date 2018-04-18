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
import javax.swing.UIManager;

import seventh.accout.BankAccout;
import seventh.until.ATMButton;
import seventh.until.CountdownThread;

/**
 * 取款类型选择界面，用户持卡类型为信用卡，则可以进行取款和透支取款，为储蓄卡，则只能进行取款
 *
 */
public class TakeChoseFrame {

	private JFrame frameChose;
	private TakeFrame takeFrame = new TakeFrame();
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";

	// 声明线程变量
	private JLabel countdownLabel;
	private CountdownThread time;
	private ATMButton overdeaftButton;
	
	/**
	 * 主函数
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TakeChoseFrame window = new TakeChoseFrame();
					window.frameChose.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrameChose() {
		return frameChose;
	}

	/**
	 * 初始化应用界面
	 */
	public TakeChoseFrame() {
		initialize();
		takeFrame.getFrameTake().setVisible(false);
		//卡类型判断及按钮隐藏
		if(BankAccout.getInstance().getAccountDAO().getCardType(BankAccout.getInstance().getCardNum()).equals("储蓄卡")){
			overdeaftButton.setVisible(false);
		}
	}

	/**
	 * 添加控件
	 */
	private void initialize() {
		frameChose = new JFrame();
		frameChose.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameChose.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameChose.setResizable(false);
		frameChose.setBounds(360, 150, 1095, 750);
		frameChose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameChose.getContentPane().setLayout(null);
		
		ATMButton button = new ATMButton("<html><center>取款<br>Cash</center></html>");
		button.addActionListener(new ToTake());
		button.setBounds(14, 330, 160, 70);
		frameChose.getContentPane().add(button);
		
		overdeaftButton = new ATMButton("<html><center>透支取款<br>Overdraft</center></html>");
		overdeaftButton.setActionCommand("透支取款");
		overdeaftButton.addActionListener(new ToTake());
		overdeaftButton.setBounds(915, 330, 160, 70);
		frameChose.getContentPane().add(overdeaftButton);
		
		ATMButton button_2 = new ATMButton("<html>退出<br>Exit</html>");
		button_2.setForeground(Color.RED);
		button_2.addActionListener(new Back());
		button_2.setBounds(915, 550, 160, 70);
		frameChose.getContentPane().add(button_2);

		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("黑体", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameChose.getContentPane().add(countdownLabel);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameChose.getContentPane().add(lblBg);
		
	}

	/** 设置用户选择的取款类型，并跳转取款界面
	 * @author Admin
	 *
	 */
	class ToTake implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//判断是否是透支取款
			if (e.getActionCommand().equals("透支取款")) {
				takeFrame.isOverdeaft = true;
			} else {
				takeFrame.isOverdeaft = false;
			}
			takeFrame.getFrameTake().setVisible(true);
			// 停止当前倒计时
			stopCountdown();
			takeFrame.startCountdown();
			frameChose.dispose();
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
			//开始主界面倒计时
			MainFrame.startCountdown();
			// 停止当前倒计时
			stopCountdown();
			frameChose.dispose();
		}
	}
	
	// 开始倒计时
		public void startCountdown() {
			time = new CountdownThread();
			time.setCom(frameChose, countdownLabel);
			time.start();
		}
		
		// 停止倒计时
		public void stopCountdown() {
			time.stopThread();
			time = null;
		}
}
