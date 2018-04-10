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

public class SaveFrame {

	private JFrame frameSave;
	private JTextField textField_money;

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
		frameSave.setIconImage(
				Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
		frameSave.setResizable(false);
		frameSave.setBounds(360, 150, 1095, 750);
		frameSave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSave.getContentPane().setLayout(null);

		ATMButton button_1 = new ATMButton("<html>�˳�<br>Exit</html>");
		button_1.addActionListener(new Back());
		button_1.setBounds(875, 550, 200, 80);
		frameSave.getContentPane().add(button_1);
		
		JLabel label = new JLabel("��������");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("��Բ", Font.BOLD, 20));
		label.setBounds(381, 216, 294, 48);
		frameSave.getContentPane().add(label);
		
		textField_money = new JTextField();
		textField_money.setFont(new Font("΢���ź� Light", Font.PLAIN, 40));
		textField_money.setBounds(380, 338, 294, 53);
		frameSave.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		ATMButton button = new ATMButton("<html>ȷ��<br>Exit</html>");
		button.addActionListener(new SaveMoney());
		button.setBounds(14, 550, 200, 80);
		frameSave.getContentPane().add(button);

		JLabel lblBg = new JLabel("");
		lblBg.setFont(new Font("΢���ź� Light", Font.PLAIN, 36));
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameSave.getContentPane().add(lblBg);
	}


	class Back implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);;
			frameSave.setVisible(false);
		}
	}

	public Boolean poundage(String card) {
		//�ж���������
		return true;
	}
	
	public void deposit(Long card,int money){
		//����
	}

	// ��Ǯ������
		class SaveMoney implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				String moneys = textField_money.getText().trim();
				try {
					int money = Integer.parseInt(moneys);
//					BlankAccout.getInstance().setDepositLimit(4000);
//					BlankAccout.getInstance().setBlank("�й�����");
					if (money % 100 != 0)
						JOptionPane.showMessageDialog(null, "�����������100��������", "����", JOptionPane.ERROR_MESSAGE);
					else if (money > 10000) {
						JOptionPane.showMessageDialog(null, "���������ڵ����޶���ʴ�����Ϊ10000Ԫ", "����", JOptionPane.ERROR_MESSAGE);
					} else if (money > BlankAccout.getInstance().getDepositLimit()) {
						JOptionPane.showMessageDialog(null, "���������ڽ����޶�", "����", JOptionPane.ERROR_MESSAGE);
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
						// �������ݿ⺯������Ǯ
						JOptionPane.showMessageDialog(null, money, "���ɹ�", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "����������", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	
}
