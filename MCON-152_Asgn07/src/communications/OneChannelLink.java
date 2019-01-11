package communications;

public class OneChannelLink {
	int channel;
	public OneChannelLink(int channel)
	{
		this.channel = channel;
	}
	
	public void Transmit()
	{
		System.out.println("One channel link sending tranmission on channel " + channel);
	}
	
	public void CancelLastTransmission()
	{
		System.out.println("One channel link cancelling tranmission on channel " + channel);
	}
}
