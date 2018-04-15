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

import seventh.accout.BlankAccout;
import seventh.until.ATMButton;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * ת��
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

		ATMButton btn_exit = new ATMButton("<html><center>�˳�<br>Confirm</center></html>");
		btn_exit.setForeground(new Color(255, 0, 0));
		btn_exit.addActionListener(new Back());
		btn_exit.setBounds(14, 550, 200, 80);
		frameTransfer.getContentPane().add(btn_exit);

		textField_money = new JTextField();
		textField_money.setFont(new Font("΢���ź� Light", Font.PLAIN, 40));
		textField_money.setBounds(321, 284, 451, 53);
		frameTransfer.getContentPane().add(textField_money);
		textField_money.setColumns(10);

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
	 */
	class TransferMoney implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label_message.setText("");
			// �����ж����뿨���Ѿ�ѡ��Ĺ����Ƿ�һ��(ָ�������м�ת������)
			String inputCard = textField_money.getText();// ��ȡ����Ҫ����
			if (!inputCard.isEmpty()) {
				Long card = Long.parseLong(inputCard);
				BlankAccout.getInstance().setTargetCard(card);
				// �ж����뿨���Ƿ����
				if (BlankAccout.getInstance().getAccountDAO().getCardExit(card)) {
					if (isCross) {// ���а�ť
						if (BlankAccout.getInstance().getBlank()) {
							// 1.�����û�����ת
							if (!BlankAccout.getInstance().getAccountDAO().getBanks(card)) {// ���벻���Ǳ��п���
								// �������
								label_tip.setText("������ת�˽�ȷ�ϼ�ת��");
								btn_transfer.setVisible(false);
								textField_money.setText("");
								btn_confirm.setVisible(true);
								fees = true;
							} else {
								// ��ʾ�������뱾�п���
								label_message.setText("<html><center>��ѡ����ǿ���ת�ˣ�<br>�������������е��˺�</center></html>");
							}
						} else {
							// 2.�ǽ����û�ת
							// TODO ����ת���Լ�����ʾ��Ϣ��ôд
							if (BlankAccout.getInstance().getCardNum() == BlankAccout.getInstance().getTargetCard()) {
								label_message.setText("�����������˵��˺�");
							} else {
								// ������ת
								label_tip.setText("������ת�˽��");
								btn_transfer.setVisible(false);
								textField_money.setText("");
								btn_confirm.setVisible(true);
								fees = true;
							}
						}

					} else {// ����ת���а�ť
							// ֻ��Ҫ�ж����뿨���ǲ��ǽ����Լ����������Լ��Ŀ���
						if (BlankAccout.getInstance().getAccountDAO().getBanks(card)) {
							if (BlankAccout.getInstance().getCardNum() == BlankAccout.getInstance().getTargetCard()) {
								// TODO ����ת���Լ�����ʾ��Ϣ��ôд
								label_message.setText("�����������˵��˺�");
							} else {
								// �������
								label_tip.setText("������ת�˽��");
								btn_transfer.setVisible(false);
								textField_money.setText("");
								btn_confirm.setVisible(true);
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
	 */
	class ConfirmTransfer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label_message.setText("");
			String moneys = textField_money.getText();
			float money = Float.parseFloat(moneys);
			float fee = 0;
			// ����ת�˽��ĺϷ����жϣ������û����
			if (fees) {// ���У���ȡ������
				// ����˻�����ȡ�����Ѻ�����㹻�Ļ�
				float balance = BlankAccout.getInstance().getBalance();// �û�ת��ǰ�����
				balance = (float) (balance - money * 1.01);// ����������ȡ������
				if (balance >= 0) {
					// ����㹻���������п۳�ת�˽��
					BlankAccout.getInstance().setBalance(balance);
					// ת������
					Long cardOut = BlankAccout.getInstance().getCardNum();
					// ת�뿨��
					Long cardIn = BlankAccout.getInstance().getTargetCard();
					// ת�˽��
					money = (float) (money * 0.99);
					// ������
					fee = (float) (money * 0.01);
					// ��ת�������
					float balanceOut = balance;
					// ��ת������
					float balanceIn = BlankAccout.getInstance().getAccountDAO().getCardBalance(cardIn) + money;

					// ������Ϣ��������������
					message[0] = "����ת��";
					message[1] = moneys; // ת�˽��
					message[4] = String.valueOf(money * 0.1);
					message[2] = Float.toString(BlankAccout.getInstance().getBalance());// �˻����
					message[3] = Long.toString(BlankAccout.getInstance().getTargetCard());// Ŀ���˺�
					messageFrame.getFrameMessage().setVisible(true);
					messageFrame.showMessage(message);
					frameTransfer.dispose();
					// �����ı���Ϊ�գ���ť�ص�
					label_tip.setText("������ת���˺ţ���������");
					textField_money.setText("");
					btn_transfer.setVisible(true);
					btn_confirm.setVisible(false);

					// ����ת��ת��������ת������+���
					BlankAccout.getInstance().getAccountDAO().setCardBalance(cardOut, balanceOut);
					// ����ת��ת�뷽����ת�뿨��+���
					BlankAccout.getInstance().getAccountDAO().setCardBalance(cardIn, balanceIn);

					// �����ǽ���¼���뽻����ʷ��¼��
					// ��ת���ļ�¼
					BlankAccout.getInstance().getTradingrecDAO().insertRecording(cardOut, money, "ת��ת��", cardIn, fee);
					// ��ת��ļ�¼
					BlankAccout.getInstance().getTradingrecDAO().insertRecording(cardIn, money, "ת��ת��", cardOut, fee);

				} else {
					// �����û��۳������Ѻ�����
					label_message.setText("�۳�1%�������Ѻ�����");
				}
			} else {// ����ת�ˣ�����������
					// ����˻����㹻�Ļ�
				float balance = BlankAccout.getInstance().getBalance();
				balance = balance - money; // ת�˺�����
				if (balance >= 0) {
					// ����㹻���������п۳�ת�˽��
					BlankAccout.getInstance().setBalance(balance);
					// ת������
					Long cardOut = BlankAccout.getInstance().getCardNum();
					// ת�뿨��
					Long cardIn = BlankAccout.getInstance().getTargetCard();
					// ת�˽���������Ľ��money
					// �����Ѿ���fee = 0
					// ��ת��������
					float balanceOut = balance;
					// ��ת�������
					float balanceIn = BlankAccout.getInstance().getAccountDAO().getCardBalance(cardIn) + money;

					// ת�˳ɹ���������Ϣ��ת�˳ɹ���ʾ����
					message[0] = "ת��";
					message[1] = moneys; // ת�˽��
					message[2] = Float.toString(BlankAccout.getInstance().getBalance());// �˻����
					message[3] = Long.toString(BlankAccout.getInstance().getTargetCard());// Ŀ���˺�
					messageFrame.getFrameMessage().setVisible(true);
					messageFrame.showMessage(message);
					frameTransfer.dispose();
					label_tip.setText("������ת���˺ţ���������");
					textField_money.setText("");
					btn_transfer.setVisible(true);
					btn_confirm.setVisible(false);

					// ����ת��ת��������ת������+���
					BlankAccout.getInstance().getAccountDAO().setCardBalance(cardOut, balanceOut);
					// ����ת��ת�뷽����ת�뿨��+���
					BlankAccout.getInstance().getAccountDAO().setCardBalance(cardIn, balanceIn);

					// �����ǽ���¼���뽻����ʷ��¼��
					// ��ת���ļ�¼
					BlankAccout.getInstance().getTradingrecDAO().insertRecording(cardOut, money, "ת��ת��", cardIn, fee);
					// ��ת��ļ�¼
					BlankAccout.getInstance().getTradingrecDAO().insertRecording(cardIn, money, "ת��ת��", cardOut, fee);

				} else {
					// �����û�����
				}

			}
			// TODO ת�˲������ж�Ŀ���˺ţ����ӽ��׼�¼�����ݿ⣬�޸����
		}
	}

	class Back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameTransfer.dispose();
			label_message.setText("");
			label_tip.setText("������ת���˺ţ���������");
			btn_transfer.setVisible(true);
			textField_money.setText("");
			btn_confirm.setVisible(false);

		}

	}

}
