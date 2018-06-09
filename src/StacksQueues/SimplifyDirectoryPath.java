package StacksQueues;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by OlehKa on 15.10.2016.
 */
public class SimplifyDirectoryPath {

    public String simplifyPath1(String a) {
        Stack<String> stack = new Stack<>();
        String[] paths = a.split("/");
        for (String s : paths) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            } else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                stack.push(s);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            String dir = stack.pop();
            result.insert(0, "/" + dir);
        }
        return (result.length() == 0) ? "/" : result.toString();
    }

    public String simplifyPath2(String a) {
        LinkedList<String> queue = new LinkedList<>();
        String[] paths = a.split("/");
        for (String s : paths) {
            if (!queue.isEmpty() && s.equals("..")) {
                queue.remove();
            } else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                queue.add(0, s);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            String dir = queue.poll();
            result.insert(0, "/" + dir);
        }
        return (result.length() == 0) ? "/" : result.toString();
    }

    public static void main(String[] args) {
        SimplifyDirectoryPath simplifyDirectoryPath = new SimplifyDirectoryPath();
        System.out.println(simplifyDirectoryPath.simplifyPath2("/home/"));
        System.out.println(simplifyDirectoryPath.simplifyPath2("/a/./b/../../c/"));
        System.out.println(simplifyDirectoryPath.simplifyPath2("/a/./b//../c/"));
        System.out.println(simplifyDirectoryPath.simplifyPath2("/../"));
        System.out.println(simplifyDirectoryPath.simplifyPath2("/home//foo/"));
    }
}
