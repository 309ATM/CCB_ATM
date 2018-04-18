package seventh.user;

import seventh.until.ATMButton;
import seventh.until.CountdownThread;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;

/** �û���������Ϣ��ʾ����
 * �����û�ȡ���ת�˺���ʾ��ǰ������ϸ�����ҿ���ѡ��������׻��߷���������
 * @author Jachin
 *
 */
public class MessageFrame {

	private JFrame frameMessage;
	private JLabel label_message;
	private String[] message;

	//private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";

	// �����̱߳���
	private JLabel countdownLabel;
	private CountdownThread time;

	// ��ʼ����ʱ
	public void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameMessage, countdownLabel);
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
					MessageFrame window = new MessageFrame();
					window.frameMessage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ��ʼ������
	 */
	public MessageFrame() {
		initialize();
	}

	public void showMessage(String[] message) {
		this.message = message;
		if (message[0].equals("ȡ��") | message[0].equals("͸֧ȡ��") | message[0].equals("���")) {
			String messages = "<html>{0}�ɹ�<br>{0}{1}Ԫ<br>����ǰ������{2}<br>�����տ�{0}�{3}";
			messages = messages.replace("{0}", message[0]);
			messages = messages.replace("{1}", message[1]);
			messages = messages.replace("{2}", message[2]);
			messages = messages.replace("{3}", message[3]);
			label_message.setText(messages);
		} else if (message[0].equals("ת��")) {
			String messages = "<html>{0}�ɹ�<br>{0}{1}Ԫ<br>ת��Ŀ�꣺{3}<br>����ǰ������{2}";
			messages = messages.replace("{0}", message[0]);
			messages = messages.replace("{1}", message[1]);
			messages = messages.replace("{2}", message[2]);
			messages = messages.replace("{3}", message[3]);
			label_message.setText(messages);
		} else if (message[0].equals("����ת��")) {
			String messages = "<html>{0}�ɹ�<br>{0}��{1}Ԫ<br>��ȡ�����ѣ�{4}Ԫ<br>ת��Ŀ�꣺{3}<br>����ǰ������{2}";
			messages = messages.replace("{0}", message[0]);
			messages = messages.replace("{1}", message[1]);
			messages = messages.replace("{2}", message[2]);
			messages = messages.replace("{3}", message[3]);
			messages = messages.replace("{4}", message[4]);
			label_message.setText(messages);
		}
	}

	public JFrame getFrameMessage() {
		return frameMessage;
	}

	/**
	 * ��ӿؼ�
	 */
	private void initialize() {
		frameMessage = new JFrame();
		frameMessage.setTitle("��������ATM");
		frameMessage.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameMessage.setResizable(false);
		frameMessage.setBounds(360, 150, 1095, 750);
		frameMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMessage.getContentPane().setLayout(null);

		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("����", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameMessage.getContentPane().add(countdownLabel);

		label_message = new JLabel();
		label_message.setForeground(new Color(255, 255, 255));
		label_message.setFont(new Font("��Բ", Font.BOLD, 24));
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setBounds(287, 282, 504, 204);
		frameMessage.getContentPane().add(label_message);

		ATMButton button_continue = new ATMButton("<html><center>����<br>Continue</center></html>");
		button_continue.setForeground(new Color(0, 128, 0));
		button_continue.addActionListener(new Continue());
		button_continue.setBounds(875, 550, 200, 80);
		frameMessage.getContentPane().add(button_continue);

		ATMButton button_exit = new ATMButton("<html><center>�˳�<br>Exit</center></html>");
		button_exit.setForeground(Color.RED);
		button_exit.addActionListener(new Back());
		button_exit.setBounds(14, 550, 200, 80);
		frameMessage.getContentPane().add(button_exit);

		JLabel lblBg = new JLabel("");
		lblBg.setFont(new Font("��Բ", Font.BOLD, 24));
		lblBg.setForeground(Color.WHITE);
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameMessage.getContentPane().add(lblBg);

	}

	/** �û�ѡ��������װ�ť�¼�������
	 * @author Jachin
	 *
	 */
	class Continue implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (message[0].equals("ȡ��") || message[0].equals("͸֧ȡ��")) {
				// ֹͣ��ǰ����ʱ��������һ���ĵ���ʱ
				stopCountdown();
				TakeChoseFrame takeChoseFrame = new TakeChoseFrame();
				takeChoseFrame.getFrameChose().setVisible(true);
				takeChoseFrame.startCountdown();
				frameMessage.setVisible(false);
			}
			if (message[0].equals("���")) {
				stopCountdown();
				SaveFrame saveFrame = new SaveFrame();
				saveFrame.getFrameSave().setVisible(true);
				saveFrame.startCountdown();
				frameMessage.setVisible(false);
			}
			if (message[0].equals("ת��") || message[0].equals("����ת��")) {
				stopCountdown();
				TransferChoseFrame transferChoseFrame = new TransferChoseFrame();
				transferChoseFrame.getFrameTransferChose().setVisible(true);
				transferChoseFrame.startCountdown();
				frameMessage.setVisible(false);
			}
		}

	}

	/** 
	 * �˳���ť�¼�������
	 */
	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameMessage.setVisible(false);
			label_message.setText("");
			// ��ʼ�����浹��ʱ
			MainFrame.startCountdown();
			// ֹͣ��ǰ����ʱ
			stopCountdown();
		}
	}

}
