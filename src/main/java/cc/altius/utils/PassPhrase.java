package cc.altius.utils;

/**
 * This Utility is used to generate Passwords or random strings that comprise of
 * small case characters, caps or digits. Is generally used to auto-generate
 * passwords
 *
 * @author Akil Mahimwala
 *
 */
public final class PassPhrase {

    private static final int MIN_LENGTH = 8;
    private static final int DEFAULT_OTP_LENGTH = 4;
    protected static java.util.Random r = new java.util.Random();
    protected static char[] goodChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
        'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    protected static char[] goodSmallCaseChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
        'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    protected static char[] numberChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * Get a random generated String that consists of digits only to be used for
     * OTP
     *
     * @return Returns the random generated String of size 4 that consists of
     * only digits
     */
    public static String getOtp() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DEFAULT_OTP_LENGTH; i++) {
            sb.append(numberChar[r.nextInt(numberChar.length)]);
        }
        return sb.toString();
    }
    
    /**
     * Get a random generated String that consists of digits only to be used for
     * OTP
     *
     * @return Returns the random generated String of size 4 that consists of
     * only digits
     */
    public static String getOtp(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(numberChar[r.nextInt(numberChar.length)]);
        }
        return sb.toString();
    }

    /**
     * Get a random generated String that is only in small case or digits
     *
     * @return Returns the random generated String of size 8
     */
    public static String getSmallCasePassword() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MIN_LENGTH; i++) {
            sb.append(goodSmallCaseChar[r.nextInt(goodSmallCaseChar.length)]);
        }
        return sb.toString();
    }

    /**
     * Get a random generated String that is only in small case or digits
     *
     * @param length Length that you want the string to be
     * @return Returns the random generated String of size `length`
     */
    public static String getSmallCasePassword(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(goodSmallCaseChar[r.nextInt(goodSmallCaseChar.length)]);
        }
        return sb.toString();
    }

    /**
     * Get a random generated String that is in small case, caps or digits
     *
     * @return Returns the random generated String of size 8
     */
    public static String getPassword() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MIN_LENGTH; i++) {
            sb.append(goodChar[r.nextInt(goodChar.length)]);
        }
        return sb.toString();
    }

    /**
     * Get a random generated String that is in small case, caps or digits
     *
     * @param length Length that you want the string to be
     * @return Returns the random generated String of size `length`
     */
    public static String getPassword(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(goodChar[r.nextInt(goodChar.length)]);
        }
        return sb.toString();
    }
}
