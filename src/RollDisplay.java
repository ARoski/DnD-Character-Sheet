import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollDisplay extends JFrame {
	
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
	// Creating the content for the display
	private JButton four;
	private JButton six;
	private JButton eight;
	private JButton ten;
	private JButton twenty;
	private JButton hundred;
	
	private JButton roll;
	private JTextField modText;
	private JLabel modifier;
	private JTextField rollText;
	
	private int holder = -1;
	
	/**
	 * Creates the Display
	 */
	public RollDisplay() {
		setTitle("Dice Roller");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		createContent();
		createPanels();
	}
	
	private void createContent() {
		four = new JButton("d4");
		ActionListener listFour = new rollType(4);
		four.addActionListener(listFour);
		four.setBounds(75, 50, 100, 50);
		
		six = new JButton("d6");
		ActionListener listSix = new rollType(6);
		six.addActionListener(listSix);
		six.setBounds(200, 50, 100, 50);
		
		eight = new JButton("d8");
		ActionListener listEight = new rollType(8);
		eight.addActionListener(listEight);
		eight.setBounds(325, 50, 100, 50);
		
		ten = new JButton("d10");
		ActionListener listTen = new rollType(10);
		ten.addActionListener(listTen);
		ten.setBounds(75, 125, 100, 50);
		
		twenty = new JButton("d20");
		ActionListener listTwenty = new rollType(20);
		twenty.addActionListener(listTwenty);
		twenty.setBounds(200, 125, 100, 50);
		
		hundred = new JButton("d100");
		ActionListener listHundred = new rollType(100);
		hundred.addActionListener(listHundred);
		hundred.setBounds(325, 125, 100, 50);
		
		rollText = new JTextField("");
		rollText.setEditable(false);
		rollText.setBounds(150 ,325, 50, 50);
		rollText.setFont(rollText.getFont().deriveFont(Font.PLAIN, 20));
		rollText.setHorizontalAlignment(JTextField.CENTER);
		
		modText = new JTextField("");
		modText.setEditable(true);
		modText.setBounds(150, 250, 50, 50);
		modText.setFont(modText.getFont().deriveFont(Font.PLAIN, 20));
		modText.setHorizontalAlignment(JTextField.CENTER);
		
		modifier = new JLabel("Modifier:");
		modifier.setBounds(25, 250, 100, 50);
        modifier.setFont(modifier.getFont().deriveFont(Font.BOLD, 20));
		modifier.setForeground(Color.white);
		
		roll = new JButton("Roll");
		ActionListener listRoll = new rollDie();
		roll.addActionListener(listRoll);
		roll.setBounds(25, 325, 100, 50);
        roll.setFont(roll.getFont().deriveFont(Font.BOLD, 20));
	}
	
	private int retrieveMod() {
		return Integer.parseInt(modText.getText());
	}
	
	private int retrieveRoll() {
		return holder;
	}
	
	private void createPanels() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(four);
		panel.add(six);
		panel.add(eight);
		panel.add(ten);
		panel.add(twenty);
		panel.add(hundred);
		panel.add(rollText);
		panel.add(modText);
		panel.add(modifier);
		panel.add(roll);
        Color color = new Color(153, 0, 51);
        panel.setBackground(color);
		add(panel);
	}
	
	class rollType implements ActionListener {
		
		private int temp;
		public rollType(int temp) {
			this.temp = temp;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			holder = temp;
		}
	}
	
//	class rollSix implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			holder = 6;
//		}
//	}
//	
//	class rollEight implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			holder = 8;
//		}
//	}
//	
//	class rollTen implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			holder = 10;
//		}
//	}
//	
//	class rollTwenty implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			holder = 20;
//		}
//	}
//	
//	class rollHundred implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			holder = 100;
//		}
//	}
	
	class rollDie implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (holder != -1) {
				Roll roll = new Roll(retrieveRoll(), retrieveMod());
				rollText.setText("" + roll.rollDie());
			}
		}
	}
}
