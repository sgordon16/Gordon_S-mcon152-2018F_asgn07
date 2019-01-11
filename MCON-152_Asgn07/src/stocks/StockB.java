package stocks;

import java.util.Random;

public class StockB implements IStock {

	private String Id;
	private double shareValue;
	private int totalShares;
	Random rand;
	Boolean increase;
	
	
	public StockB(String id)
	{
		Id = "TYPE B - " + id;
		shareValue = 25.0;
		totalShares = 1000;
		increase = true;
		rand = new Random();
	}
	public String getId()
	{
		return Id;
	}
	
	@Override
	public Boolean buy(int shares) {
		if (shares <= 0 || shares + totalShares < 3)
			return false;
		totalShares += shares - 3; // three shares are taken as a service fee
		return true;
	}

	@Override
	public Boolean sell(int shares) {
		if (shares >= totalShares )
			return false;
		totalShares -= shares; 	
		
		return true;
	}

	@Override
	public double adjustValue() {	
		// adjust by a random percent up to 25%, switch off between gains and losses
		double pct = rand.nextDouble() * (.25);		
		shareValue += shareValue * (increase ? pct : -pct);
		increase = !increase;
		return shareValue;
	}

	@Override
	public int getShares() {
		return totalShares;
	}

	@Override
	public double getShareValue() {
		return shareValue - 0.01; // an adjustment to reflect a per share fee
	}

	@Override
	public double getTotalValue() {
		return totalShares * shareValue - 10; // always take off 10 which would be a fee if the stock was sold completely
	}

}
