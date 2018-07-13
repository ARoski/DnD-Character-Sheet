import java.util.Random;
public class Roll {
	private int low = 1;
	private int high;
	private int modifier = 0;
	private int check = 0;
	
	public Roll(int high, int modifier, int check) {
		this.high = high;
		this.modifier = modifier;
		this.check = check;
	}
	
	public Roll(int high, int modifier) {
		this.high = high;
		this.modifier = modifier;
	}
	
	public int rollDie() {
		Random rand = new Random();
		return (rand.nextInt((high - low) + 1) + low) + check + modifier;
	}
}
