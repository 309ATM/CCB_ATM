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
import javax.swing.JPasswordField;
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
import org.junit.Test;

/**
 * ����Ա����
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
@SuppressWarnings("rawtypes")
public class AdminUI {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_idcard;
	private JTextField textField_delAccount;
	private JTextField textField_phone;
	private JTextField textField_queryBalance;
	private JTextField textField_loss;
	private JTextField textField_chaUserPass;
	private JTextArea textArea_address;
	private JTextField textField_query;
	private JTextField textField_changeInfo;
	private JTextField textField_queryInfo;
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
	private JTextField textField_chaAdminPass;
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
	 * ΪFrame��ӿؼ�����ʵ��������
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
		panel_DelAcc.setLayout(null);

		JLabel label_inputCardNum = new JLabel("�����뿨��");
		label_inputCardNum.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_inputCardNum.setBounds(45, 13, 171, 43);
		panel_DelAcc.add(label_inputCardNum);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(14, 70, 1024, 2);
		panel_DelAcc.add(separator_1);

		textField_delAccount = new JTextField();
		textField_delAccount.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_delAccount.setBounds(285, 155, 444, 43);
		panel_DelAcc.add(textField_delAccount);
		textField_delAccount.setColumns(10);

		JButton btn_delAcc = new JButton("����");
		btn_delAcc.addActionListener(new Cancellation());
		btn_delAcc.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_delAcc.setBounds(458, 258, 84, 27);
		panel_DelAcc.add(btn_delAcc);

		JLabel label_bg12 = new JLabel("");
		label_bg12.setIcon(ico_background);
		label_bg12.setBounds(0, -29, 1065, 502);
		panel_DelAcc.add(label_bg12);

		// ��ѯ�û���Ϣ����
		JPanel panel_queryInfo = new JPanel();
		tabbedPane_Acc.addTab("��ѯ��Ϣ", null, panel_queryInfo, null);
		panel_queryInfo.setLayout(null);

		JLabel lblTips1 = new JLabel("���������֤��");
		lblTips1.setFont(new Font("��Բ", Font.PLAIN, 18));
		lblTips1.setBounds(45, 13, 171, 43);
		panel_queryInfo.add(lblTips1);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(14, 70, 1024, 2);
		panel_queryInfo.add(separator_6);

		textField_queryInfo = new JTextField();
		textField_queryInfo.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_queryInfo.setBounds(285, 155, 444, 43);
		panel_queryInfo.add(textField_queryInfo);

		JButton btn_query = new JButton("\u786E\u8BA4");
		btn_query.addActionListener(new queryUserInfo());
		btn_query.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_query.setBounds(458, 258, 69, 29);
		panel_queryInfo.add(btn_query);

		JLabel label_14 = new JLabel("");
		label_14.setIcon(ico_background);
		label_14.setBounds(0, -29, 1065, 502);
		panel_queryInfo.add(label_14);

		// �޸��û���Ϣ����
		JPanel panel_changeInfo = new JPanel();
		tabbedPane_Acc.addTab("�޸���Ϣ", null, panel_changeInfo, null);
		panel_OpenAcc.setLayout(null);
		panel_changeInfo.setLayout(null);

		JLabel lblTips2 = new JLabel("���������֤��");
		lblTips2.setFont(new Font("��Բ", Font.PLAIN, 18));
		lblTips2.setBounds(45, 13, 171, 43);
		panel_changeInfo.add(lblTips2);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(14, 70, 1024, 2);
		panel_changeInfo.add(separator_7);

		textField_changeInfo = new JTextField();
		textField_changeInfo.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_changeInfo.setBounds(285, 155, 444, 43);
		panel_changeInfo.add(textField_changeInfo);

		JButton btn_change = new JButton("ȷ��");
		btn_change.addActionListener(new changeUserInfo());
		btn_change.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_change.setBounds(458, 258, 69, 29);
		panel_changeInfo.add(btn_change);

		JLabel label_13 = new JLabel("");
		label_13.setIcon(ico_background);
		label_13.setBounds(0, -29, 1065, 502);
		panel_changeInfo.add(label_13);

		// ״̬��������
		JPanel panel_statusOpera = new JPanel();
		tabbedPane.addTab(null, ico_statusOprea, panel_statusOpera, "��ʧ���");
		panel_statusOpera.setLayout(null);

		JLabel label_2 = new JLabel("������Ҫ��ʧ���ҵĿ���");
		label_2.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_2.setBounds(35, 13, 290, 43);
		panel_statusOpera.add(label_2);

		textField_loss = new JTextField();
		textField_loss.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_loss.setBounds(290, 84, 444, 43);
		panel_statusOpera.add(textField_loss);

		btn_loss = new JButton("ȷ��");
		btn_loss.addActionListener(new LossOperation());
		btn_loss.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_loss.setBounds(470, 140, 90, 43);
		panel_statusOpera.add(btn_loss);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(14, 240, 1024, 2);
		panel_statusOpera.add(separator_2);

		JLabel label_5 = new JLabel("������Ҫ�����ⶳ�Ŀ���");
		label_5.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_5.setBounds(35, 255, 290, 43);
		panel_statusOpera.add(label_5);

		textField_lock = new JTextField();
		textField_lock.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_lock.setBounds(290, 338, 444, 43);
		panel_statusOpera.add(textField_lock);

		JButton btn_lock = new JButton("\u786E\u8BA4");
		btn_lock.addActionListener(new LockOperation());
		btn_lock.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_lock.setBounds(470, 394, 90, 43);
		panel_statusOpera.add(btn_lock);

		JLabel label_bg2 = new JLabel("");
		label_bg2.setIcon(ico_background);
		label_bg2.setBounds(0, 0, 1065, 502);
		panel_statusOpera.add(label_bg2);
		panel_OpenAcc.setLayout(null);

		// ��ѯ������
		JPanel panel_queryBalance = new JPanel();
		tabbedPane.addTab(null, ico_query, panel_queryBalance, null);
		panel_queryBalance.setLayout(null);

		JLabel label_inputCardNumLock = new JLabel("�����뿨��");
		label_inputCardNumLock.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_inputCardNumLock.setBounds(35, 13, 171, 43);
		panel_queryBalance.add(label_inputCardNumLock);
		separator_1.setBounds(14, 70, 1024, 2);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(14, 69, 1024, 2);
		panel_queryBalance.add(separator_4);

		textField_queryBalance = new JTextField();
		textField_queryBalance.setFont(new Font("��Բ", Font.PLAIN, 24));
		textField_queryBalance.setBounds(290, 128, 444, 43);
		panel_queryBalance.add(textField_queryBalance);
		textField_delAccount.setColumns(10);

		JButton btn_queryBalance = new JButton("\u786E\u8BA4");
		btn_queryBalance.addActionListener(new QueryBalacne());
		btn_queryBalance.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_queryBalance.setBounds(483, 216, 90, 43);
		panel_queryBalance.add(btn_queryBalance);

		JLabel label_bg3 = new JLabel("");
		label_bg3.setIcon(ico_background);
		label_bg3.setBounds(0, 0, 1065, 502);
		panel_queryBalance.add(label_bg3);

		// ��ѯ������ʷ��¼����
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

		JLabel label_bg4 = new JLabel("");
		label_bg4.setIcon(ico_background);
		label_bg4.setBounds(0, 0, 1068, 504);
		panel_queryHistory.add(label_bg4);

		// �޸��������
		JPanel panel_changePasswd = new JPanel();
		tabbedPane.addTab(null, ico_changePasswd, panel_changePasswd, "�޸�����");
		panel_changePasswd.setLayout(null);

		JTabbedPane tabbedPane_changePass = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_changePass.setBounds(0, 0, 1066, 505);
		panel_changePasswd.add(tabbedPane_changePass);

		// �û����ܽ���
		JPanel panel_chaUserPass = new JPanel();
		tabbedPane_changePass.addTab("�Ñ�", null, panel_chaUserPass, null);
		panel_chaUserPass.setLayout(null);

		JLabel lblTips3 = new JLabel("�����뿨��");
		lblTips3.setFont(new Font("��Բ", Font.PLAIN, 18));
		lblTips3.setBounds(45, 13, 171, 43);
		panel_chaUserPass.add(lblTips3);

		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(14, 70, 1024, 2);
		panel_chaUserPass.add(separator_8);

		textField_chaUserPass = new JTextField();
		textField_chaUserPass.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_chaUserPass.setBounds(285, 155, 444, 43);
		panel_chaUserPass.add(textField_chaUserPass);

		JButton btn_chaUserPass = new JButton("\u786E\u8BA4");
		btn_chaUserPass.addActionListener(new changeUserPasswd());
		btn_chaUserPass.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_chaUserPass.setBounds(458, 258, 69, 29);
		panel_chaUserPass.add(btn_chaUserPass);

		JLabel label_41 = new JLabel("");
		label_41.setIcon(ico_background);
		label_41.setBounds(0, -29, 1065, 502);
		panel_chaUserPass.add(label_41);

		// ����Ա���ܽ���
		JPanel panel_chaAdminPass = new JPanel();
		tabbedPane_changePass.addTab("����Ա", null, panel_chaAdminPass, null);
		panel_chaAdminPass.setLayout(null);

		JLabel lblTips4 = new JLabel("���������Ա�˺�");
		lblTips4.setFont(new Font("��Բ", Font.PLAIN, 18));
		lblTips4.setBounds(45, 13, 171, 43);
		panel_chaAdminPass.add(lblTips4);

		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(14, 70, 1024, 2);
		panel_chaAdminPass.add(separator_9);

		textField_chaAdminPass = new JTextField();
		textField_chaAdminPass.setFont(new Font("��Բ", Font.PLAIN, 18));
		textField_chaAdminPass.setBounds(285, 155, 444, 43);
		panel_chaAdminPass.add(textField_chaAdminPass);

		JButton btn_chaAdminPass = new JButton("ȷ��");
		btn_chaAdminPass.addActionListener(new changeAdminPasswd());
		btn_chaAdminPass.setFont(new Font("��Բ", Font.PLAIN, 18));
		btn_chaAdminPass.setBounds(458, 258, 69, 29);
		panel_chaAdminPass.add(btn_chaAdminPass);

		JLabel label_42 = new JLabel("");
		label_42.setIcon(ico_background);
		label_42.setBounds(0, -29, 1065, 502);
		panel_chaAdminPass.add(label_42);

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
			// ��ȡ����
			String cardNums = textField_delAccount.getText().trim();
			long cardNum = Long.parseLong(cardNums);
			// �жϿ����Ƿ���ڣ�������ڽ�����һ�����������������ʾ
			if (BlankAccout.getInstance().getAccountDAO().getCardExit(cardNum)) {
				// ����ÿ����ڽ������У�����������������ʾ
				if (BlankAccout.getInstance().getAccountDAO().getBanks(cardNum)) {
					float balance = BlankAccout.getInstance().getAccountDAO().getCardBalance(cardNum);
					// ���ÿ������ͣ���������ÿ�������Ҫ����Ƿ���δ��͸֧��
					if (BlankAccout.getInstance().getAccountDAO().getCardType(cardNum).equals("���ÿ�")) {
						// ��ȡ�ÿ�������͸֧��
						float overdraft = BlankAccout.getInstance().getAccountDAO().getCardOverdraft(cardNum);
						if (balance + overdraft >= 5000) {
							// ������������
							accountCancellation(cardNum);
						} else {
							JOptionPane.showMessageDialog(null, "����δ�����͸֧���볥��֮���ٽ�������", "�ܾ�", JOptionPane.ERROR_MESSAGE);
						}
						// ����Ǵ��
					} else {
						// TODO ��ʾ�ͻ���Ϣ���ÿͻ�ȷ���Ƿ�Ҫ����
						accountCancellation(cardNum);
					}
				} else {
					JOptionPane.showMessageDialog(null, "�ÿ������ڽ�������", "����", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "����Ŀ��Ų�����", "����", JOptionPane.ERROR_MESSAGE);
			}

		}

		/**
		 * ����������п����м�����������
		 * 
		 * @param cardNum
		 */
		private void accountCancellation(long cardNum) {
			if (BlankAccout.getInstance().getAccountDAO().getCardStatu(cardNum).equals("����")) {
				JShowInfo jSM = new JShowInfo();
				jSM.setBtnText("����");
				String[] info = new String[7];// ��ȡ�û���Ϣ
				String[] info_Data = { "����", "���ÿ�", "��", "����", "440823199602133837", "13724867853", "�㶫ʡ�����к�������ͷ·21��" };
				info = info_Data;
				jSM.StatusOpera(info);
				// ѡ������������������֤����
				if (jSM.showJSM()) {
					Long[] result = showPasswordDialog("����������:");
					// �������ݿⷽ�����жϿ����Ƿ��Ӧ����
					if (result[0] == 0) {
						if (BlankAccout.getInstance().getAccountDAO().checkPawd(cardNum, result[1])) {
							// �������ݿⷽ�������˻�״̬Ϊ����
							JOptionPane.showMessageDialog(null, "�����ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
							BlankAccout.getInstance().getAccountDAO().updateStatus(cardNum, "����");
							// ��տ��������
							textField_delAccount.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "���Ŀ�״̬���������ܾ�����", "�ܾ�", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	/**
	 * ��ѯ�û���Ϣ���� �İ�ť�¼�������
	 * 
	 * @author Jachin
	 *
	 */
	class queryUserInfo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// ��ȡ��������֤��
			String idCard = textField_queryInfo.getText();// 440981199611046654
			if (!idCard.isEmpty()) {// ���벻Ϊ��
				// �ж����֤���Ƿ����
				try {
					// �������ݿⷽ�����������֤��ѯ�û���Ϣ
					String[] info = BlankAccout.getInstance().getUserDao().getUserInformation(idCard);
					// ��ʾ�û���Ϣ
					JShowInfo jSM = new JShowInfo();
					jSM.QueryUserInfo(info);
					jSM.showJSM();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "�û�������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		}

	}

	/** �û��޸���Ϣ���ܰ�ť�¼�������
	 * @author Jachin
	 *
	 */
	class changeUserInfo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// ��ȡ��������֤��
			String idCard = textField_changeInfo.getText();// 440981199611046654
			if (!idCard.isEmpty()) {// ���벻Ϊ��
				// �ж����֤���Ƿ����
				try {
					// �������ݿⷽ�����������֤��ѯ�û���Ϣ
					String[] info = BlankAccout.getInstance().getUserDao().getUserInformation(idCard);
					// ��ʾ�û���Ϣ
					JShowInfo jSM = new JShowInfo();
					jSM.ChangeUserInfo(info);
					//�û��޸���Ϣ������ȷ����
					if(jSM.showJSM()){
						//��������Ϣ�ĺϷ������ж�
						jSM.ConfirmChange();
						//TODO �����������룬�û�û�����룬����ʹ�ö��Ŷ�̬������֤
						//�������ݿ��޸���Ϣ�ķ��������µ�����д�����ݿ�
						try{
							String[] info2 = jSM.info;
							info2[0] = info[2];
							BlankAccout.getInstance().getUserDao().updateUserInformation(info2);
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
						}catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "�޸�ʧ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "�û�������", "��ʾ", JOptionPane.ERROR_MESSAGE);
				}
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
					String[] info = new String[7];// ��ȡ�û���Ϣ
					// String[] info_Data = { "����", "���ÿ�", "��", "��ʧ",
					// "440823199602133837", "13724867853",
					// "�㶫ʡ�����к�������ͷ·21��" };
					// info = info_Data;
					info = BlankAccout.getInstance().getConnectTable().getUserMessage(card);
					jSM.StatusOpera(info);
					if (jSM.showJSM()) { // ѡ���Ҳ�����������֤����
						Long[] result = showPasswordDialog("����������:");
						// �������ݿⷽ�����жϿ����Ƿ��Ӧ����
						if (result[0] == 0) {
							if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
								// �������ݿⷽ�������˻�״̬Ϊ����
								JOptionPane.showMessageDialog(null, "��ҳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
								BlankAccout.getInstance().getAccountDAO().updateStatus(card, "����");
								// ��տ��������
								textField_loss.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				}

				// 2.����˻�������ѯ���Ƿ�Ҫ��ʧ
				else if (cardStatus.equals("����")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("��ʧ");
					String[] info = new String[7];// ��ȡ�û���Ϣ
					// String[] info_Data = { "����", "���ÿ�", "��", "����",
					// "440823199602133837", "13724867853",
					// "�㶫ʡ�����к�������ͷ·21��" };
					// info = info_Data;
					info = BlankAccout.getInstance().getConnectTable().getUserMessage(card);
					jSM.StatusOpera(info);
					if (jSM.showJSM()) { // ѡ���ʧ������������֤����
						Long[] result = showPasswordDialog("����������:");
						// �������ݿⷽ�����жϿ����Ƿ��Ӧ����
						if (result[0] == 0) {
							if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
								// �������ݿⷽ�������˻�״̬Ϊ��ʧ
								JOptionPane.showMessageDialog(null, "��ʧ�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
								BlankAccout.getInstance().getAccountDAO().updateStatus(card, "��ʧ");
								// ��տ��������
								textField_loss.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
				// 3.����˻����ᣬ��ʾ�û����ܲ���
				else if (cardStatus.equals("����")) {
					JOptionPane.showMessageDialog(null, "���Ŀ��Ѷ��ᣬ���Ƚⶳ", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "���˻�������", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * �û�����ⶳ���ܼ�����
	 * 
	 * @author Jachin
	 *
	 */
	class LockOperation implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String cards = textField_lock.getText();
			Long card = Long.parseLong(cards);
			// �������ݿⷽ���жϿ����Ƿ����
			Boolean flag = BlankAccout.getInstance().getAccountDAO().getCardExit(card);
			if (flag) {
				// �������ݿⷽ����ȡ�˻�״̬
				String cardStatus = BlankAccout.getInstance().getAccountDAO().getCardStatu(card);
				// 1.��������ˣ��������Ƿ�Ҫ�ⶳ
				if (cardStatus.equals("����")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("�ⶳ");
					String[] info = new String[7];// ��ȡ�û���Ϣ
					// TODO �����ݿ��ȡ�û���Ϣ
					// String[] info_Data = { "����", "���ÿ�", "��", "����",
					// "440823199602133837", "13724867853",
					// "�㶫ʡ�����к�������ͷ·21��" };
					// info = info_Data;
					info = BlankAccout.getInstance().getConnectTable().getUserMessage(card);
					jSM.StatusOpera(info);
					if (jSM.showJSM()) { // ѡ��ⶳ������������֤����
						Long[] result = showPasswordDialog("����������:");
						// �������ݿⷽ�����жϿ����Ƿ��Ӧ����
						if (result[0] == 0) {
							if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
								// �������ݿⷽ�������˻�״̬Ϊ����
								JOptionPane.showMessageDialog(null, "�ⶳ�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
								BlankAccout.getInstance().getAccountDAO().updateStatus(card, "����");
								// ��տ��������
								textField_queryBalance.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}

				// 2.����˻�������ѯ���Ƿ�Ҫ����
				else if (cardStatus.equals("����")) {
					JShowInfo jSM = new JShowInfo();
					jSM.setBtnText("����");
					String[] info = new String[7];// ��ȡ�û���Ϣ
					// String[] info_Data = { "����", "���ÿ�", "��", "����",
					// "440823199602133837", "13724867853",
					// "�㶫ʡ�����к�������ͷ·21��" };
					// info = info_Data;
					info = BlankAccout.getInstance().getConnectTable().getUserMessage(card);
					jSM.StatusOpera(info);
					if (jSM.showJSM()) { // ѡ�񶳽������������֤����
						Long[] result = showPasswordDialog("����������:");
						// �������ݿⷽ�����жϿ����Ƿ��Ӧ����
						if (result[0] == 0) {
							if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
								// �������ݿⷽ�������˻�״̬Ϊ����
								JOptionPane.showMessageDialog(null, "����ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
								BlankAccout.getInstance().getAccountDAO().updateStatus(card, "����");
								// ��տ��������
								textField_loss.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
				// 3.����˻���ʧ����ʾ�û����ܲ���
				else if (cardStatus.equals("��ʧ")) {
					JOptionPane.showMessageDialog(null, "���Ŀ��ѹ�ʧ�����Ƚ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "���˻�������", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * �û���ѯ���ܵļ�����
	 * 
	 * @author Jachin
	 *
	 */
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
				Long[] result = showPasswordDialog("����������:");
				if (result[0] == 0) {

					if (BlankAccout.getInstance().getAccountDAO().checkPawd(card, result[1])) {
						// �������ݿⷽ������ȡ�ÿ��������Ϣ
						JOptionPane.showMessageDialog(null, showMessage(card), "�˻������Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
						textField_queryBalance.setText("");
					} else
						JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "�˺Ų�����", "����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * �û��޸����������
	 * 
	 * @author SAM
	 *
	 */
	class changeUserPasswd implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String card = textField_chaUserPass.getText().trim();
			Long cardNum = 0L;
			boolean flagF = true;
			try {
				cardNum = Long.parseLong(card);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��������ȷ�˺�", "ȷ��", JOptionPane.ERROR_MESSAGE);
				flagF = false;
			}
			// �жϿ����Ƿ����
			if (flagF) {
				Boolean flag = BlankAccout.getInstance().getAccountDAO().getCardExit(cardNum);
				if (flag) {
					// �û����������
					Long[] result = showPasswordDialog("�����������:");
					if (result[0] == 0) {
						// ���ݿ�Ա�����
						long OldPasswd = result[1];
						if (BlankAccout.getInstance().getAccountDAO().checkPawd(cardNum, OldPasswd)) {
							// �û�����������
							Long[] result2 = showPasswordDialog("������������");
							long NewPasswd = result2[1];
							// ���ݿ��޸�����
							if (result2[0] == 0) {
								// ȷ��������
								Long[] result3 = showPasswordDialog("ȷ��������");
								if (result3[0] == 0) {
									if (result3[1] == NewPasswd) {
										BlankAccout.getInstance().getAccountDAO().updatePasswd(cardNum, OldPasswd,
												NewPasswd);
										JOptionPane.showMessageDialog(null, "�����޸ĳɹ�", "ȷ��",
												JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(null, "�����������벻һ��", "����",
												JOptionPane.ERROR_MESSAGE);
									} // if6
								} // else{}//if5

							} // else{}//if4
						} else {
							JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
						} // if3
					} // else{}//if2
				} else {
					JOptionPane.showMessageDialog(null, "�˺Ų�����", "����", JOptionPane.ERROR_MESSAGE);
				} // if1
			}
		}
	}

	/**
	 * ����Ա�޸����빦��
	 * 
	 * @author SAM
	 *
	 */
	class changeAdminPasswd implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String AccountId = "";
			boolean flagF = true;
			try {
				AccountId = textField_chaAdminPass.getText().trim();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��������ȷ����", "ȷ��", JOptionPane.ERROR_MESSAGE);
				flagF = false;
			}
			// �жϹ���Ա�˺��Ƿ����
			if (flagF) {
				Boolean flag = BlankAccout.getInstance().getAdminDAO().getAccountExit(AccountId);
				if (flag) {
					// �û����������
					Long[] result = showPasswordDialog("�����������:");
					if (result[0] == 0) {
						// ���ݿ�Ա�����
						String OldPasswd = String.valueOf(result[1]);
						if (BlankAccout.getInstance().getAdminDAO().cheeckAdmin(AccountId, OldPasswd)) {
							// ����Ա����������
							Long[] result2 = showPasswordDialog("������������");
							String NewPasswd = String.valueOf(result2[1]);
							// ���ݿ��޸�����
							if (result2[0] == 0) {
								// ȷ��������
								Long[] result3 = showPasswordDialog("ȷ��������");
								String NewPasswdDemo = String.valueOf(result3[1]);
								if (result3[0] == 0) {
									if (NewPasswdDemo.equals(NewPasswd)) {
										// �������ݿⷽ���޸Ĺ���Ա����
										BlankAccout.getInstance().getAdminDAO().updateAccountPasswd(AccountId,
												OldPasswd, NewPasswd);
										JOptionPane.showMessageDialog(null, "�����޸ĳɹ�", "ȷ��",
												JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(null, "�����������벻һ��", "����",
												JOptionPane.ERROR_MESSAGE);
									} // if6
								} // else{}//if5
							} // else{}//if4
						} else {
							JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
						} // if3
					} // else{}//if2
				} else {
					JOptionPane.showMessageDialog(null, "�˺Ų�����", "����", JOptionPane.ERROR_MESSAGE);
				} // if1
			}
		}
	}

	/**
	 * ����������棬������ʾΪԲ��
	 * 
	 * @return Long[] reslut,��һ���� �ж��û��Ƿ���ȡ��(����2)���ڶ������û����������
	 */
	public Long[] showPasswordDialog(String text) {
		JPasswordField pwd = new JPasswordField();
		Object[] message = { text, pwd };
		int res = JOptionPane.showConfirmDialog(null, message, "����������:", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		Long password = -0L;
		try {
			password = Long.valueOf(new String(pwd.getPassword()));
		} catch (Exception e1) {
		}
		Long[] result = { (long) res, password };
		return result;
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
