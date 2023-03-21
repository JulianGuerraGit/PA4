package util;

public class InvArithmeticException extends Exception{
    private String invArithmeticString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return invArithmeticString + " is a arithmetic string of order -1 that is found at index " + occurrenceIndex + "!";
    }

    public InvArithmeticException(String invArithmeticString, int index) {
        this.invArithmeticString = invArithmeticString;
        occurrenceIndex = index;
    }
}
