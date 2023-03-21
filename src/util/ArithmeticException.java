package util;

public class ArithmeticException extends Exception{
    private String arithmeticString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return arithmeticString + " is a arithmetic string of order 1 that is found at index " + occurrenceIndex + "!";
    }

    public ArithmeticException(String arithmeticString, int index) {
        this.arithmeticString = arithmeticString;
        occurrenceIndex = index;
    }
}
