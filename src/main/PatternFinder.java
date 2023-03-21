package main;

import util.*;
import util.ArithmeticException;

import java.util.*;

public class PatternFinder {
    /**
     * randomStringGenerator is a method that generates and returns a randomly generated string of a given length.
     * This is done by using the random class from java to generate random integers within a range of 25 and converts
     * that into a character that gets stored in a character array which then gets passed into the String class
     * constructor that is returned as a string.
     *
     * @param length is the given input length.
     * @return returns the randomly generated string.
     */
    private static String randomStringGenerator(int length) {// generates a string made of randomly generated lowercase
        // letters.
        Random random = new Random(System.nanoTime());
        char[] array = new char[length];
        for (int i = 0; i < length; i++)
            array[i] = (char) ('a' + random.nextInt(26));
        return new String(array);
    }

    /**
     * singletonMiner is the method that looks for a singleton pattern of a given length within a given string. This is
     * done by iterating character by character and checking if the previous character matches the current character,
     * if the target length of identical characters is reached then it throws a SingletonException which stores the
     * substring it found and its starting index.
     *
     * @param mine is the given string that is being checked.
     * @param length is the given length of the pattern we are looking for.
     * @throws SingletonException is called with, and stores, the substring pattern found and the starting index.
     */
    private static void singletonMiner(String mine, int length) throws SingletonException {
        for (int start = 0; start <= mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++)
                if (mine.charAt(i) != mine.charAt(i - 1))
                    break;
            if (i == start + length)
                throw new SingletonException(mine.substring(start, start + length), start);
        }
    }

    /**
     * arithmeticMiner is the method that looks for an arithmetic pattern of a given length within a given string. This
     * is done by iterating character by character and checking if the previous character is sequential to the current
     * character, if the target length of arithmetically incrementing characters is reached then it throws an
     * ArithmeticException which stores the substring it found and its starting index.
     *
     * @param mine is the given string that is being checked.
     * @param length is the given length of the pattern we are looking for.
     * @throws ArithmeticException is called with, and stores, the substring pattern found and the starting index.
     */
    private static void arithmeticMiner(String mine, int length) throws ArithmeticException {
        for (int start = 0; start <= mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++)
                if (mine.charAt(i) != mine.charAt(i - 1) + 1)
                    break;
            if (i == start + length)
                throw new ArithmeticException(mine.substring(start, start + length), start);
        }
    }

    /**
     * invArithmeticMiner is the method that looks for an arithmetic pattern of order -1 of a given length within a
     * given string. This is done by iterating character by character and checking if the previous character is
     * sequential to the current character, if the target length of arithmetically decrementing characters is reached
     * then it throws an InvArithmeticException which stores the substring it found and its starting index.
     *
     * @param mine is the given string that is being checked.
     * @param length is the given length of the pattern we are looking for.
     * @throws InvArithmeticException is called with, and stores, the substring pattern found and the starting index.
     */
    private static void invArithmeticMiner(String mine, int length) throws InvArithmeticException {
        for (int start = 0; start <= mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++)
                if (mine.charAt(i) != mine.charAt(i - 1) - 1)
                    break;
            if (i == start + length)
                throw new InvArithmeticException(mine.substring(start, start + length), start);
        }
    }

    private static void balTripartiteMiner(String mine, int length) throws BalTripartiteException {

        if (length % 3 != 0)
            return;
        int n = length / 3;
        for (int start = 0; start <= mine.length() - length; start++) {
            String substring1 = mine.substring(start, start + n);
            String substring2 = mine.substring(start + n, start + (n * 2));
            String substring3 = mine.substring(start + (n * 2), start + length);
            if (substring1.equals(substring2) && substring2.equals(substring3))
                throw new BalTripartiteException(mine.substring(start, start + length), start);
        }

    }

    private static void balBipartiteMiner(String mine, int length) throws BalBipartiteException {

        if (length % 2 != 0)
            return;
        int n = length / 2;
        for (int start = 0; start <= mine.length() - length; start++) {
            String substring1 = mine.substring(start, start + n);
            String substring2 = mine.substring(start + n, start + length);
            if (substring1.equals(substring2))
                throw new BalBipartiteException(mine.substring(start, start + length), start);
        }

    }

    private static void palindromeMiner(String mine, int length) throws PalindromeException {

        for (int start = 0; start <= mine.length() - length; start++) {
            int i = start;
            int j = start + length - 1;
            boolean isPalindrome = true;
            while (i < j) {
                if (mine.charAt(i) != mine.charAt(j)) {
                    isPalindrome = false;
                    break;
                }
                i++;
                j--;
            }
            if (isPalindrome)
                throw new PalindromeException(mine.substring(start, start + length), start);
        }

    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Step 1: handling input...
        System.out.println("Enter the length of random string: ");
        int randomStringLength = keyboard.nextInt();
        while (true) {
            try {
                if (randomStringLength < 100000 || randomStringLength > 1000000000)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Try again!");
                randomStringLength = keyboard.nextInt();
                continue;
            }
            break;
        }

        System.out.println("Enter the max length of a special pattern: ");
        int patternMaxLength = keyboard.nextInt();
        while (true) {
            try {
                if (patternMaxLength < 3 || patternMaxLength > 15)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Try again!");
                patternMaxLength = keyboard.nextInt();
                continue;
            }
            break;
        }
        //Step 2: generating random string...
        String randomString = randomStringGenerator(10000);
        //Step 3: finding the interesting patterns
        try {
            for (int length = patternMaxLength; length > 0; length--) {
                singletonMiner(randomString, length);
                arithmeticMiner(randomString, length);
                invArithmeticMiner(randomString, length);
                balTripartiteMiner(randomString, length);
                balBipartiteMiner(randomString, length);
                palindromeMiner(randomString, length);
            }
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
}
