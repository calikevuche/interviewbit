package StacksQueues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by OlehKa on 15.10.2016.
 */
public class SimplifyDirectoryPath {

    public String simplifyPath1(String a) {
        Stack stack = new Stack();
        String[] paths = a.split("/");
        for (String s : paths) {
            if (s.equals("") || s.equals(".") || (stack.isEmpty() && s.equals(".."))) continue;
            else if (s.equals("..")) stack.pop();
            else stack.push(s);
        }
        String result = "";
        while (!stack.isEmpty()) {
            String dir = (String) stack.pop();
            result = "/" + dir + result;
        }
        return result.isEmpty() ? "/" : result;
    }

    public String simplifyPath(String a) {
        LinkedList queue = new LinkedList();
        String[] paths = a.split("/");
        for (String s : paths) {
            if (s.equals("") || s.equals(".") || (queue.isEmpty() && s.equals(".."))) continue;
            else if (s.equals("..")) queue.remove();
            else queue.add(0, s);
        }
        String result = "";
        while (!queue.isEmpty()) {
            String dir = (String) queue.poll();
            result = "/" + dir + result;
        }
        return result.isEmpty() ? "/" : result;
    }

    public static void main(String[] args) {
        SimplifyDirectoryPath simplifyDirectoryPath = new SimplifyDirectoryPath();
        System.out.println(simplifyDirectoryPath.simplifyPath("/home/"));
        System.out.println(simplifyDirectoryPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyDirectoryPath.simplifyPath("/a/./b//../c/"));
        System.out.println(simplifyDirectoryPath.simplifyPath("/../"));
        System.out.println(simplifyDirectoryPath.simplifyPath("/home//foo/"));
    }
}
