package seventh.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 取款选择
 *
 */
public class TakeChoseFrame {

	private JFrame frameChose;
	private TakeFrame takeFrame = new TakeFrame();
	private String File = "E:\\Code\\java\\CCB_ATM";
	// private String File = ".";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		
		ATMButton button = new ATMButton("<html><center>取款<br>Cash</center></html>");
		button.addActionListener(new ToTake());
		button.setBounds(14, 330, 160, 70);
		frameChose.getContentPane().add(button);
		
		ATMButton button_1 = new ATMButton("<html><center>透支取款<br>Overdraft</center></html>");
		button_1.addActionListener(new ToTake());
		button_1.setBounds(915, 330, 160, 70);
		frameChose.getContentPane().add(button_1);
		
		ATMButton button_2 = new ATMButton("<html>退出<br>Exit</html>");
		button_2.setForeground(Color.RED);
		button_2.addActionListener(new Back());
		button_2.setBounds(915, 550, 160, 70);
		frameChose.getContentPane().add(button_2);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameChose.getContentPane().add(lblBg);
	}
	
	class ToTake implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			takeFrame.getFrameTake().setVisible(true);
			frameChose.dispose();
		}
	}
	
	class Back implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameChose.dispose();
		}
	}
}
