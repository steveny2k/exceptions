package pointofsale;

import java.io.IOException;
import java.net.Socket;

class ModemDidNotConnectException extends Exception {
    public ModemDidNotConnectException(String message) {
        super(message);
    }
}

class SerialDriver {
    public static void dialModem(String phonenum) throws ModemDidNotConnectException {
        throw new ModemDidNotConnectException("Darn ancient hardware!!!");
    }
}

public class CCard {
    public static class RetryLaterException extends Exception {
        public RetryLaterException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private static boolean useModem = true;

    public static void authorizePayment(int cc, int money) throws RetryLaterException {
        // retry three times
        try {
            if (useModem) {
                SerialDriver.dialModem("800 555 1212");
            } else {
                Socket s = new Socket("serives.salesforce.cmo", 8000);
            }
            // do protocol to authorize payment
        } catch (IOException | ModemDidNotConnectException ex) {
            throw new RetryLaterException("Infrastructure problem", ex);
        }
    }

    public static void main(String[] args) {
        try {
            authorizePayment(1, 100);
        } catch (RetryLaterException rle) {
            rle.printStackTrace();
        }
//        } catch (ModemDidNotConnectException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
