package Strings;

import java.util.ArrayList;

/**
 * Created by OlehKa on 07.08.2016.
 */
public class PrettyJson {

    public ArrayList<String> prettyJsonV1(String a) {
        ArrayList<String> result = new ArrayList<>();
        if (a.length() == 0) return result;
        a = a.replace(" ", "");
        char[] chars = a.toCharArray();
        int beginIndex = 0;
        int tabCount = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = chars[i];
            if (c == ',') {
                if (beginIndex < i) result.add(getTabs(tabCount) + a.substring(beginIndex, i + 1));
                beginIndex = i + 1;
            }
            if (c == '{' || c == '[') {
                if (beginIndex < i) result.add(getTabs(tabCount) + a.substring(beginIndex, i));
                result.add(getTabs(tabCount) + String.valueOf(c));
                tabCount++;
                beginIndex = i + 1;
            }
            if (c == '}' || c == ']') {
                if (beginIndex < i) result.add(getTabs(tabCount) + a.substring(beginIndex, i));
                tabCount--;
                if (i + 1 < a.length() && chars[i + 1] == ',') {
                    result.add(getTabs(tabCount) + String.valueOf(c) + String.valueOf(','));
                    beginIndex = i + 2;
                } else {
                    result.add(getTabs(tabCount) + String.valueOf(c));
                    beginIndex = i + 1;
                }
            }
        }
        result.forEach(System.out::println);
        return result;
    }

    private String getTabs(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append('\t');
        }
        return sb.toString();
    }

    public ArrayList<String> prettyJsonV2(String a) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int tabs = 0;
        boolean open = false;
        char cur = 0, prev = 0;
        for (int i = 0; i < a.length(); i++) {
            cur = a.charAt(i);
            prev = i > 0 ? a.charAt(i - 1) : 0;
            switch (cur) {
                case ' ':
                    break;
                case '{':
                case '[':
                case '}':
                case ']':
                    open = cur == '{' || cur == '[';
                    if (sb.length() > 0) {
                        result.add(sb.toString());
                        sb.delete(0, sb.length());
                        sb.append(getTabs(open ? tabs : tabs - 1));
                    }
                    sb.append(cur);
                    tabs += open ? 1 : -1;
                    break;
                case ',':
                    sb.append(cur);
                    break;
                default:
                    if (prev == ',' ||
                            prev == '{' ||
                            prev == '[' ||
                            prev == '}' ||
                            prev == ']') {
                        result.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    if (sb.length() == 0) {
                        sb.append(getTabs(tabs));
                    }
                    sb.append(cur);
                    break;
            }
        }
        if (sb.length() > 0) {
            result.add(sb.toString());
        }
        result.forEach(System.out::println);
        return result;
    }

    public static void main(String[] args) {
        PrettyJson instance = new PrettyJson();
        instance.prettyJsonV2("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
        instance.prettyJsonV2("[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]");
//        instance.prettyJSON("\"{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}\"");
//        instance.prettyJsonV1("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
    }
}