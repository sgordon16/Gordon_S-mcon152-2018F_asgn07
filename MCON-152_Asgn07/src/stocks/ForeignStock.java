package stocks;

public class ForeignStock {
	private int shares;
	private double stockValue;
	
	public ForeignStock()
	{
		shares = 0;
		stockValue = 150.0;
	}
	
	public Boolean purchase(int s)
	{
		if (s < 0)
			return false;
		this.shares += s;
		if (shares > 10000)
			shares -= 5; // special fee for a large balance
		return true;
	}
	
	public void sell(int s)
	{
		shares -= s;
	}
	
	public void adjust(double pct)
	{
		stockValue += stockValue * pct;
	}
	
	public int getTotalShares()
	{
		return shares;
	}
	
	public void setStockValue(double v)
	{
		stockValue = v - 0.005; // reflect potential service fee
	}
	
	public double getStockValue()
	{
		return stockValue - 3; // Service fee of 3 for closing the account
	}
}
