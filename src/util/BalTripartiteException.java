package util;

public class BalTripartiteException extends Exception{
    private String balTripartiteString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return balTripartiteString + " is a balanced tripartite string that is found at index " + occurrenceIndex + "!";
    }

    public BalTripartiteException(String balTripartiteString, int index) {
        this.balTripartiteString = balTripartiteString;
        occurrenceIndex = index;
    }
}
