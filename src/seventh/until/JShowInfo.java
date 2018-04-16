package seventh.until;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 * ����ѡ�����ؼ�
 * 
 * @author jachin
 * 
 */
@SuppressWarnings("serial")
public final class JShowInfo extends JDialog {
	
	public JFrame frame;
	private JTextField text_name;
	private JTextField text_sex;
	private JTextField text_idcard;
	private JTextField text_phone;
	private JTextField text_status;
	private JTextField text_type;
	private JButton btn_cancel;
	private JTextArea text_address;
	private JTextArea text_address_1;
	private JButton btn_confirm;
	private JLabel label_name;
	private JLabel label_type;
	private JLabel label_sex;
	private JLabel label_Status;
	private JLabel label_idcard;
	private JLabel label_phone;
	private JLabel label_address1;
	private JLabel label_bg; 

	public boolean isConfirm;	//�ж��û�����ȡ����ť����ȷ����ť

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		JShowInfo gg = new JShowInfo();
		gg.showJSM();
	}

	/**
	 * ��ʾ�Ի���
	 */
	public boolean showJSM() {
		setVisible(true);
		return isConfirm;
	}

	/**
	 * �رնԻ���
	 */
	public void closeJSM() {
		this.dispose();
	}

	public void setBtnText(String text){
		btn_confirm.setText(text);
	}

	/**
	 * ���췽��
	 */
	public JShowInfo() {
		initComponent();
		addComponent();
		addListener();
		setDialogAttribute();
	}

	/**
	 * ʵ�������
	 */
	private void initComponent() {
		btn_confirm = new JButton();
		btn_cancel = new JButton();
		text_name = new JTextField();
		text_type = new JTextField();
		text_sex = new JTextField();
		text_status = new JTextField();
		text_idcard = new JTextField();
		text_phone = new JTextField();
		text_address = new JTextArea();
		label_name = new JLabel("����");
		label_name.setFont(new Font("��Բ", Font.PLAIN, 20));
		label_name.setBounds(100, 173, 81, 30);
		
		label_type = new JLabel("�˻�����");
		label_type.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_type.setBounds(372, 174, 79, 30);
		
		label_sex = new JLabel("�Ա�");
		label_sex.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_sex.setBounds(100, 241, 81, 30);
		
		label_Status = new JLabel("�˻�״̬");
		label_Status.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_Status.setBounds(372, 241, 79, 30);
		
		label_idcard = new JLabel("���֤��");
		label_idcard.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_idcard.setBounds(100, 304, 81, 30);
		
		label_phone = new JLabel("�ֻ�����");
		label_phone.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_phone.setBounds(100, 367, 81, 30);
		
		label_address1 = new JLabel("��ͥסַ");
		label_address1.setFont(new Font("��Բ", Font.PLAIN, 18));
		label_address1.setBounds(100, 434, 81, 30);
		
		text_name = new JTextField();
		text_name.setBackground(Color.WHITE);
		text_name.setEditable(false);
		text_name.setFont(new Font("��Բ", Font.PLAIN, 20));
		text_name.setBounds(185, 174, 140, 30);
		text_name.setColumns(10);
		
		text_type = new JTextField();
		text_type.setBackground(Color.WHITE);
		text_type.setEditable(false);
		text_type.setFont(new Font("��Բ", Font.PLAIN, 20));
		text_type.setColumns(10);
		text_type.setBounds(465, 174, 140, 30);
		
		text_sex = new JTextField();
		text_sex.setBackground(Color.WHITE);
		text_sex.setEditable(false);
		text_sex.setFont(new Font("��Բ", Font.PLAIN, 20));
		text_sex.setColumns(10);
		text_sex.setBounds(185, 241, 140, 30);
		
		text_status = new JTextField();
		text_status.setBackground(Color.WHITE);
		text_status.setEditable(false);
		text_status.setFont(new Font("��Բ", Font.PLAIN, 20));
		text_status.setColumns(10);
		text_status.setBounds(465, 241, 140, 30);
		
		text_idcard = new JTextField();
		text_idcard.setBackground(Color.WHITE);
		text_idcard.setEditable(false);
		text_idcard.setFont(new Font("��Բ", Font.PLAIN, 20));
		text_idcard.setColumns(10);
		text_idcard.setBounds(185, 304, 420, 30);
		
		text_phone = new JTextField();
		text_phone.setBackground(Color.WHITE);
		text_phone.setEditable(false);
		text_phone.setFont(new Font("��Բ", Font.PLAIN, 20));
		text_phone.setColumns(10);
		text_phone.setBounds(185, 367, 413, 30);
		
		text_address_1 = new JTextArea();
		text_address_1.setFont(new Font("��Բ", Font.PLAIN, 20));
		text_address_1.setEditable(false);
		text_address_1.setBackground(Color.WHITE);
		text_address_1.setLineWrap(true);
		text_address_1.setBounds(185, 434, 413, 64);
		text_address_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		btn_confirm = new JButton("ȷ��");
		btn_confirm.setBounds(212, 527, 113, 42);
		
		btn_cancel = new JButton("ȡ��");
		btn_cancel.setBounds(372, 527, 113, 42);
		
		label_bg = new JLabel("");
		label_bg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\UserInformation.png"));
		label_bg.setBounds(0, 0, 707, 603);
	}

	/**
	 * ������
	 */
	private void addComponent() {
		// ��ӱ������
		JPanel north = new JPanel();
		north.setLayout(null);
		north.add(label_address1);
		north.add(label_idcard);
		north.add(label_name);
		north.add(label_phone);
		north.add(label_sex);
		north.add(label_Status);
		north.add(label_type);
		

		north.add(text_address_1);
		north.add(text_idcard);
		north.add(text_name);
		north.add(text_phone);
		north.add(text_sex);
		north.add(text_status);
		north.add(text_type);
		
		north.add(btn_cancel);
		north.add(btn_confirm);
		
		north.add(label_bg);
		
		getContentPane().add(north, null);

	}

	/**
	 * ����������
	 */
	public void addComponentData(String[] info){
		text_name.setText(info[0]);
		text_type.setText(info[1]);
		text_sex.setText(info[2]);
		text_status.setText(info[3]);
		text_idcard.setText(info[4]);
		text_phone.setText(info[5]);
		text_address_1.setText(info[6]);
	}
	
	/**
	 * ����������2
	 */
	public void addComponentData2(String[] info){
		text_name.setText(info[0]);
		text_sex.setText(info[1]);
		text_idcard.setText(info[2]);
		text_phone.setText(info[3]);
		text_address_1.setText(info[4]);
		
		label_type.setVisible(false);
		label_Status.setVisible(false);
		
		text_status.setVisible(false);
		text_type.setVisible(false);
	}
	
	/**
	 * �û��޸���Ϣ
	 */
	public void changeInfo(String[] info){
		text_name.setText(info[0]);
		text_sex.setText(info[1]);
		text_idcard.setText(info[2]);
		text_phone.setText(info[3]);
		text_address_1.setText(info[4]);
		
		label_type.setVisible(false);
		label_Status.setVisible(false);
		
		text_status.setVisible(false);
		text_type.setVisible(false);
		
		text_name.setEditable(true);
		text_sex.setEditable(true);
		text_idcard.setEditable(true);
		text_phone.setEditable(true);
		text_address_1.setEditable(true);
		
		
	}
	
	/**
	 * ��Ӽ���
	 */
	private void addListener() {
		ButtonActionListener buttonActionListener = new ButtonActionListener();
		btn_cancel.addActionListener(buttonActionListener);
		btn_confirm.addActionListener(buttonActionListener);

	}

	/**
	 * ���öԻ�������
	 */
	private void setDialogAttribute() {
		
		this.setTitle("�˻���Ϣ");
		this.setBounds(680, 210, 711, 641);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		// ��ʾΪģ̬�Ի���
		this.setModal(true);
	}

	/**
	 * ��ť�¼�����
	 */
	final class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn_confirm){
				isConfirm = true;
				closeJSM();
			}
			if(e.getSource() == btn_cancel){
				isConfirm = false;
				closeJSM();
			}
		}
	}
}