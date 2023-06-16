package org.demo.example;
import  java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputString = "cbbbcbbnhgb";
        char symbol = 'b';

        System.out.println("Symbol '" + symbol + "' meets " + findSymbolOccurrence(inputString, symbol) + " times");

        String sourceString = "apollo";
        String targetString = "pollo";

        System.out.println("Position of " + targetString + " in " + sourceString + " is " + findWordPosition(sourceString, targetString));

        sourceString = "Apple";
        targetString = "plant";

        System.out.println("Position of " + targetString + " in " + sourceString + " is " + findWordPosition(sourceString, targetString));

        String toReverse = "Hello world";
        System.out.println("Reversed string " + stringReverse(toReverse));

        String palindrome = "Alla";

        if (isPalindrome(palindrome)) {
            System.out.println("String " + palindrome + " is palindrome");
        } else {
            System.out.println("String " + palindrome + " is not palindrome");
        }

        palindrome = "Taras";

        if (isPalindrome(palindrome)) {
            System.out.println("String " + palindrome + " is palindrome");
        } else {
            System.out.println("String " + palindrome + " is not palindrome");
        }

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple", "peanut", "potato"};
        final Random random = new Random();
        String hiddenWord = words[random.nextInt(words.length)];
        Scanner scanner = new Scanner(System.in);
        String userWord;

        while (true){
            int matchedChars = 0;
            StringBuilder stringBuilder = new StringBuilder();
            boolean allMatched = false;

            System.out.println("Enter word that was hidden:");
            userWord = scanner.nextLine();

            for (int i = 0; i < 15; i++) {
                if (matchedChars == hiddenWord.length()){
                    allMatched = true;
                    break;
                }

                if (hiddenWord.length() > i && userWord.length() > i && hiddenWord.charAt(i) == userWord.charAt(i)){
                    stringBuilder.append(hiddenWord.charAt(i));
                    matchedChars++;
                }else{
                    stringBuilder.append('#');
                }
            }

            if (allMatched) {
                System.out.println("Correct");
                break;
            };

            System.out.println(stringBuilder.toString());
        }
    }

    private static int findSymbolOccurrence(String inputString, char searchingSymbol){
        int occurrence = 0;
        int currentPossition = inputString.length();

        while (true){
            currentPossition = inputString.lastIndexOf(searchingSymbol, currentPossition);
            if (currentPossition == -1) break;
            occurrence++;
            currentPossition--;
        }

        return occurrence;
    }

    private static int findWordPosition(String source, String target){
        int position = -1;
        boolean contains = source.contains(target);

        if (contains){
            return source.lastIndexOf(target);
        }

        return position;
    }

    private static String stringReverse(String inputString){
        char currentChar;
        String reversedString = "";

        for (int i = 0; i < inputString.length(); i++)
        {
            currentChar = inputString.charAt(i);
            reversedString= currentChar + reversedString;
        }

        return reversedString;
    }

    public static boolean isPalindrome(String text)
    {
        String result = text.replaceAll("\\W", "").toLowerCase();

        int n = result.length();
        for (int i = 0; i < (n/2); ++i) {
            if (result.charAt(i) != result.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}