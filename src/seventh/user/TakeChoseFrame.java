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
 * ȡ������ѡ����棬�û��ֿ�����Ϊ���ÿ�������Խ���ȡ���͸֧ȡ�Ϊ�������ֻ�ܽ���ȡ��
 *
 */
public class TakeChoseFrame {

	private JFrame frameChose;
	private TakeFrame takeFrame = new TakeFrame();
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";

	// �����̱߳���
	private JLabel countdownLabel;
	private CountdownThread time;
	private ATMButton overdeaftButton;
	
	/**
	 * ������
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
	 * ��ʼ��Ӧ�ý���
	 */
	public TakeChoseFrame() {
		initialize();
		takeFrame.getFrameTake().setVisible(false);
		//�������жϼ���ť����
		if(BankAccout.getInstance().getAccountDAO().getCardType(BankAccout.getInstance().getCardNum()).equals("���")){
			overdeaftButton.setVisible(false);
		}
	}

	/**
	 * ��ӿؼ�
	 */
	private void initialize() {
		frameChose = new JFrame();
		frameChose.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameChose.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameChose.setResizable(false);
		frameChose.setBounds(360, 150, 1095, 750);
		frameChose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameChose.getContentPane().setLayout(null);
		
		ATMButton button = new ATMButton("<html><center>ȡ��<br>Cash</center></html>");
		button.addActionListener(new ToTake());
		button.setBounds(14, 330, 160, 70);
		frameChose.getContentPane().add(button);
		
		overdeaftButton = new ATMButton("<html><center>͸֧ȡ��<br>Overdraft</center></html>");
		overdeaftButton.setActionCommand("͸֧ȡ��");
		overdeaftButton.addActionListener(new ToTake());
		overdeaftButton.setBounds(915, 330, 160, 70);
		frameChose.getContentPane().add(overdeaftButton);
		
		ATMButton button_2 = new ATMButton("<html>�˳�<br>Exit</html>");
		button_2.setForeground(Color.RED);
		button_2.addActionListener(new Back());
		button_2.setBounds(915, 550, 160, 70);
		frameChose.getContentPane().add(button_2);

		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("����", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameChose.getContentPane().add(countdownLabel);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameChose.getContentPane().add(lblBg);
		
	}

	/** �����û�ѡ���ȡ�����ͣ�����תȡ�����
	 * @author Admin
	 *
	 */
	class ToTake implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//�ж��Ƿ���͸֧ȡ��
			if (e.getActionCommand().equals("͸֧ȡ��")) {
				takeFrame.isOverdeaft = true;
			} else {
				takeFrame.isOverdeaft = false;
			}
			takeFrame.getFrameTake().setVisible(true);
			// ֹͣ��ǰ����ʱ
			stopCountdown();
			takeFrame.startCountdown();
			frameChose.dispose();
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
			//��ʼ�����浹��ʱ
			MainFrame.startCountdown();
			// ֹͣ��ǰ����ʱ
			stopCountdown();
			frameChose.dispose();
		}
	}
	
	// ��ʼ����ʱ
		public void startCountdown() {
			time = new CountdownThread();
			time.setCom(frameChose, countdownLabel);
			time.start();
		}
		
		// ֹͣ����ʱ
		public void stopCountdown() {
			time.stopThread();
			time = null;
		}
}
