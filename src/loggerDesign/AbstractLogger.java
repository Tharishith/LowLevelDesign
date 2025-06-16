package loggerDesign;

public abstract class AbstractLogger {
    protected LogLevel logLevel;
    protected AbstractLogger nextLogger;


    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(LogLevel logLevel,String message){

        if(message == null || message.trim().isEmpty())
            throw  new RuntimeException("Message cannot be null");

        if(logLevel == null)
            throw  new RuntimeException("Log level cannot be null");

        if(this.logLevel == logLevel){
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(logLevel, message);
        }

    }

    protected abstract void write(String message);
}
