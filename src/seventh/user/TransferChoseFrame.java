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

/** ѡ��ת��������ת���棬��ǰ�û�Ϊ���У������ѡ������ת�����ת��Ϊ���������û�����ֻ��ѡ�����ת��������ȡһ�������ѡ�
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

	// �����̱߳���
	private JLabel countdownLabel;
	private CountdownThread time;

	// ��ʼ����ʱ
	public void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameTransferChose, countdownLabel);
		time.start();
	}

	// ֹͣ����ʱ
	public void stopCountdown() {
		time.stopThread();
		time = null;
	}

	/**
	 * ������
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
	 * ��ʼ��Ӧ��
	 */
	public TransferChoseFrame() {
		initialize();
		transferFrame.getFrameTransfer().setVisible(false);
		if (!BankAccout.getInstance().getBlank()) {
			button.setVisible(false);
		}

	}

	/**
	 * ��ӿؼ�
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
		countdownLabel.setFont(new Font("����", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameTransferChose.getContentPane().add(countdownLabel);
		
		button = new ATMButton("<html><center>����ת����<br>Transfer</center></html>");
		button.addActionListener(new ToTransfer());
		button.setBounds(14, 330, 200, 80);
		frameTransferChose.getContentPane().add(button);

		ATMButton overdeaftButton = new ATMButton("<html><center>����ת��<br>Cross Bank</center></html>");
		overdeaftButton.setActionCommand("����ת��");
		overdeaftButton.addActionListener(new ToTransfer());
		overdeaftButton.setBounds(875, 330, 200, 80);
		frameTransferChose.getContentPane().add(overdeaftButton);

		ATMButton button_2 = new ATMButton("<html>�˳�<br>Exit</html>");
		button_2.setForeground(Color.RED);
		button_2.addActionListener(new Back());
		button_2.setBounds(875, 550, 200, 80);
		frameTransferChose.getContentPane().add(button_2);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameTransferChose.getContentPane().add(lblBg);
	}

	/** ��ť�¼��������������û�ѡ������ת�����ͣ�����ת����
	 * @author Jachin
	 *
	 */
	class ToTransfer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// �ж�����һ��ת��
			if (e.getActionCommand().equals("����ת��")) {
				transferFrame.isCross = true;
			} else {
				transferFrame.isCross = false;
			}
			// ֹͣ��ǰ����ʱ
			stopCountdown();
			transferFrame.startCountdown();
			transferFrame.getFrameTransfer().setVisible(true);
			frameTransferChose.dispose();
		}
	}

	/** �˳���ť�¼�������
	 * @author Admin
	 *
	 */
	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);

			// ��ʼ�����浹��ʱ
			MainFrame.startCountdown();
			// ֹͣ��ǰ����ʱ
			stopCountdown();
			
			frameTransferChose.dispose();
		}
	}
}
