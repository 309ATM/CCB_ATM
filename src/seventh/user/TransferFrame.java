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
	String[] message =new String[4]; 
	// private MainFrame mainFrame = new MainFrame();
	//private String File = "E:\\Code\\java\\CCB_ATM";
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
		frameTransfer.setIconImage(
				Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
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
		
		label_tip = new JLabel("������ת���˺�");
		label_tip.setHorizontalAlignment(SwingConstants.CENTER);
		label_tip.setForeground(new Color(255, 255, 255));
		label_tip.setFont(new Font("��Բ", Font.BOLD, 24));
		label_tip.setBounds(392, 204, 311, 53);
		frameTransfer.getContentPane().add(label_tip);
		
		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(new Color(255, 0, 0));
		label_message.setFont(new Font("��Բ", Font.BOLD, 24));
		label_message.setBounds(392, 368, 311, 53);
		frameTransfer.getContentPane().add(label_message);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameTransfer.getContentPane().add(lblBg);
	}

	/**
	 * ���뿨�ź��ת�˰�ť������ 
	 */
	class TransferMoney implements ActionListener {
		boolean flag;
		@Override
		public void actionPerformed(ActionEvent e) {
			//�����ж����뿨���Ѿ�ѡ��Ĺ����Ƿ�һ��(ָ�������м�ת������)
			String cardNum = textField_money.getText();//��ȡ����Ҫ����
			//TODO *�������ݿⷽ�� �ж����������Ƿ�Ϊ������
			flag = false;
			//����ǿ��У��ǿ���Ҫ�����Ǳ��п���
			if(isCross){
				if(flag){//flag��ʾΪ�����ǲ��Ǳ���
					//�޸�label�ı�ֵ
					label_tip.setText("������ת�˽��");
					btn_transfer.setVisible(false);
					btn_confirm.setVisible(true);
				}else{
					label_message.setText("<html><center>��ѡ����ǿ���ת�ˣ�<br>�������������е��˺�</center></html>");
				}
			}else{//������ѡ���ܲ�һ��
				if(!flag){//flag��ʾΪ�����ǲ��Ǳ���
					//�޸�label�ı�ֵ
					label_tip.setText("������ת�˽��");
					btn_transfer.setVisible(false);
					btn_confirm.setVisible(true);
					textField_money.setText("");
				}else{
					label_message.setText("<html><center>��ѡ����ǿ�ת��ת�ˣ�<br>�����뱾�е��˺�</center></html>");
				}
			}
			
			// TODO ת�˲������ж�Ŀ���˺ţ����ӽ��׼�¼�����ݿ⣬�޸����
			//System.out.println(isCross);
		}

	}

	/**
	 * ��������ȷ�ϰ�ť������
	 */
	class ConfirmTransfer implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String moneys = textField_money.getText();
			label_message.setText(moneys);
			//����ת�˽��ĺϷ����жϣ������û����
			if(isCross){//���У���ȡ������
				//����˻�����ȡ�����Ѻ�����㹻�Ļ�
			}else{//����ת�ˣ�����������
				//����˻����㹻�Ļ�
				// TODO ��תת�˳ɹ����棬Ŀǰֻ�ǿ�ܣ��߼�ȫ��ûʵ��
				
				// ת�˳ɹ���������Ϣ��ȡ��ɹ���ʾ����
				message[0] = "ת��";
				message[1] = moneys; // ȡ����
				message[2] = Float.toString(BlankAccout.getInstance().getBalance());// �˻����
				message[3] = Float.toString(BlankAccout.getInstance().getTargetCard());// ���տ�ȡ����
				
				messageFrame.getFrameMessage().setVisible(true);
				messageFrame.showMessage(message);
				frameTransfer.dispose();
			}
			
			
		}
		
	}
	
	
	class Back implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameTransfer.dispose();
			textField_money.setText("");
			//label_message.set
		}
		
	}
}
