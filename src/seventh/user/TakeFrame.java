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
 * ATMȡ���
 *
 */
public class TakeFrame {

	public JFrame frameTake;
	private MessageFrame messageFrame = new MessageFrame();
	private JTextField textField_money;
	private String[] message = new String[4];
	// �ǲ���͸֧ȡ��
	Boolean isOverdeaft;
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";
	private JLabel label_message;

	// �����̱߳���
	private JLabel countdownLabel;
	private CountdownThread time;

	// ��ʼ����ʱ
	public void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameTake, countdownLabel);
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
	 * ��ʼ��Ӧ��
	 */
	public TakeFrame() {
		initialize();
	}

	/**
	 * ��ӿؼ�
	 */
	private void initialize() {
		frameTake = new JFrame();
		frameTake.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameTake.setTitle("�й���������ATM");
		frameTake.setResizable(false);
		frameTake.setBounds(360, 150, 1095, 750);
		frameTake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTake.getContentPane().setLayout(null);

		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("����", Font.BOLD, 40));
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

		ATMButton btnBack = new ATMButton("<html><center>�˳�<br>Exit</center></html>");
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
		textField_money.setFont(new Font("΢���ź� Light", Font.PLAIN, 40));
		textField_money.setBounds(381, 277, 294, 53);
		frameTake.getContentPane().add(textField_money);
		textField_money.addKeyListener(new NumLimit());
		textField_money.setDocument(new NumLengthLimit(5));

		ATMButton btn_confirm = new ATMButton("<html><center>ȷ��<br>Confirm</center></html>");
		btn_confirm.setForeground(new Color(0, 128, 0));
		btn_confirm.addActionListener(new CustomWithdrawal());
		btn_confirm.setBounds(915, 550, 160, 70);
		frameTake.getContentPane().add(btn_confirm);

		JLabel label = new JLabel("��������");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("��Բ", Font.BOLD, 20));
		label.setBounds(381, 216, 294, 48);
		frameTake.getContentPane().add(label);

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(Color.red);
		label_message.setFont(new Font("��Բ", Font.BOLD, 20));
		label_message.setBounds(381, 341, 294, 48);
		frameTake.getContentPane().add(label_message);

		JLabel lblBg2 = new JLabel("");
		lblBg2.setBounds(3, 0, 1086, 716);
		lblBg2.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		frameTake.getContentPane().add(lblBg2);
	}

	/**
	 * ͨ����ťȡ��ʱ�ļ�����
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
	 * �û���������ȡ��ʱ�ļ�������
	 *
	 */
	class CustomWithdrawal implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label_message.setText("");
			String moneys = textField_money.getText();
			if (!moneys.isEmpty()) {
				float money = Float.parseFloat(moneys);
				// �������͸֧ȡ��
				if (!isOverdeaft) {
					if (money % 100 != 0 || money <= 0) {
						label_message.setText("�����������100����������");
					} else if (money > 5000) {
						label_message.setText("����ȡ�����Ϊ5000Ԫ");
					} else if (money > BankAccout.getInstance().getWithdrawalsLimit()) {
						label_message.setText("ȡ��������ڽ����޶�");
					} else {
						// ȡ���
						take(moneys);
					}
				} else {
					if (money % 100 != 0) {
						label_message.setText("�����������100��������");
					} else if (money > 5000) {
						label_message.setText("͸֧����Ϊ5000Ԫ");
					} else if (money > BankAccout.getInstance().getOverdraft()) {
						label_message.setText("͸֧������ڿ���͸֧���");
					} else {
						// ͸֧ȡ���
						Overdraft(moneys);
					}
				}
			} else {
				label_message.setText("��������");
			}
			textField_money.setText("");

		}

	}

	/**
	 * ��ͨȡ��
	 * 
	 * @param moneys ȡ����
	 */
	public void take(String moneys) {
		float money = Float.parseFloat(moneys);
		float fees = 0;// ������

		if (BankAccout.getInstance().getBlank() != true) {
			fees = money * 1 / 100;
		}
		if (BankAccout.getInstance().getBalance() > (money + fees)) {
			// ����Ŀ���˺�Ϊ�Լ�
			BankAccout.getInstance().setTargetCard(BankAccout.getInstance().getCardNum());
			// �޸Ľ���ȡ����
			BankAccout.getInstance().setWithdrawalsLimit(BankAccout.getInstance().getWithdrawalsLimit() - money);
			// �޸����
			BankAccout.getInstance().setBalance(BankAccout.getInstance().getBalance() - (money + fees));
			BankAccout.getInstance().getTradingrecDAO().insertRecording(BankAccout.getInstance().getCardNum(), money,
					"ȡ��", BankAccout.getInstance().getTargetCard(), fees);
			BankAccout.getInstance().getAccountDAO().loadBalance(BankAccout.getInstance().getCardNum(), money - fees);
			// ȡ��ɹ���������Ϣ��ȡ��ɹ���ʾ����
			message[0] = "ȡ��";
			message[1] = moneys; // ȡ����
			message[2] = Float.toString(BankAccout.getInstance().getBalance());// �˻����
			message[3] = Float.toString(BankAccout.getInstance().getWithdrawalsLimit());// ���տ�ȡ����
			
			// ֹͣ��ǰ����ʱ
			stopCountdown();
			messageFrame.startCountdown();
			
			messageFrame.getFrameMessage().setVisible(true);
			messageFrame.showMessage(message);
			frameTake.dispose();
		} else {
			label_message.setText("�������");
		}

	}

	/** ͸֧ȡ��
	 * @param moneys ͸֧ȡ����
	 */
	public void Overdraft(String moneys) {
		float money = Float.parseFloat(moneys);
		float fees = 0;// ������
		if (BankAccout.getInstance().getBlank() != true) {
			fees = money * 1 / 100;
		}
		if (BankAccout.getInstance().getOverdraft() > money + fees) {
			// ����Ŀ���˺�Ϊ�Լ�
			BankAccout.getInstance().setTargetCard(BankAccout.getInstance().getCardNum());
			// �޸�͸֧��
			BankAccout.getInstance().setOverdraft(BankAccout.getInstance().getOverdraft() - money - fees);
			// �޸Ľ���ȡ����
			BankAccout.getInstance().setWithdrawalsLimit(BankAccout.getInstance().getWithdrawalsLimit() - money);
			// �������ݿⷽ�������׼�¼������һ��޸����ݿ��е�͸֧��
			BankAccout.getInstance().getTradingrecDAO().insertRecording(BankAccout.getInstance().getCardNum(), money,
					"͸֧ȡ��", BankAccout.getInstance().getTargetCard(), fees);
			BankAccout.getInstance().getAccountDAO().setCardOverdraft(BankAccout.getInstance().getCardNum(),
					BankAccout.getInstance().getOverdraft());
			// ȡ��ɹ���������Ϣ��ȡ��ɹ���ʾ����
			message[0] = "͸֧ȡ��";
			message[1] = moneys; // ȡ����
			message[2] = Float.toString(BankAccout.getInstance().getBalance());// �˻����
			message[3] = Float.toString(BankAccout.getInstance().getOverdraft());// ���տ�͸֧ȡ����
			
			// ֹͣ��ǰ����ʱ
			stopCountdown();
			messageFrame.startCountdown();
			messageFrame.getFrameMessage().setVisible(true);
			messageFrame.showMessage(message);
			frameTake.dispose();
		} else {
			label_message.setText("����͸֧��Ȳ���");
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
			
			frameTake.dispose();
			textField_money.setText("");
			label_message.setText("");
		}
	}
	
}
