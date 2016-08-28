package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 07.08.2016.
 */
public class JustifiedText {

    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> result = new ArrayList<>();
        int wordsPerLine = 0;
        int startIndex = 0;
        while (startIndex + wordsPerLine < a.size()) {
            startIndex += wordsPerLine;
            wordsPerLine = getWordsNumber(a, b, startIndex);
            boolean isLast = startIndex+wordsPerLine == a.size();
            String line = getLine(a.subList(startIndex, startIndex+wordsPerLine), b, isLast);
            result.add(line);
        }
        return result;
    }

    public int getWordsNumber(ArrayList<String> list, int lineLength, int startId) {
        int charCount = 0;
        for (int i = startId; i < list.size(); i++) {
            String word = list.get(i);
            charCount += word.length();
            int spaces = i - startId;
            if (charCount + spaces > lineLength) {
                return i-startId;
            }
        }
        return list.size()-startId;
    }

    public String getLine(List<String> list, int lineLength, boolean isLast) {
        String result = "";
        if (list.size() == 1) {
            result += list.get(0);
            for (int i = 0; i < lineLength - list.get(0).length(); i++) {
                result += " ";
            }
        } else {
            int charLength = 0;
            for (String s :list) {
                charLength += s.length();
            }
            int holeCount = list.size()-1;
            int commonSpaces = (lineLength - charLength) / holeCount;
            int additionalSpaces = (lineLength - charLength) % holeCount;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                result += s;
                if (i == list.size()-1) {
                    break;
                }
                if (isLast) {
                    result += " ";
                } else {
                    for (int j = 0; j < commonSpaces; j++) {
                        result += " ";
                    }
                    if (additionalSpaces > 0) {
                        result += " ";
                        additionalSpaces--;
                    }
                }
            }
            if (isLast) {
                additionalSpaces = lineLength-charLength-holeCount;
                for (int i = 0; i < additionalSpaces; i++) {
                    result += " ";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        JustifiedText instance = new JustifiedText();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("This", "is", "an", "example", "of", "text", "just","fication."));
//        System.out.println(instance.getWordsNumber(list, 16, 0));
//        System.out.println(instance.getWordsNumber(list, 16, 3));
//        System.out.println(instance.getWordsNumber(list, 16, 6));
        System.out.println(instance.fullJustify(list, 16));
    }
}
