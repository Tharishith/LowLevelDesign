package loggerDesign;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(){
        this.logLevel = LogLevel.DEBUG;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG : " + message);
    }
}
