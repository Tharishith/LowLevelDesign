package loggerDesign;

public class InfoLogger extends AbstractLogger{

    public InfoLogger(){
        this.logLevel = LogLevel.INFO;
    }

    @Override
    protected void write(String message) {
        System.out.println(" INFO : "+ message);
    }
}
