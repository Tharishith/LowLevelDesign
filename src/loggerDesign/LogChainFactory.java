package loggerDesign;

public class LogChainFactory {
    public static AbstractLogger getLoggerChain(){
        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger infoLogger= new InfoLogger();
        AbstractLogger debugLogger = new DebugLogger();

        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);

        return debugLogger;
    }
}
