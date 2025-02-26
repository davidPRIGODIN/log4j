package MyLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.TimeUnit;


public class MyLogger {
    private static final Logger logger = LogManager.getLogger(MyLogger.class);

    public static void main(String[] args) {
        while (true) {
            logger.info("INFO: Le systeme fonctionne normalement.");
            sleep(5); // Pause de 5 secondes
        }
        
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.fatal("FATAL: Le thread principal a ete interrompu !");
        }
    }
}

