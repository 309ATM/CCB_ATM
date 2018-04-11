package seventh.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import seventh.accout.BlankAccout;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * ����Ա����
 *
 */
public class AdminUI {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_sex;
	private JTextField textField_idcard;
	private JTextField textField_carNum;
	private JTextField textField_phone;
	private JTextField textField_lock;
	private JTextField textField_loss;
	private JTextField textField_yue;
	private JTextArea textArea_address;
	private JButton btn_begin;
	private JButton btn_end;
	private JButton btn_confirm;
	private JTable table;
	private String File = "E:\\Code\\java\\CCB_ATM";
	// private String File = ".";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AdminUI window = new AdminUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frame.setTitle("�й��������к�̨����ϵͳ");
		frame.setBounds(500, 200, 1079, 660);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 15, 1062, 635);
		frame.getContentPane().add(tabbedPane);
		tabbedPane.setOpaque(false);

		ImageIcon ico_openAcc = new ImageIcon(File + "\\img\\OpenAccount.png");
		ImageIcon ico_reportLoss = new ImageIcon(File + "\\img\\ReportLoss.png");
		ImageIcon ico_lockAcc = new ImageIcon(File + "\\img\\LockAcc.png");
		ImageIcon ico_queryHistory = new ImageIcon(File + "\\img\\QueryHistory.png");
		ImageIcon ico_changePasswd = new ImageIcon(File + "\\img\\Admin.png");

		JPanel panel_Acc = new JPanel();
		tabbedPane.addTab(null, ico_openAcc, panel_Acc, "��������");
		panel_Acc.setLayout(null);

		JTabbedPane tabbedPane_Acc = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Acc.setBounds(0, 0, 1057, 514);
		panel_Acc.add(tabbedPane_Acc);

		JPanel panel_OpenAcc = new JPanel();
		tabbedPane_Acc.addTab("\u5F00\u6237", null, panel_OpenAcc, null);
		panel_OpenAcc.setLayout(null);
		panel_OpenAcc.setOpaque(false);

		JLabel label_inputAccInfo = new JLabel("�������û���Ϣ");
		label_inputAccInfo.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_inputAccInfo.setBounds(45, 13, 133, 43);
		panel_OpenAcc.add(label_inputAccInfo);

		JSeparator separator = new JSeparator();
		separator.setBounds(14, 70, 1024, 2);
		panel_OpenAcc.add(separator);

		JLabel label_name = new JLabel("����");
		label_name.setHorizontalAlignment(SwingConstants.LEFT);
		label_name.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_name.setBounds(180, 123, 72, 43);
		panel_OpenAcc.add(label_name);

		JLabel label_sex = new JLabel("�Ա�");
		label_sex.setHorizontalAlignment(SwingConstants.LEFT);
		label_sex.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_sex.setBounds(180, 179, 72, 43);
		panel_OpenAcc.add(label_sex);

		JLabel label_idcard = new JLabel("���֤��");
		label_idcard.setHorizontalAlignment(SwingConstants.LEFT);
		label_idcard.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_idcard.setBounds(180, 235, 72, 43);
		panel_OpenAcc.add(label_idcard);

		JLabel label_phone = new JLabel("�ֻ�����");
		label_phone.setHorizontalAlignment(SwingConstants.LEFT);
		label_phone.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_phone.setBounds(180, 291, 72, 43);
		panel_OpenAcc.add(label_phone);

		JLabel label_5 = new JLabel("\u8D26\u6237\u7C7B\u578B");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_5.setBounds(529, 123, 72, 43);
		panel_OpenAcc.add(label_5);

		JLabel label_address = new JLabel("��ͥסַ");
		label_address.setHorizontalAlignment(SwingConstants.LEFT);
		label_address.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_address.setBounds(529, 179, 72, 43);
		panel_OpenAcc.add(label_address);

		textField_name = new JTextField();
		textField_name.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_name.setBounds(265, 131, 211, 28);
		panel_OpenAcc.add(textField_name);
		textField_name.setColumns(10);

		textField_sex = new JTextField();
		textField_sex.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_sex.setColumns(10);
		textField_sex.setBounds(266, 189, 211, 28);
		panel_OpenAcc.add(textField_sex);

		textField_idcard = new JTextField();
		textField_idcard.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_idcard.setColumns(10);
		textField_idcard.setBounds(266, 243, 211, 28);
		panel_OpenAcc.add(textField_idcard);

		textField_phone = new JTextField();
		textField_phone.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_phone.setColumns(10);
		textField_phone.setBounds(266, 299, 211, 28);
		panel_OpenAcc.add(textField_phone);

		textArea_address = new JTextArea();
		textArea_address.setLineWrap(true);
		textArea_address.setFont(new Font("��Բ", Font.PLAIN, 18));
		textArea_address.setBounds(615, 189, 211, 134);
		panel_OpenAcc.add(textArea_address);
		textArea_address.setBorder(new LineBorder(Color.LIGHT_GRAY));

		JButton btn_account = new JButton("¼���û���Ϣ");
		btn_account.addActionListener(new UserInformation());

		String[] s = { "���ÿ�", "���" };
		JComboBox comboBox = new JComboBox(s);
		comboBox.setFont(new Font("��Բ", Font.PLAIN, 18));
		comboBox.setBounds(615, 133, 211, 24);
		panel_OpenAcc.add(comboBox);

		btn_account.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_account.setBounds(415, 379, 153, 43);
		panel_OpenAcc.add(btn_account);

		JLabel label_bg11 = new JLabel("");
		label_bg11.setBounds(0, 0, 1052, 475);
		label_bg11.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
		panel_OpenAcc.add(label_bg11);

		JPanel panel_DelAcc = new JPanel();
		tabbedPane_Acc.addTab("\u9500\u6237", null, panel_DelAcc, null);
		panel_DelAcc.setOpaque(false);
		panel_DelAcc.setLayout(null);

		JLabel label_inputCardNum = new JLabel("�����뿨��");
		label_inputCardNum.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_inputCardNum.setBounds(45, 13, 171, 43);
		panel_DelAcc.add(label_inputCardNum);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(14, 70, 1024, 2);
		panel_DelAcc.add(separator_1);

		textField_carNum = new JTextField();
		textField_carNum.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_carNum.setBounds(285, 155, 444, 43);
		panel_DelAcc.add(textField_carNum);
		textField_carNum.setColumns(10);

		JButton btn_delAcc = new JButton("����");
		btn_delAcc.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_delAcc.setBounds(458, 258, 84, 27);
		panel_DelAcc.add(btn_delAcc);

		JLabel label_bg12 = new JLabel("");
		label_bg12.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
		label_bg12.setBounds(0, 0, 1052, 475);
		panel_DelAcc.add(label_bg12);

		JPanel panel_Loss = new JPanel();
		tabbedPane.addTab(null, ico_reportLoss, panel_Loss, "��ʧ���");
		panel_Loss.setLayout(null);

		textField_loss = new JTextField();
		textField_loss.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_loss.setBounds(290, 128, 444, 43);
		panel_Loss.add(textField_loss);

		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u5361\u53F7");
		label_2.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_2.setBounds(35, 13, 171, 43);
		panel_Loss.add(label_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(14, 69, 1024, 2);
		panel_Loss.add(separator_3);

		JButton btn_loss = new JButton("ȷ��");
		btn_loss.addActionListener(new LossOperation());
		btn_loss.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_loss.setBounds(470, 217, 90, 43);
		panel_Loss.add(btn_loss);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
		label_1.setBounds(0, 0, 1065, 502);
		panel_Loss.add(label_1);

		JPanel panel_lock = new JPanel();
		tabbedPane.addTab(null, ico_lockAcc, panel_lock, "����ⶳ");
		panel_lock.setLayout(null);

		JLabel label_inputCardNumLock = new JLabel("�����뿨��");
		label_inputCardNumLock.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_inputCardNumLock.setBounds(35, 13, 171, 43);
		panel_lock.add(label_inputCardNumLock);
		separator_1.setBounds(14, 70, 1024, 2);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(14, 69, 1024, 2);
		panel_lock.add(separator_4);

		textField_lock = new JTextField();
		textField_lock.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_lock.setBounds(290, 128, 444, 43);
		panel_lock.add(textField_lock);
		textField_carNum.setColumns(10);

		JButton btn_lock = new JButton("\u786E\u8BA4");
		btn_lock.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_lock.setBounds(470, 217, 90, 43);
		panel_lock.add(btn_lock);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
		label.setBounds(0, 0, 1065, 502);
		panel_lock.add(label);

		JPanel panel_queryHistory = new JPanel();
		tabbedPane.addTab(null, ico_queryHistory, panel_queryHistory, "��ѯ������ʷ");
		panel_queryHistory.setLayout(null);

		JLabel lblBegin = new JLabel("��ʼ����");
		lblBegin.setFont(new Font("��Բ", Font.PLAIN, 18));
		lblBegin.setBounds(363, 30, 72, 40);
		panel_queryHistory.add(lblBegin);

		JLabel lblEnd = new JLabel("��������");
		lblEnd.setFont(new Font("��Բ", Font.PLAIN, 18));
		lblEnd.setBounds(632, 30, 72, 40);
		panel_queryHistory.add(lblEnd);

		// TODO ��ť
		btn_begin = new JButton("ѡ������");
		btn_begin.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		btn_begin.addActionListener(new getDate());
		btn_begin.setBounds(444, 30, 155, 40);
		panel_queryHistory.add(btn_begin);

		btn_end = new JButton("ѡ������");
		btn_end.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		btn_end.addActionListener(new getDate());
		btn_end.setBounds(711, 30, 160, 40);
		panel_queryHistory.add(btn_end);

		btn_confirm = new JButton("ȷ��");
		btn_confirm.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_confirm.addActionListener(new getDate());
		btn_confirm.setBounds(900, 30, 113, 41);
		panel_queryHistory.add(btn_confirm);

		// ���
		JPanel panel = new JPanel();
		panel.setBounds(73, 100, 954, 365);
		panel_queryHistory.add(panel);

		table = new JTable();
		// ���ñ��ĸ�ʽ
		table.setRowHeight(50); // �����и�
		table.getTableHeader().setFont(new Font("��Բ", Font.BOLD, 20)); // ���ñ�ͷ����
		table.setFont(new Font("��Բ", Font.BOLD, 20)); // ���ñ������
		table.setRowMargin(5);// �����������е�Ԫ��ľ���
		table.setRowSelectionAllowed(true);// ���ÿɷ�ѡ��.Ĭ��Ϊfalse
		table.setSelectionBackground(Color.white);// ������ѡ���еı���ɫ
		table.setSelectionForeground(new Color(135, 136, 250));// ������ѡ���е�ǰ��ɫ
		table.setGridColor(Color.black);// ���������ߵ���ɫ
		table.setDragEnabled(false);// �������
		table.setShowGrid(false);// �Ƿ���ʾ������
		table.setShowHorizontalLines(true);// �Ƿ���ʾˮƽ��������
		table.setShowVerticalLines(true);// �Ƿ���ʾ��ֱ��������
		table.getTableHeader().setResizingAllowed(false);// ���ñ�񲻿������ƶ�
		table.getTableHeader().setReorderingAllowed(false);// ���ñ���п��ɸ�

		table.doLayout();
		panel.setLayout(null);
		table.setBackground(SystemColor.control);

		JScrollPane JSP = new JScrollPane(table);
		JSP.setBounds(0, 0, 954, 365);
		panel.add(JSP);
		table.setBounds(171, 236, 700, 700);
		
		textField = new JTextField();
		textField.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(120, 32, 223, 36);
		panel_queryHistory.add(textField);
		
		JLabel label_6 = new JLabel("\u5361\u53F7");
		label_6.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_6.setBounds(68, 32, 47, 40);
		panel_queryHistory.add(label_6);
		
				JLabel label_3 = new JLabel("");
				label_3.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
				label_3.setBounds(0, 0, 1068, 504);
				panel_queryHistory.add(label_3);

		JPanel panel_changePasswd = new JPanel();
		tabbedPane.addTab(null, ico_changePasswd, panel_changePasswd, "�޸�����");
		panel_changePasswd.setLayout(null);

		JLabel lblTips = new JLabel("\u8BF7\u8F93\u5165\u5361\u53F7");
		lblTips.setFont(new Font("��Բ", Font.PLAIN, 18));
		lblTips.setBounds(35, 13, 101, 43);
		panel_changePasswd.add(lblTips);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(14, 69, 1024, 2);
		panel_changePasswd.add(separator_5);

		textField_yue = new JTextField();
		textField_yue.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_yue.setBounds(290, 128, 444, 43);
		panel_changePasswd.add(textField_yue);

		JButton btn_yue = new JButton("\u786E\u8BA4");
		btn_yue.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_yue.setBounds(752, 128, 90, 43);
		panel_changePasswd.add(btn_yue);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(File + "\\img\\bg.jpg"));
		label_4.setBounds(0, 0, 1068, 504);
		panel_changePasswd.add(label_4);
	}

	public void lock() {
		String card = textField_lock.getText();
		// �������ݿⷽ���жϿ����Ƿ����
	}

	public void yue() {
		String card = textField_yue.getText();
		// �������ݿⷽ���жϿ����Ƿ����
	}

	//TODO ��ȡ�����������
	public void WriteData(String[] month) {
		final String[] columnNames = { "����", "��������", "���׽��", "Ŀ���˻�", "������" };
		// �������ݿⷽ����ȡ��¼
		// function(BlankAccout.getInstance().getCardNum(),getDate(6));
		// �ⲿ�����ݴ����ݿ����ȡ
		String[][] rowData = { { "2018.04.01 08:09:56", "ת��", "��1200", "62218858000005086", "��0.00" },
				{ "2018.04.01 14:04:38", "ת��", "��13000", "62218858000005086", "��0.00" },
				{ "2018.04.04 15:50:21", "ת��", "��100", "62218858000005086", "��1.00" },
				{ "2018.04.08 11:34:23", "ת��", "��200", "62218858000005086", "��2.00" },
				{ "2018.04.10 09:56:12", "͸֧ȡ��", "��400", "62218858000005086", "��4.00" },
				{ "2018.04.10 09:56:12", "͸֧ȡ��", "��400", "62218858000005086", "��4.00" },
				{ "2018.04.10 09:56:12", "͸֧ȡ��", "��400", "62218858000005086", "��4.00" },
				{ "2018.04.10 09:56:12", "͸֧ȡ��", "��400", "62218858000005086", "��4.00" },
				{ "2018.04.10 09:56:12", "͸֧ȡ��", "��400", "62218858000005086", "��4.00" },
				{ "2018.04.10 09:56:12", "͸֧ȡ��", "��400", "62218858000005086", "��4.00" } };

		table.setModel(new DefaultTableModel(rowData, columnNames));
		// �������־���
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumn("����").setCellRenderer(render);
		table.getColumn("��������").setCellRenderer(render);
		table.getColumn("���׽��").setCellRenderer(render);
		table.getColumn("Ŀ���˻�").setCellRenderer(render);
		table.getColumn("������").setCellRenderer(render);
		// �����п�
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
	}

	String dateBefore = "";
	String dateNow = "";
	private JTextField textField;

	// TODO ��ȡ���ڼ�����
	class getDate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JDateChooser dateChoose = new JDateChooser();

			if (e.getSource() == btn_begin) {
				dateChoose.showDateChooser();
				dateBefore = dateChoose.getDateFormat("yyyy-MM-dd");
				btn_begin.setText(dateBefore);
			}
			if (e.getSource() == btn_end) {
				dateChoose.showDateChooser();
				dateNow = dateChoose.getDateFormat("yyyy-MM-dd");
				btn_end.setText(dateNow);
			}
			if (e.getSource() == btn_confirm) {
				if(dateBefore.isEmpty()||dateNow.isEmpty()){
					JOptionPane.showMessageDialog(null, "��ѡ����ȷ����", "����", JOptionPane.ERROR_MESSAGE);
				}
				else if (dateBefore.compareTo(dateNow) <= 0) {
					// TODO ��ȡ��¼��Ϣ��������Ϣ�����JTable��
					String[] date = {dateBefore,dateNow};
					WriteData(date);
				} else {
					JOptionPane.showMessageDialog(null, "��ѡ����ȷ����", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	// ¼���û���Ϣ�ļ�����
	class UserInformation implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// ȥ����Ϣͷβ�Ŀո�
			String name = textField_name.getText().trim();
			String sex = textField_sex.getText().trim();
			String idCard = textField_idcard.getText().trim();
			String phone = textField_phone.getText().trim();
			String address = textArea_address.getText().trim();
			// ��ʼ������Ϣ���
			if (name.isEmpty() | sex.isEmpty() | idCard.isEmpty() | phone.isEmpty() | address.isEmpty()) {
				JOptionPane.showMessageDialog(null, "��Ϣ����Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
			} else if (phone.length() != 11) {
				JOptionPane.showMessageDialog(null, "�ֻ��ų��Ȳ���ȷ", "����", JOptionPane.ERROR_MESSAGE);
			} else if (idCard.length() != 18) {
				JOptionPane.showMessageDialog(null, "���֤���볤�Ȳ���ȷ", "����", JOptionPane.ERROR_MESSAGE);
			} else {
				String password = JOptionPane.showInputDialog(null, "����������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				String confirmPassword = null;
				// ����û�ȡ���������룬�򲻵���ȷ������������
				if (password != null) {
					confirmPassword = JOptionPane.showInputDialog(null, "���ٴ���������", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				}
				try {
					if (confirmPassword.length() == 6 && password.length() == 6) {
						if (password.equals(confirmPassword)) {
							BlankAccout.getInstance().setCardNum(Long.parseLong(idCard));
							System.out.println(BlankAccout.getInstance().getCardNum());
						} else {
							JOptionPane.showMessageDialog(null, "�������벻һ��", "����", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "������6λ����", "����", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "��ȡ���˲���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		}
	}

	// ��ʧ��Ҽ�����
	class LossOperation implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String card = textField_loss.getText();
			Boolean flag = true;
			// �������ݿⷽ���жϿ����Ƿ����
			if (flag) {
				String a = JOptionPane.showInputDialog(null, "����������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				// �жϿ�������һ��
				if (flag) {
					// ��ȡ�˻�״̬
					System.out.println("");
				} else {
					JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "���˻�������", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
