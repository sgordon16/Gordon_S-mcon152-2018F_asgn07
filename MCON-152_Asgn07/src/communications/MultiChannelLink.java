package communications;

import java.util.Random;

public class MultiChannelLink {
	Random rand;
	int currentChannel;
	
	public MultiChannelLink()
	{
		rand = new Random();
		currentChannel = rand.nextInt(10);
	}

	public void Transmit()
	{
		System.out.println("One channel link sending tranmission on channel " + currentChannel);
		currentChannel = rand.nextInt(10);
	}
	
	public void CancelLastTransmission(int channel)
	{
		System.out.println("One channel link cancelling tranmission on channel " + channel);
	}
	
	public int getCurrentChannel()
	{
		return currentChannel;
	}
}
