package seventh.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import seventh.accout.BlankAccout;
import seventh.until.JDateChooser;
import seventh.until.JShowInfo;

/**
 * ����Ա����
 *
 */
@SuppressWarnings("rawtypes")
public class AdminUI {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_idcard;
	private JTextField textField_carNum;
	private JTextField textField_phone;
	private JTextField textField_queryBalance;
	private JTextField textField_loss;
	private JTextField textField_yue;
	private JTextArea textArea_address;
	private JTextField textField_query;
	private JButton btn_begin;
	private JButton btn_end;
	private JButton btn_confirm;
	private JComboBox comboBox_cardType;
	private JComboBox comboBox;
	private JButton btn_loss;
	private JTable table;
	private String[] date;

	private String File = "E:\\Code\\java\\CCB_ATM";
	private JTextField textField_lock;
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
		date = new String[2];
		date[0] = "";
		date[1] = "";
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
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
		ImageIcon ico_statusOprea = new ImageIcon(File + "\\img\\StatusOperation.png");
		ImageIcon ico_query = new ImageIcon(File + "\\img\\QueryBlance.png");
		ImageIcon ico_queryHistory = new ImageIcon(File + "\\img\\QueryHistory.png");
		ImageIcon ico_changePasswd = new ImageIcon(File + "\\img\\Admin.png");
		ImageIcon ico_background = new ImageIcon(File + "\\img\\bg.jpg");

		JPanel panel_Acc = new JPanel();
		tabbedPane.addTab(null, ico_openAcc, panel_Acc, "��������");
		panel_Acc.setLayout(null);

		JTabbedPane tabbedPane_Acc = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Acc.setBounds(0, 0, 1066, 505);
		panel_Acc.add(tabbedPane_Acc);

		JPanel panel_OpenAcc = new JPanel();
		tabbedPane_Acc.addTab("����", null, panel_OpenAcc, null);
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
		label_name.setBounds(180, 130, 72, 35);
		panel_OpenAcc.add(label_name);

		JLabel label_sex = new JLabel("�Ա�");
		label_sex.setHorizontalAlignment(SwingConstants.LEFT);
		label_sex.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_sex.setBounds(180, 185, 72, 35);
		panel_OpenAcc.add(label_sex);

		JLabel label_idcard = new JLabel("���֤��");
		label_idcard.setHorizontalAlignment(SwingConstants.LEFT);
		label_idcard.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_idcard.setBounds(180, 240, 72, 35);
		panel_OpenAcc.add(label_idcard);

		JLabel label_phone = new JLabel("�ֻ�����");
		label_phone.setHorizontalAlignment(SwingConstants.LEFT);
		label_phone.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_phone.setBounds(180, 295, 72, 35);
		panel_OpenAcc.add(label_phone);

		JLabel label_type = new JLabel("�˻�����");
		label_type.setHorizontalAlignment(SwingConstants.LEFT);
		label_type.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_type.setBounds(529, 130, 72, 35);
		panel_OpenAcc.add(label_type);

		JLabel label_address = new JLabel("��ͥסַ");
		label_address.setHorizontalAlignment(SwingConstants.LEFT);
		label_address.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_address.setBounds(529, 185, 72, 35);
		panel_OpenAcc.add(label_address);

		textField_name = new JTextField();
		textField_name.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_name.setBounds(265, 130, 211, 35);
		panel_OpenAcc.add(textField_name);
		textField_name.setColumns(10);

		String[] sex = { "��", "Ů" };
		comboBox = new JComboBox(sex);
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("��Բ", Font.PLAIN, 18));
		comboBox.setBounds(265, 185, 211, 35);
		panel_OpenAcc.add(comboBox);

		textField_idcard = new JTextField();
		textField_idcard.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_idcard.setColumns(10);
		textField_idcard.setBounds(266, 240, 211, 35);
		panel_OpenAcc.add(textField_idcard);

		textField_phone = new JTextField();
		textField_phone.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_phone.setColumns(10);
		textField_phone.setBounds(266, 295, 211, 35);
		panel_OpenAcc.add(textField_phone);

		textArea_address = new JTextArea();
		textArea_address.setLineWrap(true);
		textArea_address.setFont(new Font("��Բ", Font.PLAIN, 18));
		textArea_address.setBounds(615, 185, 211, 145);
		panel_OpenAcc.add(textArea_address);
		textArea_address.setBorder(new LineBorder(Color.LIGHT_GRAY));

		JButton btn_account = new JButton("¼���û���Ϣ");
		btn_account.addActionListener(new UserInformation());

		String[] type = { "���ÿ�", "���" };
		comboBox_cardType = new JComboBox(type);
		comboBox_cardType.setForeground(Color.BLUE);
		comboBox_cardType.setFont(new Font("��Բ", Font.PLAIN, 18));
		comboBox_cardType.setBounds(615, 130, 211, 35);
		panel_OpenAcc.add(comboBox_cardType);

		btn_account.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_account.setBounds(410, 379, 153, 43);
		panel_OpenAcc.add(btn_account);

		JLabel label_bg11 = new JLabel("");
		label_bg11.setBounds(0, -29, 1065, 502);
		label_bg11.setIcon(ico_background);
		panel_OpenAcc.add(label_bg11);

		JPanel panel_DelAcc = new JPanel();
		tabbedPane_Acc.addTab("����", null, panel_DelAcc, null);
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
		btn_delAcc.addActionListener(new Cancellation());
		btn_delAcc.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_delAcc.setBounds(458, 258, 84, 27);
		panel_DelAcc.add(btn_delAcc);

		JLabel label_bg12 = new JLabel("");
		label_bg12.setIcon(ico_background);
		label_bg12.setBounds(0, 0, 1052, 475);
		panel_DelAcc.add(label_bg12);

		JPanel panel_Loss = new JPanel();
		tabbedPane.addTab(null, ico_statusOprea, panel_Loss, "��ʧ���");
		panel_Loss.setLayout(null);

		JLabel label_2 = new JLabel("������Ҫ��ʧ���ҵĿ���");
		label_2.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_2.setBounds(35, 13, 290, 43);
		panel_Loss.add(label_2);

		textField_loss = new JTextField();
		textField_loss.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_loss.setBounds(290, 84, 444, 43);
		panel_Loss.add(textField_loss);

		btn_loss = new JButton("ȷ��");
		btn_loss.addActionListener(new LossOperation());
		btn_loss.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_loss.setBounds(470, 140, 90, 43);
		panel_Loss.add(btn_loss);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(14, 240, 1024, 2);
		panel_Loss.add(separator_2);

		JLabel label_5 = new JLabel("������Ҫ�����ⶳ�Ŀ���");
		label_5.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_5.setBounds(35, 255, 290, 43);
		panel_Loss.add(label_5);

		textField_lock = new JTextField();
		textField_lock.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_lock.setBounds(290, 338, 444, 43);
		panel_Loss.add(textField_lock);

		JButton btn_lock = new JButton("\u786E\u8BA4");
		btn_lock.addActionListener(new LockOperation());
		btn_lock.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_lock.setBounds(470, 394, 90, 43);
		panel_Loss.add(btn_lock);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(ico_background);
		label_1.setBounds(0, 0, 1065, 502);
		panel_Loss.add(label_1);

		JPanel panel_lock = new JPanel();
		tabbedPane.addTab(null, ico_query, panel_lock, "����ⶳ");
		panel_lock.setLayout(null);

		JLabel label_inputCardNumLock = new JLabel("�����뿨��");
		label_inputCardNumLock.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_inputCardNumLock.setBounds(35, 13, 171, 43);
		panel_lock.add(label_inputCardNumLock);
		separator_1.setBounds(14, 70, 1024, 2);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(14, 69, 1024, 2);
		panel_lock.add(separator_4);

		textField_queryBalance = new JTextField();
		textField_queryBalance.setFont(new Font("��Բ", Font.PLAIN, 24));
		textField_queryBalance.setBounds(290, 128, 444, 43);
		panel_lock.add(textField_queryBalance);
		textField_carNum.setColumns(10);

		JButton btn_queryBalance = new JButton("\u786E\u8BA4");
		btn_queryBalance.addActionListener(new QueryBalacne());
		btn_queryBalance.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_queryBalance.setBounds(483, 216, 90, 43);
		panel_lock.add(btn_queryBalance);

		JLabel label = new JLabel("");
		label.setIcon(ico_background);
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
		table.getTableHeader().setFont(new Font("��Բ", Font.BOLD, 18)); // ���ñ�ͷ����
		table.setFont(new Font("��Բ", Font.BOLD, 18)); // ���ñ������
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

		textField_query = new JTextField();
		textField_query.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		textField_query.setColumns(10);
		textField_query.setBounds(120, 32, 223, 36);
		panel_queryHistory.add(textField_query);

		JLabel label_6 = new JLabel("\u5361\u53F7");
		label_6.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_6.setBounds(68, 32, 47, 40);
		panel_queryHistory.add(label_6);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(ico_background);
		label_3.setBounds(0, 0, 1068, 504);
		panel_queryHistory.add(label_3);

		JPanel panel_changePasswd = new JPanel();
		tabbedPane.addTab(null, ico_changePasswd, panel_changePasswd, "�޸�����");
		panel_changePasswd.setLayout(null);

		JLabel lblTips = new JLabel("�����뿨��");
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
		label_4.setIcon(ico_background);
		label_4.setBounds(0, 0, 1068, 504);
		panel_changePasswd.add(label_4);
	}

	/**
	 * ��ȡ���ݿ⽻�׼�¼��������д��JTable�����
	 */
	public void WriteData(Long card, String[] date) {
		final String[] columnNames = { "�˺�", "����", "��������", "���׽��", "Ŀ���˻�", "������" };
		// �������ݿⷽ����ȡ��¼
		// function(BlankAccout.getInstance().getCardNum(),getDate(6));
		// �ⲿ�����ݴ����ݿ����ȡ
		String[][] rowData = BlankAccout.getInstance().getTradingrecDAO().getSpecifiedRecording(card, date);

		table.setModel(new DefaultTableModel(rowData, columnNames));
		// �������־���
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumn("�˺�").setCellRenderer(render);
		table.getColumn("����").setCellRenderer(render);
		table.getColumn("��������").setCellRenderer(render);
		table.getColumn("���׽��").setCellRenderer(render);
		table.getColumn("Ŀ���˻�").setCellRenderer(render);
		table.getColumn("������").setCellRenderer(render);
		// �����п�
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(180);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
	}

	/**
	 * ��ȡʼĩ���ڵİ�ť������
	 */
	class getDate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JDateChooser dateChoose = new JDateChooser();

			if (e.getSource() == btn_begin) {
				dateChoose.showDateChooser();
				date[0] = dateChoose.getDateFormat("yyyy-MM-dd");
				btn_begin.setText(date[0]);
			}
			if (e.getSource() == btn_end) {
				dateChoose.showDateChooser();
				date[1] = dateChoose.getDateFormat("yyyy-MM-dd");
				btn_end.setText(date[1]);
			}
			if (e.getSource() == btn_confirm) {
				if (date[0].isEmpty() || date[1].isEmpty()) {
					JOptionPane.showMessageDialog(null, "��ѡ������", "����", JOptionPane.ERROR_MESSAGE);
				} else if (textField_query.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�����뿨��", "����", JOptionPane.ERROR_MESSAGE);
				} else if (date[0].compareTo(date[1]) <= 0) {
					// TODO ��ȡ��¼��Ϣ��������Ϣ�����JTable��
					WriteData(Long.parseLong(textField_query.getText()), date);
				} else {
					JOptionPane.showMessageDialog(null, "��ѡ����ȷ����", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		public String SQLDate(String source) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try {
				date = simpleDateFormat.parse(source);
			} catch (Exception e) {
			}
			Calendar calendar = Calendar.getInstance(); // �õ�����
			calendar.add(Calendar.DATE, 1);
			date = calendar.getTime();

			return simpleDateFormat.format(date);

		}

	}

	// ¼���û���Ϣ�ļ�����
	class UserInformation implements ActionListener {
		/**
		 * ����ı���
		 */
		public void setTextNone() {
			textField_name.setText("");
			textField_idcard.setText("");
			textField_phone.setText("");
			textArea_address.setText("");
		}

		/**
		 * ���ɿ���
		 * 
		 * @return һ�� string ���͵Ŀ���
		 */
		public String generateCardNum() {
			// �� 621700 �Ĺ̶���ͷ��ʱ������ɿ���
			String cardNum = "621700" + String.valueOf(new Date().getTime()).substring(1);
			return cardNum;
		}

		public void actionPerformed(ActionEvent arg0) {
			// ȥ����Ϣͷβ�Ŀո�
			String name = textField_name.getText().trim();
			String sex = (String) comboBox.getSelectedItem();// �������ȡ�Ա�
			String phone = textField_phone.getText().trim();
			String idCard = textField_idcard.getText();
			String cardType = (String) comboBox_cardType.getSelectedItem();// �������ȡ����������
			String address = textArea_address.getText().trim();
			// ��ʼ������Ϣ���
			if (name.isEmpty() | phone.isEmpty() | address.isEmpty()) {
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
							// ���ɿ���
							String cardnum = generateCardNum();
							// ͸֧���Ĭ��Ϊ 0
							float overdraft = 0;
							System.out.println("������" + name + "\n�Ա�" + sex + "\n�ֻ��ţ�" + phone + "\n���֤�ţ�" + idCard
									+ "\n�˻����ͣ�" + cardType + "\n��ͥסַ��" + address);
							JOptionPane.showMessageDialog(null, "�����ɹ������Ŀ���Ϊ��\n" + cardnum, "��ϲ",
									JOptionPane.INFORMATION_MESSAGE);
							// ����û���Ϣ¼�����������ı�������
							setTextNone();
							// ����˺����������ÿ���͸֧�������Ϊ5000
							if (cardType == "���ÿ�") {
								overdraft = 5000;
							}
							// �������ݿⷽ���������û���Ϣ���� user �� account ���в���¼������
							BlankAccout.getInstance().getUserDao().insertUserInformation(name, sex, idCard, phone,
									address);
							BlankAccout.getInstance().getAccountDAO().setAccount(idCard, Long.parseLong(cardnum),
									Long.parseLong(password), "����", cardType, "��������", 0, overdraft, 0);
						} else {
							JOptionPane.showMessageDialog(null, "�������벻һ��", "����", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "������6λ����", "����", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "��ȡ���˲���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * �������ܼ�����
	 */
	class Cancellation implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO ������Ϣ���ڣ�����ť��Ϊ������Ȼ�������������ȷ�ϣ������û�״̬
			// ��ȡ����
			String cardNums = textField_carNum.getText().trim();
			long cardNum = Long.parseLong(cardNums);
			// �жϿ����Ƿ���ڣ�������ڽ�����һ�����������������ʾ
			if (BlankAccout.getInstance().getAccountDAO().getCardExit(cardNum)) {
				float balance = BlankAccout.getInstance().getAccountDAO().getCardBalance(cardNum);
				// ���ÿ������ͣ���������ÿ�������Ҫ����Ƿ���δ��͸֧��
				if (BlankAccout.getInstance().getAccountDAO().getCardType(cardNum).equals("���ÿ�")) {
					// ��ȡ�ÿ�������͸֧��
					float overdraft = BlankAccout.getInstance().getAccountDAO().getCardOverdraft(cardNum);
					if (balance + overdraft >= 5000) {
						// TODO ��ʾ�ͻ���Ϣ���ÿͻ�ȷ���Ƿ�Ҫ����
						JOptionPane.showMessageDialog(null, "������ÿ��Ѿ������ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "����δ�����͸֧���볥��֮���ٽ�������", "�ܾ�", JOptionPane.ERROR_MESSAGE);
					}
					// ����Ǵ����
				} else {
					// TODO ��ʾ�ͻ���Ϣ���ÿͻ�ȷ���Ƿ�Ҫ����
					JOptionPane.showMessageDialog(null, "��Ĵ���Ѿ������ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "����Ŀ��Ų�����", "����", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	// ��ʧ��Ҽ�����
	class LossOperation implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String cards = textField_loss.getText();
			Long card = Long.parseLong(cards);
			// �������ݿⷽ���жϿ����Ƿ����
			Boolean flag = BlankAccout.getInstance().getAccountDAO().getCardExit(card);
			if (flag) {
				// �������ݿⷽ����ȡ�˻�״̬
				String cardStatus = BlankAccout.getInstance().getAccountDAO().getCardStatu(card);
				// 1.�����ʧ�ˣ��������Ƿ�Ҫ���
				if (cardStatus.equals("��ʧ")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("���");
					String[] info = new String[7];//��ȡ�û���Ϣ
					String[] info_Data = {"����","���ÿ�","��","��ʧ","440823199602133837","13724867853","�㶫ʡ�����к�������ͷ·21��"};
 					info = info_Data;
 					jSM.addComponentData(info);
					//info = BlankAccout.getInstance().getUserDao().getUserInformation(idCard) 
					if (jSM.showJSM()) { // ѡ���Ҳ�����������֤����
						long input_password = Long.parseLong(JOptionPane.showInputDialog(null, "����������", "��ʾ",
								JOptionPane.INFORMATION_MESSAGE));
						// �������ݿⷽ�����жϿ����Ƿ��Ӧ����
						if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, input_password)) {
							//TODO D�������ݿⷽ�������˻�״̬Ϊ����
							JOptionPane.showMessageDialog(null, "��ҳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
							// ��տ��������
							textField_loss.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
						}
					}

				}

				// 2.����˻�������ѯ���Ƿ�Ҫ��ʧ
				else if (cardStatus.equals("����")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("��ʧ");
					String[] info = new String[7];//��ȡ�û���Ϣ
					String[] info_Data = {"����","���ÿ�","��","����","440823199602133837","13724867853","�㶫ʡ�����к�������ͷ·21��"};
 					info = info_Data;
 					jSM.addComponentData(info);
					if (jSM.showJSM()) { // ѡ���ʧ������������֤����
						long input_password = Long.parseLong(JOptionPane.showInputDialog(null, "����������", "��ʾ",
								JOptionPane.INFORMATION_MESSAGE));
						// �������ݿⷽ������ȡ���Ŷ�Ӧ���룬����Ϊ123
						if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, input_password)) {
							//TODO D�������ݿⷽ�������˻�״̬Ϊ��ʧ
							JOptionPane.showMessageDialog(null, "��ʧ�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
							// ��տ��������
							textField_loss.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "���˻�������", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// ����ⶳ������
	class LockOperation implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String cards = textField_lock.getText();
			Long card = Long.parseLong(cards);
			// �������ݿⷽ���жϿ����Ƿ����
			Boolean flag = BlankAccout.getInstance().getAccountDAO().getCardExit(card);;
			if (flag) {
				// �������ݿⷽ����ȡ�˻�״̬
				String cardStatus = BlankAccout.getInstance().getAccountDAO().getCardStatu(card);
				// 1.��������ˣ��������Ƿ�Ҫ�ⶳ
				if (cardStatus.equals("����")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("�ⶳ");
					String[] info = new String[7];//��ȡ�û���Ϣ
					//�����ݿ��ȡ�û���Ϣ
					String[] info_Data = {"����","���ÿ�","��","����","440823199602133837","13724867853","�㶫ʡ�����к�������ͷ·21��"};
 					info = info_Data;
 					jSM.addComponentData(info);
					if (jSM.showJSM()) { // ѡ��ⶳ������������֤����
						long input_password = Long.parseLong(JOptionPane.showInputDialog(null, "����������", "��ʾ",
								JOptionPane.INFORMATION_MESSAGE));
						// �������ݿⷽ������ȡ���Ŷ�Ӧ���룬����Ϊ123
						if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, input_password)) {
							// �������ݿⷽ�������˻�״̬Ϊ����
							JOptionPane.showMessageDialog(null, "�ⶳ�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
							// ��տ��������
							textField_queryBalance.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				// 2.����˻�������ѯ���Ƿ�Ҫ����
				else if (cardStatus.equals("����")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("����");
					String[] info = new String[7];//��ȡ�û���Ϣ
					String[] info_Data = {"����","���ÿ�","��","����","440823199602133837","13724867853","�㶫ʡ�����к�������ͷ·21��"};
 					info = info_Data;
 					jSM.addComponentData(info);
					if (jSM.showJSM()) { // ѡ�񶳽������������֤����
						long input_password = Long.parseLong(JOptionPane.showInputDialog(null, "����������", "��ʾ",
								JOptionPane.INFORMATION_MESSAGE));
						// �������ݿⷽ������ȡ���Ŷ�Ӧ���룬����Ϊ123
						if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, input_password)) {
							// �������ݿⷽ�������˻�״̬Ϊ����
							JOptionPane.showMessageDialog(null, "����ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
							// ��տ��������
							textField_loss.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "���˻�������", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// ��ѯ�û���������
	class QueryBalacne implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textField_queryBalance.setText("656885452136697452");
			String cards = textField_queryBalance.getText().trim();
			Long card = Long.parseLong(cards);
			// �жϿ����Ƿ����
			Boolean flag = BlankAccout.getInstance().getAccountDAO().getCardExit(card);
			if (flag) {
				// �û���������
				String input_password = JOptionPane.showInputDialog(null, "����������", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
				Long password = -0L;
				try {
					password = Long.parseLong(input_password);
				} catch (Exception e1) {
				} finally {
					if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, password)) {
						// �������ݿⷽ������ȡ�ÿ��������Ϣ
						JOptionPane.showMessageDialog(null, showMessage(card), "�˻������Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
					} else
						JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "�˺Ų�����", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public String showMessage(Long card) {
		float balance = BlankAccout.getInstance().getAccountDAO().getCardBalance(card);
		float overdraft = BlankAccout.getInstance().getAccountDAO().getCardOverdraft(card);
		float withdrawalsLimit = BlankAccout.getInstance().getTradingrecDAO().getWithdrawalsLimit(card);
		float depositLimit = BlankAccout.getInstance().getTradingrecDAO().getDepositLimit(card);

		String messages = "<html><p align=\"left\">�������Ϊ��{0}Ԫ<br>����͸֧���Ϊ��{1}Ԫ<br>�����մ���޶ʣ��{2}Ԫ<br>������ȡ���޶ʣ��{3}Ԫ</p></html>";// ��ʾ��Ϣ��Ҫ�޸�
		messages = messages.replace("{0}", String.valueOf(balance));// message[0-3]���������money��
		messages = messages.replace("{1}", String.valueOf(overdraft));
		messages = messages.replace("{2}", String.valueOf(depositLimit));
		messages = messages.replace("{3}", String.valueOf(withdrawalsLimit));

		return messages;
	}

}
