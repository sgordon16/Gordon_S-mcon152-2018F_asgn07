package communications;

public class FileWriter {
	private String path;
	public FileWriter(String filePath)
	{
		path = filePath;
	}
	
	public void AppendLine(String line)
	{
		System.out.println("Wrote ***" + line + "*** to " + path);
	}
}
