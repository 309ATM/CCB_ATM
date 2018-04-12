package seventh.user;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import seventh.until.ATMButton;

import java.awt.Color;

/**
 * ATM主菜单
 *
 */
public class MainFrame {

	public static String card;
	public static JFrame frameMain;
	private TakeChoseFrame takeChoseFrame = new TakeChoseFrame();
	private SaveFrame saveFrame = new SaveFrame();
	private TransferFrame transferFrame = new TransferFrame();
	private QueryFrame queryFrame = new QueryFrame();
	private HistoryFrame historyFrame = new HistoryFrame();
	private String File = "E:\\Code\\java\\CCB_ATM";
//	private String File = ".";
	private ATMButton btnQu;
	private ATMButton btnZhuan;

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

	public MainFrame() {
		initialize();
		takeChoseFrame.getFrameChose().setVisible(false);
		transferFrame.getFrameTransfer().setVisible(false);
		saveFrame.getFrameSave().setVisible(false);
		queryFrame.getFrameQuery().setVisible(false);
		historyFrame.getFrameHistory().setVisible(false);
	}

	private void initialize() {
		frameMain = new JFrame();
		frameMain.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameMain.setIconImage(
				Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
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

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameMain.getContentPane().add(lblBg);
		
		cardLock();
	}

	public void cardLock() {
		//这部分我写
		String status = "正常";//"正常","挂失","销户"
		if(status.equals("冻结")) {
			//调用MainFrame的方法，隐藏部分控件，实现功能消除
			btnQu.setVisible(false);
			btnZhuan.setVisible(false);
			//label提示账户已冻结
		}
		
	}
	
	
	class ToTake implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			takeChoseFrame.getFrameChose().setVisible(true);
			frameMain.setVisible(false);

		}
	}

	class ToSave implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			saveFrame.getFrameSave().setVisible(true);
			frameMain.setVisible(false);

		}
	}

	class ToTransfer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			transferFrame.getFrameTransfer().setVisible(true);
			frameMain.dispose();

		}
	}

	class ToQuery implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			queryFrame.getFrameQuery().setVisible(true);
			frameMain.setVisible(false);
		}
	}

	class Exit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			UserLoginCardNum.main(null);
			frameMain.dispose();
		}
	}

	class ToHistory implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			historyFrame.getFrameHistory().setVisible(true);
			frameMain.setVisible(false);
		}
	}
}
