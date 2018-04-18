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
 * ATM���˵����� ��������� �û�ȡ��û����û�ת�ˡ��û���ѯ���û���ѯ������ʷ��ϸ
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

	// �����̱߳���
	private static JLabel countdownLabel;
	private static CountdownThread time;

	// ��ʼ����ʱ
	public static void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameMain, countdownLabel);
		time.start();
	}

	// ֹͣ����ʱ
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
	 * ��ʼ��Ӧ�ý���
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
	 * ��ӿؼ�
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameMain.setResizable(false);
		frameMain.setBounds(360, 150, 1095, 750);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);

		btnQu = new ATMButton("<html><center>ȡ��<br>Cash</center></html>");
		btnQu.addActionListener(new ToTake());
		btnQu.setBounds(10, 250, 200, 80);
		frameMain.getContentPane().add(btnQu);

		ATMButton btnSave = new ATMButton("<html><center>���<br>Deposit</center></html>");
		btnSave.addActionListener(new ToSave());
		btnSave.setBounds(10, 400, 200, 80);
		frameMain.getContentPane().add(btnSave);

		btnZhuan = new ATMButton("<html><center>ת��<br>Transfer</center></html>");
		btnZhuan.addActionListener(new ToTransfer());
		btnZhuan.setBounds(10, 550, 200, 80);
		frameMain.getContentPane().add(btnZhuan);

		ATMButton button = new ATMButton("<html><center>��ѯ���<br>Query balance</center></html>");
		button.addActionListener(new ToQuery());
		button.setBounds(875, 250, 200, 80);
		frameMain.getContentPane().add(button);

		ATMButton button_1 = new ATMButton("<html><center>��ѯ��ʷ��¼<br>Query history</center></html>");
		button_1.addActionListener(new ToHistory());
		button_1.setBounds(875, 400, 200, 80);
		frameMain.getContentPane().add(button_1);

		ATMButton button_2 = new ATMButton("<html><center>�˳�<br>Exit</center></html>");
		button_2.setForeground(Color.RED);
		button_2.addActionListener(new Exit());
		button_2.setBounds(875, 550, 200, 80);
		frameMain.getContentPane().add(button_2);

		countdownLabel = new JLabel("60");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("����", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameMain.getContentPane().add(countdownLabel);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameMain.getContentPane().add(lblBg);

		cardLock();
	}

	/**
	 * �ж��˻�״̬��������ᣬ����ʹ��ȡ���ת�˹���
	 */
	public void cardLock() {
		String status = BlankAccout.getInstance().getStatus();
		if (status.equals("����")) {
			// ����MainFrame�ķ��������ز��ֿؼ���ʵ�ֹ�������
			btnQu.setVisible(false);
			btnZhuan.setVisible(false);
			// label��ʾ�˻��Ѷ���
		}

	}

	/** ��ת��ȡ���
	 * @author Admin
	 *
	 */
	class ToTake implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			takeChoseFrame.getFrameChose().setVisible(true);
			// ��ʼ����ʱ��ֹͣ��ǰ���ڵ���ʱ
			takeChoseFrame.startCountdown();
			stopCountdown();
			frameMain.setVisible(false);

		}
	}

	/** ��ת������
	 * @author Admin
	 *
	 */
	class ToSave implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			saveFrame.getFrameSave().setVisible(true);
			// ��ʼ����ʱ��ֹͣ��ǰ���ڵ���ʱ
			saveFrame.startCountdown();
			stopCountdown();
			frameMain.setVisible(false);

		}
	}

	/** ��ת��ת�˹���
	 * @author Admin
	 *
	 */
	class ToTransfer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			transferChoseFrame.getFrameTransferChose().setVisible(true);
			// ��ʼ����ʱ��ֹͣ��ǰ���ڵ���ʱ
			transferChoseFrame.startCountdown();
			stopCountdown();
			frameMain.dispose();

		}
	}

	/** ��ת����ѯ����
	 * @author Admin
	 *
	 */
	class ToQuery implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			queryFrame.getFrameQuery().setVisible(true);
			queryFrame.showMessage();
			// ��ʼ����ʱ��ֹͣ��ǰ���ڵ���ʱ
			queryFrame.startCountdown();
			stopCountdown();
			frameMain.setVisible(false);
		}
	}
	
	/** ��ת����ѯ������ϸ����
	 * @author Admin
	 *
	 */
	class ToHistory implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			historyFrame.getFrameHistory().setVisible(true);
			// ��ʼ����ʱ��ֹͣ��ǰ���ڵ���ʱ
			historyFrame.startCountdown();
			stopCountdown();
			frameMain.setVisible(false);
		}
	}

	/** �û��˿�
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
