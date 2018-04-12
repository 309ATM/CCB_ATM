package seventh.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import seventh.accout.BlankAccout;
import seventh.until.ATMButton;

/**
 * ���
 *
 */
public class SaveFrame {

	private JFrame frameSave;
	private JTextField textField_money;
	private String File = "E:\\Code\\java\\CCB_ATM";
	private JLabel label_message;
	private JLabel label_success;
	// private String File = ".";

	public JFrame getFrameSave() {
		return frameSave;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SaveFrame window = new SaveFrame();
					window.frameSave.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaveFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSave = new JFrame();
		frameSave.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameSave.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameSave.setResizable(false);
		frameSave.setBounds(360, 150, 1095, 750);
		frameSave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSave.getContentPane().setLayout(null);

		JLabel label = new JLabel("��������");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("��Բ", Font.BOLD, 28));
		label.setBounds(381, 260, 294, 48);
		frameSave.getContentPane().add(label);

		label_message = new JLabel("");
		label_message.setHorizontalAlignment(SwingConstants.CENTER);
		label_message.setForeground(Color.red);
		label_message.setFont(new Font("��Բ", Font.BOLD, 20));
		label_message.setBounds(381, 406, 294, 48);
		frameSave.getContentPane().add(label_message);
		
		label_success = new JLabel("");
		label_success.setHorizontalAlignment(SwingConstants.CENTER);
		label_success.setForeground(Color.WHITE);
		label_success.setFont(new Font("��Բ", Font.BOLD, 20));
		label_success.setBounds(381, 406, 294, 100);
		frameSave.getContentPane().add(label_success);

		textField_money = new JTextField();
		textField_money.setFont(new Font("΢���ź� Light", Font.PLAIN, 40));
		textField_money.setBounds(380, 330, 294, 53);
		frameSave.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		ATMButton btn_confirm = new ATMButton("<html><center>ȷ��<br>Exit</center></html>");
		btn_confirm.setForeground(new Color(0, 128, 0));
		btn_confirm.addActionListener(new SaveMoney());
		btn_confirm.setBounds(875, 550, 200, 80);
		frameSave.getContentPane().add(btn_confirm);

		ATMButton btn_exit = new ATMButton("<html><center>�˳�<br>Exit</center></html>");
		btn_exit.setForeground(Color.RED);
		btn_exit.addActionListener(new Back());
		btn_exit.setBounds(14, 550, 200, 80);
		frameSave.getContentPane().add(btn_exit);

		JLabel lblBg = new JLabel("");
		lblBg.setFont(new Font("΢���ź� Light", Font.PLAIN, 36));
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameSave.getContentPane().add(lblBg);
	}

	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameSave.setVisible(false);
		}
	}

	public Boolean poundage(String card) {
		// �ж���������
		return true;
	}

	public void deposit(Long card, int money) {
		// ����
		//TODO �������ݿ⺯������Ǯ
		BlankAccout.getInstance().setBalance(BlankAccout.getInstance().getBalance() + money);
		BlankAccout.getInstance().setTargetCard(BlankAccout.getInstance().getCardNum());
	}

	// ��Ǯ������
	class SaveMoney implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			label_message.setText("");
				String moneys = textField_money.getText().trim();
				try {
					int money = Integer.parseInt(moneys);
//					BlankAccout.getInstance().setDepositLimit(4000);
//					BlankAccout.getInstance().setBlank("�й�����");
					if (money % 100 != 0){
						label_message.setText("�����������100��������");
					}
					else if (money > 10000) {
						label_message.setText("���ʴ�����Ϊ10,000Ԫ");
					} else if (money > BlankAccout.getInstance().getDepositLimit()) {
						label_message.setText("���������ڽ����޶�");
					} else {
						// �ж����У������Ѽ���
						if (BlankAccout.getInstance().getBlank() == "��������") {
							// ֱ�ӵ������ݿ����
							deposit(BlankAccout.getInstance().getCardNum(), money);
						} else {
							// �Ǳ��У�����������
							money = money * 99 / 100;
							deposit(BlankAccout.getInstance().getCardNum(), money);
						}
						textField_money.setText("");
						float balace = BlankAccout.getInstance().getBalance();
						float overdraft = BlankAccout.getInstance().getOverdraft();
						
						label_success.setText("<html><center>���ɹ�<br>��" + balace + "<br>��͸֧�" + overdraft + "</center></html>");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "����������", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
	}

}
