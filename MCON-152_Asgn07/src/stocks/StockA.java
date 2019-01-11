package stocks;

import java.util.Random;

public class StockA implements IStock {

	private String Id;
	private double shareValue;
	private int totalShares;
	Random rand;
	
	
	public StockA(String id)
	{
		Id = id;
		shareValue = 5.0;
		totalShares = 100;
		rand = new Random();
	}
	public String getId()
	{
		return Id;
	}
	
	@Override
	public Boolean buy(int shares) {
		if (shares <= 0)
			return false;
		totalShares += shares;
		return true;
	}

	@Override
	public Boolean sell(int shares) {
		if (shares >= totalShares - 1)
			return false;
		totalShares -= shares + 1; // one share is taken as a service fee		
		
		return true;
	}

	@Override
	public double adjustValue() {
		// Randomly adjust the value between -10% and +10%
		double pct = -.1 + rand.nextDouble() * (.2);
		shareValue += shareValue * pct;
		return shareValue;
	}

	@Override
	public int getShares() {
		return totalShares;
	}

	@Override
	public double getShareValue() {
		return shareValue;
	}

	@Override
	public double getTotalValue() {
		return totalShares * shareValue;
	}

}
