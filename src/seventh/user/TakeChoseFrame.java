package seventh.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import seventh.until.ATMButton;

/**
 * ȡ��ѡ��
 *
 */
public class TakeChoseFrame {

	private JFrame frameChose;
	private TakeFrame takeFrame = new TakeFrame();
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
					TakeChoseFrame window = new TakeChoseFrame();
					window.frameChose.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrameChose() {
		return frameChose;
	}

	/**
	 * Create the application.
	 */
	public TakeChoseFrame() {
		initialize();
		takeFrame.getFrameTake().setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameChose = new JFrame();
		frameChose.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameChose.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameChose.setResizable(false);
		frameChose.setBounds(360, 150, 1095, 750);
		frameChose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameChose.getContentPane().setLayout(null);
		
		ATMButton button = new ATMButton("<html><center>ȡ��<br>Cash</center></html>");
		button.addActionListener(new ToTake());
		button.setBounds(14, 330, 160, 70);
		frameChose.getContentPane().add(button);
		
		ATMButton overdeaftButton = new ATMButton("<html><center>͸֧ȡ��<br>Overdraft</center></html>");
		overdeaftButton.setActionCommand("͸֧ȡ��");
		overdeaftButton.addActionListener(new ToTake());
		overdeaftButton.setBounds(915, 330, 160, 70);
		frameChose.getContentPane().add(overdeaftButton);
		
		ATMButton button_2 = new ATMButton("<html>�˳�<br>Exit</html>");
		button_2.setForeground(Color.RED);
		button_2.addActionListener(new Back());
		button_2.setBounds(915, 550, 160, 70);
		frameChose.getContentPane().add(button_2);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameChose.getContentPane().add(lblBg);
	}

	class ToTake implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//�ж��Ƿ���͸֧ȡ��
			if (e.getActionCommand().equals("͸֧ȡ��")) {
				takeFrame.isOverdeaft = true;
			} else {
				takeFrame.isOverdeaft = false;
			}
			takeFrame.getFrameTake().setVisible(true);
			frameChose.dispose();
		}
	}

	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameChose.dispose();
		}
	}
}
