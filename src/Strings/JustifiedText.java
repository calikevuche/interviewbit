package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 07.08.2016.
 */
public class JustifiedText {

    public ArrayList<String> fullJustifyV1(ArrayList<String> a, int b) {
        ArrayList<String> result = new ArrayList<>();
        int wordsPerLine = 0;
        int startIndex = 0;
        while (startIndex + wordsPerLine < a.size()) {
            startIndex += wordsPerLine;
            wordsPerLine = getWordsNumber(a, b, startIndex);
            boolean isLast = startIndex + wordsPerLine == a.size();
            String line = getLine(a.subList(startIndex, startIndex + wordsPerLine), b, isLast);
            result.add(line);
        }
        return result;
    }

    private int getWordsNumber(ArrayList<String> list, int lineLength, int startId) {
        int charCount = 0;
        for (int i = startId; i < list.size(); i++) {
            String word = list.get(i);
            charCount += word.length();
            int spaces = i - startId;
            if (charCount + spaces > lineLength) {
                return i - startId;
            }
        }
        return list.size() - startId;
    }

    private String getLine(List<String> list, int lineLength, boolean isLast) {
        StringBuilder result = new StringBuilder();
        if (list.size() == 1) {
            result.append(list.get(0));
            for (int i = 0; i < lineLength - list.get(0).length(); i++) {
                result.append(" ");
            }
        } else {
            int charLength = 0;
            for (String s : list) {
                charLength += s.length();
            }
            int holeCount = list.size() - 1;
            int commonSpaces = (lineLength - charLength) / holeCount;
            int additionalSpaces = (lineLength - charLength) % holeCount;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                result.append(s);
                if (i == list.size() - 1) {
                    break;
                }
                if (isLast) {
                    result.append(" ");
                } else {
                    for (int j = 0; j < commonSpaces; j++) {
                        result.append(" ");
                    }
                    if (additionalSpaces > 0) {
                        result.append(" ");
                        additionalSpaces--;
                    }
                }
            }
            if (isLast) {
                additionalSpaces = lineLength - charLength - holeCount;
                for (int i = 0; i < additionalSpaces; i++) {
                    result.append(" ");
                }
            }
        }
        return result.toString();
    }

    public ArrayList<String> fullJustifyV2(ArrayList<String> words, int l) {
        ArrayList<String> result = new ArrayList<>();
        int startId = 0, lineCount = 0, spaces = 0, addSpaces = 0;
        StringBuilder stringBuilder;
        while (startId < words.size()) {
            lineCount = getWordsPerLine(words, startId, l);
            stringBuilder = new StringBuilder();
            if (lineCount == 1 || startId + lineCount == words.size()) {
                stringBuilder.append(words.get(startId));
                for (int i = startId + 1; i < startId + lineCount; i++) {
                    stringBuilder.append(" ").append(words.get(i));
                }
                stringBuilder.append(getSpaces(l - stringBuilder.length()));
            } else if (lineCount == 2) {
                stringBuilder.append(words.get(startId));
                stringBuilder.append(getSpaces(l - words.get(startId).length() - words.get(startId + 1).length()));
                stringBuilder.append(words.get(startId + 1));
            } else {
                stringBuilder.append(words.get(startId));
                spaces = (l - getCharsPerLine(words, startId, lineCount)) / (lineCount - 1);
                addSpaces = (l - getCharsPerLine(words, startId, lineCount)) % (lineCount - 1);
                for (int i = startId + 1; i < startId + lineCount; i++) {
                    if (addSpaces > 0) {
                        stringBuilder.append(getSpaces(spaces + 1));
                        addSpaces--;
                    } else {
                        stringBuilder.append(getSpaces(spaces));
                    }
                    stringBuilder.append(words.get(i));
                }
            }
            result.add(stringBuilder.toString());
            startId += lineCount;
        }
        return result;
    }

    private String getSpaces(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private int getCharsPerLine(ArrayList<String> arrayList, int start, int wordCount) {
        int result = 0;
        for (int i = start; i < start + wordCount; i++) {
            result += arrayList.get(i).length();
        }
        return result;
    }

    private int getWordsPerLine(ArrayList<String> arrayList, int start, int lineSize) {
        int size = 0, result = 0;
        for (int i = start; i < arrayList.size(); i++) {
            size += arrayList.get(i).length();
            if (size > lineSize) {
                break;
            }
            size++;
            result++;
        }
        return result;
    }

    public ArrayList<String> fullJustifyV3(ArrayList<String> words, int L) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder stringBuilder;
        int l = 0, n = 0, sp = 0, asp = 0;
        for (int i = 0; i < words.size(); i += l) {
            stringBuilder = new StringBuilder();
            for (l = 0, n = 0;
                 l + i < words.size() &&
                         n + l + words.get(l + i).length() <= L;
                 l++) {
                n += words.get(l + i).length();
            }
            stringBuilder.append(words.get(i));
            boolean lastLine = l + i == words.size();
            if (l > 1) {
                sp = (L - n) / (l - 1);
                asp = (L - n) % (l - 1);
            }
            for (int j = 1; j < l; j++) {
                stringBuilder.append(getSpaces(lastLine ? 1 : (j <= asp) ? sp + 1 : sp));
                stringBuilder.append(words.get(j + i));
            }
            stringBuilder.append(getSpaces(L - stringBuilder.length()));
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        JustifiedText instance = new JustifiedText();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("This", "is", "an", "example", "of", "text", "just", "fication."));
        System.out.println(instance.fullJustifyV2(list, 16));
    }
}
