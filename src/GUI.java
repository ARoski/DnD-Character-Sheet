import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 1000;
	
	private JLabel characterName;
	private JLabel background;
	private JLabel playerName;
	private JLabel race;
	private JLabel alignment;
	
	private JButton str;
	private JButton dex;
	private JButton con;
	private JButton inte;
	private JButton wis;
	private JButton charisma;
	private JButton perc;
	
	private JButton rollDie;
	private JTextField rollDisplay;
	
	public GUI() {
		setTitle("DnD Character Sheet");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		createTest();
		createPanels();
	}
	
	public void createTest() {
		rollDie = new JButton("Roll Die");
		rollDisplay = new JTextField("Roll Die First");
		rollDisplay.setEditable(false);
		rollDie.setBounds(50, 50, 300, 100);
		rollDisplay.setBounds(400, 100, 100, 100);
		ActionListener tester = new RollDie();
		rollDie.addActionListener(tester);
	}
	
	class RollDie implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Roll roll = new Roll(20, 0);
			rollDisplay.setText("" + roll.rollDie());
		}
	}
	
	public void createPanels() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(rollDie);
		panel.add(rollDisplay);
		add(panel);
	}
}
