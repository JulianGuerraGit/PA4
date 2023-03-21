package util;

public class PalindromeException extends Exception {//e.g. "bbbbbbb", "mmmm", "nn"
    private String palindromeString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return palindromeString + " is a palindrome that is found at index " + occurrenceIndex + "!";
    }

    public PalindromeException(String palindromeString, int index) {
        this.palindromeString = palindromeString;
        occurrenceIndex = index;
    }
}
