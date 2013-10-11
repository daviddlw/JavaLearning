package david.thinkinginJava;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException extends Exception {
    private static Logger logger  = Logger.getLogger("Logging Exception");
    
    public LoggingException() {
	// TODO Auto-generated constructor stub
	StringWriter sw = new StringWriter();
	printStackTrace(new PrintWriter(sw));
	logger.severe(sw.toString());
    }
}
