package communications;

public class FileWriterCommand implements Command {

	FileWriter fileWriter;
	
	public FileWriterCommand(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	@Override
	public void execute() {
		fileWriter.AppendLine("Activity");
		
	}
	@Override
	public void cancelLast() {
		fileWriter.AppendLine("Cancel Last Activity");
		
	}

}
