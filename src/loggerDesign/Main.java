package loggerDesign;

public class Main {
    public static void main(String[] args){
        AbstractLogger logger = LogChainFactory.getLoggerChain();

        try{
            logger.logMessage(LogLevel.DEBUG,"Debugging the database connection..");
            logger.logMessage(LogLevel.INFO,"Print this message");
            logger.logMessage(LogLevel.ERROR,"Found the error ");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
