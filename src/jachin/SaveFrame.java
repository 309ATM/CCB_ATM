package jachin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class SaveFrame {

	private JFrame frameSave;
	private JTextField textField_money;

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
				Toolkit.getDefaultToolkit().getImage(".\\img\\CCB.png"));
		frameSave.setResizable(false);
		frameSave.setBounds(360, 150, 1095, 750);
		frameSave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSave.getContentPane().setLayout(null);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		button_1.setIcon(new ImageIcon(".\\img\\btnExit.png"));
		button_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		button_1.setBounds(875, 550, 200, 80);
		frameSave.getContentPane().add(button_1);

		textField_money = new JTextField();
		textField_money.setFont(new Font("΢���ź� Light", Font.PLAIN, 40));
		textField_money.setBounds(380, 338, 294, 53);
		frameSave.getContentPane().add(textField_money);
		textField_money.setColumns(10);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveMoney();
			}
		});
		button.setIcon(new ImageIcon(".\\img\\btn_confirm.png"));
		button.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		button.setBounds(14, 550, 200, 80);
		frameSave.getContentPane().add(button);

		JLabel lblBg = new JLabel("");
		lblBg.setFont(new Font("΢���ź� Light", Font.PLAIN, 36));
		lblBg.setIcon(new ImageIcon(".\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameSave.getContentPane().add(lblBg);
	}

	public void SaveMoney() {
		String moneys = textField_money.getText();
		try {
			int money = Integer.parseInt(moneys);
			if (money % 100 != 0)
				JOptionPane.showMessageDialog(null, "�����������100��������", "����", JOptionPane.ERROR_MESSAGE);
			else {
				// �ж����У������Ѽ���
				if(poundage(MainFrame.card)){
					//ֱ�ӵ������ݿ����
					deposit(MainFrame.card, money);
				}else{
					//�Ǳ��У�����������
					money = money * 99 / 100;
					deposit(MainFrame.card, money);
				}
				// �������ݿ⺯������Ǯ
				JOptionPane.showMessageDialog(null, money, "���ɹ�", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "����������", "����", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void Back() {
		MainFrame.main(null);
		frameSave.dispose();
	}

	public Boolean poundage(String card) {
		//�ж���������
		return true;
	}
	
	public void deposit(String card,int money){
		//����
	}

}
