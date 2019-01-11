package stocks;

import java.util.Random;

public class ForeignStockAdapter implements IStock{
	
	ForeignStock foreignStock;
	private String Id;
	Random rand;
	
	public ForeignStockAdapter(ForeignStock foreignStock, String Id) {
		this.foreignStock = foreignStock;
		this.Id = Id;
		rand = new Random();
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return Id;
	}

	@Override
	public Boolean buy(int shares) {
		return foreignStock.purchase(shares);
	}

	@Override
	public Boolean sell(int shares) {
		if (shares >=  foreignStock.getTotalShares())
			return false;
		foreignStock.sell(shares);	
		return true;
	}

	@Override
	public double adjustValue() {
		double pct = -.2 + rand.nextDouble() * (.4);
		foreignStock.adjust(pct);
		return foreignStock.getStockValue();
	}

	@Override
	public int getShares() {
		// TODO Auto-generated method stub
		return foreignStock.getTotalShares();
	}

	@Override
	public double getShareValue() {
		// TODO Auto-generated method stub
		return foreignStock.getStockValue();
	}

	@Override
	public double getTotalValue() {
		// TODO Auto-generated method stub
		return foreignStock.getTotalShares() * foreignStock.getStockValue();
	}

}
