package communications;

public interface Command {

	public void execute();
	public void cancelLast();
}
