package stocks;

public interface IStock {
	public String getId();
	public Boolean buy (int shares);
	public Boolean sell (int shares);
	public double adjustValue();
	public int getShares();
	public double getShareValue();
	public double getTotalValue();
}
