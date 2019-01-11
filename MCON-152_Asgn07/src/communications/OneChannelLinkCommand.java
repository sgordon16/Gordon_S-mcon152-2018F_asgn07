package communications;

public class OneChannelLinkCommand implements Command {

	OneChannelLink oneChannelLink;
	
	public OneChannelLinkCommand(OneChannelLink oneChannelLink) {
		this.oneChannelLink = oneChannelLink;
	}
	@Override
	public void execute() {
		oneChannelLink.Transmit();
	}
	@Override
	public void cancelLast() {
		oneChannelLink.CancelLastTransmission();
		
	}

}
