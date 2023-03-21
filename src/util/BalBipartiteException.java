package util;

public class BalBipartiteException extends Exception{
    private String balBipartiteString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return balBipartiteString + " is a balanced bipartite string that is found at index " + occurrenceIndex + "!";
    }

    public BalBipartiteException(String balBipartiteString, int index) {
        this.balBipartiteString = balBipartiteString;
        occurrenceIndex = index;
    }
}
