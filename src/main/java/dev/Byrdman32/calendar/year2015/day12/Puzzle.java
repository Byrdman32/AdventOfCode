package dev.Byrdman32.calendar.year2015.day12;

import java.util.ArrayList;
import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    public static int countAllNumbers(String document)
    {
        int total = 0;
        StringBuilder buffer = new StringBuilder();

        for (char c : document.toCharArray())
        {
            if (Character.isDigit(c) || c == '-')
            {
                buffer.append(c);
                continue;
            }

            if (buffer.length() > 0)
            {
                total += Integer.parseInt(buffer.toString());
                buffer.setLength(0);
            }
        }

        return total;
    }

    public static String cleanJson(String document)
    {
        String illegal = "red";

        while (true)
        {
            int objectToRemoveIndex = document.indexOf(illegal);
            if (objectToRemoveIndex == -1) break;

            String context = document.substring(objectToRemoveIndex - 2, objectToRemoveIndex);
            if (context.equals(",\"") || context.equals("[\""))
            {
                StringBuilder builder = new StringBuilder(document);
                builder.replace(objectToRemoveIndex, objectToRemoveIndex + illegal.length(), "");
                document = builder.toString();
                continue;
            }

            document = removeContainingObject(document, objectToRemoveIndex);
        }

        return document;
    }

    public static String removeContainingObject(String document, int index)
    {
        StringBuilder builder = new StringBuilder(document);

        int leftBraceIndex = getLeftEnclosingObjectBrace(document, index);
        int rightBraceIndex = getRightEnclosingObjectBrace(document, index);
        builder.replace(leftBraceIndex, rightBraceIndex + 1,"");

        return builder.toString();
    }

    public static int getLeftEnclosingObjectBrace(String document, int index)
    {
        int braceCounter = 0;
        int i;

        for (i = index; i > 0; i--)
        {
            if      (document.charAt(i) == '{' && braceCounter == 0) break;
            else if (document.charAt(i) == '}') braceCounter++;
            else if (document.charAt(i) == '{') braceCounter--;
        }

        if (document.charAt(i) != '{') throw new IllegalArgumentException();

        return i;
    }

    public static int getRightEnclosingObjectBrace(String document, int index)
    {
        int braceCounter = 0;
        int i;

        for (i = index; i < document.length(); i++)
        {
            if      (document.charAt(i) == '}' && braceCounter == 0) break;
            else if (document.charAt(i) == '{') braceCounter++;
            else if (document.charAt(i) == '}') braceCounter--;
        }

        if (document.charAt(i) != '}') throw new IllegalArgumentException();

        return i;
    }
    public Object solvePart1(List<String> input) {

        int count = 0;
        String str = input.get(0);
        List<Integer> values = new ArrayList<>();
        String temp = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '-') {
                temp = temp.concat(str.charAt(i) + "");
            } else if (temp.length() > 0) {
                values.add(Integer.parseInt(temp));
                temp = "";
            }
        }

        for (Integer value : values) {
            count += value;
        }

        return count;
    }

    public Object solvePart2(List<String> input) {

        String cleanedDocument = cleanJson(input.get(0));

        return countAllNumbers(cleanedDocument);
    }
}