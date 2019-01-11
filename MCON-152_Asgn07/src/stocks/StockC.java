package stocks;

import java.util.Random;

public class StockC implements IStock {

	private String Id;
	private double shareValue;
	private int totalShares;
	private int totalPurchases;
	double[] adjustments = {.2, -.1, .1, .2, -.3, -.1, 2};
	int adjustmentsIndex = 0;
	
	
	public StockC(String id)
	{
		Id = id + " (C)";
		shareValue = 100.0;
		totalShares = 1400;
		totalPurchases = 0;
	}
	public String getId()
	{
		return Id;
	}
	
	@Override
	public Boolean buy(int shares) {
		int serviceFeeShares = totalPurchases % 3 == 0 ? 5 : 0; // a service fee of 5 shares for every third purchase
		if (shares <= 0 || shares + totalShares < serviceFeeShares)
			return false;
		totalShares += shares - serviceFeeShares;
		totalPurchases++;
		return true;
	}

	@Override
	public Boolean sell(int shares) {
		if (shares >= totalShares - 1)
			return false;
		totalShares -= shares + 1; // service fee of 1 every time 	
		
		return true;
	}

	@Override
	public double adjustValue() {		
		// adjustments are according to the percentages hardcoded in the array
		shareValue += shareValue * adjustments[adjustmentsIndex];
		adjustmentsIndex = (adjustmentsIndex + 1) % adjustments.length;
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
		return totalShares * shareValue * .99; // always take off 1% which would be a fee if the account was closed
	}

}
