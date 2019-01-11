package communications;

public class MultiChannelLinkCommand implements Command {

	MultiChannelLink multiChannelLink;
	int lastChannel;
	
	public MultiChannelLinkCommand(MultiChannelLink multiChannelLink) {
		this.multiChannelLink = multiChannelLink;
	}
	@Override
	public void execute() {
		lastChannel = multiChannelLink.currentChannel;
		multiChannelLink.Transmit();

	}
	@Override
	public void cancelLast() {
		multiChannelLink.CancelLastTransmission(lastChannel);
		
	}

}
