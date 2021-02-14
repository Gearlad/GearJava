
public class flipCoin_driver {
	public static void main(String [] args) {
		flipCoin obj1=new flipCoin(.5);
		obj1.fairness();
		obj1.trials();
		obj1.flip();
		obj1.output();
	}
}
