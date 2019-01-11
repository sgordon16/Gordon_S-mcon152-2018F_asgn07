package communications;

public class Communicator {
	Command[] comMedia = new Command[7];
	// Variables to remember previous values for canceling
	int lastMediumUsed;
	
	public Communicator()
	{
		// Hardcode in the media
		comMedia[0] = new FileWriterCommand(new FileWriter("c:\\logs\\log.dat"));
		comMedia[1] = new FileWriterCommand(new FileWriter("d:\\system\\activities\\act.dat"));
		comMedia[2] = new DbLoggerCommand(new DbLogger());
		comMedia[3] = new OneChannelLinkCommand(new OneChannelLink(12));
		comMedia[5] = new MultiChannelLinkCommand(new MultiChannelLink());
		comMedia[6] = new MultiChannelLinkCommand(new MultiChannelLink());
	}
	
	// log a single activity
	public void logActivity(int medium)
	{
		Command m = comMedia[medium];
		m.execute();
		lastMediumUsed = medium;
	}
	
	public void cancelLastLogging()
	{
		Command m = comMedia[lastMediumUsed];
		m.cancelLast();
	}
	
	// log activity on all media
	public void broadcastActivity()
	{
		for (int i = 0; i < comMedia.length; i++)
			logActivity(i);
	}
	
	public void cancelLastBroadcast() throws Exception
	{
		for (int i = 0; i < comMedia.length; i++)
			comMedia[i].cancelLast();
	}
}
