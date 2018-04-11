package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import seventh.until.ATMButton;

import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * ȡ��
 *
 */
public class TakeFrame {

	public JFrame frameTake;
	private JTextField textField_money;
	Boolean isOverdeaft; //�ǲ���͸֧ȡ��
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public TakeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameTake = new JFrame();
		frameTake.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameTake.setTitle("�й���������ATM");
		frameTake.setResizable(false);
		frameTake.setBounds(360, 150, 1095, 750);
		frameTake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTake.getContentPane().setLayout(null);

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
		textField_money.setColumns(10);

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
			// TODO �Զ����ɵĹ��캯�����
			this.money = money;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//�����͸֧ȡ������͸֧ȡ��ķ�����
			if(isOverdeaft) {
				Overdraft(money);
			}
			else
				take(money);
		}

	}
	
	
	/**
	 * �û���������ȡ��ʱ�ļ�������
	 *
	 */
	class CustomWithdrawal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String moneys = textField_money.getText();
			float money = Float.parseFloat(moneys);
			
			if (!isOverdeaft) {
				if (money % 100 != 0)
					JOptionPane.showMessageDialog(null, "�����������100��������", "����", JOptionPane.ERROR_MESSAGE);
				else if (money > 5000) {
					JOptionPane.showMessageDialog(null, "ȡ��������ڵ����޶���ʴ�����Ϊ5000Ԫ", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					take(moneys);
				} 
			}else {
				if (money % 100 != 0)
					JOptionPane.showMessageDialog(null, "�����������100��������", "����", JOptionPane.ERROR_MESSAGE);
				else if (money > 5000) {
					JOptionPane.showMessageDialog(null, "͸֧�������͸֧�͸֧���Ϊ5000Ԫ", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					Overdraft(moneys);
				} 
			}
			
			textField_money.setText("");
		}

	}

	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameTake.dispose();
		}
	}

	/** �������ݿⷽ��д�����ݣ��޸� BlankAccount
	 * @param moneys
	 */
	public void take(String moneys) {
		float money = Float.parseFloat(moneys);
		// ������
		float fees  = 0;
		if (money > BlankAccout.getInstance().getWithdrawalsLimit()) {
			JOptionPane.showMessageDialog(null, "ȡ��������ڽ����޶�", "����", JOptionPane.ERROR_MESSAGE);
		} else {
			// TODO �������ݿⷽ�������׼�¼������һ��޸����ݿ��е����
			if (BlankAccout.getInstance().getBlank() != "��������") {
				fees = money* 1 / 100;
			}
			// �޸Ľ���ȡ����
			BlankAccout.getInstance().setWithdrawalsLimit(BlankAccout.getInstance().getWithdrawalsLimit() - money);
			// �޸����
			BlankAccout.getInstance().setBalance(BlankAccout.getInstance().getBalance() - money - fees);
			System.out.println(BlankAccout.getInstance().getWithdrawalsLimit());
			System.out.println(BlankAccout.getInstance().getBalance());
			JOptionPane.showMessageDialog(null, "ȡ��" + money, "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void Overdraft(String moneys) {
		//TODO ͸֧ȡ��ķ���
		float money = Float.parseFloat(moneys);
		// ������
		float fees  = 0;
		if (money > BlankAccout.getInstance().getWithdrawalsLimit()) {
			JOptionPane.showMessageDialog(null, "͸֧������ڽ����޶�", "����", JOptionPane.ERROR_MESSAGE);
		} else {
			// TODO �������ݿⷽ�������׼�¼������һ��޸����ݿ��е����
			if (BlankAccout.getInstance().getBlank() != "��������") {
				fees = money* 1 / 100;
			}
			// �޸Ľ���ȡ����
			BlankAccout.getInstance().setWithdrawalsLimit(BlankAccout.getInstance().getWithdrawalsLimit() - money);
			// �޸����
			BlankAccout.getInstance().setBalance(BlankAccout.getInstance().getBalance() - money - fees);
			System.out.println(BlankAccout.getInstance().getWithdrawalsLimit());
			System.out.println(BlankAccout.getInstance().getBalance());
			JOptionPane.showMessageDialog(null, "ȡ��" + money, "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
