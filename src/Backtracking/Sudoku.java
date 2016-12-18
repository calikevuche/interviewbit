package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by OlehKa on 08.12.2016.
 */
public class Sudoku {

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        ArrayList<ArrayList<Character>> result = createTable(a.size(), '.');
        solveSudoku(result, a, 0, 0);
        copyTable(result, a);
    }

    private void solveSudoku(ArrayList<ArrayList<Character>> result, ArrayList<ArrayList<Character>> table, int x, int y) {
        int size = 9;
        int sizeSmall = 3;

        if (isFull(table)) {
            copyTable(table,result);
            return;
        }

        if (isFull(result)) {
            return;
        }

        if (table.get(y).get(x) != '.') {
            if (x+1 < size) solveSudoku(result, table, x+1, y);
            else if (y+1 < size) solveSudoku(result, table, 0, y+1);

        } else {
            char num = '1';
            while (num <= '9') {

                boolean valid;
                loop1:
                do {
                    valid = true;

                    //line
                    ArrayList<Character> line = table.get(y);
                    for (int i = 0; i < size; i++) {
                        if (table.get(y).get(i) == num) {
                            valid = false;
                            continue loop1;
                        }
                    }

                    //column
                    for (int i = 0; i < size; i++) {
                        if (table.get(i).get(x) == num) {
                            valid = false;
                            continue loop1;
                        }
                    }

                    //area
                    int areaX = (x / sizeSmall) * sizeSmall;
                    int areaY = (y / sizeSmall) * sizeSmall;
                    for (int i = areaY; i < areaY+sizeSmall; i++) {
                        for (int j = areaX; j < areaX+sizeSmall; j++) {
                            if (table.get(i).get(j) == num) {
                                valid = false;
                                continue loop1;
                            }
                        }
                    }

                } while (!valid && num++ < '9');

                if (valid && num <= '9') {
                    ArrayList<ArrayList<Character>> copy = copyTable(table);
                    copy.get(y).set(x, num);
                    if (isFull(copy)) {
                        copyTable(copy,result);
                        return;
                    }
                    if (x+1 < size) solveSudoku(result, copy, x+1, y);
                    else if (y+1 < size) solveSudoku(result, copy, 0, y+1);
                } else {
                    break;
                }

                num++;
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private ArrayList<ArrayList<Character>> createTable(int size, char c) {
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        ArrayList<Character> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(c);
        }
        for (int i = 0; i < size; i++) {
            result.add(new ArrayList<>(array));
        }
        return result;
    }

    private ArrayList<ArrayList<Character>> copyTable(ArrayList<ArrayList<Character>> list) {
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        for (ArrayList<Character> array: list) {
            result.add(new ArrayList<>(array));
        }
        return result;
    }

    private void copyTable(ArrayList<ArrayList<Character>> source, ArrayList<ArrayList<Character>> target) {
        target.clear();
        for (ArrayList<Character> array: source) {
            target.add(new ArrayList<>(array));
        }
    }

    private boolean isFull(ArrayList<ArrayList<Character>> list) {
        for (ArrayList<Character> chars:list) {
            for (char c:chars) {
                if (c == '.') return false;
            }
        }
        return true;
    }

    public static ArrayList<Character> convertStringToArraylist(String str) {
        ArrayList<Character> charList = new ArrayList<Character>();
        for(int i = 0; i<str.length();i++){
            charList.add(str.charAt(i));
        }
        return charList;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        ArrayList<ArrayList<Character>> input = new ArrayList<>();

        input.add(convertStringToArraylist("53..7....")); //1
        input.add(convertStringToArraylist("6..195...")); //2
        input.add(convertStringToArraylist(".98....6.")); //3
        input.add(convertStringToArraylist("8...6...3")); //4
        input.add(convertStringToArraylist("4..8.3..1")); //5
        input.add(convertStringToArraylist("7...2...6")); //6
        input.add(convertStringToArraylist(".6....28.")); //7
        input.add(convertStringToArraylist("...419..5")); //8
        input.add(convertStringToArraylist("....8..79")); //9

        System.out.println(input);
        sudoku.solveSudoku(input);
        System.out.println(input);
    }
}
