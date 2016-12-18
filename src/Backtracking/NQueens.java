package Backtracking;

import java.util.ArrayList;

/**
 * Created by OlehKa on 03.12.2016.
 */
public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<StringBuilder>> result = new ArrayList<>();

        solveNQueens(result, createNewBoard(a), 0, 0);

        ArrayList<ArrayList<String>> result2 = new ArrayList<>();

        for (ArrayList<StringBuilder> list: result) {
            ArrayList<String> list2 = new ArrayList<>();
            for (StringBuilder sb: list) {
                String s = sb.toString().replaceAll("X",".");
                list2.add(s);
            }
            result2.add(list2);
        }

        return result2;
    }

    void solveNQueens(ArrayList<ArrayList<StringBuilder>> result, ArrayList<StringBuilder> chessboard, int x, int y) {
        ArrayList<StringBuilder> originalChessboard = copyBoard(chessboard);
        int size = chessboard.size();
        if (x > size-1 || y > size-1) return;

        StringBuilder line = chessboard.get(y);
        if (line.toString().indexOf('.', x) == -1) return;

        x = line.toString().indexOf('.', x);
        line.setCharAt(x, 'Q');

        if (y == size-1) {
            result.add(chessboard);
            return;
        }

        //up
        int y1 = y-1;
        while (y1 >= 0) {
            if (chessboard.get(y1).charAt(x) != 'Q')
                chessboard.get(y1).setCharAt(x,'X');
            y1--;
        }

        //down
        y1 = y+1;
        while (y1 < size) {
            if (chessboard.get(y1).charAt(x) != 'Q')
                chessboard.get(y1).setCharAt(x, 'X');
            y1++;
        }

        //left
        int x1 = x-1;
        while (x1 >= 0) {
            if (chessboard.get(y).charAt(x1) != 'Q')
                chessboard.get(y).setCharAt(x1, 'X');
            x1--;
        }

        //right
        x1 = x+1;
        while (x1 < size) {
            if (chessboard.get(y).charAt(x1) != 'Q')
                chessboard.get(y).setCharAt(x1, 'X');
            x1++;
        }

        //up-left
        x1 = x-1;
        y1 = y-1;
        while (x1 >=0 && y1 >= 0) {
            if (chessboard.get(y1).charAt(x1) != 'Q')
                chessboard.get(y1).setCharAt(x1, 'X');
            x1--;
            y1--;
        }

        //up-right
        x1 = x+1;
        y1 = y-1;
        while (x1 < size && y1 >= 0) {
            if (chessboard.get(y1).charAt(x1) != 'Q')
                chessboard.get(y1).setCharAt(x1, 'X');
            x1++;
            y1--;
        }

        //down-left
        x1 = x-1;
        y1 = y+1;
        while (x1 >=0 && y1 < size) {
            if (chessboard.get(y1).charAt(x1) != 'Q')
                chessboard.get(y1).setCharAt(x1, 'X');
            x1--;
            y1++;
        }

        //down-right
        x1 = x+1;
        y1 = y+1;
        while (x1 < size && y1 < size) {
            if (chessboard.get(y1).charAt(x1) != 'Q')
                chessboard.get(y1).setCharAt(x1, 'X');
            x1++;
            y1++;
        }

        if (y+1 < size) {
            solveNQueens(result, chessboard, 0, y+1);
        }
        if (x+1 < size) {
            solveNQueens(result, originalChessboard, x+1, y);
        }
    }

    ArrayList<StringBuilder> createNewBoard(int size) {
        ArrayList<StringBuilder> newBoard = new ArrayList<>();
        String emptyLine = "";
        int len = 0;
        while (len < size) {
            emptyLine += ".";
            len++;
        }
        for (int i = 0; i < size; i++) {
            newBoard.add(new StringBuilder(emptyLine));
        }
        return newBoard;
    }

    ArrayList<StringBuilder> copyBoard(ArrayList<StringBuilder> board) {
        ArrayList<StringBuilder> copyBoard = new ArrayList<>();
        for (StringBuilder line: board) {
            StringBuilder copyLine = new StringBuilder(line);
            copyBoard.add(copyLine);
        }
        return copyBoard;
    }

    public static void main(String[] args) {
        NQueens instance = new NQueens();
        System.out.println(instance.solveNQueens(4));
    }
}
