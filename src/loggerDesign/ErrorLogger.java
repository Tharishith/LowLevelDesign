package loggerDesign;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(){
        this.logLevel = LogLevel.ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println(" ERROR : "+ message);
    }
}
