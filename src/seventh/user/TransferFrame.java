package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import seventh.accout.BankAccout;
import seventh.until.ATMButton;
import seventh.until.CountdownThread;
import seventh.until.NumLengthLimit;
import seventh.until.NumLimit;

import java.awt.Color;
import javax.swing.SwingConstants;

/** 
 * ATMת�˹���
 * 
 */
/**
 * @author Admin
 *
 */
/**
 * @author Admin
 *
 */
public class TransferFrame {

	private JFrame frameTransfer;
	private JTextField textField_money;
	boolean isCross;
	boolean fees;
	String[] message = new String[5];
	// private MainFrame mainFrame = new MainFrame();
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";
	private JLabel label_tip;
	private ATMButton btn_confirm;
	private ATMButton btn_transfer;
	private JLabel label_message;
	private MessageFrame messageFrame = new MessageFrame();

	// �����̱߳���
	private JLabel countdownLabel;
	private CountdownThread time;

	// ��ʼ����ʱ
	public void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameTransfer, countdownLabel);
		time.start();
	}

	// ֹͣ����ʱ
	public void stopCountdown() {
		time.stopThread();
		time = null;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferFrame window = new TransferFrame();
					window.frameTransfer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TransferFrame() {
		initialize();
	}

	public JFrame getFrameTransfer() {
		return frameTransfer;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameTransfer = new JFrame();
		frameTransfer.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameTransfer.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameTransfer.setResizable(false);
		frameTransfer.setBounds(360, 150, 1095, 750);
		frameTransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTransfer.getContentPane().setLayout(null);

		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("����", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameTransfer.getContentPane().add(countdownLabel);

		ATMButton btn_exit = new ATMButton("<html><center>�˳�<br>Confirm</center></html>");
		btn_exit.setForeground(new Color(255, 0, 0));
		btn_exit.addActionListener(new Back());
		btn_exit.setBounds(14, 550, 200, 80);
		frameTransfer.getContentPane().add(btn_exit);

		textField_money = new JTextField();
		textField_money.setFont(new Font("΢���ź� Light", Font.PLAIN, 40));
		textField_money.setBounds(321, 284, 451, 53);
		frameTransfer.getContentPane().add(textField_money);
		textField_money.addKeyListener(new NumLimit2());
		textField_money.setDocument(new NumLengthLimit(18));

		btn_transfer = new ATMButton("<html><center>ת��<br>Transfer</center></html>");
		btn_transfer.setForeground(new Color(0, 128, 0));
		btn_transfer.addActionListener(new TransferMoney());
		btn_transfer.setBounds(875, 550, 200, 80);
		frameTransfer.getContentPane().add(btn_transfer);

		btn_confirm = new ATMButton("<html><center>ȷ��<br>Confirm</center></html>");
		btn_confirm.setForeground(new Color(0, 128, 0));
		btn_confirm.addActionListener(new ConfirmTransfer());
		btn_confirm.setBounds(875, 550, 200, 80);
		frameTransfer.getContentPane().add(btn_confirm);

		label_tip = new JLabel("������ת���˺ţ���������");
		label_tip.setHorizontalAlignment(SwingConstants.CENTER);
		label_tip.setForeground(new Color(255, 255, 255));
		label_tip.setFont(new Font("��Բ", Font.BOLD, 24));
		label_tip.setBounds(321, 204, 451, 53);
		frameTransfer.getContentPane().add(label_tip);

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(new Color(255, 0, 0));
		label_message.setFont(new Font("��Բ", Font.BOLD, 24));
		label_message.setBounds(392, 368, 311, 92);
		frameTransfer.getContentPane().add(label_message);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameTransfer.getContentPane().add(lblBg);
	}

	/**
	 * ���뿨�ź�� ת�˰�ť ������
	 * @author Jachin
	 */
	class TransferMoney implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label_message.setText("");
			// �����ж����뿨���Ѿ�ѡ��Ĺ����Ƿ�һ��(ָ�������м�ת������)
			String inputCard = textField_money.getText();// ��ȡ����Ҫ����
			if (!inputCard.isEmpty()) {
				Long card = Long.parseLong(inputCard);
				BankAccout.getInstance().setTargetCard(card);
				// �ж����뿨���Ƿ����
				if (BankAccout.getInstance().getAccountDAO().getCardExit(card)) {
					if (isCross) {// ���а�ť
						if (BankAccout.getInstance().getBlank()) {
							// 1.�����û�����ת
							if (!BankAccout.getInstance().getAccountDAO().getBanks(card)) {// ���벻���Ǳ��п���
								// �������
								label_tip.setText("������ת�˽�ȷ�ϼ�ת��");
								btn_transfer.setVisible(false);
								textField_money.setText("");
								btn_confirm.setVisible(true);
								textField_money.setDocument(new NumLengthLimit(5));
								fees = true;
							} else {
								// ��ʾ�������뱾�п���
								label_message.setText("<html><center>��ѡ����ǿ���ת�ˣ�<br>�������������е��˺�</center></html>");
							}
						} else {
							// 2.�ǽ����û�ת
							// TODO ����ת���Լ�����ʾ��Ϣ��ôд
							if (BankAccout.getInstance().getCardNum() == BankAccout.getInstance().getTargetCard()) {
								label_message.setText("�����������˵��˺�");
							} else {
								// ������ת
								label_tip.setText("������ת�˽��");
								btn_transfer.setVisible(false);
								textField_money.setText("");
								btn_confirm.setVisible(true);
								textField_money.setDocument(new NumLengthLimit(5));
								fees = true;
							}
						}

					} else {// ����ת���а�ť
							// ֻ��Ҫ�ж����뿨���ǲ��ǽ����Լ����������Լ��Ŀ���
						if (BankAccout.getInstance().getAccountDAO().getBanks(card)) {
							if (BankAccout.getInstance().getCardNum() == BankAccout.getInstance().getTargetCard()) {
								// TODO ����ת���Լ�����ʾ��Ϣ��ôд
								label_message.setText("�����������˵��˺�");
							} else {
								// �������
								label_tip.setText("������ת�˽��");
								btn_transfer.setVisible(false);
								textField_money.setText("");
								btn_confirm.setVisible(true);
								textField_money.setDocument(new NumLengthLimit(5));
								fees = false;
							}
						} else {
							// �������뽨���˺�
							label_message.setText("�����뽨�������˺�");
						}
					}
				} else {
					label_message.setText("<html><center>��������˺Ų����ڣ�<br>����������</center></html>");
				}
			} else {
				label_message.setText("�������˺�");
			}
		}
	}

	/**
	 * �������� ȷ�ϰ�ť ������
	 * @author Jachin
	 */
	class ConfirmTransfer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label_message.setText("");
			// ����������Ľ��棬�����ж�ת���޶��Ƿ��㹻
			String moneys = textField_money.getText();
			float money = Float.parseFloat(moneys);
			if (BankAccout.getInstance().getTransferLimit() - money > 0) {
				float fee = 0;
				// ����ת�˽��ĺϷ����жϣ������û����
				if (fees) {// ���У���ȡ������
					// ����˻�����ȡ�����Ѻ�����㹻�Ļ�
					float balance = BankAccout.getInstance().getBalance();// �û�ת��ǰ�����
					balance = (float) (balance - money * 1.01);// ����������ȡ������
					if (balance >= 0) {
						// ����㹻���������п۳�ת�˽��
						BankAccout.getInstance().setBalance(balance);
						// ת������
						Long cardOut = BankAccout.getInstance().getCardNum();
						// ת�뿨��
						Long cardIn = BankAccout.getInstance().getTargetCard();
						// ת�˽��
						// money = (float) (money * 99 / 100);
						// ������
						fee = (float) (money / 100);
						// ��ת�������
						float balanceOut = balance;
						// ��ת������
						float balanceIn = BankAccout.getInstance().getAccountDAO().getCardBalance(cardIn) + money;

						// ������Ϣ��������������
						message[0] = "����ת��";
						message[1] = moneys; // ת�˽��
						message[4] = Float.toString(fee);
						message[2] = Float.toString(BankAccout.getInstance().getBalance());// �˻����
						message[3] = Long.toString(BankAccout.getInstance().getTargetCard());// Ŀ���˺�

						// ֹͣ��ǰ����ʱ
						stopCountdown();
						messageFrame.startCountdown();
						messageFrame.getFrameMessage().setVisible(true);
						messageFrame.showMessage(message);
						frameTransfer.dispose();
						// �����ı���Ϊ�գ���ť�ص�
						label_tip.setText("������ת���˺ţ���������");
						textField_money.setText("");
						btn_transfer.setVisible(true);
						btn_confirm.setVisible(false);
						textField_money.setDocument(new NumLengthLimit(18));

						// ����ת��ת��������ת������+���
						BankAccout.getInstance().getAccountDAO().setCardBalance(cardOut, balanceOut);
						// ����ת��ת�뷽����ת�뿨��+���
						BankAccout.getInstance().getAccountDAO().setCardBalance(cardIn, balanceIn);

						// �޸Ľ���ת�˶��
						BankAccout.getInstance()
								.setTransferLimit(BankAccout.getInstance().getTransferLimit() - money);

						// �����ǽ���¼���뽻����ʷ��¼��
						// ��ת���ļ�¼
						BankAccout.getInstance().getTradingrecDAO().insertRecording(cardOut, money, "ת��ת��", cardIn,
								fee);
						// ��ת��ļ�¼
						BankAccout.getInstance().getTradingrecDAO().insertRecording(cardIn, money, "ת��ת��", cardOut,
								fee);

					} else {
						// �����û��۳������Ѻ�����
						label_message.setText("�۳�1%�������Ѻ�����");
					}
				} else {// ����ת�ˣ�����������
						// ����˻����㹻�Ļ�
					float balance = BankAccout.getInstance().getBalance();
					balance = balance - money; // ת�˺�����
					if (balance >= 0) {
						// ����㹻���������п۳�ת�˽��
						BankAccout.getInstance().setBalance(balance);
						// ת������
						Long cardOut = BankAccout.getInstance().getCardNum();
						// ת�뿨��
						Long cardIn = BankAccout.getInstance().getTargetCard();
						// ת�˽���������Ľ��money
						// �����Ѿ���fee = 0
						// ��ת��������
						float balanceOut = balance;
						// ��ת�������
						float balanceIn = BankAccout.getInstance().getAccountDAO().getCardBalance(cardIn) + money;

						// ת�˳ɹ���������Ϣ��ת�˳ɹ���ʾ����
						message[0] = "ת��";
						message[1] = moneys; // ת�˽��
						message[2] = Float.toString(BankAccout.getInstance().getBalance());// �˻����
						message[3] = Long.toString(BankAccout.getInstance().getTargetCard());// Ŀ���˺�

						// ֹͣ��ǰ����ʱ
						stopCountdown();
						messageFrame.startCountdown();

						messageFrame.getFrameMessage().setVisible(true);
						messageFrame.showMessage(message);
						frameTransfer.dispose();
						label_tip.setText("������ת���˺ţ���������");
						textField_money.setText("");
						btn_transfer.setVisible(true);
						btn_confirm.setVisible(false);
						textField_money.setDocument(new NumLengthLimit(18));

						// ����ת��ת��������ת������+���
						BankAccout.getInstance().getAccountDAO().setCardBalance(cardOut, balanceOut);
						// ����ת��ת�뷽����ת�뿨��+���
						BankAccout.getInstance().getAccountDAO().setCardBalance(cardIn, balanceIn);

						// �޸Ľ���ת�˶��
						BankAccout.getInstance()
								.setTransferLimit(BankAccout.getInstance().getTransferLimit() - money);

						// �����ǽ���¼���뽻����ʷ��¼��
						// ��ת���ļ�¼
						BankAccout.getInstance().getTradingrecDAO().insertRecording(cardOut, money, "ת��ת��", cardIn,
								fee);
						// ��ת��ļ�¼
						BankAccout.getInstance().getTradingrecDAO().insertRecording(cardIn, money, "ת��ת��", cardOut,
								fee);

					} else {
						// �����û�����
						label_message.setText("��������");
					}

				}
			} else {
				label_message.setText("�����յ�ת���޶��");
			}
		}
	}

	/** ����ת�˽����ֻ���������ֺ�С����
	 * @author Jachin
	 *
	 */
	public class NumLimit2 implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
			int keyChar = e.getKeyChar();
			if ((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) || keyChar == 46) {
			} else {
				e.consume(); // �ؼ������ε��Ƿ�����
			}
		}

	}
	
	/** �˳���ť�¼�������
	 * @author Jachin
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

			frameTransfer.dispose();
			label_message.setText("");
			label_tip.setText("������ת���˺ţ���������");
			btn_transfer.setVisible(true);
			textField_money.setText("");
			btn_confirm.setVisible(false);
			textField_money.setDocument(new NumLengthLimit(18));
		}
	}
}
