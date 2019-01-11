package program;

import java.util.Scanner;

import communications.Communicator;
import stocks.*;

public class Program {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		String choice;
		IStock[] stocks = getStockArray();
		Communicator communicator = new Communicator();
		int index;
		
		do
		{
			System.out.println("Would you like to:\n" +
					"'Buy' 50 shares\n" + 
					"'Sell' 50 shares\n" + 
					"Get the 'Total' value\n" + 
					"'Log' an activity\n" + 
					"'Cancel' the last logged activity\n" +
					"'Broadcast' an activity\n" +
					"'Delete' the last broadcast, or\n" + 
					"'Quit'?");
							
			choice = kb.nextLine().toLowerCase();
			switch(choice)
			{
				case "buy":
					System.out.println("Which stock in the array?");
					index = kb.nextInt();
					kb.nextLine();
					if (stocks[index].buy(50))
						System.out.println("Buy was successful");
					else
						System.out.println("Buy failed");
					break;
				case "sell":
					System.out.println("Which stock in the array?");
					index = kb.nextInt();
					kb.nextLine();
					if (stocks[index].sell(50))
						System.out.println("Sell was successful");
					else
						System.out.println("Sell failed");
					break;
				case "total":
					int sum = 0;
					for (IStock s : stocks)
						sum += s.getTotalValue();
					System.out.println("Total is " + sum);
					break;
				case "log":
					System.out.println("Which medium index?");
					index = kb.nextInt();
					kb.nextLine();
					communicator.logActivity(index);
					break;
				case "cancel":
					communicator.cancelLastLogging();
					break;
				case "broadcast":
					communicator.broadcastActivity();
					break;
				case "delete":
					communicator.cancelLastBroadcast();
					break;
				case "quit":
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Invalid choice");
			}
			for (IStock s : stocks)
				s.adjustValue();
			
		}while (choice != "Quit");
	}

	private static IStock[] getStockArray()
	{
		// Hardcoded array of stocks
		IStock[] stocks = new IStock[8];
		stocks[0] = new StockA("AXX");
		stocks[1] = new StockA("KYM");
		stocks[2] = new StockB("FDS");
		stocks[3] = new StockB("LLQ");
		stocks[4] = new StockC("WER");
		stocks[5] = new StockC("ZYB");
		stocks[6] = new ForeignStockAdapter(new ForeignStock(), "J2L");
		stocks[7] = new ForeignStockAdapter(new ForeignStock(),"PA");
		
		return stocks;
	}
}
