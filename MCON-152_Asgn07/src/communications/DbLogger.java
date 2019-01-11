package communications;

public class DbLogger {
	private long nextRecord = 0;
	private Boolean writeEnabled = false;
	private Boolean deleteEnabled = false;
	
	public long writeRecord(String msg)
	{
		if (!writeEnabled)
		{
			System.out.println("CANNOT WRITE, MUST ENABLE FIRST");
			return -1;
		}
		else
		{
			System.out.println("Wrote ***" + msg + "*** to db as record " + nextRecord);
			writeEnabled = false;
			return nextRecord++;
		}
			
	}
	
	public void deleteRecord(long r)
	{
		if (!deleteEnabled)
			System.out.println("CANNOT DELETE, MUST ENABLE FIRST");
		else
		{
			System.out.println("Deleted db record " + r);
			deleteEnabled = false;
		}
	}
	
	public void enableWrite()
	{
		deleteEnabled = false;
		writeEnabled = true;
	}
	
	public void enableDelete()
	{
		writeEnabled = false;
		deleteEnabled = true;
	}
}
