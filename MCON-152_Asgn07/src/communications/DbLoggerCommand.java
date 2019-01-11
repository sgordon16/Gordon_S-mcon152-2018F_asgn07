package communications;

public class DbLoggerCommand implements Command {

	DbLogger dbLogger;
	long lastDbRecord;
	
	public DbLoggerCommand(DbLogger dbLogger) {
		this.dbLogger  = dbLogger;
	}
	@Override
	public void execute() {
		dbLogger.enableWrite();
		lastDbRecord = dbLogger.writeRecord("Activity");
	}
	@Override
	public void cancelLast() {
		dbLogger.enableDelete();
		dbLogger.deleteRecord(lastDbRecord);
		
	}

}
